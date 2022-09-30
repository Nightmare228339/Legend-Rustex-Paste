//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.cookie.legendmod.module.COMBAT;

import com.cookie.legendmod.module.*;
import com.cookie.legendmod.utils.*;
import net.minecraftforge.fml.common.gameevent.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import net.minecraftforge.fml.common.eventhandler.*;
import java.util.*;

public class AntiBot extends Module
{
    public TimerUtils timer;
    public static Set<String> black;
    
    public AntiBot() {
        super("AntiBot", 0, Category.COMBAT);
        this.timer = new TimerUtils();
    }
    
    @SubscribeEvent
    public void onPlayerTick(final TickEvent.PlayerTickEvent e) {
        final List<EntityPlayer> players = (List<EntityPlayer>)AntiBot.mc.world.playerEntities;
        for (int i = 0; i < players.size(); ++i) {
            final EntityPlayer ep = (EntityPlayer)players.toArray()[i];
            if (ep.isInvisible() || AntiBot.black.contains(ep.getName())) {
                AntiBot.black.add(ep.getName());
                AntiBot.mc.world.removeEntity((Entity)ep);
            }
        }
        if (this.timer.isDelay(60000L)) {
            AntiBot.black.clear();
        }
    }
    
    @Override
    public void onDisable() {
        AntiBot.black.clear();
        super.onDisable();
    }
    
    public static boolean check(final EntityPlayer player) {
        if (player.isInvisible() || AntiBot.black.contains(player.getName())) {
            AntiBot.black.add(player.getName());
            return true;
        }
        return false;
    }
    
    static {
        AntiBot.black = new HashSet<String>();
    }
}
