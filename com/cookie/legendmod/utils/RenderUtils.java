//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.cookie.legendmod.utils;

import net.minecraft.client.*;
import net.minecraft.entity.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.math.*;
import net.minecraft.item.*;
import net.minecraft.client.renderer.*;

public class RenderUtils
{
    static Minecraft mc;
    
    public static void trace(final Minecraft mc, final Entity e, final float partialTicks, final int mode) {
        if (mc.getRenderManager().renderViewEntity != null) {
            GL11.glDisable(2929);
            GL11.glDisable(2896);
            GL11.glLineWidth(2.0f);
            GL11.glPushMatrix();
            GL11.glDepthMask(false);
            GL11.glColor4d((mode == 0) ? 1.0 : 0.0, (mode == 1) ? 1.0 : 0.0, 0.0, 1.0);
            GL11.glBlendFunc(770, 771);
            GL11.glDisable(3553);
            GL11.glBegin(1);
            final RenderManager r = mc.getRenderManager();
            final Vec3d v = new Vec3d(0.0, 0.0, 1.0).rotatePitch(-(float)Math.toRadians(mc.player.rotationPitch)).rotateYaw(-(float)Math.toRadians(mc.player.rotationYaw));
            GL11.glVertex3d(v.x, mc.player.getEyeHeight() + v.y, v.z);
            final double x = e.lastTickPosX + (e.posX - e.lastTickPosX) * partialTicks;
            final double y = e.lastTickPosY + (e.posY - e.lastTickPosY) * partialTicks;
            final double z = e.lastTickPosZ + (e.posZ - e.lastTickPosZ) * partialTicks;
            GL11.glVertex3d(x - r.viewerPosX, y - r.viewerPosY + 0.25, z - r.viewerPosZ);
            GL11.glEnd();
            GL11.glDepthMask(true);
            GL11.glEnable(2929);
            GL11.glEnable(3553);
            GL11.glPopMatrix();
        }
    }
    
    public static void trace(final Minecraft mc, final Blockinfo blockinfo, final float partialTicks) {
        if (mc.getRenderManager().renderViewEntity != null) {
            GL11.glDisable(2929);
            GL11.glDisable(2896);
            GL11.glLineWidth(2.0f);
            GL11.glPushMatrix();
            GL11.glDepthMask(false);
            GL11.glColor4d((double)blockinfo.getR(), (double)blockinfo.getG(), (double)blockinfo.getB(), 1.0);
            GL11.glBlendFunc(770, 771);
            GL11.glDisable(3553);
            GL11.glBegin(1);
            final RenderManager r = mc.getRenderManager();
            final Vec3d v = new Vec3d(0.0, 0.0, 1.0).rotatePitch(-(float)Math.toRadians(mc.player.rotationPitch)).rotateYaw(-(float)Math.toRadians(mc.player.rotationYaw));
            GL11.glVertex3d(v.x, mc.player.getEyeHeight() + v.y, v.z);
            final double x = blockinfo.getX();
            final double y = blockinfo.getY();
            final double z = blockinfo.getZ();
            GL11.glVertex3d(x - r.viewerPosX, y - r.viewerPosY + 0.25, z - r.viewerPosZ);
            GL11.glEnd();
            GL11.glDepthMask(true);
            GL11.glEnable(2929);
            GL11.glEnable(3553);
            GL11.glEnable(2896);
            GL11.glPopMatrix();
        }
    }
    
    public static void FillLine(final Entity entity, final AxisAlignedBB box) {
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(3042);
        GL11.glLineWidth(2.0f);
        GL11.glDisable(3553);
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        if (!FriendManager.friendsList.contains(entity.getName())) {
            RenderGlobal.renderFilledBox(box, 1.0f, 0.0f, 0.0f, 0.3f);
            RenderGlobal.drawSelectionBoundingBox(box, 1.0f, 0.0f, 0.0f, 0.8f);
        }
        else {
            RenderGlobal.renderFilledBox(box, 0.0f, 1.0f, 0.0f, 0.3f);
            RenderGlobal.drawSelectionBoundingBox(box, 0.0f, 1.0f, 0.0f, 0.8f);
        }
        GL11.glEnable(3553);
        GL11.glEnable(2929);
        GL11.glDepthMask(true);
        GL11.glDisable(3042);
    }
    
