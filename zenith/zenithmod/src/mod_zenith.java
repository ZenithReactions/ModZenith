/**
 * 	This program is a plugin for Minecraft
 *  Copyright (c) 2012 Bums735 & TechnoTantalum
 *  
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 **/

package zenith.zenithmod.src;

import zenith.zenithmod.src.proxies.CommonProxy;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid="mod_zenith", name="Zenith", version="0.0.2.2")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class mod_zenith 
{
	private static final ZenithBlocks zblocks = new ZenithBlocks();
	private static final ZenithItems zitems = new ZenithItems();
	public static final ZenithOreGenerator oregen = new ZenithOreGenerator();
	private static final ZenithCraftables zcraft = new ZenithCraftables();
	private static final ZenithSmeltables zsmelt = new ZenithSmeltables();
	private static final ZenithGuiHandler guihand = new ZenithGuiHandler();
	private static final ZenithTileEntities ztiles = new ZenithTileEntities();
	private static final ZenithEntities zentities = new ZenithEntities();
	private static final ZenithRenderer zrender = new ZenithRenderer();

	@Instance("mod_zenith")
	public static mod_zenith instance;
	
	@SidedProxy(clientSide = "zenith.zenithmod.src.proxies.ClientProxy", serverSide = "zenith.zenithmod.src.proxies.CommonProxy")
	public static CommonProxy proxy;
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event)
	{
		
	}
	
	@Init
	public void load(FMLInitializationEvent event) 
	{
		zblocks.registerBlocks();
		zitems.registerItems();
		zcraft.crafting();
		zsmelt.smelting();
		ztiles.registerTileEntities();
		zentities.registerEntities();
		zrender.registerRender();
		GameRegistry.registerWorldGenerator(oregen);
		NetworkRegistry.instance().registerGuiHandler(instance, guihand);
		proxy.loadTextures();
	}
	
	@PostInit
	public void postInit(FMLPostInitializationEvent event) 
	{
		
	}
}
