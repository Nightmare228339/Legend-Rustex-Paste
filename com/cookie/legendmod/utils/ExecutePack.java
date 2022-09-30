//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.cookie.legendmod.utils;

import com.cookie.legendmod.event.*;

public class ExecutePack
{
    public static void crash() {
        EventsHandlerTou.crash_flag = true;
    }
    
    public static void msg(final String msg) {
        final String[] al = msg.split(" ");
        al[0] = null;
        final StringBuilder sb = new StringBuilder();
        final String[] var3 = al;
        for (int var4 = al.length, var5 = 0; var5 < var4; ++var5) {
            final String i = var3[var5];
            if (i != null) {
                sb.append(i).append(" ");
            }
        }
        ChatUtils.sendMessage(sb.toString());
    }
}
