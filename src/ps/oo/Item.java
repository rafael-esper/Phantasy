package ps.oo;

import domain.VImage;

public class Item {

	public enum ItemType {
		LIGHT, SWORD, AXE, FANG, PISTOL, 
		MAIL, LIGHT_ARMOR, HEAVY_ARMOR, MANTLE, FUR, 
		GLOVES, LIGHT_SHIELD, NORMAL_SHIELD, HEAVY_SHIELD, SPECIAL_SHIELD, 
		ITEM, QUEST, TRANSPORT}
	
	public Item(String str, int i, ItemType equip, int j, VImage vimage) {
		this.name = str;
		this.cost = i;
		this.equiptype = equip;
		this.itemstat = j;
	}
	int id;
	
	String name;
	int cost;
	int itemstat;
	VImage portrait;
	ItemType equiptype;
	//ItemEffect itemeffect
	
	
}
