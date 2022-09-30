//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.cookie.legendmod;

import com.cookie.legendmod.utils.*;
import com.cookie.legendmod.module.*;
import net.minecraft.client.*;
import java.util.*;

public class EventsHandler
{
    private boolean initialized;
    
    public EventsHandler() {
        this.initialized = false;
    }
    
    public boolean onPacket(final Object packet, final Connection.Side side) {
        boolean suc = true;
        for (final Module module : Client.modules) {
            if (module.isEnabled()) {
                if (Minecraft.getMinecraft().world == null) {
                    continue;
                }
                suc &= module.onPacket(packet, side);
            }
        }
        return suc;
    }
}
