//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.cookie.legendmod.module.MOVEMENT;

import com.cookie.legendmod.module.*;
import com.cookie.legendmod.*;
import yea.bushroot.clickgui.*;
import net.minecraftforge.event.entity.living.*;
import net.minecraftforge.fml.common.eventhandler.*;

public class LowJump extends Module
{
    public LowJump() {
        super("LowJump", 0, Module.Category.MOVEMENT);
        Legendmod.instance.settingsManager.rSetting(new Setting("Height", (Module)this, 0.4, 0.01, 0.4, false));
    }
    
    @SubscribeEvent
    public void onPlayerLiving(final LivingEvent.LivingJumpEvent e) {
        if (this.toggled) {
            final float spedd = (float)Legendmod.instance.settingsManager.getSettingByName(this.name, "Height").getValDouble();
            LowJump.mc.player.motionY = spedd;
        }
    }
}
