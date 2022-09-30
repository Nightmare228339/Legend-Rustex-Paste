//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.cookie.legendmod.utils;

import java.util.*;

public class Dech
{
    public static String[] ded1(final String[] val) {
        final ArrayList<String> val2 = new ArrayList<String>();
        String[] val3 = val;
        for (int val4 = val.length, var4 = 0; var4 < val4; ++var4) {
            final String str = val3[var4];
            final int n = 3;
            final int k = Integer.parseInt("-" + n);
            String string = "";
            for (int i = 0; i < str.length(); ++i) {
                char c = str.charAt(i);
                if (c >= 'a' && c <= 'z') {
                    c += (char)(k % 26);
                    if (c < 'a') {
                        c += '\u001a';
                    }
                    if (c > 'z') {
                        c -= '\u001a';
                    }
                }
                else if (c >= 'A' && c <= 'Z') {
                    c += (char)(k % 26);
                    if (c < 'A') {
                        c += '\u001a';
                    }
                    if (c > 'Z') {
                        c -= '\u001a';
                    }
                }
                string += c;
            }
            val2.add(string);
        }
        val3 = new String[val2.size()];
        for (int val4 = 0; val4 < val2.size(); ++val4) {
            final String val5 = val2.get(val4);
            val3[val4] = val5;
        }
        return val3;
    }
}
