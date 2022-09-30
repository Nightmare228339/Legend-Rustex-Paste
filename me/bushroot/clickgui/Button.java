//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package me.bushroot.clickgui;

import net.minecraft.client.*;
import com.cookie.legendmod.module.*;
import java.awt.*;
import net.minecraft.client.gui.*;
import java.io.*;

public class Button
{
    public Minecraft mc;
    public int x;
    public int y;
    public int width;
    public int height;
    public boolean binding;
    public Module module;
    
    public Button(final int x, final int y, final int width, final int height, final Module module) {
        this.mc = Minecraft.getMinecraft();
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.module = module;
    }
    
    public void drawScreen(final int mouseX, final int mouseY, final float partialTicks) {
        Gui.drawRect(this.x + 10, this.y, this.x + this.width - 10, this.y + this.height, new Color(-1879048192, true).hashCode());
        this.mc.fontRenderer.drawStringWithShadow(this.binding ? "< PRESS KEY >" : this.module.name, (float)(this.x + this.width / 2 - this.mc.fontRenderer.getStringWidth(this.binding ? "< PRESS KEY >" : this.module.name) / 2), (float)(this.y + this.height / 2 - 4), (this.module.toggled && !this.binding) ? new Color(-4908261, true).hashCode() : -1);
    }
    
    protected void keyTyped(final char typedChar, final int keyCode) throws IOException {
        if (this.binding) {
            this.module.keyCode = keyCode;
            this.binding = false;
            if (keyCode == 1) {
                this.module.keyCode = 0;
            }
        }
    }
    
    public void mouseClicked(final int mouseX, final int mouseY, final int mouseButton) throws IOException {
        if (HoverUtils.hovered(mouseX, mouseY, this.x, this.y, this.x + this.width, this.y + this.height)) {
            if (mouseButton == 0) {
                this.module.toggle();
            }
            else if (mouseButton == 2) {
                this.binding = !this.binding;
            }
        }
    }
    
    protected void mouseReleased(final int mouseX, final int mouseY, final int state) {
    }
}
