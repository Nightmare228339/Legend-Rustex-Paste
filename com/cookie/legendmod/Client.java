//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.cookie.legendmod;

import java.util.concurrent.*;
import com.cookie.legendmod.module.*;
import yea.bushroot.clickgui.*;
import org.lwjgl.opengl.*;
import com.cookie.legendmod.module.EXPEREMENTAL.*;
import com.cookie.legendmod.module.MOVEMENT.*;
import com.cookie.legendmod.module.PLAYER.*;
import com.cookie.legendmod.module.COMBAT.*;
import com.cookie.legendmod.module.RENDER.*;
import com.cookie.legendmod.module.MISC.*;
import com.cookie.legendmod.module.EXPLOIT.*;
import java.util.*;

public class Client
{
    public static String Clname;
    public static CopyOnWriteArrayList<Module> modules;
    public static ClickGuiManager clickGuiManager;
    
    public static void startup() {
        Display.setTitle(Client.Clname = "Legend Client 1.12.2");
        Client.modules.add(new Fly());
        Client.modules.add(new Time());
        Client.modules.add(new Zoom());
        Client.modules.add(new Temp());
        Client.modules.add(new Panic());
        Client.modules.add(new Sneak());
        Client.modules.add(new Sprint());
        Client.modules.add(new BoxESP());
        Client.modules.add(new NoFall());
        Client.modules.add(new AimBot());
        Client.modules.add(new NoHand());
        Client.modules.add(new Strafe());
        Client.modules.add(new InvWalk());
        Client.modules.add(new AirJump());
        Client.modules.add(new GlowESP());
        Client.modules.add(new Players());
        Client.modules.add(new AtackTp());
        Client.modules.add(new ClickTp());
        Client.modules.add(new Tracers());
        Client.modules.add(new LowJump());
        Client.modules.add(new AntiBot());
        Client.modules.add(new NoArmor());
        Client.modules.add(new AutoPeek());
        Client.modules.add(new ArmorHUD());
        Client.modules.add(new Platform());
        Client.modules.add(new AntiSpec());
        Client.modules.add(new WallHack());
        Client.modules.add(new NameTags());
        Client.modules.add(new KillAura());
        Client.modules.add(new GayFinder());
        Client.modules.add(new HightJump());
        Client.modules.add(new JoinCheck());
        Client.modules.add(new BlockReach());
        Client.modules.add(new TriggerBot());
        Client.modules.add(new FullBright());
        Client.modules.add(new BlockESP_2());
        Client.modules.add(new AutoReload());
        Client.modules.add(new AutoClicker());
        Client.modules.add(new PlayerCheck());
        Client.modules.add(new MiddleClick());
        Client.modules.add(new HouseRender());
        Client.modules.add(new SleeperCheck());
        Client.modules.add(new FakeCreative());
        Client.modules.add(new ClickPosInfo());
        Client.modules.add(new OfflineCheck());
        Client.clickGuiManager = new ClickGuiManager();
    }
    
    public static ArrayList<Module> getModulesInCategory(final Module.Category c) {
        final ArrayList<Module> mods = new ArrayList<Module>();
        for (final Module m : Client.modules) {
            if (m.category.name().equalsIgnoreCase(c.name())) {
                mods.add(m);
            }
        }
        return mods;
    }
    
    public static void keyPress(final int key) {
        for (final Module m : Client.modules) {
            if (m.getKey() == key) {
                m.toggle();
            }
        }
    }
    
    static {
        Client.modules = new CopyOnWriteArrayList<Module>();
    }
}
