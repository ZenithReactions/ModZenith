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
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid="mod_zenith", name="Zenith", version="0.0.1")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class mod_zenith 
{
	private static final ZenithBlocks zblocks = new ZenithBlocks();
	private static final ZenithItems zitems = new ZenithItems();
	public static final ZenithOreGenerator oregen = new ZenithOreGenerator();
	private static final ZenithCraftables zcraft = new ZenithCraftables();
	private static final ZenithSmeltables zsmelt = new ZenithSmeltables();

	@Instance("mod_zenith")
	public static mod_zenith instance;
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event)
	{
		zblocks.loadBlockTextures();
		zitems.loadItemTextures();
	
	}
	
	@Init
	public void load(FMLInitializationEvent event) 
	{
		zblocks.registerBlocks();
		zitems.registerItems();
		zcraft.crafting();
		zsmelt.smelting();
		GameRegistry.registerWorldGenerator(oregen);
	}
	
	@PostInit
	public void postInit(FMLPostInitializationEvent event) 
	{
		
	}
}