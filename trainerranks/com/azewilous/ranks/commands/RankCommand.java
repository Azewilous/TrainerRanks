package com.azewilous.ranks.commands;

import java.util.ArrayList;
import java.util.List;

import com.azewilous.ranks.RankHandler;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;

public class RankCommand extends CommandBase implements ICommand {
	
	private List aliases;
	
	public RankCommand(){
	   this.aliases = new ArrayList();
	   this.aliases.add("r");
	}
	
	@Override
	public int compareTo(Object o) {
		return 0;
	}

	@Override
	public String getCommandName() {
		return "rank";
	}

	@Override
	public String getCommandUsage(ICommandSender p_71518_1_) {
		return "rank";
	}

	@Override
	public List getCommandAliases() {
		return this.aliases;
	}
	
	@Override
	public void processCommand(ICommandSender commandSender, String[] args) {
		EntityPlayerMP player = (EntityPlayerMP) commandSender;
		if(args.length == 0){
			commandSender.addChatMessage(new ChatComponentTranslation(EnumChatFormatting.RED 
					+ "Too Few Arguments"));
		}else
			if(args.length == 1){
				if(args[0].equalsIgnoreCase("requirement")){
					commandSender.addChatMessage(new ChatComponentTranslation(EnumChatFormatting.RED 
							+ "Too Few Arguments"));
				}else 
					if(args[0].equalsIgnoreCase("check")){
							commandSender.addChatMessage(new ChatComponentTranslation(EnumChatFormatting.GREEN
									+ "Your Rank Is " + RankHandler.getRank(player)));
						} 
					}else
						if(args.length == 2){
							if(args[0].equalsIgnoreCase("requirement")){
								RankHandler.getRankRequirement(player, args);
								}else
									if(args[0].equalsIgnoreCase("check")){
										EntityPlayerMP tarpl = getPlayer(commandSender, args[1]);
										if(tarpl != null){
											commandSender.addChatMessage(new ChatComponentTranslation(EnumChatFormatting.GREEN
													+ "Your Rank Is " + RankHandler.getRank(tarpl)));
										}else
											commandSender.addChatMessage(new ChatComponentTranslation(EnumChatFormatting.RED
													+ "The Player " + args[1] + EnumChatFormatting.RED + " Is Not Online"));
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
