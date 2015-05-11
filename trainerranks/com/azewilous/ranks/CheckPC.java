package com.azewilous.ranks;

import java.util.List;

import com.pixelmonmod.pixelmon.Pixelmon;
import com.pixelmonmod.pixelmon.battles.BattleRegistry;
import com.pixelmonmod.pixelmon.enums.EnumGui;
import com.pixelmonmod.pixelmon.storage.ComputerBox;
import com.pixelmonmod.pixelmon.storage.PCClient;
import com.pixelmonmod.pixelmon.storage.PCClientStorage;
import com.pixelmonmod.pixelmon.storage.PCServer;
import com.pixelmonmod.pixelmon.storage.PixelmonStorage;
import com.pixelmonmod.pixelmon.storage.PlayerComputerStorage;
import com.pixelmonmod.pixelmon.storage.PlayerStorage;
import com.pixelmonmod.pixelmon.storage.ServerStorage;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.PlayerNotFoundException;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;

public class CheckPC extends CommandBase implements ICommand{

	@Override
	public int compareTo(Object arg0) {
		return 0;
	}

	@Override
	public String getCommandName() {
		return "pcopen";
	}

	@Override
	public String getCommandUsage(ICommandSender p_71518_1_) {
		return "pc <playername>";
	}

	@Override
	public List getCommandAliases() {
		return null;
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args) {
		EntityPlayerMP player = (EntityPlayerMP) sender;
		if(args.length == 0){
			if(BattleRegistry.getBattle(player) == null){
				
				player.openGui(Pixelmon.instance, EnumGui.PC.getIndex().intValue(), player.getEntityWorld(), 0, 0, 0);
			}else
				if(args.length == 1){
					EntityPlayerMP tarpl = getPlayer(player, args[1]);
					try {
						if(BattleRegistry.getBattle(tarpl) == null){
							tarpl.openGui(Pixelmon.instance, EnumGui.PC.getIndex().intValue(), tarpl.getEntityWorld(), 0, 0, 0);
						}
					}catch (PlayerNotFoundException pnfe){
						player.addChatMessage(new ChatComponentTranslation(EnumChatFormatting.RED 
								+ "Player Not Found Exception"));
					}
				}
		}
	}

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender p_71519_1_) {
		return true;
	}

	@Override
	public List addTabCompletionOptions(ICommandSender p_71516_1_,
			String[] p_71516_2_) {
		return null;
	}

	@Override
	public boolean isUsernameIndex(String[] p_82358_1_, int p_82358_2_) {
		return false;
	}

}
