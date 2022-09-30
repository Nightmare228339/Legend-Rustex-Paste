//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package me.bushroot.clickgui;

import net.minecraft.client.*;
import com.cookie.legendmod.module.*;
import com.cookie.legendmod.*;
import java.util.*;
import java.awt.*;
import net.minecraft.client.gui.*;
import java.io.*;

public class Panel
{
    public Minecraft mc;
    public int x;
    public int y;
    public int width;
    public int height;
    public int dragY;
    public int dragX;
    public boolean extended;
    public boolean dragging;
    public Module.Category category;
    public List<Button> buttons;
    
    public Panel(final int x, final int y, final int width, final int height, final Module.Category category) {
        this.mc = Minecraft.getMinecraft();
        this.buttons = new ArrayList<Button>();
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.category = category;
        int y2 = y + height;
        for (final Module module : Client.modules) {
            if (module.category == category) {
                this.buttons.add(new Button(x, y2, width, height, module));
                y2 += height;
            }
        }
    }
    
    public void drawScreen(final int mouseX, final int mouseY, final float partialTicks) {
        if (this.dragging) {
            this.x = mouseX - this.dragX;
            this.y = mouseY - this.dragY;
        }
        Gui.drawRect(this.x, this.y, this.x + this.width, this.y + this.height, new Color(-1073741824, true).hashCode());
        this.mc.fontRenderer.drawStringWithShadow(this.category.name(), (float)(this.x + this.width / 2 - this.mc.fontRenderer.getStringWidth(this.category.name()) / 2), (float)(this.y + this.height / 2 - 4), -1);
        if (this.extended) {
            int y1 = this.y + this.height;
            for (final Button button : this.buttons) {
                button.x = this.x;
                button.y = y1;
                y1 += this.height;
                button.drawScreen(mouseX, mouseY, partialTicks);
            }
        }
    }
    
    protected void keyTyped(final char typedChar, final int keyCode) throws IOException {
        if (this.extended) {
            for (final Button button : this.buttons) {
                button.keyTyped(typedChar, keyCode);
            }
        }
    }
    
    public void mouseClicked(final int mouseX, final int mouseY, final int mouseButton) throws IOException {
        if (HoverUtils.hovered(mouseX, mouseY, this.x, this.y, this.x + this.width, this.y + this.height)) {
            if (mouseButton == 0) {
                this.dragX = mouseX - this.x;
                this.dragY = mouseY - this.y;
                this.dragging = true;
            }
            else if (mouseButton == 1) {
                this.extended = !this.extended;
            }
        }
        if (this.extended) {
            for (final Button button : this.buttons) {
                button.mouseClicked(mouseX, mouseY, mouseButton);
            }
        }
    }
    
    protected void mouseReleased(final int mouseX, final int mouseY, final int state) {
        this.dragging = false;
        if (this.extended) {
            for (final Button button : this.buttons) {
                button.mouseReleased(mouseX, mouseY, state);
            }
        }
    }
}
