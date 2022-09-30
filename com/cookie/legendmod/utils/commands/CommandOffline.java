//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.cookie.legendmod.utils.commands;

import net.minecraft.server.*;
import net.minecraft.util.math.*;
import javax.annotation.*;
import com.cookie.legendmod.module.EXPLOIT.*;
import net.minecraft.client.network.*;
import java.util.*;
import com.cookie.legendmod.utils.*;
import net.minecraft.command.*;

public class CommandOffline extends CommandBase
{
    private static ArrayList<String> nick;
    
    public static ArrayList<String> getNick() {
        return CommandOffline.nick;
    }
    
    public String getName() {
        return "offline";
    }
    
    public int getRequiredPermissionLevel() {
        return 0;
    }
    
    public String getUsage(final ICommandSender sender) {
        return "/offline help";
    }
    
    public List<String> getTabCompletions(final MinecraftServer server, final ICommandSender sender, final String[] args, @Nullable final BlockPos targetPos) {
        try {
            if (args.length == 1) {
                return (List<String>)getListOfStringsMatchingLastWord(args, new String[] { "help", "clear", "add", "remove", "check", "list" });
            }
            final ArrayList<String> templist = new ArrayList<String>();
            for (final NetworkPlayerInfo ii : OfflineCheck.getList()) {
                templist.add(ii.getGameProfile().getName());
            }
            return (args.length == 2) ? getListOfStringsMatchingLastWord(args, (Collection)templist) : Collections.emptyList();
        }
        catch (Throwable throwable) {
            return Collections.emptyList();
        }
    }
    
    public void execute(final MinecraftServer server, final ICommandSender sender, final String[] args) throws CommandException {
        if (args.length == 1) {
            final String s2;
            final String s = s2 = args[0];
            switch (s2) {
                case "list": {
                    ChatUtils.sendMessage(CommandOffline.nick.toString());
                    break;
                }
                case "clear": {
                    CommandOffline.nick.clear();
                    OfflineCheck.offlined.clear();
                    ChatUtils.sendMessage("list cleared");
                    break;
                }
                case "help": {
                    ChatUtils.sendMessage("/offline list - write list");
                    ChatUtils.sendMessage("/offline clear - clear list");
                    ChatUtils.sendMessage("/offline add <name> - add <name> to list");
                    ChatUtils.sendMessage("/offline remove <name> - remove <name> from the list");
                    ChatUtils.sendMessage("/offline check <name> - check online");
                    break;
                }
            }
        }
        else {
            if (args.length != 2) {
                throw new WrongUsageException("/offline help", new Object[0]);
            }
            if (args[0].equals("add")) {
                CommandOffline.nick.add(args[1]);
                ChatUtils.sendMessage(args[1] + " added to the list");
            }
            else if (args[0].equals("remove")) {
                OfflineCheck.offlined.remove(args[1]);
                CommandOffline.nick.remove(args[1]);
                ChatUtils.sendMessage(args[1] + " removed from the list");
            }
            else if (args[0].equals("check")) {
                ChatUtils.sendMessage(OfflineCheck.check(args[1]));
            }
        }
    }
    
    static {
        CommandOffline.nick = new ArrayList<String>();
    }
}
