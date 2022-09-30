//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.cookie.legendmod.module.MISC;

import com.cookie.legendmod.module.*;
import net.minecraft.entity.*;
import net.minecraftforge.fml.common.gameevent.*;
import com.cookie.legendmod.utils.*;
import java.util.*;
import net.minecraftforge.fml.common.eventhandler.*;

public class Players extends Module
{
    private ArrayList<Entity> PlayersList;
    
    public Players() {
        super("Players", 0, Category.MISC);
        this.PlayersList = new ArrayList<Entity>();
    }
    
    @SubscribeEvent
    public void onWorldRender(final TickEvent.RenderTickEvent e) {
        if (this.toggled) {
            for (final Entity playerEntity : Players.mc.world.playerEntities) {
                if (!this.PlayersList.contains(playerEntity)) {
                    System.out.println(Players.mc.world.playerEntities);
                    ChatUtils.sendMessage(playerEntity.getName() + " | " + playerEntity.posX + " " + playerEntity.posY + " " + playerEntity.posZ);
                    System.out.println(playerEntity.getName() + " | " + playerEntity.posX + " " + playerEntity.posY + " " + playerEntity.posZ);
                    this.PlayersList.add(playerEntity);
                }
            }
        }
    }
    
    @Override
    public void onDisable() {
        this.PlayersList.clear();
    }
}
