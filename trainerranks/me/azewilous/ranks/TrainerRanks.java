package me.azewilous.ranks;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.pixelmonmod.pixelmon.Pixelmon;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import me.azewilous.ranks.commands.RankCommand;
import me.azewilous.ranks.commands.SetExpCommand;
import me.azewilous.ranks.commands.SetRankCommand;
import me.azewilous.ranks.config.TrainerRanksConfig;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.MinecraftForge;

@Mod(name="TrainerRanks", version="1.0", acceptableRemoteVersions="*", modid="trainerranks", dependencies="after:Pixelmon")
public class TrainerRanks{

	public Logger logger = Logger.getLogger("TrainerRanks");
	public static TrainerRanksConfig config;
	
	@Mod.EventHandler
	  public void init(FMLInitializationEvent event){
	    config = new TrainerRanksConfig();
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