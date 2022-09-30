//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package yea.bushroot.clickgui.component.components;

import com.cookie.legendmod.module.*;
import yea.bushroot.clickgui.component.*;
import net.minecraft.client.*;
import com.cookie.legendmod.*;
import yea.bushroot.clickgui.*;
import yea.bushroot.clickgui.component.components.sub.*;
import java.util.*;
import net.minecraft.client.gui.*;
import java.awt.*;
import net.minecraft.util.text.*;

public class Button extends Component
{
    public Module mod;
    public Frame parent;
    public int offset;
    private boolean isHovered;
    private ArrayList<Component> subcomponents;
    public boolean open;
    public int height;
    public FontRenderer fr;
    
    public Button(final Module mod, final Frame parent, final int offset) {
        this.fr = Minecraft.getMinecraft().fontRenderer;
        this.mod = mod;
        this.parent = parent;
        this.offset = offset;
        this.height = 12;
        this.subcomponents = new ArrayList<Component>();
        this.open = false;
        int opY = offset + 12;
        if (Legendmod.instance.settingsManager.getSettingsByMod(mod) != null) {
            for (final Setting s : Legendmod.instance.settingsManager.getSettingsByMod(mod)) {
                if (s.isCombo()) {
                    this.subcomponents.add(new ModeButton(s, this, mod, opY));
                    opY += 12;
                }
                if (s.isSlider()) {
                    this.subcomponents.add(new Slider(s, this, opY));
                    opY += 12;
                }
                if (s.isCheck()) {
                    this.subcomponents.add(new Checkbox(s, this, opY));
                    opY += 12;
                }
            }
        }
        this.subcomponents.add(new Keybind(this, opY));
    }
    
    public void setOff(final int newOff) {
        this.offset = newOff;
        int opY = this.offset + 12;
        for (final Component comp : this.subcomponents) {
            comp.setOff(opY);
            opY += 12;
        }
    }
    
    public void renderComponent() {
        Gui.drawRect(this.parent.getX(), this.parent.getY() + this.offset, this.parent.getX() + this.parent.getWidth(), this.parent.getY() + 12 + this.offset, this.isHovered ? -14540254 : -15658735);
        Minecraft.getMinecraft().fontRenderer.drawStringWithShadow(this.mod.getName(), (float)(this.parent.getX() + 5), (float)(this.parent.getY() + this.offset + 2), this.mod.isEnabled() ? new Color(11868955).hashCode() : 16777215);
        if (this.subcomponents.size() >= 2) {
            Minecraft.getMinecraft().fontRenderer.drawStringWithShadow(this.open ? (TextFormatting.GRAY + "-") : (TextFormatting.GRAY + "+"), (float)(this.parent.getX() + this.parent.getWidth() - 10), (float)(this.parent.getY() + this.offset + 2), -1);
        }
        if (this.open && !this.subcomponents.isEmpty()) {
            for (final Component comp : this.subcomponents) {
                comp.renderComponent();
            }
        }
    }
    
    public int getHeight() {
        if (this.open) {
            return 12 * (this.subcomponents.size() + 1);
        }
        return 12;
    }
    
    public void updateComponent(final int mouseX, final int mouseY) {
        this.isHovered = this.isMouseOnButton(mouseX, mouseY);
        if (!this.subcomponents.isEmpty()) {
            for (final Component comp : this.subcomponents) {
                comp.updateComponent(mouseX, mouseY);
            }
        }
    }
    
    public void mouseClicked(final int mouseX, final int mouseY, final int button) {
        if (this.isMouseOnButton(mouseX, mouseY) && button == 0) {
            this.mod.toggle();
        }
        if (this.isMouseOnButton(mouseX, mouseY) && button == 1) {
            this.open = !this.open;
            this.parent.refresh();
        }
        for (final Component comp : this.subcomponents) {
            comp.mouseClicked(mouseX, mouseY, button);
        }
    }
    
    public void mouseReleased(final int mouseX, final int mouseY, final int mouseButton) {
        for (final Component comp : this.subcomponents) {
            comp.mouseReleased(mouseX, mouseY, mouseButton);
        }
    }
    
    public void keyTyped(final char typedChar, final int key) {
        for (final Component comp : this.subcomponents) {
            comp.keyTyped(typedChar, key);
        }
    }
    
    public boolean isMouseOnButton(final int x, final int y) {
        return x > this.parent.getX() && x < this.parent.getX() + this.parent.getWidth() && y > this.parent.getY() + this.offset && y < this.parent.getY() + 12 + this.offset;
    }
}
