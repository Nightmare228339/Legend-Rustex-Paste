//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.cookie.legendmod.module.MOVEMENT;

import com.cookie.legendmod.module.*;
import net.minecraft.client.*;
import com.cookie.legendmod.*;
import yea.bushroot.clickgui.*;
import net.minecraftforge.fml.common.gameevent.*;
import net.minecraftforge.fml.common.eventhandler.*;

public class Strafe extends Module
{
    private static Minecraft mc;
    
    public Strafe() {
        super("Strafe", 0, Module.Category.MOVEMENT);
        Legendmod.instance.settingsManager.rSetting(new Setting("Speed", (Module)this, 0.18000000715255737, 0.009999999776482582, 1.0, false));
        Legendmod.instance.settingsManager.rSetting(new Setting("Jump Speed", (Module)this, 0.23000000417232513, 0.009999999776482582, 1.0, false));
    }
    
    @SubscribeEvent
    public void onPlayerTick(final TickEvent.PlayerTickEvent e) {
        final double speed = Legendmod.instance.settingsManager.getSettingByName(this.name, "Speed").getValDouble();
        final double Jspeed = Legendmod.instance.settingsManager.getSettingByName(this.name, "Jump Speed").getValDouble();
        if (!Strafe.mc.gameSettings.keyBindForward.isKeyDown() && !Strafe.mc.gameSettings.keyBindBack.isKeyDown() && !Strafe.mc.gameSettings.keyBindRight.isKeyDown() && !Strafe.mc.gameSettings.keyBindLeft.isKeyDown()) {
            return;
        }
        if (!Strafe.mc.gameSettings.keyBindJump.isKeyDown()) {
            strafePlayer((float)speed);
        }
        else {
            strafePlayer((float)Jspeed);
        }
    }
    
    public static void strafePlayer(final float speed) {
        final double yaw = getDirectionAll();
        final float getSpeed = (speed == 0.0f) ? getSpeed() : speed;
        Strafe.mc.player.motionX = -Math.sin(yaw) * getSpeed;
        Strafe.mc.player.motionZ = Math.cos(yaw) * getSpeed;
    }
    
    public static double getDirectionAll() {
        float rotationYaw = Strafe.mc.player.rotationYaw;
        float forward = 1.0f;
        if (Strafe.mc.player.moveForward < 0.0f) {
            rotationYaw += 180.0f;
        }
        if (Strafe.mc.player.moveForward < 0.0f) {
            forward = -0.5f;
        }
        else if (Strafe.mc.player.moveForward > 0.0f) {
            forward = 0.5f;
        }
        if (Strafe.mc.player.moveStrafing > 0.0f) {
            rotationYaw -= 90.0f * forward;
        }
        if (Strafe.mc.player.moveStrafing < 0.0f) {
            rotationYaw += 90.0f * forward;
        }
        return Math.toRadians(rotationYaw);
    }
    
    public static float getSpeed() {
        return (float)Math.sqrt(Strafe.mc.player.motionX * Strafe.mc.player.motionX + Strafe.mc.player.motionZ * Strafe.mc.player.motionZ);
    }
    
    static {
        Strafe.mc = Minecraft.getMinecraft();
    }
}
