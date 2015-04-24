package me.azewilous.ranks;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.pixelmonmod.pixelmon.Pixelmon;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import me.azewilous.ranks.commands.RankCommand;
import me.azewilous.ranks.commands.SetExpCommand;
import me.azewilous.ranks.commands.SetRankCommand;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;

@Mod(name="TrainerRanks", version="1.0", acceptableRemoteVersions="*", modid="trainerranks", dependencies = "required-after:pixelmon")
public class TrainerRanks{

	public Logger logger = Logger.getLogger("TrainerRanks");
	
	/*
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event){
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
	    config.load();
	    RanksConfig.loadConfig(config);
	    System.out.println("<TrainerRanks> Configuration File Loaded");
	    config.save();
	}
	*/
	
	@Mod.EventHandler
	  public void preInit(FMLPreInitializationEvent event){
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
	  }
}