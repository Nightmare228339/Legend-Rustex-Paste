//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.cookie.legendmod.utils.commands;

import net.minecraft.client.*;
import net.minecraft.server.*;
import net.minecraft.item.*;
import net.minecraft.command.*;

public class CommandDupe extends CommandBase
{
    Minecraft mc;
    
    public CommandDupe() {
        this.mc = Minecraft.getMinecraft();
    }
    
    public String getName() {
        return "dupe";
    }
    
    public int getRequiredPermissionLevel() {
        return 0;
    }
    
    public String getUsage(final ICommandSender sender) {
        return "/dupe <count>";
    }
    
    public void execute(final MinecraftServer server, final ICommandSender sender, final String[] args) throws CommandException {
        if (args.length == 1) {
            final ItemStack item = this.mc.player.getHeldItemMainhand();
            item.setCount(parseInt(args[0]));
            this.mc.player.inventory.offHandInventory.set(0, (Object)item);
            return;
        }
        throw new WrongUsageException("/dupe <count>", new Object[0]);
    }
}
