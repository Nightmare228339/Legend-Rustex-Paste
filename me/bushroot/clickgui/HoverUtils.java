//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package me.bushroot.clickgui;

public class HoverUtils
{
    public static boolean hovered(final int mouseX, final int mouseY, final int x, final int y, final int width, final int height) {
        return mouseX > x && mouseY > y && mouseX < width && mouseY < height;
    }
}
