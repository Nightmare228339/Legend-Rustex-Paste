//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.cookie.legendmod.module.MOVEMENT;

import com.cookie.legendmod.module.*;
import com.cookie.legendmod.*;
import net.minecraftforge.fml.common.gameevent.*;
import net.minecraft.client.gui.*;
import net.minecraft.client.gui.inventory.*;
import yea.bushroot.clickgui.*;
import net.minecraftforge.fml.common.eventhandler.*;
import net.minecraft.util.math.*;
import net.minecraft.client.entity.*;
import org.lwjgl.input.*;
import net.minecraft.client.*;

public class InvWalk extends Module
{
    public InvWalk() {
        super("InvWalk", 0, Module.Category.MOVEMENT);
        Legendmod.instance.settingsManager.rSetting(new Setting("Speed", (Module)this, 0.05, 0.01, 0.1, false));
    }
    
    @SubscribeEvent
    public void onClientTick(final TickEvent.ClientTickEvent e) {
        if (!(InvWalk.mc.currentScreen instanceof GuiChat) && !(InvWalk.mc.currentScreen instanceof GuiContainer) && !(InvWalk.mc.currentScreen instanceof ClickGuiManager)) {
            return;
        }
        double speed = Legendmod.instance.settingsManager.getSettingByName(this.name, "Speed").getValDouble();
        if (!InvWalk.mc.player.onGround) {
            speed /= 4.0;
        }
        this.handleJump();
        this.handleForward(speed);
        if (!InvWalk.mc.player.onGround) {
            speed /= 2.0;
        }
        this.handleBack(speed);
        this.handleLeft(speed);
        this.handleRight(speed);
    }
    
    void moveForward(final double speed) {
        final float direction = getDirection();
        final EntityPlayerSP player = InvWalk.mc.player;
        player.motionX -= MathHelper.sin(direction) * speed;
        final EntityPlayerSP player2 = InvWalk.mc.player;
        player2.motionZ += MathHelper.cos(direction) * speed;
    }
    
    void moveBack(final double speed) {
        final float direction = getDirection();
        final EntityPlayerSP player = InvWalk.mc.player;
        player.motionX += MathHelper.sin(direction) * speed;
        final EntityPlayerSP player2 = InvWalk.mc.player;
        player2.motionZ -= MathHelper.cos(direction) * speed;
    }
    
    void moveLeft(final double speed) {
        final float direction = getDirection();
        final EntityPlayerSP player = InvWalk.mc.player;
        player.motionZ += MathHelper.sin(direction) * speed;
        final EntityPlayerSP player2 = InvWalk.mc.player;
        player2.motionX += MathHelper.cos(direction) * speed;
    }
    
    void moveRight(final double speed) {
        final float direction = getDirection();
        final EntityPlayerSP player = InvWalk.mc.player;
        player.motionZ -= MathHelper.sin(direction) * speed;
        final EntityPlayerSP player2 = InvWalk.mc.player;
        player2.motionX -= MathHelper.cos(direction) * speed;
    }
    
    void handleForward(final double speed) {
        if (!Keyboard.isKeyDown(InvWalk.mc.gameSettings.keyBindForward.getKeyCode())) {
            return;
        }
        this.moveForward(speed);
    }
    
    void handleBack(final double speed) {
        if (!Keyboard.isKeyDown(InvWalk.mc.gameSettings.keyBindBack.getKeyCode())) {
            return;
        }
        this.moveBack(speed);
    }
    
    void handleLeft(final double speed) {
        if (!Keyboard.isKeyDown(InvWalk.mc.gameSettings.keyBindLeft.getKeyCode())) {
            return;
        }
        this.moveLeft(speed);
    }
    
    void handleRight(final double speed) {
        if (!Keyboard.isKeyDown(InvWalk.mc.gameSettings.keyBindRight.getKeyCode())) {
            return;
        }
        this.moveRight(speed);
    }
    
    void handleJump() {
        if (InvWalk.mc.player.onGround && Keyboard.isKeyDown(InvWalk.mc.gameSettings.keyBindJump.getKeyCode())) {
            InvWalk.mc.player.jump();
        }
    }
    
    public static float getDirection() {
        final Minecraft mc = Minecraft.getMinecraft();
        float var1 = mc.player.rotationYaw;
        if (mc.player.moveForward < 0.0f) {
            var1 += 180.0f;
        }
        float forward = 1.0f;
        if (mc.player.moveForward < 0.0f) {
            forward = -0.5f;
        }
        else if (mc.player.moveForward > 0.0f) {
            forward = 0.5f;
        }
        if (mc.player.moveStrafing > 0.0f) {
            var1 -= 90.0f * forward;
        }
        if (mc.player.moveStrafing < 0.0f) {
            var1 += 90.0f * forward;
        }
        var1 *= 0.017453292f;
        return var1;
    }
}
