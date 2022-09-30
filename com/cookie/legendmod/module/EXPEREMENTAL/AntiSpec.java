//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.cookie.legendmod.module.EXPEREMENTAL;

import com.cookie.legendmod.module.*;
import net.minecraft.entity.*;
import net.minecraftforge.fml.common.gameevent.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import com.cookie.legendmod.utils.*;
import net.minecraftforge.fml.common.eventhandler.*;
import java.util.*;

public class AntiSpec extends Module
{
    private static List<Entity> Spectators;
    
    public AntiSpec() {
        super("AntiSpec", 0, Category.EXPEREMENTAL);
    }
    
    @SubscribeEvent
    public void onWorldTick(final TickEvent.PlayerTickEvent e) {
        if (this.toggled) {
            AntiSpec.mc.playerController.setGameType(GameType.SPECTATOR);
            for (final EntityPlayer entityPlayer : AntiSpec.mc.world.playerEntities) {
                if (entityPlayer.capabilities.isFlying && entityPlayer != AntiSpec.mc.player) {
                    ChatUtils.sendMessage("!WARNING! " + entityPlayer.getName() + " is Spectator");
                    AntiSpec.Spectators.add((Entity)entityPlayer);
                }
                AntiSpec.mc.playerController.setGameType(GameType.SURVIVAL);
            }
        }
    }
    
    @Override
    public void onDisable() {
        AntiSpec.mc.playerController.setGameType(GameType.SURVIVAL);
        AntiSpec.Spectators.clear();
    }
    
    static {
        AntiSpec.Spectators = new ArrayList<Entity>();
    }
}
