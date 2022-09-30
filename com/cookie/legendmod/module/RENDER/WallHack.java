//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.cookie.legendmod.module.RENDER;

import com.cookie.legendmod.module.*;
import com.cookie.legendmod.*;
import yea.bushroot.clickgui.*;
import net.minecraftforge.client.event.*;
import net.minecraft.client.renderer.*;
import net.minecraftforge.fml.common.eventhandler.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.entity.item.*;
import java.util.*;

public class WallHack extends Module
{
    private static Set<Entity> memed;
    Entity arm;
    
    public WallHack() {
        super("WallHack", 0, Module.Category.RENDER);
        Legendmod.instance.settingsManager.rSetting(new Setting("ArmorStand", (Module)this, false));
    }
    
    @SubscribeEvent
    public void onRenderWorldLast(final RenderWorldLastEvent event) {
        if (this.toggled) {
            GlStateManager.clear(256);
            RenderHelper.enableStandardItemLighting();
            for (final Object object : WallHack.mc.world.getLoadedEntityList()) {
                final Entity entity = (Entity)object;
                this.render(entity, event.getPartialTicks());
            }
            for (final Object obj : WallHack.memed) {
                final Entity entity = (Entity)obj;
                this.render(entity, event.getPartialTicks());
            }
        }
    }
    
    void render(final Entity entity, final float ticks) {
        final Entity ent = this.checkEntity(entity);
        if (ent == null || ent == WallHack.mc.player) {
            return;
        }
        if (ent == WallHack.mc.getRenderViewEntity() && WallHack.mc.gameSettings.thirdPersonView == 0) {
            return;
        }
        WallHack.mc.entityRenderer.disableLightmap();
        WallHack.mc.getRenderManager().renderEntityStatic(ent, ticks, false);
        WallHack.mc.entityRenderer.enableLightmap();
    }
    
    Entity checkEntity(final Entity e) {
        Entity entity = null;
        if (e instanceof EntityPlayer) {
            entity = e;
        }
        else if (e instanceof EntityLiving) {
            entity = e;
        }
        else if (e instanceof EntityItem) {
            entity = e;
        }
        else if (e instanceof EntityArrow) {
            entity = e;
        }
        else if (e instanceof EntityArmorStand && Legendmod.instance.settingsManager.getSettingByName(this.name, "ArmorStand").getValBoolean()) {
            entity = e;
            WallHack.memed.add(e);
        }
        return entity;
    }
    
    public void onDisable() {
        WallHack.memed.clear();
    }
    
    static {
        WallHack.memed = new HashSet<Entity>();
    }
}
