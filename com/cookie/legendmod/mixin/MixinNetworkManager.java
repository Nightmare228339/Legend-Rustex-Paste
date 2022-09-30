//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.cookie.legendmod.mixin;

import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import net.minecraft.client.*;
import net.minecraftforge.fml.common.network.internal.*;
import net.minecraft.network.play.client.*;
import io.netty.buffer.*;
import net.minecraft.network.*;
import java.lang.reflect.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin({ NetworkManager.class })
public class MixinNetworkManager
{
    @Inject(method = { "sendPacket" }, at = { @At("HEAD") }, cancellable = true)
    public void sendPacket(final Packet<?> packet, final CallbackInfo callbackInfo) {
        if (Minecraft.getMinecraft().isIntegratedServerRunning()) {
            return;
        }
        if (packet instanceof FMLProxyPacket) {
            callbackInfo.cancel();
            return;
        }
        if (packet instanceof CPacketCustomPayload) {
            final CPacketCustomPayload packetCustomPayload = (CPacketCustomPayload)packet;
            final String channelName = packetCustomPayload.getChannelName();
            if (!channelName.startsWith("MC|")) {
                callbackInfo.cancel();
            }
            else if (channelName.equalsIgnoreCase("MC|Brand")) {
                final PacketBuffer packetBuffer = new PacketBuffer(Unpooled.buffer()).writeString("vanilla");
                try {
                    final Field field = packetCustomPayload.getClass().getDeclaredField("data");
                    field.setAccessible(true);
                    field.set(packetCustomPayload, packetBuffer);
                }
                catch (NoSuchFieldException e3) {
                    try {
                        final Field field2 = packetCustomPayload.getClass().getDeclaredField("data");
                        field2.setAccessible(true);
                        field2.set(packetCustomPayload, packetBuffer);
                    }
                    catch (NoSuchFieldException | IllegalAccessException ex2) {
                        final ReflectiveOperationException ex;
                        final ReflectiveOperationException e1 = ex;
                        e1.printStackTrace();
                    }
                }
                catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
