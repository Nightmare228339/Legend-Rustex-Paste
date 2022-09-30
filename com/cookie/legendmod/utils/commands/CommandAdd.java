//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Наталья\Desktop\project\Decompile\DeobfMineObf\1.12 stable mappings"!

//Decompiled by Procyon!

package com.cookie.legendmod.utils.commands;

import net.minecraft.client.*;
import net.minecraft.server.*;
import com.cookie.legendmod.utils.*;
import net.minecraft.item.*;
import net.minecraft.command.*;

public class CommandAdd extends CommandBase
{
    Minecraft mc;
    
    public CommandAdd() {
        this.mc = Minecraft.getMinecraft();
    }
    
    public String getName() {
        return "add";
    }
    
    public int getRequiredPermissionLevel() {
        return 0;
    }
    
    public String getUsage(final ICommandSender sender) {
        return "/add <count> || /add <name> <count>";
    }
    
    public void execute(final MinecraftServer server, final ICommandSender sender, final String[] args) throws CommandException {
        if (args.length == 1) {
            final ItemStack item = this.mc.player.getHeldItemMainhand().copy();
            item.setCount(parseInt(args[0]));
            this.mc.player.inventory.addItemStackToInventory(item);
        }
        else {
            if (args.length != 2) {
                throw new WrongUsageException("/add <count> || /add <name> <count>", new Object[0]);
            }
            if (args[0].equals("lr")) {
                this.mc.player.inventory.addItemStackToInventory(Guns.getLR(args[1]));
            }
            if (args[0].equals("ak")) {
                this.mc.player.inventory.addItemStackToInventory(Guns.getAK(args[1], false));
            }
        }
    }
}