    public static void plato(final Entity e, final float partialTicks, final Minecraft mc, final float roll) {
        GL11.glDisable(2896);
        GL11.glEnable(3042);
        GL11.glLineWidth(2.0f);
        GL11.glPushMatrix();
        GL11.glRotatef(180.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScalef(0.12f, 1.0f, 0.12f);
        GL11.glBlendFunc(770, 771);
        GL11.glDisable(3553);
        GL11.glPushMatrix();
        GL11.glRotatef(roll, 0.0f, 1.0f, 0.0f);
        GL11.glBegin(4);
        final RenderManager r = mc.getRenderManager();
        final double xmn = 2.0;
        final double x = e.lastTickPosX + (e.posX - e.lastTickPosX) * partialTicks;
        final double y = e.lastTickPosY + (e.posY - e.lastTickPosY) * partialTicks;
        final double z = e.lastTickPosZ + (e.posZ - e.lastTickPosZ) * partialTicks;
        final double xur = e.lastTickPosX + 1.0 + (e.posX + 1.0 - e.lastTickPosX + 1.0) * partialTicks;
        final double zur = e.lastTickPosZ + 1.0 + (e.posZ + 1.0 - e.lastTickPosZ + 1.0) * partialTicks;
        final double xdr = e.lastTickPosX + xmn + (e.posX + xmn - e.lastTickPosX + xmn) * partialTicks;
        final double zdr = e.lastTickPosZ - 1.1 + (e.posZ - 1.1 - e.lastTickPosZ - 1.1) * partialTicks;
        final double zul = e.lastTickPosZ + 2.0 + (e.posZ + 2.0 - e.lastTickPosZ + 2.0) * partialTicks;
        final double xdl = e.lastTickPosX - xmn + (e.posX - xmn - e.lastTickPosX - xmn) * partialTicks;
        final double zdl = e.lastTickPosZ - 1.1 + (e.posZ - 1.1 - e.lastTickPosZ - 1.1) * partialTicks;
        GL11.glColor4d(0.7059, 0.1053, 0.1053, 0.6000000238418579);
        GL11.glVertex3d(x - r.viewerPosX, y - r.viewerPosY - 0.001, zul - r.viewerPosZ + 2.0);
        GL11.glVertex3d(xdl - r.viewerPosX - 1.0, y - r.viewerPosY - 0.001, zdl - r.viewerPosZ - 1.1);
        GL11.glVertex3d(xdr - r.viewerPosX + 1.0, y - r.viewerPosY - 0.001, zdr - r.viewerPosZ - 1.1);
        GL11.glEnd();
        GL11.glPopMatrix();
        GL11.glDepthMask(true);
        GL11.glEnable(3553);
        GL11.glDisable(3042);
        GL11.glEnable(2896);
        GL11.glPopMatrix();
    }
    
    public static void vod(final Entity e, final float partialTicks, final Minecraft mc) {
        GL11.glDisable(2929);
        GL11.glDisable(2896);
        GL11.glLineWidth(2.0f);
        GL11.glPushMatrix();
        GL11.glDepthMask(false);
        GL11.glBlendFunc(770, 771);
        GL11.glDisable(3553);
        GL11.glPushMatrix();
        GL11.glBegin(1);
        final RenderManager r = mc.getRenderManager();
        final double x = e.lastTickPosX + (e.posX - e.lastTickPosX) * partialTicks;
        final double y = e.lastTickPosY + 1.7000000476837158 + (e.posY + 1.7000000476837158 - e.lastTickPosY + 1.7000000476837158) * partialTicks;
        final double z = e.lastTickPosZ + (e.posZ - e.lastTickPosZ) * partialTicks;
        ChatUtils.sendMessage(x + " " + y + " " + z);
        GL11.glVertex3d(x - r.viewerPosX, y - 1.7 - r.viewerPosY - 1.7, z - r.viewerPosZ);
        GL11.glVertex3d(x - r.viewerPosX, y - r.viewerPosY + 1.7, z - r.viewerPosZ);
        ChatUtils.sendMessage(x - r.viewerPosX + " " + (y - r.viewerPosY) + " " + (z - r.viewerPosZ));
        GL11.glEnd();
        GL11.glPopMatrix();
        GL11.glDepthMask(true);
        GL11.glEnable(2929);
        GL11.glEnable(3553);
        GL11.glDisable(3042);
        GL11.glPopMatrix();
    }
    
    public static void blockESP(final BlockPos blockPos, final float r, final float g, final float b) {
        GL11.glPushMatrix();
        final double x = blockPos.getX() - Minecraft.getMinecraft().getRenderManager().viewerPosX;
        final double y = blockPos.getY() - Minecraft.getMinecraft().getRenderManager().viewerPosY;
        final double z = blockPos.getZ() - Minecraft.getMinecraft().getRenderManager().viewerPosZ;
        GL11.glDisable(3553);
        GL11.glDisable(2929);
        GL11.glDisable(2896);
        GL11.glDepthMask(false);
        RenderGlobal.drawSelectionBoundingBox(new AxisAlignedBB(x, y, z, x + 1.0, y + 1.0, z + 1.0), r, g, b, 0.5f);
        GL11.glEnable(3553);
        GL11.glEnable(2929);
        GL11.glEnable(2896);
        GL11.glDepthMask(true);
        GL11.glPopMatrix();
    }
    
    public static void renderItem(final ItemStack itemStack, final int x, final int y) {
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GlStateManager.enableDepth();
        RenderHelper.enableGUIStandardItemLighting();
        RenderUtils.mc.getRenderItem().renderItemAndEffectIntoGUI(itemStack, x, y);
        RenderUtils.mc.getRenderItem().renderItemOverlays(RenderUtils.mc.fontRenderer, itemStack, x, y);
        RenderHelper.disableStandardItemLighting();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.disableDepth();
    }
    
    static {
        RenderUtils.mc = Minecraft.getMinecraft();
    }
}
