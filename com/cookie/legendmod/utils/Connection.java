//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.cookie.legendmod.utils;

import net.minecraft.client.*;
import com.cookie.legendmod.*;
import io.netty.channel.*;

public class Connection extends ChannelDuplexHandler
{
    Minecraft mc;
    private EventsHandler eventHandler;
    
    public Connection(final EventsHandler eventHandler) {
        this.mc = Minecraft.getMinecraft();
        this.eventHandler = eventHandler;
        try {
            final ChannelPipeline pipeline = this.mc.getConnection().getNetworkManager().channel().pipeline();
            pipeline.addBefore("packet_handler", "PacketHandler", (ChannelHandler)this);
        }
        catch (Exception var3) {
            ChatUtils.sendMessage("Connection: Error on attaching");
            var3.printStackTrace();
        }
    }
    
    public void channelRead(final ChannelHandlerContext ctx, final Object packet) throws Exception {
        if (this.eventHandler.onPacket(packet, Side.IN)) {
            super.channelRead(ctx, packet);
        }
    }
    
    public void write(final ChannelHandlerContext ctx, final Object packet, final ChannelPromise promise) throws Exception {
        if (this.eventHandler.onPacket(packet, Side.OUT)) {
            super.write(ctx, packet, promise);
        }
    }
    
    public enum Side
    {
        IN, 
        OUT;
    }
}
