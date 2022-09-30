//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.cookie.legendmod.module.RENDER;

import com.cookie.legendmod.module.*;
import com.cookie.legendmod.*;
import yea.bushroot.clickgui.*;
import net.minecraftforge.client.event.*;
import net.minecraft.item.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import com.cookie.legendmod.utils.*;
import com.cookie.legendmod.module.COMBAT.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.gui.*;
import java.util.*;
import net.minecraftforge.fml.common.eventhandler.*;

public class ArmorHUD extends Module
{
    private int offHandHeldItemCount;
    private int armourCompress;
    private int armourSpacing;
    
    public ArmorHUD() {
        super("ArmorHUD", 0, Module.Category.RENDER);
        Legendmod.instance.settingsManager.rSetting(new Setting("Enemy", (Module)this, false));
    }
    
    @SubscribeEvent
    public void onRenderGameOverlay(final RenderGameOverlayEvent.Text event) {
        final ScaledResolution resolution = new ScaledResolution(ArmorHUD.mc);
        final RenderItem itemRender = ArmorHUD.mc.getRenderItem();
        final FontRenderer fr = ArmorHUD.mc.fontRenderer;
        GlStateManager.enableTexture2D();
        final int i = resolution.getScaledWidth() / 2;
        int iteration = 0;
        final int y = resolution.getScaledHeight() - 55 - (ArmorHUD.mc.player.isInWater() ? 10 : 0);
        for (final ItemStack is : ArmorHUD.mc.player.inventory.armorInventory) {
            ++iteration;
            if (is.isEmpty()) {
                continue;
            }
            final int x = i - 90 + 19 * iteration;
            RenderUtils.renderItem(is, x, y);
        }
        RenderUtils.renderItem(ArmorHUD.mc.player.getHeldItemMainhand(), i - 90, y);
        if (Legendmod.instance.settingsManager.getSettingByName(this.name, "Enemy").getValBoolean()) {
            int miteration = 0;
            for (final Entity entity : ArmorHUD.mc.world.getLoadedEntityList()) {
                if (entity instanceof EntityPlayer) {
                    if (entity == ArmorHUD.mc.player) {
                        continue;
                    }
                    if (FriendManager.friendsList.contains(entity.getName())) {
                        continue;
                    }
                    if (AntiBot.check((EntityPlayer)entity)) {
                        continue;
                    }
                    ++miteration;
                    final int i2 = resolution.getScaledWidth();
                    int iteration2 = 0;
                    final int y2 = resolution.getScaledHeight() - 20 * miteration;
                    for (final ItemStack is2 : ((EntityPlayer)entity).inventory.armorInventory) {
                        ++iteration2;
                        if (is2.isEmpty()) {
                            continue;
                        }
                        final int x2 = i2 - 90 + 19 * iteration2;
                        RenderUtils.renderItem(is2, x2, y2);
                    }
                    RenderUtils.renderItem(((EntityPlayer)entity).getHeldItemMainhand(), i2 - 96, y2);
                    ArmorHUD.mc.fontRenderer.drawString(((EntityPlayer)entity).getDisplayNameString(), i2 - 77, y2 - 5, -1);
                    if (miteration <= 11) {
                        continue;
                    }
                    miteration = 0;
                }
            }
        }
    }
}
