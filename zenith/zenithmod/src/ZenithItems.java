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
import zenith.zenithmod.src.items.item_c4blue;
import zenith.zenithmod.src.items.item_c4green;
import zenith.zenithmod.src.items.item_c4red;
import zenith.zenithmod.src.items.item_c4yellow;
import zenith.zenithmod.src.items.item_copper;
import zenith.zenithmod.src.items.item_copperwire;
import zenith.zenithmod.src.items.item_magainiam;
import zenith.zenithmod.src.items.item_plastic;
import zenith.zenithmod.src.items.item_plutonium;
import zenith.zenithmod.src.items.item_silicon;
import zenith.zenithmod.src.items.item_tantalum;
import zenith.zenithmod.src.items.item_unstablemagainiam;
import zenith.zenithmod.src.items.item_unstableplutonium;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;

public class ZenithItems 
{
	//ZenithItems.png
	public static final Item unstablemagainiam = new item_unstablemagainiam(5000, 0);
	public static final Item magainiam = new item_magainiam(5001, 1);
	public static final Item tantalum = new item_tantalum(5002, 2);
	public static final Item silicon = new item_silicon(5003, 3);
	public static final Item unstableplutonium = new item_unstableplutonium(5004, 4);
	public static final Item plutonium = new item_plutonium(5005, 5);
	public static final Item copper = new item_copper(5006, 6);
	public static final Item copperwire = new item_copperwire(5007, 7);
	public static final Item plastic = new item_plastic(5008, 8);
	public static final Item c4blue = new item_c4blue(5009, 9);
	public static final Item c4green = new item_c4green(5010, 10);
	public static final Item c4red = new item_c4red(5011, 11);
	public static final Item c4yellow = new item_c4yellow(5012, 12);
	
	//ZenithItems2.png
	public static final item_LaserPistol laserPistol = new item_LaserPistol(5013, 0);
	
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
		OreDictionary.registerOre("copper", copper);
		OreDictionary.registerOre("copperwire", copperwire);
		OreDictionary.registerOre("plastic", plastic);
		OreDictionary.registerOre("c4blue", c4blue);
		OreDictionary.registerOre("c4green", c4green);
		OreDictionary.registerOre("c4red", c4red);
		OreDictionary.registerOre("c4yellow", c4yellow);
	}
}
