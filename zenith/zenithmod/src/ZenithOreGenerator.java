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

import java.util.Random;

import net.minecraft.src.Block;
import net.minecraft.src.IChunkProvider;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class ZenithOreGenerator implements IWorldGenerator
{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) 
	{
		if(world.provider.dimensionId == 0)
		{
			genSurfaceWorldOre(world, random, chunkX*16, chunkZ*16, ZenithBlocks.magainiamoreblock, 3, 7, 16);
			genSurfaceWorldOre(world, random, chunkX*16, chunkZ*16, ZenithBlocks.tantalumore, 5, 14, 36);
			genSurfaceWorldOre(world, random, chunkX*16, chunkZ*16, ZenithBlocks.siliconore, 6, 18, 44);
			genSurfaceWorldOre(world, random, chunkX*16, chunkZ*16, ZenithBlocks.plutoniumore, 3, 8, 14);
		}
	}
	
	public void genSurfaceWorldOre(World world, Random rand, int chunkX, int chunkZ, Block block, int veinSize, int blocksperchunk, int height)
	{
		int randposX = 0;
		int randposY = 0;
		int randposZ = 0;
		
		for(int i = 0; i < blocksperchunk ; i++)
		{
			randposX = chunkX + rand.nextInt(16);
			randposY = rand.nextInt(height);
			randposZ = chunkZ + rand.nextInt(16);
			
			WorldGenMinable worldore = new WorldGenMinable(block.blockID, veinSize);
			worldore.generate(world, rand, randposX, randposY, randposZ);
		}
	}

}
