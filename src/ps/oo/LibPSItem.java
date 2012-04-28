package ps.oo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ps.oo.Item.ItemType;

public class LibPSItem {

	List<Item> items;
	
	public LibPSItem() {
		items = new ArrayList<Item>();

		// WEAPONS
		items.add(new Item("Woodcane",25, ItemType.LIGHT, 3, null));
		items.add(new Item("Short Sword",30, ItemType.LIGHT, 4, null));
		items.add(new Item("Iron Axe",64, ItemType.AXE, 10, null));
		items.add(new Item("Iron Fang",-1, ItemType.FANG, 10, null));
		items.add(new Item("Wand",1200, ItemType.LIGHT, 10, null));
		items.add(new Item("Iron Sword",75, ItemType.SWORD, 12, null));
		items.add(new Item("Needle Gun",400, ItemType.PISTOL, 18, null));
		items.add(new Item("Titanium Sword",320, ItemType.SWORD, 21, null));
		items.add(new Item("Heat Gun",1540, ItemType.PISTOL, 30, null));
		items.add(new Item("Silver Fang",1620, ItemType.FANG, 30, null));
		items.add(new Item("Ceramic Sword",1220, ItemType.SWORD, 31, null));
		items.add(new Item("Light Saber",2980, ItemType.SWORD, 46, null));
		items.add(new Item("Laser Gun",4120, ItemType.PISTOL, 50, null));
		items.add(new Item("Laconian Sword",1000, ItemType.SWORD, 60, null));
		items.add(new Item("Laconian Axe",780, ItemType.AXE, 80, null));

		// ARMORS
		items.add(new Item("Leather Armor",28, ItemType.MAIL, 5, null));
		items.add(new Item("White Mantle",78, ItemType.MANTLE, 5, null));
		items.add(new Item("Light Suit",290, ItemType.MAIL, 15, null));
		items.add(new Item("Iron Armor",320, ItemType.HEAVY_ARMOR, 20, null));
		items.add(new Item("Thick Fur",630, ItemType.FUR, 30, null));
		items.add(new Item("Zirconian Armor",1000, ItemType.LIGHT_ARMOR, 30, null));
		items.add(new Item("Frad Mantle",840, ItemType.MANTLE, 40, null));
		items.add(new Item("Diamond Armor",15000, ItemType.LIGHT_ARMOR, 60, null));
		items.add(new Item("Laconian Armor",980, ItemType.HEAVY_ARMOR, 80, null));

		// SHIELDS
		items.add(new Item("Leather Shield",30, ItemType.LIGHT_SHIELD, 3, null));
		items.add(new Item("Bronze Shield",310, ItemType.HEAVY_SHIELD, 8, null));
		items.add(new Item("Iron Shield",520, ItemType.HEAVY_SHIELD, 15, null));
		items.add(new Item("Ceramic Shield",1400, ItemType.NORMAL_SHIELD, 23, null));
		items.add(new Item("Laser Shield",1120, ItemType.SPECIAL_SHIELD, 30, null));
		items.add(new Item("Glove",3300, ItemType.GLOVES, 40, null));
		items.add(new Item("Mirror Shield",-1, ItemType.HEAVY_SHIELD, 40, null));
		items.add(new Item("Laconian Shield",820, ItemType.LIGHT_SHIELD, 50, null));

		// ITEMS
		items.add(new Item("Transer",48, ItemType.ITEM, 0, null));
		items.add(new Item("Escaper",10, ItemType.ITEM, 0, null));
		items.add(new Item("Flute",-1, ItemType.ITEM, 0, null));
		items.add(new Item("Cola",10, ItemType.ITEM, 10, null));
		items.add(new Item("Burger",40, ItemType.ITEM, 40, null));
		items.add(new Item("Polymaterial",1600, ItemType.ITEM, 0, null));
		items.add(new Item("Magic Hat",0, ItemType.ITEM, 0, null));
		items.add(new Item("Sphere",0, ItemType.ITEM, 0, null));
		items.add(new Item("Flash",0, ItemType.ITEM, 20, null));
		items.add(new Item("Magic Lamp",0, ItemType.ITEM, 1400, null));
		items.add(new Item("Passport",0, ItemType.ITEM, 100, null));
		items.add(new Item("Gas Shield",0, ItemType.ITEM, 1000, null));

		// QUEST ITEMS
		items.add(new Item("Dungeon Key",0, ItemType.QUEST, 0, null));
		items.add(new Item("Magic Key",0, ItemType.QUEST, 0, null));
		items.add(new Item("Alsulin",0, ItemType.QUEST, 0, null));
		items.add(new Item("Torch",0, ItemType.QUEST, 0, null));
		items.add(new Item("Prism",0, ItemType.QUEST, 0, null));
		items.add(new Item("Compass",0, ItemType.QUEST, 0, null));
		items.add(new Item("Roadpass",0, ItemType.QUEST, 200, null));
		items.add(new Item("Laconian Pot",0, ItemType.QUEST, 0, null));
		items.add(new Item("Amber Eye",0, ItemType.QUEST, 0, null));
		items.add(new Item("Crystal",0, ItemType.QUEST, 0, null));

		// TRANSPORT
		items.add(new Item("Landrover",0, ItemType.TRANSPORT, 5200, null));
		items.add(new Item("Hovercraft",0, ItemType.TRANSPORT, 0, null));
		items.add(new Item("Ice Digger",0, ItemType.TRANSPORT, 12000, null));
		
		HashMap<String, Item> hm = new HashMap<String, Item>();
		for(Item i: items) {
			hm.put(i.name, i);
		}
		
		
	}
}
