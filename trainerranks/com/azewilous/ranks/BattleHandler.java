package com.azewilous.ranks;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;

import com.pixelmonmod.pixelmon.api.events.PlayerBattleEndedEvent;
import com.pixelmonmod.pixelmon.battles.controller.participants.BattleParticipant;
import com.pixelmonmod.pixelmon.battles.controller.participants.ParticipantType;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class BattleHandler {
	
	@SubscribeEvent
	public void battleEnded(PlayerBattleEndedEvent event){
		BattleParticipant par1 = event.battleController.participants.get(0);
		BattleParticipant par2 = event.battleController.participants.get(1);
		//BattleParticipant par3 = event.battleController.participants.get(2);
		//BattleParticipant par4 = event.battleController.participants.get(3);
		if(par1 != null && par2 != null){
			if(par1.getType() == ParticipantType.Player && par2.getType() == ParticipantType.Player){
				if(!par1.getEntity().worldObj.isRemote){
						if(par1.hasRemainingPokemon()){
							RankHandler.recieveExp((EntityPlayerMP) par1.getEntity());
							RankHandler.rankUp((EntityPlayerMP) par1.getEntity());
							((EntityPlayerMP)par1.getEntity()).addChatMessage(new ChatComponentTranslation(EnumChatFormatting.YELLOW 
									+ "Victory Against " + par2.getName().getUnformattedTextForChat()
									+ EnumChatFormatting.YELLOW + ", You Now Have " + RankHandler.getExp((EntityPlayerMP) par1.getEntity())
									+ EnumChatFormatting.YELLOW + " PokeExp"));
						}else
							if(!par1.hasRemainingPokemon()){
							RankHandler.looseExp((EntityPlayerMP) par1.getEntity());
							RankHandler.rankUp((EntityPlayerMP) par1.getEntity());
							((EntityPlayerMP)par1.getEntity()).addChatMessage(new ChatComponentTranslation(EnumChatFormatting.YELLOW 
									+ "Defeated By " + par2.getName().getUnformattedTextForChat()
									+ EnumChatFormatting.YELLOW + ", You Now Have " + RankHandler.getExp((EntityPlayerMP) par1.getEntity())
									+ EnumChatFormatting.YELLOW + " PokeExp"));
						}else
							return;
				}
							if(!par2.getEntity().worldObj.isRemote){
								if(par2.hasRemainingPokemon()){
									RankHandler.recieveExp((EntityPlayerMP) par2.getEntity());
									RankHandler.rankUp((EntityPlayerMP) par2.getEntity());
									((EntityPlayerMP)par2.getEntity()).addChatMessage(new ChatComponentTranslation(EnumChatFormatting.YELLOW 
											+ "Victory Against " + par1.getName().getUnformattedTextForChat()
											+ EnumChatFormatting.YELLOW + ", You Now Have " + RankHandler.getExp((EntityPlayerMP) par2.getEntity())
											+ EnumChatFormatting.YELLOW + " PokeExp"));
								}else
									if(!par2.hasRemainingPokemon()){
									RankHandler.looseExp((EntityPlayerMP) par1.getEntity());
									RankHandler.rankUp((EntityPlayerMP) par1.getEntity());
									((EntityPlayerMP)par1.getEntity()).addChatMessage(new ChatComponentTranslation(EnumChatFormatting.YELLOW 
											+ "Defeated By " + par2.getName().getUnformattedTextForChat()
											+ EnumChatFormatting.YELLOW + ", You Now Have " + RankHandler.getExp((EntityPlayerMP) par1.getEntity())
											+ EnumChatFormatting.YELLOW + " PokeExp"));
								}
							}
			}else
				return;
		}
	}
}