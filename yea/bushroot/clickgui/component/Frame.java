//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package yea.bushroot.clickgui.component;

import com.cookie.legendmod.module.*;
import com.cookie.legendmod.*;
import yea.bushroot.clickgui.component.components.*;
import java.util.*;
import java.awt.*;
import net.minecraft.client.gui.*;
import net.minecraft.client.*;

public class Frame
{
    public ArrayList<Component> components;
    public Module.Category category;
    private boolean open;
    private int width;
    private int y;
    private int x;
    private int barHeight;
    private boolean isDragging;
    public int dragX;
    public int dragY;
    public static int color;
    
    public Frame(final Module.Category cat) {
        this.components = new ArrayList<Component>();
        this.category = cat;
        this.width = 88;
        this.x = 0;
        this.y = 60;
        this.dragX = 0;
        this.barHeight = 12;
        this.open = false;
        this.isDragging = false;
        int tY = this.barHeight;
        for (final Module mod : Client.getModulesInCategory(this.category)) {
            final Button modButton = new Button(mod, this, tY);
            this.components.add((Component)modButton);
            tY += 12;
        }
    }
    
    public ArrayList<Component> getComponents() {
        return this.components;
    }
    
    public void setX(final int newX) {
        this.x = newX;
    }
    
    public void setY(final int newY) {
        this.y = newY;
    }
    
    public void setDrag(final boolean drag) {
        this.isDragging = drag;
    }
    
    public boolean isOpen() {
        return this.open;
    }
    
    public void setOpen(final boolean open) {
        this.open = open;
    }
    
    public void renderFrame(final FontRenderer fontRenderer) {
        Gui.drawRect(this.x, this.y - 1, this.x + this.width, this.y, new Color(-1879048192, true).hashCode());
        Gui.drawRect(this.x, this.y, this.x + this.width, this.y + 12, new Color(-1879048192, true).hashCode());
        Minecraft.getMinecraft().fontRenderer.drawStringWithShadow(this.category.name(), (float)(this.x + 5), (float)(this.y + 2), -1);
        if (this.open && !this.components.isEmpty()) {
            for (final Component component : this.components) {
                component.renderComponent();
            }
        }
    }
    
    public void refresh() {
        int off = this.barHeight;
        for (final Component comp : this.components) {
            comp.setOff(off);
            off += comp.getHeight();
        }
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public int getWidth() {
        return this.width;
    }
    
    public void updatePosition(final int mouseX, final int mouseY) {
        if (this.isDragging) {
            this.setX(mouseX - this.dragX);
            this.setY(mouseY - this.dragY);
        }
    }
    
    public boolean isWithinHeader(final int x, final int y) {
        return x >= this.x && x <= this.x + this.width && y >= this.y && y <= this.y + this.barHeight;
    }
}
