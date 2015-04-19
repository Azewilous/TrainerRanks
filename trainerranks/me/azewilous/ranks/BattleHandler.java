package me.azewilous.ranks;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatComponentText;

import com.pixelmonmod.pixelmon.api.events.BeatTrainerEvent;
import com.pixelmonmod.pixelmon.api.events.PlayerBattleEndedEvent;
import com.pixelmonmod.pixelmon.api.events.PlayerBattleEndedEvent.battleResults;
import com.pixelmonmod.pixelmon.battles.controller.BattleControllerBase;
import com.pixelmonmod.pixelmon.battles.controller.participants.BattleParticipant;
import com.pixelmonmod.pixelmon.battles.controller.participants.ParticipantType;
import com.pixelmonmod.pixelmon.battles.controller.participants.PixelmonWrapper;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class BattleHandler {
	
	@SubscribeEvent
	 public void resultOfBattle(PlayerBattleEndedEvent pbee){
		 EntityPlayerMP player = pbee.player;
		 BattleParticipant bplayer = pbee.battleController.getParticipantForEntity(player);
		 if(!bplayer.hasMorePokemon()){
			 RankHandler.looseExp(player);
			 player.addChatComponentMessage(new ChatComponentText("Out Of Pokemon You Lost The Battle And Now Have " 
					 + RankHandler.looseExp(player) + " PokeExp"));
		 }else
			 player.addChatComponentMessage(new ChatComponentText("You Have Won The Battle And Now Have " 
					 + RankHandler.recieveExp(player) + " PokeExp"));
			 RankHandler.recieveExp(player);
	 } 	
}
