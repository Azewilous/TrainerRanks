package me.azewilous.ranks.commands;

import java.util.List;

import me.azewilous.ranks.RankHandler;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

public class SetExpCommand extends CommandBase implements ICommand {

	@Override
	public int compareTo(Object o) {
		return 0;
	}

	@Override
	public String getCommandName() {
		return "pokeexp";
	}

	@Override
	public String getCommandUsage(ICommandSender p_71518_1_) {
		return "pokeexp <give/set/check>";
	}

	@Override
	public List getCommandAliases() {
		return null;
	}

	public int getRequiredPermissionLevel(){
		return 2;
	}
	
	@Override
	public void processCommand(ICommandSender commandSender, String[] args) {
		EntityPlayerMP player = (EntityPlayerMP) commandSender;
		if(args.length == 0){
			player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.RED 
					+ "Too Few Arguments"));
		}else
			if(args.length == 1){
				if(args[0].equalsIgnoreCase("give")){
					player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.RED 
							+ "Too Few Arguments"));
				}else
					if(args[0].equalsIgnoreCase("set")){
						player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.RED 
								+ "Too Few Arguments"));
					}else
						if(args[0].equalsIgnoreCase("check")){
							RankHandler.checkExp(player);
							player.addChatMessage(new ChatComponentText(EnumChatFormatting.GRAY + "Your pokeExp is " + RankHandler.getExp(player)));
						}
			}else
				if(args.length == 2){
					if(args[0].equalsIgnoreCase("give")){
						RankHandler.giveExp(player, args);
						player.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN 
								+ "You Have Been Given " + args[1] + " PokeExp"));
					}else
						if(args[0].equalsIgnoreCase("set")){
							RankHandler.setExp(player, args);
							player.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN 
									+ "Your PokeExp Has Been Set To " + args[1]));
						}else
							if(args[0].equalsIgnoreCase("check")){
								EntityPlayerMP tarpl = getPlayer(commandSender, args[2]);
								RankHandler.checkExp(tarpl);
							}
					}else
						if(args.length == 3){
							EntityPlayerMP tarpl = getPlayer(commandSender, args[2]);
							if(args[0].equalsIgnoreCase("give")){
								RankHandler.giveExp(tarpl, args);
								player.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN + "You Have Given " + tarpl 
										+ "  " + args[1] + EnumChatFormatting.GREEN + " PokeExp"));
								tarpl.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN + "You Have Been Given " + args[1] 
										+ EnumChatFormatting.GREEN + " PokeExp By " + player));
							}else
								if(args[0].equalsIgnoreCase("set")){
									RankHandler.giveExp(tarpl, args);
									player.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN + "You Have Set " + tarpl 
											+ EnumChatFormatting.GREEN + " PokeExp to " + args[1]));
									tarpl.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN + "Your PokeExp Has Been Set To " + args[1] 
											+ EnumChatFormatting.GREEN + " By " + player));
								}else
									if(args[0].equalsIgnoreCase("check")){
										RankHandler.checkExp(tarpl);
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
