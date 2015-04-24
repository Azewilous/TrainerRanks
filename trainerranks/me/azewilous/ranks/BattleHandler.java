package me.azewilous.ranks;

import java.util.ArrayList;
import java.util.List;

import com.pixelmonmod.pixelmon.api.events.BattleStartedEvent;
import com.pixelmonmod.pixelmon.api.events.PlayerBattleEndedEvent;
import com.pixelmonmod.pixelmon.battles.controller.BattleControllerBase;
import com.pixelmonmod.pixelmon.battles.controller.participants.BattleParticipant;
import com.pixelmonmod.pixelmon.battles.controller.participants.ParticipantType;
import com.pixelmonmod.pixelmon.battles.controller.participants.PlayerParticipant;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatComponentText;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class BattleHandler {
	
	EntityPlayerMP player;
	
	@SubscribeEvent
	public void resultOfBattle(BattleStartedEvent bse){
		BattleParticipant par1 = bse.participant1;
		BattleParticipant par2 = bse.participant2;
		if(par1.getEntity() == player && par2.getEntity() == player){
			if(!par1.hasMorePokemon()){
				RankHandler.looseExp(player);
				RankHandler.rankUp(player);
				player.addChatComponentMessage(new ChatComponentText("Out Of Pokemon You Lost The Battle And Now Have " 
						+ RankHandler.pokeExp.get(player) + " PokeExp"));
				}else
					if(!par2.hasMorePokemon()){
						RankHandler.looseExp(player);
						RankHandler.rankUp(player);
						player.addChatComponentMessage(new ChatComponentText("Out Of Pokemon You Lost The Battle And Now Have " 
								+ RankHandler.pokeExp.get(player) + " PokeExp"));
					}else
						if(par1.hasMorePokemon()){
					RankHandler.recieveExp(player);
			 	 	RankHandler.rankUp(player);
			 	 	player.addChatComponentMessage(new ChatComponentText("You Have Won The Battle And Now Have " 
			 	 			+ RankHandler.pokeExp.get(player) + " PokeExp"));
						}else
							if(par2.hasMorePokemon()){
								RankHandler.recieveExp(player);
						 	 	RankHandler.rankUp(player);
						 	 	player.addChatComponentMessage(new ChatComponentText("You Have Won The Battle And Now Have " 
						 	 			+ RankHandler.pokeExp.get(player) + " PokeExp"));
							}
		}else
			player.addChatMessage(new ChatComponentText("Not A PvP Battle No PokeExp Will Be Rewarded"));
	}
}
