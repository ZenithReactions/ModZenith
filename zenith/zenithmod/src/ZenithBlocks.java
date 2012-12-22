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

import zenith.zenithmod.src.blocks.*;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.client.MinecraftForgeClient;

public class ZenithBlocks 
{
	//ZenithBlocks
	public static final block_magainiamore magainiamoreblock = new block_magainiamore(500, 0);
	public static final block_tantalumore tantalumore = new block_tantalumore(501, 1);
	public static final block_siliconore siliconore = new block_siliconore(502, 2);
	public static final block_plutoniumore plutoniumore = new block_plutoniumore(503, 3);
	
	//ZenithBlocks2
	public static final block_refiner refiner = new block_refiner(504, 0);
	
	public void loadBlockTextures()
	{
		MinecraftForgeClient.preloadTexture("/textures/zenithblocks.png");
		MinecraftForgeClient.preloadTexture("/textures/zenithblocks2.png");
	
	}
	
	public void registerBlocks()
	{
		GameRegistry.registerBlock(magainiamoreblock);
		GameRegistry.registerBlock(tantalumore);
		GameRegistry.registerBlock(siliconore);
		GameRegistry.registerBlock(plutoniumore);
		GameRegistry.registerBlock(refiner);
	}
}
