//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.cookie.legendmod.mixin;

import net.minecraft.client.network.*;
import net.minecraft.network.play.server.*;
import net.minecraft.util.*;
import net.minecraft.client.multiplayer.*;
import net.minecraft.world.*;
import net.minecraft.client.gui.*;
import io.netty.buffer.*;
import net.minecraft.network.*;
import net.minecraft.client.*;
import net.minecraft.network.play.client.*;
import org.spongepowered.asm.mixin.*;

@Mixin({ NetHandlerPlayClient.class })
public class MixinNetHandlerPlayClient
{
    @Shadow
    private Minecraft client;
    @Shadow
    private WorldClient world;
    @Shadow
    public int currentServerMaxPlayers;
    @Shadow
    @Final
    private NetworkManager netManager;
    
    @Overwrite
    public void handleJoinGame(final SPacketJoinGame packetIn) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet)packetIn, (INetHandler)this, (IThreadListener)this.client);
        this.client.playerController = new PlayerControllerMP(this.client, (NetHandlerPlayClient)this);
        this.world = new WorldClient((NetHandlerPlayClient)this, new WorldSettings(0L, packetIn.getGameType(), false, packetIn.isHardcoreMode(), packetIn.getWorldType()), packetIn.getDimension(), packetIn.getDifficulty(), this.client.profiler);
        this.client.gameSettings.difficulty = packetIn.getDifficulty();
        this.client.loadWorld(this.world);
        this.client.player.dimension = packetIn.getDimension();
        this.client.displayGuiScreen((GuiScreen)new GuiDownloadTerrain());
        this.client.player.setEntityId(packetIn.getPlayerId());
        this.currentServerMaxPlayers = packetIn.getMaxPlayers();
        this.client.player.setReducedDebug(packetIn.isReducedDebugInfo());
        this.client.playerController.setGameType(packetIn.getGameType());
        this.client.gameSettings.sendSettingsToServer();
        this.netManager.sendPacket((Packet)new CPacketCustomPayload("MC|Brand", new PacketBuffer(Unpooled.buffer()).writeString(ClientBrandRetriever.getClientModName())));
    }
}
