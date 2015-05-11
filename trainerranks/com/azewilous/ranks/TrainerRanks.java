package com.azewilous.ranks;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.azewilous.ranks.commands.RankCommand;
import com.azewilous.ranks.commands.SetExpCommand;
import com.azewilous.ranks.commands.SetRankCommand;
import com.pixelmonmod.pixelmon.Pixelmon;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.event.FMLServerStoppingEvent;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;

@Mod(name="TrainerRanks", version="1.0", acceptableRemoteVersions="*", modid="trainerranks", dependencies = "required-after:pixelmon")
public class TrainerRanks{

	public Logger logger = Logger.getLogger("TrainerRanks");
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event){
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());

        config.load();
        
        config.save();
	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event){
		
	}
	
	@Mod.EventHandler
	public void serverLoad(FMLServerStartingEvent event){
	    MinecraftForge.EVENT_BUS.register(new RankHandler());
	    Pixelmon.EVENT_BUS.register(new BattleHandler());
	    event.registerServerCommand(new RankCommand());
	    event.registerServerCommand(new SetRankCommand());
	    event.registerServerCommand(new SetExpCommand());
	    event.registerServerCommand(new CheckPC());
	 }
}