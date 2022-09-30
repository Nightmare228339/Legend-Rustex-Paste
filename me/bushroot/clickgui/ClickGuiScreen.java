//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package me.bushroot.clickgui;

import net.minecraft.client.gui.*;
import com.cookie.legendmod.module.*;
import java.util.*;
import java.io.*;

public class ClickGuiScreen extends GuiScreen
{
    public List<Panel> panels;
    
    public ClickGuiScreen() {
        this.panels = new ArrayList<Panel>();
        int y = 10;
        for (final Module.Category value : Module.Category.values()) {
            this.panels.add(new Panel(10, y, 110, 15, value));
            y += 20;
        }
    }
    
    public void drawScreen(final int mouseX, final int mouseY, final float partialTicks) {
        for (final Panel panel : this.panels) {
            panel.drawScreen(mouseX, mouseY, partialTicks);
        }
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
    
    protected void keyTyped(final char typedChar, final int keyCode) throws IOException {
        for (final Panel panel : this.panels) {
            panel.keyTyped(typedChar, keyCode);
        }
        super.keyTyped(typedChar, keyCode);
    }
    
    public void mouseClicked(final int mouseX, final int mouseY, final int mouseButton) throws IOException {
        for (final Panel panel : this.panels) {
            panel.mouseClicked(mouseX, mouseY, mouseButton);
        }
        super.mouseClicked(mouseX, mouseY, mouseButton);
    }
    
    protected void mouseReleased(final int mouseX, final int mouseY, final int state) {
        for (final Panel panel : this.panels) {
            panel.mouseReleased(mouseX, mouseY, state);
        }
        super.mouseReleased(mouseX, mouseY, state);
    }
}
