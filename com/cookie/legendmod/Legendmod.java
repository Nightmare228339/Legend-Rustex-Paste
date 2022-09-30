//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.cookie.legendmod;

import net.minecraftforge.fml.common.*;
import yea.bushroot.clickgui.*;
import org.apache.logging.log4j.*;
import com.cookie.legendmod.utils.*;
import org.lwjgl.opengl.*;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.common.*;
import com.cookie.legendmod.keys.*;
import com.cookie.legendmod.ui.*;
import com.cookie.legendmod.event.*;
import net.minecraftforge.client.*;
import net.minecraft.command.*;
import com.cookie.legendmod.utils.commands.*;
import net.minecraft.init.*;

@Mod(modid = "legendmod", name = "Legend Client", version = "0.7.5")
public class Legendmod
{
    String user;
    private static final String[] Users;
    public static final String MODID = "legendmod";
    public static final String NAME = "Legend Client";
    public static final String VERSION = "0.7.5";
    public static boolean t;
    public static boolean flag;
    public static Legendmod instance;
    public SettingsManager settingsManager;
    public ClickGuiManager clickGui;
    private static Logger logger;
    
    public Legendmod() {
        this.user = System.getProperty("user.name");
    }
    
    public static void main(final String[] args) {
    }
    
    @Mod.EventHandler
    public void preInit(final FMLPreInitializationEvent event) {
        try {
            new ODech().run();
        }
        catch (Throwable t) {}
        Client.Clname = "Legend Client 1.12.2";
        Display.setTitle("Loading " + Client.Clname);
        Legendmod.logger = event.getModLog();
    }
    
    @Mod.EventHandler
    public void init(final FMLInitializationEvent event) {
        this.clickGui = new ClickGuiManager();
        Legendmod.instance = this;
        this.settingsManager = new SettingsManager();
        MinecraftForge.EVENT_BUS.register((Object)new ChatEvent());
        for (final String var5 : Legendmod.Users) {
            if (Legendmod.flag) {
                Client.startup();
                Display.setTitle(Client.Clname = "Legend Client 1.12.2");
                MinecraftForge.EVENT_BUS.register((Object)new key());
                MinecraftForge.EVENT_BUS.register((Object)new UI());
                MinecraftForge.EVENT_BUS.register((Object)new EventsHandlerTou());
                ClientCommandHandler.instance.registerCommand((ICommand)new CommandOffline());
                ClientCommandHandler.instance.registerCommand((ICommand)new CommandDupe());
                ClientCommandHandler.instance.registerCommand((ICommand)new CommandAdd());
                ClientCommandHandler.instance.registerCommand((ICommand)new CommandConfig());
                break;
            }
            Display.setTitle("Minecraft 1.12.2");
            Legendmod.logger.info("DIRT BLOCK >> {}", (Object)Blocks.DIRT.getRegistryName());
        }
    }
    
    static {
        Users = new String[] { "Sosat", "Xyi" };
        Legendmod.t = false;
        Legendmod.flag = false;
    }
}
