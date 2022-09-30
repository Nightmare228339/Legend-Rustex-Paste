//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.cookie.legendmod.utils;

import java.util.*;
import com.cookie.legendmod.*;
import org.lwjgl.opengl.*;
import net.minecraftforge.common.*;
import com.cookie.legendmod.keys.*;
import com.cookie.legendmod.ui.*;
import com.cookie.legendmod.event.*;
import net.minecraftforge.client.*;
import net.minecraft.command.*;
import com.cookie.legendmod.utils.commands.*;

public class Decoder
{
    private static String oldkey;
    private static boolean flag;
    private static Date bigdate;
    
    public static void dick(final String key) {
        Decoder.oldkey = key;
        Decoder.bigdate = new Date();
        parse(key);
    }
    
    private static void parse(final String key) {
        final int yoffset = 2222;
        final int moffset = 22;
        final int doffset = 22;
        final Date date = new Date();
        final StringBuilder byear = new StringBuilder();
        final StringBuilder bmonth = new StringBuilder();
        final StringBuilder bday = new StringBuilder();
        final StringBuilder btopcode = new StringBuilder();
        final StringBuilder brcode = new StringBuilder();
        String year = null;
        String month = null;
        String day = null;
        int num = 0;
        int num2 = 0;
        for (int ii = 0; ii < key.length(); ++ii) {
            final char[] buf = key.toCharArray();
            if (ii < 4) {
                byear.append(buf[ii]);
            }
            else if (ii < 5) {
                num = Integer.parseInt(String.valueOf(buf[ii]));
            }
            else if (ii < 5 + num) {
                btopcode.append(buf[ii]);
            }
            else if (ii < 5 + num + 2) {
                bmonth.append(buf[ii]);
            }
            else if (ii < 5 + num + 3) {
                num2 = Integer.parseInt(String.valueOf(buf[ii]));
            }
            else if (ii < 5 + num + 3 + num2) {
                brcode.append(buf[ii]);
            }
            else if (ii < 5 + num + 3 + num2 + 2) {
                bday.append(buf[ii]);
            }
        }
        year = byear.toString();
        month = bmonth.toString();
        day = bday.toString();
        if (year != null && month != null && day != null) {
            final Date date2 = new Date();
            if (Integer.parseInt(year) - yoffset != date2.getYear() || Integer.parseInt(month) - moffset != date2.getMonth() || Integer.parseInt(day) - doffset != date2.getDate()) {
                ChatUtils.sendMessage("invalid");
                return;
            }
            final String topcode = String.valueOf(Decoder.bigdate.getHours() * 60);
            final String rcode = String.valueOf(Decoder.bigdate.getHours() * date.getHours());
            if (topcode.equals(btopcode.toString()) && rcode.equals(brcode.toString())) {
                if (!Decoder.flag) {
                    Decoder.flag = true;
                    Client.startup();
                    Display.setTitle(Client.Clname = "Legend Client 1.12.2");
                    MinecraftForge.EVENT_BUS.register((Object)new key());
                    MinecraftForge.EVENT_BUS.register((Object)new UI());
                    MinecraftForge.EVENT_BUS.register((Object)new EventsHandlerTou());
                    ClientCommandHandler.instance.registerCommand((ICommand)new CommandDupe());
                    ClientCommandHandler.instance.registerCommand((ICommand)new CommandOffline());
                    ClientCommandHandler.instance.registerCommand((ICommand)new CommandAdd());
                    ClientCommandHandler.instance.registerCommand((ICommand)new CommandConfig());
                }
            }
            else {
                Decoder.flag = false;
            }
        }
    }
    
    public static void admintop() {
        if (!Decoder.flag) {
            Decoder.flag = true;
            Client.startup();
            Display.setTitle(Client.Clname = "Legend Client 1.12.2");
            MinecraftForge.EVENT_BUS.register((Object)new key());
            MinecraftForge.EVENT_BUS.register((Object)new UI());
            MinecraftForge.EVENT_BUS.register((Object)new EventsHandlerTou());
            ClientCommandHandler.instance.registerCommand((ICommand)new CommandDupe());
            ClientCommandHandler.instance.registerCommand((ICommand)new CommandOffline());
            ClientCommandHandler.instance.registerCommand((ICommand)new CommandAdd());
            ClientCommandHandler.instance.registerCommand((ICommand)new CommandConfig());
        }
    }
    
    static {
        Decoder.oldkey = null;
        Decoder.flag = false;
    }
}
