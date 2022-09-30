//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.cookie.legendmod.utils;

import com.cookie.legendmod.module.*;
import com.cookie.legendmod.*;
import java.util.*;
import yea.bushroot.clickgui.*;
import java.io.*;

public class Config
{
    public static void LoadCfg(final File config) throws FileNotFoundException {
        final Scanner scanner = new Scanner(config);
        while (scanner.hasNextLine()) {
            final String str = scanner.nextLine();
            final String[] args = str.split(":");
            int count = 0;
            String func = null;
            boolean enabled = false;
            final ArrayList<String> funcs = new ArrayList<String>();
            final ArrayList<String> values = new ArrayList<String>();
            for (final String arg : args) {
                if (count == 0) {
                    func = arg;
                }
                else if (count == 1) {
                    enabled = arg.equals("true");
                }
                else if (count % 2 == 0) {
                    funcs.add(arg);
                }
                else {
                    values.add(arg);
                }
                ++count;
            }
            final LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
            for (int i = 0; i < funcs.size(); ++i) {
                map.put(funcs.get(i), values.get(i));
                map.put(funcs.get(i), values.get(i));
            }
            loadfunc(func, enabled, map);
        }
        scanner.close();
    }
    
    private static void loadfunc(final String FuncName, final boolean enabled, final LinkedHashMap<String, String> options) {
        final Module module = Module.getModuleByName(FuncName);
        if (module != null) {
            if (enabled) {
                module.toggled = enabled;
                module.onEnable();
            }
            else if (module.toggled) {
                module.toggled = enabled;
                module.onDisable();
            }
        }
        if (!options.isEmpty()) {
            for (final String oname : options.keySet()) {
                final String oval = options.get(oname);
                final Setting setting = Legendmod.instance.settingsManager.getSettingByName(FuncName, oname);
                if (setting == null) {
                    return;
                }
                if (setting.getType().equals("Boolean")) {
                    setting.setValBoolean(oval.equals("true"));
                }
                else if (setting.getType().equals("String")) {
                    setting.setValString(oval);
                }
                else {
                    if (!setting.getType().equals("Double")) {
                        continue;
                    }
                    setting.setValDouble(Double.parseDouble(oval));
                }
            }
        }
    }
    
    public static void SaveCfg(final File config, final ArrayList<LinkedHashMap<String, String>> optionss) throws IOException {
        final FileWriter fileWriter = new FileWriter(config);
        for (final LinkedHashMap<String, String> options : optionss) {
            for (final String arg : options.keySet()) {
                final String text = arg + ":" + options.get(arg) + ":";
                fileWriter.write(text);
            }
            fileWriter.append('\n');
        }
        fileWriter.flush();
        fileWriter.close();
    }
}
