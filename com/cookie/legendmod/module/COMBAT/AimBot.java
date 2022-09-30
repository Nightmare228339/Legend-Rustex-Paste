//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.cookie.legendmod.module.COMBAT;

import com.cookie.legendmod.module.*;
import com.cookie.legendmod.*;
import yea.bushroot.clickgui.*;
import net.minecraft.entity.*;
import net.minecraft.client.*;
import net.minecraft.util.math.*;
import java.util.function.*;
import java.util.*;
import java.util.stream.*;
import net.minecraft.entity.player.*;
import net.minecraftforge.event.entity.living.*;
import com.cookie.legendmod.utils.*;
import net.minecraft.util.*;
import net.minecraftforge.fml.common.eventhandler.*;

public class AimBot extends Module
{
    public float[] facing;
    public String[] gunlist;
    public TimerUtils timer;
    public TimerUtils timer2;
    
    public AimBot() {
        super("AimBot", 0, Category.COMBAT);
        this.gunlist = new String[] { "" };
        this.timer = new TimerUtils();
        this.timer2 = new TimerUtils();
        Legendmod.instance.settingsManager.rSetting(new Setting("Range", (Module)this, 300.0, 0.0, 300.0, true));
        Legendmod.instance.settingsManager.rSetting(new Setting("Predict", (Module)this, 4.800000190734863, 0.0, 7.0, false));
        Legendmod.instance.settingsManager.rSetting(new Setting("VPredict", (Module)this, 300.0, 0.0, 300.0, true));
        Legendmod.instance.settingsManager.rSetting(new Setting("BAimDistance", (Module)this, 10.0, -1.0, 50.0, false));
        Legendmod.instance.settingsManager.rSetting(new Setting("FOV", (Module)this, 90.0, 1.0, 360.0, true));
        Legendmod.instance.settingsManager.rSetting(new Setting("Wall", (Module)this, false));
        Legendmod.instance.settingsManager.rSetting(new Setting("Silent", (Module)this, false));
        Legendmod.instance.settingsManager.rSetting(new Setting("AutoShoot", (Module)this, false));
        Legendmod.instance.settingsManager.rSetting(new Setting("AutoShootDeley", (Module)this, 100.0, 2.0, 500.0, true));
    }
    
    public float[] getPredict(final Entity e) {
        final float VPredict = (float)Legendmod.instance.settingsManager.getSettingByName("AimBot", "VPredict").getValDouble();
        final float Predict = (float)Legendmod.instance.settingsManager.getSettingByName("AimBot", "Predict").getValDouble();
        final float Range = (float)Legendmod.instance.settingsManager.getSettingByName(this.name, "Range").getValDouble();
        final double xDiff = e.posX - e.prevPosX;
        final double zDiff = e.posZ - e.prevPosZ;
        final float predict = Predict + this.getDistance(e) / Range;
        final double WillPosX = e.posX + xDiff * predict;
        final double WillPosZ = e.posZ + zDiff * predict;
        double WillPosY;
        if (VPredict != 0.0f) {
            WillPosY = e.posY - e.fallDistance + this.getDistance(e) / VPredict;
        }
        else {
            WillPosY = e.posY;
        }
        return new float[] { (float)WillPosX, (float)WillPosZ, (float)WillPosY };
    }
    
    public static float[] faceHead(final float posX, final float posY, final float posZ, final float p_706252, final float p_706253, final boolean miss) {
        final double offset = Legendmod.instance.settingsManager.getSettingByName("AimBot", "BAimDistance").getValDouble();
        final double var4 = posX - Minecraft.getMinecraft().player.posX;
        final double var5 = posZ - Minecraft.getMinecraft().player.posZ;
        double var6 = posY + 1.86 - (Minecraft.getMinecraft().player.posY + Minecraft.getMinecraft().player.getEyeHeight());
        if (offset == -1.0) {
            var6 = posY + 1.86 - (Minecraft.getMinecraft().player.posY + Minecraft.getMinecraft().player.getEyeHeight());
        }
        else {
            final float distance = getDistance(new BlockPos((double)posX, (double)posY, (double)posZ));
            if (distance <= offset) {
                var6 = posY + 1.1 - (Minecraft.getMinecraft().player.posY + Minecraft.getMinecraft().player.getEyeHeight());
            }
        }
        final double var7 = MathHelper.sqrt(var4 * var4 + var5 * var5);
        final float var8 = (float)(Math.atan2(var5, var4) * 180.0 / 3.141592653589793) - 90.0f;
        final float var9 = (float)(-(Math.atan2(var6 - 0.15, var7) * 180.0 / 3.141592653589793));
        final float f = Minecraft.getMinecraft().gameSettings.mouseSensitivity * 0.6f + 0.2f;
        final float gcd = f * f * f * 1.2f;
        float pitch = updateRotation(Minecraft.getMinecraft().player.rotationPitch, var9, p_706253);
        float yaw = updateRotation(Minecraft.getMinecraft().player.rotationYaw, var8, p_706252);
        yaw -= yaw % gcd;
        pitch -= pitch % gcd;
        return new float[] { yaw, pitch };
    }
    
