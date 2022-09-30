//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.cookie.legendmod.module.RENDER;

import com.cookie.legendmod.module.*;
import net.minecraftforge.client.event.*;
import net.minecraft.entity.player.*;
import org.lwjgl.opengl.*;
import net.minecraft.util.math.*;
import net.minecraft.util.text.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.gui.*;
import net.minecraft.entity.*;
import net.minecraftforge.fml.common.eventhandler.*;

public class NameTags extends Module
{
    private int armourCompress;
    private int armourSpacing;
    
    public NameTags() {
        super("NameTags", 0, Module.Category.RENDER);
    }
    
    @SubscribeEvent
    public void onRender(final RenderLivingEvent.Specials.Pre e) {
        final RenderItem itemRender = NameTags.mc.getRenderItem();
        final FontRenderer fr = NameTags.mc.fontRenderer;
        final EntityLivingBase entity = e.getEntity();
        if (!(entity instanceof EntityPlayer) || entity == NameTags.mc.player) {
            return;
        }
        if (entity.isDead || entity.getHealth() < 0.0f || entity.isInvisible()) {
            return;
        }
        GL11.glPushMatrix();
        final Vec3d pos = new Vec3d(e.getX(), e.getY() + entity.height / 1.5, e.getZ());
        GL11.glTranslated(pos.x, pos.y + 1.0, pos.z);
        final double scale = Math.max(1.0, pos.distanceTo(new Vec3d(0.0, 0.0, 0.0)) / 6.0);
        GL11.glScaled(scale, scale, scale);
        final int health = (int)Math.ceil(entity.getHealth());
        EntityRenderer.drawNameplate(NameTags.mc.fontRenderer, entity.getDisplayName().getFormattedText() + TextFormatting.RED + " " + health, 0.0f, 0.0f, 0.0f, 0, NameTags.mc.getRenderManager().playerViewY, NameTags.mc.getRenderManager().playerViewX, NameTags.mc.gameSettings.thirdPersonView == 2, false);
        GL11.glPopMatrix();
        e.setCanceled(true);
    }
}
