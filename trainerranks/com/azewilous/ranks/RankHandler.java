package com.azewilous.ranks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class RankHandler{

	 public static HashMap<EntityPlayerMP, Double> pokeExp = RanksConfig.pokeExp;
	 
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
		 rankUp(player);
	 }
	 
	 public static Double getExp(EntityPlayerMP player){
		 return pokeExp.get(player);
	 }
	 
	 public static void setExp(EntityPlayerMP player, String[] args){
		 Double dpokeExp = Double.valueOf(args[1]);
		 pokeExp.put(player, dpokeExp);
		 rankUp(player);
	 }
	 
	 public static boolean rankUp(EntityPlayerMP player){
		 if(getExp(player) >= 0 && getExp(player) < 300){
			 if(!trainers.contains(player)){
				 trainers.add(player);
				 player.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN 
						 + "Ranked Up To " + trainer));
				 return true;
			 }
		 }else
			 if(getExp(player) >= 300 && getExp(player) < 610){
				 if(!rkTrainers.contains(player)){
					 rkTrainers.add(player);
					 player.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN 
							 + "Ranked Up To " + rkTrainer));
					 return true;
				 }
			 }else
				 if(getExp(player) >= 610 && getExp(player) < 920){
					 if(!snrTrainers.contains(player)){
						 snrTrainers.add(player);
						 player.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN 
								 + "Ranked Up To " + snrTrainer));
						 return true;
					 }
				 }else
					 if(getExp(player) >= 1230 && getExp(player) < 1540){
						 if(!edTrainers.contains(player)){
							 edTrainers.add(player);
							 player.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN 
									 + "Ranked Up To " + edTrainer));
							 return true;
						 }
					 }else
						 if(getExp(player) >= 1540 && getExp(player) < 1850){
							 if(!elTrainers.contains(player)){
								 elTrainers.add(player);
								 player.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN 
										 + "Ranked Up To " + elTrainer));
								 return true;
							 }
						 }else
							 if(getExp(player) >= 1850 && getExp(player) < 2160){
								 if(!msTrainers.contains(player)){
									 msTrainers.add(player);
									 player.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN
											 + "Ranked Up To " + msTrainer));
									 return true;
								 }
							 }else
								 if(getExp(player) >= 2160){
									 if(!pmMasters.contains(player)){
										 pmMasters.add(player);
										 player.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN 
												 + "Ranked Up To " + pmMaster));
										 return true;
									 }
								 }
		return false;
				
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
		 Double gained;
		 if(trainers.contains(player)){
			 recieveExp = (double) 100;
		 }else
			 if(rkTrainers.contains(player)){
				 recieveExp = (double) 110;
			 }else
				 if(snrTrainers.contains(player)){
					 recieveExp = (double) 120;
				 }else
					 if(edTrainers.contains(player)){
						 recieveExp = (double) 130;
					 }else
						 if(elTrainers.contains(player)){
							 recieveExp = (double) 140;
						 }else
							 if(msTrainers.contains(player)){
								 recieveExp = (double) 150;
							 }else
								 if(pmMasters.contains(player)){
									 recieveExp = (double) 160;
								 }
		 gained = pokeExp.get(player) + recieveExp;
		 pokeExp.put(player, gained);
		 return gained;
	 }
	 
	 public static Double looseExp(EntityPlayerMP player){
		 Double lost;
		 if(trainers.contains(player)){
			 looseExp = (double) (100/3);
		 }else
			 if(rkTrainers.contains(player)){
				 looseExp = (double) (100/4);
			 }else
				 if(snrTrainers.contains(player)){
					 looseExp = (double) (100/5);
				 }else
					 if(edTrainers.contains(player)){
						 looseExp = (double) (100/6);
					 }else
						 if(elTrainers.contains(player)){
							 looseExp = (double) (100/7);
						 }else
							 if(msTrainers.contains(player)){
								 looseExp = (double) (100/8);
							 }else
								 if(pmMasters.contains(player)){
									 looseExp = (double) (100/9);
								 }
		 lost = pokeExp.get(player) - looseExp;
		 pokeExp.put(player, lost);
		 return lost;
	 }
	  
	 @SubscribeEvent
	 public void joinServer(EntityJoinWorldEvent ejwe){
	   if(ejwe.entity instanceof EntityPlayerMP){
		   EntityPlayerMP player = (EntityPlayerMP) ejwe.entity;
		   if((getRank(player) == null) && pokeExp.get(player) == null){
			   player.addChatMessage(new ChatComponentTranslation(EnumChatFormatting.DARK_GREEN
					   + "This Is A Pixelmon SideMod That Gives Trainers Ranks," + EnumChatFormatting.GREEN 
					   + "In This Side Mod You Recieve Something Called PokeExp." + EnumChatFormatting.GREEN 
					   + "To Obtain PokeExp You Must Win Trainer Battles Against Actual Players." + EnumChatFormatting.GREEN 
					   + "Obtaining Enough PokeExp Will Allow You To Rank Up." + EnumChatFormatting.GREEN 
					   + "Ranks Are As Follow, Trainer, Rookie Trainer, Senior Trainer, Elder Trainer, Elite Trainer, Master Trainer, Pokemon Master."));
		   }
		   
		 if(getRank(player) == null){
			 trainers.add(player);
			 player.addChatMessage(new ChatComponentTranslation(EnumChatFormatting.GREEN 
					 + "You Have Been Added to the group " + trainer));
			 if(pokeExp.get(player) == null){
				 pokeExp.put(player, (double) 0);
				 player.addChatMessage(new ChatComponentTranslation(EnumChatFormatting.GREEN 
						 + "Your PokeExp Has Been Set To " + getExp(player)));
			 }
		 }
	 }
	}
}