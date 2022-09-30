//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package yea.bushroot.clickgui;

import com.cookie.legendmod.module.*;
import java.util.*;

public class Setting
{
    private String name;
    private Module parent;
    private String mode;
    private String type;
    private String sval;
    private ArrayList<String> options;
    private String title;
    private boolean bval;
    private double dval;
    private double min;
    private double max;
    private boolean onlyint;
    private String text;
    private int color;
    
    public Setting(final String name, final Module parent, final ArrayList<String> options, final String title) {
        this.onlyint = false;
        this.name = name;
        this.parent = parent;
        this.options = options;
        this.title = title;
        this.mode = "Combo";
        this.type = "String";
    }
    
    public Setting(final String name, final Module parent, final boolean bval) {
        this.onlyint = false;
        this.name = name;
        this.parent = parent;
        this.bval = bval;
        this.mode = "Check";
        this.type = "Boolean";
    }
    
    public Setting(final String name, final Module parent, final double dval, final double min, final double max, final boolean onlyint) {
        this.onlyint = false;
        this.name = name;
        this.parent = parent;
        this.dval = dval;
        this.min = min;
        this.max = max;
        this.onlyint = onlyint;
        this.mode = "Slider";
        this.type = "Double";
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getType() {
        return this.type;
    }
    
    public Module getParentMod() {
        return this.parent;
    }
    
    public String getValString() {
        return this.sval;
    }
    
    public void setValString(final String in) {
        this.sval = in;
    }
    
    public ArrayList<String> getOptions() {
        return this.options;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public boolean getValBoolean() {
        return this.bval;
    }
    
    public void setValBoolean(final boolean in) {
        this.bval = in;
    }
    
    public double getValDouble() {
        if (this.onlyint) {
            this.dval = (int)this.dval;
        }
        return this.dval;
    }
    
    public void setValDouble(final double in) {
        this.dval = in;
    }
    
    public double getMin() {
        return this.min;
    }
    
    public double getMax() {
        return this.max;
    }
    
    public int getColor() {
        return this.color;
    }
    
    public String getString() {
        return this.text;
    }
    
    public boolean isCombo() {
        return this.mode.equalsIgnoreCase("Combo");
    }
    
    public boolean isCheck() {
        return this.mode.equalsIgnoreCase("Check");
    }
    
    public boolean isSlider() {
        return this.mode.equalsIgnoreCase("Slider");
    }
    
    public boolean isMode() {
        return this.mode.equalsIgnoreCase("ModeButton");
    }
    
    public boolean onlyInt() {
        return this.onlyint;
    }
}
