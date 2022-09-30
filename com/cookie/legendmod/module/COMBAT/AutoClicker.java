//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.cookie.legendmod.module.COMBAT;

import com.cookie.legendmod.module.*;
import net.minecraft.entity.*;
import com.cookie.legendmod.utils.*;
import com.cookie.legendmod.*;
import yea.bushroot.clickgui.*;
import net.minecraftforge.fml.common.gameevent.*;
import org.lwjgl.input.*;
import net.minecraft.client.*;
import net.minecraft.util.*;
import net.minecraftforge.fml.common.eventhandler.*;

public class AutoClicker extends Module
{
    private Entity entity;
    public TimerUtils timer;
    
    public AutoClicker() {
        super("AutoClicker", 0, Category.COMBAT);
        this.timer = new TimerUtils();
        Legendmod.instance.settingsManager.rSetting(new Setting("ShootDeley", (Module)this, 100.0, 5.0, 1000.0, true));
    }
    
    @SubscribeEvent
    public void onPlayerTick(final TickEvent.PlayerTickEvent e) {
        final float AutoShootDeley = (float)Legendmod.instance.settingsManager.getSettingByName(this.name, "ShootDeley").getValDouble();
        if (Mouse.isButtonDown(0) && Minecraft.getMinecraft().currentScreen == null && this.timer.isDelay((long)AutoShootDeley)) {
            AutoClicker.mc.player.swingArm(EnumHand.MAIN_HAND);
            this.timer.setLastMS();
        }
    }
}
