//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.cookie.legendmod.utils;

import net.minecraft.client.*;
import net.minecraft.util.text.*;

public class ChatUtils
{
    private static final String prefix;
    
    public static void sendMessage(final String msg) {
        Minecraft.getMinecraft().player.sendMessage((ITextComponent)new TextComponentString(ChatUtils.prefix + msg));
    }
    
    public static void say(final String msg) {
        Minecraft.getMinecraft().player.sendChatMessage(msg);
    }
    
    static {
        prefix = TextFormatting.GRAY + "[" + TextFormatting.RED + "Legend" + TextFormatting.GRAY + "]: " + TextFormatting.WHITE;
    }
}
