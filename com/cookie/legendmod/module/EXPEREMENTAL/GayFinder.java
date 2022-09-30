//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.cookie.legendmod.module.EXPEREMENTAL;

import com.cookie.legendmod.module.*;
import net.minecraftforge.fml.common.gameevent.*;
import net.minecraft.entity.*;
import net.minecraft.client.*;
import net.minecraft.util.text.*;
import java.util.*;
import net.minecraftforge.fml.common.eventhandler.*;
import net.minecraft.world.*;

public class GayFinder extends Module
{
    private static String[] players;
    
    public GayFinder() {
        super("GayFinder", 0, Category.EXPEREMENTAL);
    }
    
    @SubscribeEvent
    public void onWorldRender(final TickEvent.RenderTickEvent e) {
        if (this.toggled) {
            for (final Entity gay : GayFinder.mc.world.playerEntities) {
                final String Seaxa = "Seaxa";
                final String guy = gay.getName();
                GayFinder.players[0] = Seaxa;
                GayFinder.players[1] = guy;
                System.out.println(GayFinder.players[0] + " " + GayFinder.players[1]);
                if (GayFinder.players[0].equals(GayFinder.players[1])) {
                    final String msg = TextFormatting.LIGHT_PURPLE + "Gay was finded " + TextFormatting.GREEN + "Name: " + gay.getName();
                    final String prefix = TextFormatting.GRAY + "[" + TextFormatting.RED + "Gay Finder" + TextFormatting.GRAY + "]: " + TextFormatting.WHITE;
                    Minecraft.getMinecraft().player.sendMessage((ITextComponent)new TextComponentString(prefix + msg));
                    this.toggle();
                }
                else {
                    GayFinder.players[0] = null;
                    GayFinder.players[1] = null;
                }
            }
        }
    }
    
    @Override
    public void onDisable() {
        GayFinder.mc.playerController.setGameType(GameType.SURVIVAL);
    }
    
    static {
        GayFinder.players = new String[2];
    }
}
