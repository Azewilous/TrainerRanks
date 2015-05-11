package com.azewilous.ranks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class RanksConfig {
	
	public static Configuration config;
	public static HashMap<EntityPlayerMP, Double> pokeExp = new HashMap<EntityPlayerMP, Double>();
	String playerExp = pokeExp.toString();

	public static void loadConfig(Configuration configuration){
		config = configuration;
		
		Property general = config.get(config.CATEGORY_GENERAL, "PokeExp", "");
		general.comment = "PokeExp Data";
		
		config.save();
	}
	
}
