package me.azewilous.ranks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

import com.pixelmonmod.pixelmon.api.events.BeatTrainerEvent;
import com.pixelmonmod.pixelmon.api.events.PlayerBattleEndedEvent;
import com.pixelmonmod.pixelmon.battles.controller.participants.BattleParticipant;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class RankHandler {

	 public static HashMap<EntityPlayerMP, Double> pokeExp = new HashMap<EntityPlayerMP, Double>();
	
	 public static List<EntityPlayerMP> trainers = new ArrayList<EntityPlayerMP>();
	 public static List<EntityPlayerMP> rkTrainers = new ArrayList<EntityPlayerMP>();
	 public static List<EntityPlayerMP> snrTrainers = new ArrayList<EntityPlayerMP>();
	 public static List<EntityPlayerMP> edTrainers = new ArrayList<EntityPlayerMP>();
	 public static List<EntityPlayerMP> elTrainers = new ArrayList<EntityPlayerMP>();
	 public static List<EntityPlayerMP> msTrainers = new ArrayList<EntityPlayerMP>();
	 public static List<EntityPlayerMP> pmMasters = new ArrayList<EntityPlayerMP>();
	 
	 public static String trainer = "Trainer";
	 public static String rkTrainer = "Rookie Triner";
	 public static String snrTrainer = "Senoir Trainer";
	 public static String edTrainer = "Elder Trainer";
	 public static String elTrainer = "Elite Trainer";
	 public static String msTrainer = "Master Trainer";
	 public static String pmMaster = "Pokemon Master";
	 
	 static Double recieveExp;
	 static Double looseExp;

	 public static void giveExp(EntityPlayerMP player, String[] args){
		 Double ppokeExp = pokeExp.get(player);
		 Double dpokeExp = Double.valueOf(args[1]);
		 Double spokeExp = ppokeExp + dpokeExp;
		 pokeExp.put(player, spokeExp);
	 }
	 
	 public static Double getExp(EntityPlayerMP player){
		 Double amount = pokeExp.get(player);
		 return amount;
	 }
	 
	 public static Double checkExp(EntityPlayerMP player){
		 Double amount = pokeExp.get(player);
		 return amount;
	}
	 
	 public static void setExp(EntityPlayerMP player, String[] args){
		 Double dpokeExp = Double.valueOf(args[1]);
		 pokeExp.put(player, dpokeExp);
	 }
	 
	 public static boolean rankUp(EntityPlayerMP player){
		 if(getExp(player) >= 0 && getExp(player) < 300){
			 if(!trainers.contains(player)){
				 trainers.add(player);
				 player.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN 
						 + "Ranked Up To " + trainer));
				 return true;
			 }else
				 player.addChatMessage(new ChatComponentText(EnumChatFormatting.RED 
						 + "You Are Already In The Group " + trainer 
						 + " And You Need " + (300 - getExp(player)) + EnumChatFormatting.RED + " PokeExp To Rank Up To " + rkTrainer));
		 }else
			 if(getExp(player) >= 300 && getExp(player) < 610){
				 if(!rkTrainers.contains(player)){
					 rkTrainers.add(player);
					 player.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN 
							 + "Ranked Up To " + rkTrainer));
					 return true;
				 }else
					 player.addChatMessage(new ChatComponentText(EnumChatFormatting.RED 
							 + "You Are Already In The Group " + rkTrainer
							 + " And And You Need " + (610 - getExp(player)) + EnumChatFormatting.RED + " PokeExp To Rank Up To " + snrTrainer));
			 }else
				 if(getExp(player) >= 610 && getExp(player) < 920){
					 if(!snrTrainers.contains(player)){
						 snrTrainers.add(player);
						 player.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN 
								 + "Ranked Up To " + snrTrainer));
						 return true;
					 }else
						 player.addChatMessage(new ChatComponentText(EnumChatFormatting.RED 
								 + "You Are Already In The Group " + snrTrainer
								 + " And You Need " + (1230 - getExp(player)) + EnumChatFormatting.RED + " PokeExp To Rank Up To " + edTrainer));
				 }else
					 if(getExp(player) >= 1230 && getExp(player) < 1540){
						 if(!edTrainers.contains(player)){
							 edTrainers.add(player);
							 player.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN 
									 + "Ranked Up To " + edTrainer));
							 return true;
						 }else
							 player.addChatMessage(new ChatComponentText(EnumChatFormatting.RED 
									 + "You Are Already In The Group " + edTrainer
									 + " And You Need " + (1540 - getExp(player)) + EnumChatFormatting.RED + " PokeExp To Rank Up To " + elTrainer));
					 }else
						 if(getExp(player) >= 1540 && getExp(player) < 1850){
							 if(!elTrainers.contains(player)){
								 elTrainers.add(player);
								 player.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN 
										 + "Ranked Up To " + elTrainer));
								 return true;
							 }else
								 player.addChatMessage(new ChatComponentText(EnumChatFormatting.RED 
										 + "You Are Already In The Group " + elTrainer
										 + " And You Need " + (1850 - getExp(player)) + EnumChatFormatting.RED + " PokeExp To Rank Up To " + msTrainer));
						 }else
							 if(getExp(player) >= 1850 && getExp(player) < 2160){
								 if(!msTrainers.contains(player)){
									 msTrainers.add(player);
									 player.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN
											 + "Ranked Up To " + msTrainer));
									 return true;
								 }else
									 player.addChatMessage(new ChatComponentText(EnumChatFormatting.RED 
											 + "You Are Already In The Group " + msTrainer
											 + " And You Need " + (2160 - getExp(player)) + EnumChatFormatting.RED + " PokeExp To Rank Up To " + pmMaster));
							 }else
								 if(getExp(player) >= 2160){
									 if(!pmMasters.contains(player)){
										 pmMasters.add(player);
										 player.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN 
												 + "Ranked Up To " + pmMaster));
										 return true;
									 }else
										 player.addChatMessage(new ChatComponentText(EnumChatFormatting.RED 
												 + "You Are Already In The Group " + pmMaster));
								 }
		return false;
	 }
	 
	 public static String canRankUp(EntityPlayerMP player){
		 if(getExp(player) >= 0 && getExp(player) <= 300){
			 return "You Can Rank Up To" + trainer;
		 }else
			 return null;
	 }
	 
	 public static String getRankRequirement(EntityPlayerMP player, String[] args){
		 if(args[1].equals("trianer")){
			 return "Requirement Is 0 PokeExp";
		 }else 
			 if(args[1].equals("rktrianer")){
				 return "Requirement Is 300 PokeExp";
			 }else 
				 if(args[1].equals("snrtrianer")){
					 return "Requirement Is 610 PokeExp";
				 }else 
					 if(args[1].equals("edtrianer")){
						 return "Requirement Is 1230 PokeExp";
					 }else 
						 if(args[1].equals("eltrianer")){
							 return "Requirement Is 1540 PokeExp";
						 }else 
							 if(args[1].equals("mstrianer")){
								 return "Requirement Is 1850 PokeExp";
							 }else 
								 if(args[1].equals("pmmaster")){
									 return "Requirement Is 2160 PokeExp";
								 }
		return null; 
	 }
	 
	 public static String getRank(EntityPlayerMP player){
		 if(trainers.contains(player)){
			 return trainer;	 
		 }else
			 if(rkTrainers.contains(player)){
				 return rkTrainer;
			 }else
				 if(snrTrainers.contains(player)){
					 return snrTrainer;
				 }else
					 if(edTrainers.contains(player)){
						 return edTrainer;
					 }else
						 if(elTrainers.contains(player)){
							 return elTrainer;
						 }else
							 if(msTrainers.contains(player)){
								 return msTrainer;
							 }else
								 if(pmMasters.contains(player)){
									 return pmMaster;
								 }
		return null;
	 } 
	 
	 public static Double recieveExp(EntityPlayerMP player){
		 if(trainers.contains(player)){
			 recieveExp = (getExp(player) + 100);
		 }else
			 if(rkTrainers.contains(player)){
				 recieveExp = (getExp(player) + 110);
			 }else
				 if(snrTrainers.contains(player)){
					 recieveExp = (getExp(player) + 120);
				 }else
					 if(edTrainers.contains(player)){
						 recieveExp = (getExp(player) + 130);
					 }else
						 if(elTrainers.contains(player)){
							 recieveExp = (getExp(player) + 140);
						 }else
							 if(msTrainers.contains(player)){
								 recieveExp = (getExp(player) + 150);
							 }else
								 if(pmMasters.contains(player)){
									 recieveExp = (getExp(player) + 160);
								 }
		 return recieveExp;
	 }
	 
	 public static Double looseExp(EntityPlayerMP player){
		 if(trainers.contains(player)){
			 looseExp = getExp(player) - (100/3);
		 }else
			 if(rkTrainers.contains(player)){
				 looseExp = getExp(player) - (110/3);
			 }else
				 if(snrTrainers.contains(player)){
					 looseExp = getExp(player) - (120/3);
				 }else
					 if(edTrainers.contains(player)){
						 looseExp = getExp(player) - (130/3);
					 }else
						 if(elTrainers.contains(player)){
							 looseExp = getExp(player) - (140/3);
						 }else
							 if(msTrainers.contains(player)){
								 looseExp = getExp(player) - (150/3);
							 }else
								 if(pmMasters.contains(player)){
									 looseExp = getExp(player) - (160/3);
								 }
		 return getExp(player) - looseExp;
	 }
	 
	 @SubscribeEvent
	 public void rankPrefix(ServerChatEvent sce){
		 EntityPlayerMP player = sce.player;
		 List players = MinecraftServer.getServer().getConfigurationManager().playerEntityList;
		 for (int i = 0; i < + players.size(); i++) {
			 EntityPlayer target = (EntityPlayer) players.get(i);
			 sce.setCanceled(true);
			 if(trainers.contains(player)){
				 String msg = "§e[Trainer] " + "§f" + player.getDisplayName() + " §f " + sce.message;
				 target.addChatMessage(new ChatComponentText(msg));
			 }else
				 if(rkTrainers.contains(player)){
					 String msg = "§e[Rookie Trainer] " + "§f" + player.getDisplayName() + " §f " + sce.message;
					 target.addChatMessage(new ChatComponentText(msg));
				 }else
					 if(snrTrainers.contains(player)){
						 String msg = "§e[Senior Trainer] " + "§f" + player.getDisplayName() + " §f " + sce.message;
						 target.addChatMessage(new ChatComponentText(msg));
					 }else
						 if(edTrainers.contains(player)){
							 String msg = "§e[Elder Trainer] " + "§f" + player.getDisplayName() + " §f " + sce.message;
							 target.addChatMessage(new ChatComponentText(msg));
						 }else
							 if(elTrainers.contains(player)){
								 String msg = "§e[Elite Trainer] " + "§f" + player.getDisplayName() + " §f " + sce.message;
								 target.addChatMessage(new ChatComponentText(msg));
							 }else
								 if(msTrainers.contains(player)){
									 String msg = "§e[Master Trainer] " + "§f" + player.getDisplayName() + " §f " + sce.message;
									 target.addChatMessage(new ChatComponentText(msg));
								 }else
									 if(pmMasters.contains(player)){
										 String msg = "§e[Pokemon Master] " + "§f" + player.getDisplayName() + " §f " + sce.message;
										 target.addChatMessage(new ChatComponentText(msg));
									 }
		 }
	 }
	 
	 @SubscribeEvent
	 public void joinServer(EntityJoinWorldEvent ejwe){
	   if(ejwe.entity instanceof EntityPlayerMP){
		   EntityPlayerMP player = (EntityPlayerMP) ejwe.entity;
		   if((getRank(player) == null) && pokeExp.get(player) == null){
			   player.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN 
					   + "§a" + "\nThis Is A Pixelmon SideMod That Gives Trainers Ranks,"
					   + "§a" + "\nIn This Side Mod You Recieve Something Called PokeExp."
					   + "§a" + "\nTo Obtain PokeExp You Must Win Trainer Battles Against Actual Players."
					   + "§a" + "\nObtaining Enough PokeExp Will Allow You To Rank Up."
					   + "§a" + "\nRanks Are As Follow, Trainer, Rookie Trainer, Senior Trainer, Elder Trainer, Elite Trainer, Master Trainer, Pokemon Master."));
		   }
		 if(getRank(player) == null){
			 trainers.add(player);
			 player.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN 
					 + "You Have Been Added to the group " + trainer));
			 if(pokeExp.get(player) == null){
				 pokeExp.put(player, 0.0);
				 player.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN 
						 + "Your PokeExp Has Been Set To " + getExp(player)));
			 }
		 }
	 }
	}
}
