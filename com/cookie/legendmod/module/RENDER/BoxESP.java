//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.cookie.legendmod.module.RENDER;

import com.cookie.legendmod.module.*;
import net.minecraft.util.math.*;
import com.cookie.legendmod.*;
import yea.bushroot.clickgui.*;
import net.minecraftforge.client.event.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import com.cookie.legendmod.module.COMBAT.*;
import net.minecraft.entity.item.*;
import net.minecraft.client.*;
import com.cookie.legendmod.utils.*;
import java.util.*;
import net.minecraftforge.fml.common.eventhandler.*;

public class BoxESP extends Module
{
    AxisAlignedBB box;
    
    public BoxESP() {
        super("BoxESP", 0, Module.Category.RENDER);
        this.box = null;
        Legendmod.instance.settingsManager.rSetting(new Setting("ArmorStand", (Module)this, false));
        Legendmod.instance.settingsManager.rSetting(new Setting("Items", (Module)this, false));
    }
    
    @SubscribeEvent
    public void onRender(final RenderWorldLastEvent e) {
        for (final Entity entity : BoxESP.mc.world.loadedEntityList) {
            if (entity == null) {
                return;
            }
            if (entity instanceof EntityPlayer && AntiBot.check((EntityPlayer)entity)) {
                continue;
            }
            if ((!(entity instanceof EntityPlayer) && (!Legendmod.instance.settingsManager.getSettingByName(this.name, "ArmorStand").getValBoolean() || !(entity instanceof EntityArmorStand)) && (!(entity instanceof EntityItem) || !Legendmod.instance.settingsManager.getSettingByName(this.name, "Items").getValBoolean())) || entity == BoxESP.mc.player || entity.getDistance((Entity)BoxESP.mc.player) > 256.0f) {
                continue;
            }
            RenderUtils.FillLine(entity, this.box = new AxisAlignedBB(entity.getEntityBoundingBox().minX - 0.05 - entity.posX + ((float)((float)entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * Minecraft.getMinecraft().getRenderPartialTicks()) - Minecraft.getMinecraft().getRenderManager().viewerPosX), entity.getEntityBoundingBox().minY - entity.posY + ((float)((float)entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * Minecraft.getMinecraft().getRenderPartialTicks()) - Minecraft.getMinecraft().getRenderManager().viewerPosY), entity.getEntityBoundingBox().minZ - 0.05 - entity.posZ + ((float)((float)entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * Minecraft.getMinecraft().getRenderPartialTicks()) - Minecraft.getMinecraft().getRenderManager().viewerPosZ), entity.getEntityBoundingBox().maxX + 0.05 - entity.posX + ((float)((float)entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * Minecraft.getMinecraft().getRenderPartialTicks()) - Minecraft.getMinecraft().getRenderManager().viewerPosX), entity.getEntityBoundingBox().maxY + 0.1 - entity.posY + ((float)((float)entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * Minecraft.getMinecraft().getRenderPartialTicks()) - Minecraft.getMinecraft().getRenderManager().viewerPosY), entity.getEntityBoundingBox().maxZ + 0.05 - entity.posZ + ((float)((float)entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * Minecraft.getMinecraft().getRenderPartialTicks()) - Minecraft.getMinecraft().getRenderManager().viewerPosZ)));
        }
    }
}
