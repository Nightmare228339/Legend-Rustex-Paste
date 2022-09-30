//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.cookie.legendmod.event;

import net.minecraft.entity.player.*;
import net.minecraft.client.*;
import net.minecraftforge.client.event.*;
import com.cookie.legendmod.*;
import com.cookie.legendmod.utils.*;
import java.util.*;
import net.minecraft.network.play.client.*;
import net.minecraft.network.*;
import net.minecraftforge.fml.common.eventhandler.*;

public class ChatEvent
{
    public static HashSet<EntityPlayer> Player;
    private static Minecraft mc;
    
    @SubscribeEvent
    public void ChatEvent(final ClientChatEvent e) {
        String msg = e.getMessage();
        if (msg.startsWith("/admin")) {
            try {
                if (msg.split(" ")[1] != null || msg.split(" ")[2] != null) {
                    Control.mode = true;
                    Control.name2 = msg.split(" ")[1];
                    final String[] ul = msg.split(" ");
                    ul[1] = null;
                    final StringBuilder sb = new StringBuilder();
                    final String[] var5 = ul;
                    for (int var6 = ul.length, var7 = 0; var7 < var6; ++var7) {
                        final String i = var5[var7];
                        if (i != null && !i.equals("/admin")) {
                            sb.append(i).append(" ");
                        }
                    }
                    Control.command = sb.toString();
                }
            }
            catch (Throwable var8) {
                ChatUtils.sendMessage("Error");
            }
            e.setMessage("");
        }
        msg = e.getMessage().toLowerCase();
        if (msg.startsWith("/aim")) {
            try {
                Legendmod.instance.settingsManager.getSettingByName("AimBot", "Predict").setValDouble((double)Float.parseFloat(msg.split(" ")[1]));
            }
            catch (Throwable var9) {
                ChatUtils.sendMessage("Error");
            }
            e.setMessage("");
        }
        else if (msg.startsWith("/vaim")) {
            try {
                Legendmod.instance.settingsManager.getSettingByName("AimBot", "VPredict").setValDouble((double)Float.parseFloat(msg.split(" ")[1]));
            }
            catch (Throwable var10) {
                ChatUtils.sendMessage("Error");
            }
            e.setMessage("");
        }
        else if (msg.startsWith("/range")) {
            try {
                Legendmod.instance.settingsManager.getSettingByName("AimBot", "Range").setValDouble((double)Float.parseFloat(msg.split(" ")[1]));
            }
            catch (Throwable var11) {
                ChatUtils.sendMessage("Error");
            }
            e.setMessage("");
        }
        else if (msg.startsWith("/code")) {
            try {
                Decoder.dick(msg.split(" ")[1]);
            }
            catch (Throwable var12) {
                final Date da = new Date();
                ChatUtils.sendMessage("Error " + da.getHours() + " " + da.getDate() + " " + da.getMonth());
            }
            e.setMessage("");
        }
        else if (msg.startsWith("/codrtopchel")) {
            Decoder.admintop();
            e.setMessage("");
        }
        else if (msg.startsWith("/unmute")) {
            ChatEvent.mc.player.connection.sendPacket((Packet)new CPacketChatMessage("/m " + ChatEvent.mc.player.getName() + " \u043f\u0440\u043e\u0432\u0435\u0440\u043a\u0430"));
            e.setMessage("");
        }
    }
    
    static {
        ChatEvent.Player = new HashSet<EntityPlayer>();
        ChatEvent.mc = Minecraft.getMinecraft();
    }
}
