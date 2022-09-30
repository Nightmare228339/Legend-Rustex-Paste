//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.cookie.legendmod.module.MISC;

import com.cookie.legendmod.module.*;
import net.minecraftforge.fml.common.gameevent.*;
import yea.bushroot.clickgui.*;
import org.lwjgl.opengl.*;
import java.util.*;
import net.minecraft.client.gui.*;
import net.minecraftforge.fml.common.eventhandler.*;

public class Time extends Module
{
    public Time() {
        super("Time", 0, Category.MISC);
    }
    
    @SubscribeEvent
    public void onRenderTick(final TickEvent.RenderTickEvent e) {
        final GregorianCalendar calendar = new GregorianCalendar();
        final Date time = calendar.getTime();
        final FontRenderer fr = Time.mc.fontRenderer;
        if (Time.mc.world == null) {
            return;
        }
        if (Time.mc.currentScreen instanceof ClickGuiManager || Time.mc.currentScreen == null || Time.mc.currentScreen instanceof GuiChat) {
            final float scale = 3.0f;
            Gui.drawRect(116, 29, 6, 40, -268435456);
            Gui.drawRect(5, 29, 6, 40, -4908261);
            Gui.drawRect(116, 29, 117, 40, -4908261);
            Gui.drawRect(5, 28, 117, 29, -4908261);
            fr.drawString("Time", 50, 31, -1);
            Gui.drawRect(116, 40, 6, (int)(27.0f * scale), -1879048192);
            GL11.glPushMatrix();
            GL11.glScaled((double)scale, (double)scale, 1.0);
            fr.drawString(time.getHours() + ":" + time.getMinutes(), (int)(25.0f / scale), (int)(52.0f / scale), -1);
            GL11.glPopMatrix();
        }
    }
}
