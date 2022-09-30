//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.cookie.legendmod.module.RENDER;

import com.cookie.legendmod.module.*;
import java.util.*;
import com.cookie.legendmod.*;
import yea.bushroot.clickgui.*;
import net.minecraftforge.client.event.*;
import com.cookie.legendmod.utils.*;
import net.minecraftforge.fml.common.eventhandler.*;

public class BlockESP_2 extends Module
{
    public BlockESP_2() {
        super("BlockESP", 0, Module.Category.RENDER);
        final ArrayList<String> modes = new ArrayList<String>();
        modes.add("Ore");
        modes.add("Pumpkin");
        Legendmod.instance.settingsManager.rSetting(new Setting("Mode", (Module)this, (ArrayList)modes, "Mode"));
        Legendmod.instance.settingsManager.rSetting(new Setting("Trace", (Module)this, false));
    }
    
    @SubscribeEvent
    public void onRender(final RenderWorldLastEvent e) {
        if (this.toggled) {
            BlockFinder2.enable(Legendmod.instance.settingsManager.getSettingByName(this.name, "Mode").getValString(), Legendmod.instance.settingsManager.getSettingByName(this.name, "Trace").getValBoolean());
        }
    }
}
