//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.cookie.legendmod.ui;

import net.minecraftforge.client.event.*;
import com.cookie.legendmod.module.*;
import net.minecraft.client.*;
import com.cookie.legendmod.module.MISC.*;
import com.cookie.legendmod.*;
import net.minecraft.client.gui.*;
import java.util.*;
import net.minecraftforge.fml.common.eventhandler.*;

public class UI
{
    @SubscribeEvent
    public void onRender(final RenderGameOverlayEvent.Post e) {
        switch (e.getType()) {
            case TEXT: {
                if (!Panic.isPanic) {
                    final Minecraft mc = Minecraft.getMinecraft();
                    final FontRenderer fr = mc.fontRenderer;
                    final ScaledResolution sr = new ScaledResolution(mc);
                    class 1ModuleComparator implements Comparator<Module>
                    {
                        @Override
                        public int compare(final Module o1, final Module o2) {
                            if (Minecraft.getMinecraft().fontRenderer.getStringWidth(o1.name) > Minecraft.getMinecraft().fontRenderer.getStringWidth(o2.name)) {
                                return -1;
                            }
                            if (Minecraft.getMinecraft().fontRenderer.getStringWidth(o1.name) < Minecraft.getMinecraft().fontRenderer.getStringWidth(o2.name)) {
                                return 1;
                            }
                            return 0;
                        }
                    }
                    Collections.sort((List<Object>)Client.modules, (Comparator<? super Object>)new 1ModuleComparator());
                    Gui.drawRect(116, 6, 6, 17, -268435456);
                    Gui.drawRect(5, 6, 6, 17, -4908261);
                    Gui.drawRect(116, 6, 117, 17, -4908261);
                    Gui.drawRect(5, 5, 117, 6, -4908261);
                    Gui.drawRect(5, 17, 117, 18, -4908261);
                    fr.drawString("Legend v0.7.5 fps: " + Minecraft.getDebugFPS(), 8, 8, -1);
                    int count = 0;
                    for (final Module module : Client.modules) {
                        if (!module.toggled) {
                            continue;
                        }
                        Gui.drawRect(sr.getScaledWidth() - fr.getStringWidth(module.name) - 10, 3 + count * (fr.FONT_HEIGHT + 2), sr.getScaledWidth() - fr.getStringWidth(module.name) - 8, 4 + fr.FONT_HEIGHT + count * (fr.FONT_HEIGHT + 2), -4908261);
                        Gui.drawRect(sr.getScaledWidth() - fr.getStringWidth(module.name) - 8, 3 + count * (fr.FONT_HEIGHT + 2), sr.getScaledWidth(), 4 + fr.FONT_HEIGHT + count * (fr.FONT_HEIGHT + 2), -1879048192);
                        fr.drawString(module.name, sr.getScaledWidth() - fr.getStringWidth(module.name) - 4, 4 + count * (fr.FONT_HEIGHT + 2), -1);
                        ++count;
                    }
                    break;
                }
                Minecraft.getMinecraft().fontRenderer.drawString("FPS: " + Minecraft.getDebugFPS(), 8, 8, -1);
                break;
            }
        }
    }
}
