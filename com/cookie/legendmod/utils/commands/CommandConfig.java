//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.cookie.legendmod.utils.commands;

import net.minecraft.client.*;
import net.minecraft.server.*;
import java.io.*;
import com.cookie.legendmod.module.*;
import com.cookie.legendmod.*;
import yea.bushroot.clickgui.*;
import com.cookie.legendmod.utils.*;
import java.util.*;
import net.minecraft.command.*;
import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.*;

public class CommandConfig extends CommandBase
{
    Minecraft mc;
    
    public CommandConfig() {
        this.mc = Minecraft.getMinecraft();
    }
    
    public String getName() {
        return "config";
    }
    
    public int getRequiredPermissionLevel() {
        return 0;
    }
    
    public String getUsage(final ICommandSender sender) {
        return "/config <save/load>";
    }
    
    public void execute(final MinecraftServer server, final ICommandSender sender, final String[] args) throws CommandException {
        class 1MyThread extends Thread
        {
            @Override
            public void run() {
                try {
                    if (args[0].equals("save")) {
                        final String path = openExpl();
                        if (path == null) {
                            return;
                        }
                        final File file = new File(path);
                        try {
                            if (file.createNewFile()) {
                                ChatUtils.sendMessage("\u0444\u0430\u0439\u043b \u0441\u043e\u0437\u0434\u0430\u043d");
                            }
                        }
                        catch (Throwable t) {}
                        final ArrayList<LinkedHashMap<String, String>> conf = new ArrayList<LinkedHashMap<String, String>>();
                        for (final Module module : Client.modules) {
                            final LinkedHashMap<String, String> hashMap = new LinkedHashMap<String, String>();
                            hashMap.put(module.getName(), String.valueOf(module.toggled));
                            if (Legendmod.instance.settingsManager.getSettingsByMod(module) == null) {
                                conf.add(hashMap);
                            }
                            else {
                                if (!Legendmod.instance.settingsManager.getSettingsByMod(module).isEmpty()) {
                                    for (final Setting setting : Legendmod.instance.settingsManager.getSettingsByMod(module)) {
                                        if (setting.getType().equals("Boolean")) {
                                            hashMap.put(setting.getName(), String.valueOf(setting.getValBoolean()));
                                        }
                                        else if (setting.getType().equals("Boolean")) {
                                            hashMap.put(setting.getName(), String.valueOf(setting.getValString()));
                                        }
                                        else {
                                            if (!setting.getType().equals("Double")) {
                                                continue;
                                            }
                                            hashMap.put(setting.getName(), String.valueOf(setting.getValDouble()));
                                        }
                                    }
                                }
                                conf.add(hashMap);
                            }
                        }
                        Config.SaveCfg(file, conf);
                    }
                    else if (args[0].equals("load")) {
                        final String path = openExpl();
                        if (path == null) {
                            return;
                        }
                        final File file = new File(path);
                        Config.LoadCfg(file);
                    }
                }
                catch (Throwable exception) {
                    try {
                        throw new WrongUsageException(CommandConfig.this.getUsage(sender), new Object[0]);
                    }
                    catch (WrongUsageException e) {
                        ChatUtils.sendMessage(CommandConfig.this.getUsage(sender));
                    }
                }
            }
        }
        final Thread thread = new 1MyThread();
        thread.start();
    }
    
    private static String openExpl() {
        final JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setDialogTitle("Select an config");
        jfc.setAcceptAllFileFilterUsed(false);
        final FileNameExtensionFilter filter = new FileNameExtensionFilter("CFG config files", new String[] { "cfg" });
        jfc.addChoosableFileFilter(filter);
        final int returnValue = jfc.showOpenDialog(null);
        if (returnValue != 0) {
            return null;
        }
        return jfc.getSelectedFile().getPath();
    }
}
