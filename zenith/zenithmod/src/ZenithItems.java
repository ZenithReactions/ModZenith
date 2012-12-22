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

import zenith.zenithmod.src.items.item_LaserPistol;
import zenith.zenithmod.src.items.item_magainiam;
import zenith.zenithmod.src.items.item_plutonium;
import zenith.zenithmod.src.items.item_silicon;
import zenith.zenithmod.src.items.item_tantalum;
import zenith.zenithmod.src.items.item_unstablemagainiam;
import zenith.zenithmod.src.items.item_unstableplutonium;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;

public class ZenithItems {

public static final item_unstablemagainiam unstablemagainiam = new item_unstablemagainiam();
public static final item_magainiam magainiam = new item_magainiam();
public static final item_tantalum tantalum = new item_tantalum();
public static final item_silicon silicon = new item_silicon();
public static final item_unstableplutonium unstableplutonium = new item_unstableplutonium();
public static final item_plutonium plutonium = new item_plutonium();

public static final item_LaserPistol laserPistol = new item_LaserPistol(5006, 0);
	
	public void loadItemTextures()
	{
		MinecraftForgeClient.preloadTexture("/textures/zenithitems.png");
	}
	
	public void registerItems()
	{
		OreDictionary.registerOre("unstablemagainiam", unstablemagainiam);
		OreDictionary.registerOre("magainiam", magainiam);
		OreDictionary.registerOre("tantalum", tantalum);
		OreDictionary.registerOre("silicon", silicon);
		OreDictionary.registerOre("unstableplutonium", unstableplutonium);
		OreDictionary.registerOre("plutonium", plutonium);
		OreDictionary.registerOre("laserPistol", laserPistol);
	}
	
	
	
	
}
