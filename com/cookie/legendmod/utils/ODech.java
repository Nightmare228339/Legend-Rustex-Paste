//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.cookie.legendmod.utils;

import net.minecraft.client.*;
import java.net.*;
import com.cookie.legendmod.*;
import java.io.*;

public class ODech
{
    public void run() {
        final int serverPort = 19171;
        final String address = "46.180.196.53";
        final Minecraft mc = Minecraft.getMinecraft();
        try {
            final Socket socket = new Socket(address, serverPort);
            final InputStream sin = socket.getInputStream();
            final OutputStream sout = socket.getOutputStream();
            final DataInputStream in = new DataInputStream(sin);
            new DataOutputStream(sout);
            final PrintWriter write = new PrintWriter(socket.getOutputStream(), true);
            write.println(System.getProperty("user.name"));
            final String line = in.readLine();
            Legendmod.flag = line.equals("true");
        }
        catch (IOException var11) {
            var11.printStackTrace();
        }
    }
}
