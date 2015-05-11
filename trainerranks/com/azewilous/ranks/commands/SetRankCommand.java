package com.azewilous.ranks.commands;

import java.util.List;

import com.azewilous.ranks.RankHandler;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;

public class SetRankCommand extends CommandBase implements ICommand {

	@Override
	public String getCommandName() {
		return "rankset";
	}

	@Override
	public String getCommandUsage(ICommandSender p_71518_1_) {
		return "rankset";
	}

	@Override
	public void processCommand(ICommandSender commandSender, String[] args) {
		EntityPlayerMP player = (EntityPlayerMP) commandSender;
		if(args.length == 0){
			player.addChatMessage(new ChatComponentTranslation(EnumChatFormatting.RED 
					+ "Too Few Arguments"));
		}else
			if(args.length == 1){
				if(args[0].equalsIgnoreCase("trainer")){
					if(!RankHandler.trainers.contains(player)){
						RankHandler.trainers.add(player);
					}else
						player.addChatMessage(new ChatComponentTranslation(EnumChatFormatting.RED 
								+ "You Are Already In The Group " + RankHandler.trainer));
				}else
					if(args[0].equalsIgnoreCase("rktrainer")){
						if(!RankHandler.rkTrainers.contains(player)){
							RankHandler.rkTrainers.add(player);
						}else
							player.addChatMessage(new ChatComponentTranslation(EnumChatFormatting.RED
									+ "You Are Already In The Group " + RankHandler.rkTrainer));
					}else
						if(args[0].equalsIgnoreCase("snrtrainer")){
							if(!RankHandler.snrTrainers.contains(player)){
								RankHandler.snrTrainers.add(player);
							}else player.addChatMessage(new ChatComponentTranslation(EnumChatFormatting.RED
									+ "You Are Already In The Group " + RankHandler.snrTrainer));
						}else
							if(args[0].equalsIgnoreCase("edtrainer")){
								if(!RankHandler.edTrainers.contains(player)){
									RankHandler.edTrainers.add(player);
								}else player.addChatMessage(new ChatComponentTranslation(EnumChatFormatting.RED
										+ "You Are Already In The Group " + RankHandler.edTrainer));
							}else
								if(args[0].equalsIgnoreCase("eltrainer")){
									if(!RankHandler.elTrainers.contains(player)){
										RankHandler.elTrainers.add(player);
									}else player.addChatMessage(new ChatComponentTranslation(EnumChatFormatting.RED
											+ "You Are Already In The Group " + RankHandler.elTrainer));
								}else
									if(args[0].equalsIgnoreCase("mstrainer")){
										if(!RankHandler.msTrainers.contains(player)){
											RankHandler.msTrainers.add(player);
										}else player.addChatMessage(new ChatComponentTranslation(EnumChatFormatting.RED
												+ "You Are Already In The Group " + RankHandler.msTrainer));
									}else
										if(args[0].equalsIgnoreCase("pmmaster")){
											if(!RankHandler.pmMasters.contains(player)){
												RankHandler.pmMasters.add(player);
											}else player.addChatMessage(new ChatComponentTranslation(EnumChatFormatting.RED
													+ "You Are Already In The Group " + RankHandler.pmMaster));
										}
			}else
				if(args.length == 2){
					EntityPlayerMP tarpl = getPlayer(commandSender, args[1]);
					if(args[0].equalsIgnoreCase("trainer")){
						if(!RankHandler.trainers.contains(tarpl)){
							RankHandler.trainers.add(tarpl);
						}else
							player.addChatMessage(new ChatComponentTranslation(EnumChatFormatting.RED 
									+ "You Are Already In The Group" + RankHandler.trainer));
					}else
						if(args[0].equalsIgnoreCase("rktrainer")){
							if(!RankHandler.rkTrainers.contains(tarpl)){
								RankHandler.rkTrainers.add(tarpl);
							}else
								player.addChatMessage(new ChatComponentTranslation(EnumChatFormatting.RED
										+ "You Are Already In The Group" + RankHandler.rkTrainer));
						}else
							if(args[0].equalsIgnoreCase("snrtrainer")){
								if(!RankHandler.snrTrainers.contains(tarpl)){
									RankHandler.snrTrainers.add(tarpl);
								}else player.addChatMessage(new ChatComponentTranslation(EnumChatFormatting.RED
										+ "You Are Already In The Group" + RankHandler.snrTrainer));
							}else
								if(args[0].equalsIgnoreCase("edtrainer")){
									if(!RankHandler.edTrainers.contains(tarpl)){
										RankHandler.edTrainers.add(tarpl);
									}else player.addChatMessage(new ChatComponentTranslation(EnumChatFormatting.RED
											+ "You Are Already In The Group" + RankHandler.edTrainer));
								}else
									if(args[0].equalsIgnoreCase("eltrainer")){
										if(!RankHandler.elTrainers.contains(tarpl)){
											RankHandler.elTrainers.add(tarpl);
										}else player.addChatMessage(new ChatComponentTranslation(EnumChatFormatting.RED
												+ "You Are Already In The Group" + RankHandler.elTrainer));
									}else
										if(args[0].equalsIgnoreCase("mstrainer")){
											if(!RankHandler.msTrainers.contains(tarpl)){
												RankHandler.msTrainers.add(tarpl);
											}else player.addChatMessage(new ChatComponentTranslation(EnumChatFormatting.RED
													+ "You Are Already In The Group" + RankHandler.msTrainer));
										}else
											if(args[0].equalsIgnoreCase("pmmaster")){
												if(!RankHandler.pmMasters.contains(tarpl)){
													RankHandler.pmMasters.add(tarpl);
												}else player.addChatMessage(new ChatComponentTranslation(EnumChatFormatting.RED
														+ "You Are Already In The Group" + RankHandler.pmMaster));
											}
				
				}
	}

	@Override
	public int compareTo(Object o) {
		return 0;
	}

	@Override
	public List getCommandAliases() {
		return null;
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
	public int getRequiredPermissionLevel(){
		return 2;
	}
	
	@Override
	public boolean isUsernameIndex(String[] p_82358_1_, int p_82358_2_) {
		return false;
	}

}