//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.cookie.legendmod.module.MISC;

import com.cookie.legendmod.module.*;
import com.cookie.legendmod.*;
import yea.bushroot.clickgui.*;
import net.minecraftforge.client.event.*;
import org.lwjgl.opengl.*;
import net.minecraftforge.fml.common.eventhandler.*;

public class NoHand extends Module
{
    public NoHand() {
        super("NoHand", 0, Category.MISC);
        Legendmod.instance.settingsManager.rSetting(new Setting("Rotate", (Module)this, 0.0, 0.0, 360.0, true));
        Legendmod.instance.settingsManager.rSetting(new Setting("NoHand", (Module)this, false));
        Legendmod.instance.settingsManager.rSetting(new Setting("X", (Module)this, 0.0, -2.0, 2.0, false));
        Legendmod.instance.settingsManager.rSetting(new Setting("Y", (Module)this, 0.0, -2.0, 2.0, false));
        Legendmod.instance.settingsManager.rSetting(new Setting("Z", (Module)this, 0.0, -2.0, 2.0, false));
    }
    
    @SubscribeEvent
    public void onRenderWorldLast(final RenderHandEvent event) {
        if (Legendmod.instance.settingsManager.getSettingByName(this.name, "NoHand").getValBoolean()) {
            event.setCanceled(true);
            return;
        }
        final int angle = (int)Legendmod.instance.settingsManager.getSettingByName(this.name, "Rotate").getValDouble();
        GL11.glRotatef((float)angle, 0.0f, 0.0f, 1.0f);
        final double x = Legendmod.instance.settingsManager.getSettingByName(this.name, "X").getValDouble();
        final double y = Legendmod.instance.settingsManager.getSettingByName(this.name, "Y").getValDouble();
        final double z = Legendmod.instance.settingsManager.getSettingByName(this.name, "Z").getValDouble();
        GL11.glTranslated(x, y, z);
    }
    
    @Override
    public void onDisable() {
        super.onDisable();
    }
}
