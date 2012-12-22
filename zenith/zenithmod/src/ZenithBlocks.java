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
import zenith.zenithmod.src.items.item_c4blue;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.client.MinecraftForgeClient;

/*

 C4 not finished, need to fix orientation bug.
 
 */

public class ZenithBlocks 
{
	public static final block_magainiamore magainiamoreblock = new block_magainiamore(500, 0);
	public static final block_tantalumore tantalumore = new block_tantalumore(501, 1);
	public static final block_siliconore siliconore = new block_siliconore(502, 2);
	public static final block_plutoniumore plutoniumore = new block_plutoniumore(503, 3);
	public static final block_copperore copperore = new block_copperore(504, 4);
	//public static final block_c4blue c4blue = new block_c4blue(505, 5);
	//public static final block_c4green c4green = new block_c4green(506, 6);
	//public static final block_c4red c4red = new block_c4red(507, 7);
	//public static final block_c4yellow c4yellow = new block_c4yellow(508, 8);


	
	public void loadBlockTextures()
	{
		MinecraftForgeClient.preloadTexture("/textures/zenithblocks.png");
	
	}
	
	public void registerBlocks()
	{
		GameRegistry.registerBlock(magainiamoreblock);
		GameRegistry.registerBlock(tantalumore);
		GameRegistry.registerBlock(siliconore);
		GameRegistry.registerBlock(plutoniumore);
		GameRegistry.registerBlock(copperore);
		//GameRegistry.registerBlock(c4blue);
		//GameRegistry.registerBlock(c4green);
		//GameRegistry.registerBlock(c4red);
		//GameRegistry.registerBlock(c4yellow);
	}
}