    public static float updateRotation(final float current, final float intended, final float speed) {
        float f = MathHelper.wrapDegrees(intended - current);
        if (f > speed) {
            f = speed;
        }
        if (f < -speed) {
            f = -speed;
        }
        return current + f;
    }
    
    private boolean lambdagetTarget(final Entity entity) {
        return this.attackCheck(entity);
    }
    
    public Entity getTarget() {
        try {
            if (AimBot.mc.player != null && !AimBot.mc.player.isDead) {
                final List list = (List)AimBot.mc.world.loadedEntityList.stream().filter(entity -> entity != AimBot.mc.player).filter(entity -> AimBot.mc.player.getDistance(entity) <= 200.0f).filter(entity -> !entity.isDead).filter(this::lambdagetTarget).sorted(Comparator.comparing(entity -> AimBot.mc.player.getDistance(entity))).collect(Collectors.toList());
                return (list.size() > 0) ? list.get(0) : null;
            }
            return null;
        }
        catch (Throwable var2) {
            return null;
        }
    }
    
    public boolean attackCheck(final Entity target) {
        final boolean Walls = Legendmod.instance.settingsManager.getSettingByName(this.name, "Wall").getValBoolean();
        if (Walls) {
            return target instanceof EntityPlayer && !FriendManager.friendsList.contains(target.getName());
        }
        return !Walls && AimBot.mc.player.canEntityBeSeen(target) && target instanceof EntityPlayer && !FriendManager.friendsList.contains(target.getName());
    }
    
    @SubscribeEvent
    public void onLivingUpdate(final LivingEvent.LivingUpdateEvent e) {
        final boolean Wall = Legendmod.instance.settingsManager.getSettingByName(this.name, "Wall").getValBoolean();
        final float Range = (float)Legendmod.instance.settingsManager.getSettingByName(this.name, "Range").getValDouble();
        final boolean AutoShoot = Legendmod.instance.settingsManager.getSettingByName(this.name, "AutoShoot").getValBoolean();
        final float AutoShootDeley = (float)Legendmod.instance.settingsManager.getSettingByName(this.name, "AutoShootDeley").getValDouble();
        final EntityPlayer target = (EntityPlayer)this.getTarget();
        if (target != null && !FriendManager.friendsList.contains(target.getName()) && FovUtils.isInAttackFOV((Entity)target, (int)Legendmod.instance.settingsManager.getSettingByName(this.name, "FOV").getValDouble())) {
            this.facing = this.getPredict((Entity)target);
            this.facing = faceHead(this.facing[0], this.facing[2], this.facing[1], 360.0f, 360.0f, false);
            final float f = this.facing[0];
            final float f2 = this.facing[1];
            if (!Legendmod.instance.settingsManager.getSettingByName(this.name, "Silent").getValBoolean() && this.timer2.isDelay(1L)) {
                AimBot.mc.player.rotationYaw = this.facing[0];
                AimBot.mc.player.rotationPitch = this.facing[1];
                this.timer2.setLastMS();
                if (Minecraft.getMinecraft().currentScreen == null && this.timer.isDelay((long)AutoShootDeley) && AutoShoot) {
                    AimBot.mc.player.swingArm(EnumHand.MAIN_HAND);
                    this.timer.setLastMS();
                }
            }
        }
    }
    
    private float getDistance(final Entity entityIn) {
        final float f = (float)(AimBot.mc.player.posX - entityIn.posX);
        final float f2 = (float)(AimBot.mc.player.posZ - entityIn.posZ);
        return MathHelper.sqrt(f * f + f2 * f2);
    }
    
    private static float getDistance(final BlockPos blockPos) {
        final float f = (float)(AimBot.mc.player.posX - blockPos.getX());
        final float f2 = (float)(AimBot.mc.player.posZ - blockPos.getZ());
        return MathHelper.sqrt(f * f + f2 * f2);
    }
}
