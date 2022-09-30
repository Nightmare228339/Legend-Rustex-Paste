//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.cookie.legendmod.mixin;

import net.minecraft.network.handshake.client.*;
import net.minecraft.network.*;
import java.io.*;
import org.spongepowered.asm.mixin.*;

@Mixin({ C00Handshake.class })
public class MixinC00Handshake
{
    @Shadow
    private int protocolVersion;
    @Shadow
    private String ip;
    @Shadow
    private int port;
    @Shadow
    private EnumConnectionState requestedState;
    
    @Overwrite
    public void writePacketData(final PacketBuffer buf) throws IOException {
        buf.writeVarInt(this.protocolVersion);
        buf.writeString(this.ip);
        buf.writeShort(this.port);
        buf.writeVarInt(this.requestedState.getId());
    }
}
