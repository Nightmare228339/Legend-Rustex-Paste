//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.cookie.legendmod.keys;

import net.minecraftforge.fml.common.gameevent.*;
import org.lwjgl.input.*;
import com.cookie.legendmod.module.MISC.*;
import net.minecraft.client.*;
import com.cookie.legendmod.*;
import net.minecraft.client.gui.*;
import com.cookie.legendmod.module.RENDER.*;
import com.cookie.legendmod.module.COMBAT.*;
import net.minecraftforge.fml.common.eventhandler.*;

public class key
{
    @SubscribeEvent
    public void onKeyInput(final InputEvent.KeyInputEvent e) {
        if (Keyboard.isKeyDown(Keyboard.getEventKey()) && Keyboard.getEventKey() != 0) {
            Client.keyPress(Keyboard.getEventKey());
            if (Keyboard.getEventKey() == 210 && !Panic.isPanic) {
                Minecraft.getMinecraft().displayGuiScreen((GuiScreen)Legendmod.instance.clickGui);
            }
            if (Keyboard.getEventKey() == 46) {
                Zoom.togglezoom();
            }
            if (Keyboard.getEventKey() == 29) {
                AutoReload.iscontrol = true;
            }
            else {
                AutoReload.iscontrol = false;
            }
        }
    }
}
