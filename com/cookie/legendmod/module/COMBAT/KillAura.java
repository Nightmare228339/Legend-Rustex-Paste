//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.cookie.legendmod.module.COMBAT;

import com.cookie.legendmod.module.*;
import net.minecraft.client.*;
import com.cookie.legendmod.*;
import yea.bushroot.clickgui.*;
import net.minecraftforge.fml.common.gameevent.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraftforge.fml.common.eventhandler.*;
import java.util.function.*;
import java.util.*;
import net.minecraft.client.entity.*;
import com.cookie.legendmod.utils.*;
import net.minecraft.entity.boss.*;
import net.minecraft.entity.item.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;

public class KillAura extends Module
{
    private static final Minecraft mc;
    private static final TimerUtils oldTimerPvp;
    private static int cps;
    private static double Range;
    private static boolean FuckAll;
    private static boolean Players;
    private static boolean Mobs;
    private static boolean ArmorStand;
    private static boolean Invisible;
    
    public KillAura() {
        super("KillAura", 0, Category.COMBAT);
        Legendmod.instance.settingsManager.rSetting(new Setting("Min CPS", (Module)this, 10.0, 1.0, 20.0, true));
        Legendmod.instance.settingsManager.rSetting(new Setting("Max CPS", (Module)this, 10.0, 1.0, 20.0, true));
        Legendmod.instance.settingsManager.rSetting(new Setting("Range", (Module)this, 6.0, 0.0, 6.0, false));
        Legendmod.instance.settingsManager.rSetting(new Setting("FuckAll", (Module)this, false));
        Legendmod.instance.settingsManager.rSetting(new Setting("Players", (Module)this, false));
        Legendmod.instance.settingsManager.rSetting(new Setting("Mobs", (Module)this, false));
        Legendmod.instance.settingsManager.rSetting(new Setting("ArmorStand", (Module)this, false));
        Legendmod.instance.settingsManager.rSetting(new Setting("Invisible", (Module)this, false));
        Legendmod.instance.settingsManager.rSetting(new Setting("Legit", (Module)this, false));
    }
    
    private static boolean canApsAttack() {
        try {
            KillAura.cps = (int)Legendmod.instance.settingsManager.getSettingByName("KillAura", "Min CPS").getValDouble() + (int)(Math.random() * (int)Legendmod.instance.settingsManager.getSettingByName("KillAura", "Max CPS").getValDouble());
        }
        catch (Throwable ignored) {
            return false;
        }
        final int apsMultiplier = (int)(14.0f / KillAura.cps);
        if (KillAura.oldTimerPvp.hasReached((float)(50 * apsMultiplier))) {
            KillAura.oldTimerPvp.reset();
            return true;
        }
        return false;
    }
    
    @SubscribeEvent
    public void onPlayerTick(final TickEvent.PlayerTickEvent e) {
        final boolean Legit = Legendmod.instance.settingsManager.getSettingByName("KillAura", "Legit").getValBoolean();
        final EntityLivingBase target = getSortEntities();
        if (target == null) {
            return;
        }
        if (canApsAttack() && !Legit) {
            KillAura.mc.playerController.attackEntity((EntityPlayer)KillAura.mc.player, (Entity)target);
            if (!KillAura.FuckAll) {
                KillAura.mc.player.swingArm(EnumHand.MAIN_HAND);
            }
        }
        else if (Legit && KillAura.mc.gameSettings.keyBindAttack.isPressed()) {
            KillAura.mc.playerController.attackEntity((EntityPlayer)KillAura.mc.player, (Entity)target);
        }
    }
    
    private static EntityLivingBase getSortEntities() {
        final List<EntityLivingBase> entity = new ArrayList<EntityLivingBase>();
        final Iterator var1 = KillAura.mc.world.loadedEntityList.iterator();
        KillAura.Range = Legendmod.instance.settingsManager.getSettingByName("KillAura", "Range").getValDouble();
        while (var1.hasNext()) {
            final Entity e = var1.next();
            if (e instanceof EntityLivingBase) {
                final EntityLivingBase player = (EntityLivingBase)e;
                if (KillAura.mc.player.getDistance((Entity)player) >= KillAura.Range || !canAttack(player)) {
                    continue;
                }
                if (!player.isDead) {
                    entity.add(player);
                }
                else {
                    entity.remove(player);
                }
            }
        }
        final EntityPlayerSP var2 = KillAura.mc.player;
        var2.getClass();
        final List<EntityLivingBase> list = entity;
        final EntityPlayerSP entityPlayerSP = var2;
        Objects.requireNonNull(entityPlayerSP);
        list.sort(Comparator.comparingDouble((ToDoubleFunction<? super Object>)entityPlayerSP::getDistance));
        if (entity.isEmpty()) {
            return null;
        }
        return entity.get(0);
    }
    
    private static boolean canAttack(final EntityLivingBase player) {
        for (final String name : FriendManager.friendsList) {
            if (player.getName().equals(name)) {
                return false;
            }
        }
        KillAura.Range = Legendmod.instance.settingsManager.getSettingByName("KillAura", "Range").getValDouble();
        KillAura.FuckAll = Legendmod.instance.settingsManager.getSettingByName("KillAura", "FuckAll").getValBoolean();
        KillAura.Players = Legendmod.instance.settingsManager.getSettingByName("KillAura", "Players").getValBoolean();
        KillAura.Mobs = Legendmod.instance.settingsManager.getSettingByName("KillAura", "Mobs").getValBoolean();
        KillAura.ArmorStand = Legendmod.instance.settingsManager.getSettingByName("KillAura", "ArmorStand").getValBoolean();
        KillAura.Invisible = Legendmod.instance.settingsManager.getSettingByName("KillAura", "Invisible").getValBoolean();
        if (player instanceof EntityPlayer && AntiBot.check((EntityPlayer)player)) {
            return false;
        }
        if (player instanceof EntitySlime && !KillAura.Mobs) {
            return false;
        }
        if (player instanceof EntityMagmaCube && !KillAura.Mobs) {
            return false;
        }
        if (player instanceof EntityDragon && !KillAura.Mobs) {
            return false;
        }
        if (player instanceof EntityEnderman && !KillAura.Mobs) {
            return false;
        }
        if (player instanceof EntityArmorStand && !KillAura.ArmorStand) {
            return false;
        }
        if (player.isInvisible() && !KillAura.Invisible) {
            return false;
        }
        if (player instanceof EntityPlayer || player instanceof EntityAnimal || player instanceof EntityMob || player instanceof EntityVillager) {
            if (player instanceof EntityPlayer && !KillAura.Players) {
                return false;
            }
            if (player instanceof EntityAnimal && !KillAura.Mobs) {
                return false;
            }
            if (player instanceof EntityMob && !KillAura.Mobs) {
                return false;
            }
            if (player instanceof EntityVillager && !KillAura.Mobs) {
                return false;
            }
            if (player instanceof EntityOcelot && !KillAura.Mobs) {
                return false;
            }
            if (player instanceof EntityWolf && !KillAura.Mobs) {
                return false;
            }
        }
        return player.canEntityBeSeen((Entity)KillAura.mc.player) && player != KillAura.mc.player;
    }
    
    static {
        mc = Minecraft.getMinecraft();
        oldTimerPvp = new TimerUtils();
    }
}
