package ps.maps;

import static ps.oo.PSGame.*;
import ps.oo.City;
import ps.oo.Dungeon;
import ps.oo.Enemy;
import ps.oo.PSGame;
import ps.oo.Item;
import ps.oo.PSGame.Flags;
import ps.oo.PSLibEnemy.PS1Enemy;
import ps.oo.PSLibItem.OriginalItem;
import ps.oo.PSLibSound.PS1Sound;
import ps.oo.PSMenu;
import ps.oo.PSMenu.EntityClothes;
import ps.oo.PSMenu.EntityType;
import ps.oo.PSMenu.LargeEntity;
import ps.oo.PSMenu.MotaCape;
import ps.oo.PSMenu.Outcome;
import ps.oo.PSMenu.Scene;
import ps.oo.PSMenu.SpecialEntity;

public class Tonoe {

	public static void church() {
		PSMenu.startScene(Scene.CHURCH_VILLAGE, EntityType.MOTA_CAP, MotaCape.YELLOW);
		PSGame.Church(1);
		PSMenu.endScene();
	}	
	
	public static void food_shop() {
		PSMenu.startScene(Scene.SHOP_FOOD_VILLAGE, EntityType.MOTA_CAP, MotaCape.YELLOW);
		Shop(getString("Shop_Pharmacy_Welcome"), false, new Item[]{	getItem(OriginalItem.Inventory_Monomate),
																	getItem(OriginalItem.Inventory_Dimate),
																	getItem(OriginalItem.Inventory_Trimate)});
		PSMenu.endScene();
	}	
	public static void hand_shop() {
		PSMenu.startScene(Scene.SHOP_HAND_VILLAGE, EntityType.MOTA_NOCAP, MotaCape.GREEN);
		Shop(getString("Shop_Tool_Welcome"), true, new Item[]{	getItem(OriginalItem.Quest_Alsuline)});
		PSMenu.endScene();
	}	
	
	
	public static void chief_house() {
		PSMenu.startScene(Scene.VILLAGE_HOUSE, EntityType.MOTA_CUSTOM, MotaCape.RED);
		PSMenu.Stext(getString("Tonoe_House_Chief"));
		PSMenu.endScene();		 
	}
	
	public static void house1() {
		PSMenu.startScene(Scene.VILLAGE_HOUSE, EntityType.MOTA_NOCAP, MotaCape.YELLOW);
		if(PSMenu.Prompt(getString("Tonoe_House_1"), getYesNo()) == 1) {
			PSMenu.StextLast(getString("Tonoe_House_1Yes"));
		} else {
			PSMenu.StextLast(getString("Tonoe_House_1No"));
		}
		PSMenu.endScene();
	}
	public static void house2() {
		PSMenu.startScene(Scene.VILLAGE_HOUSE, EntityType.MOTA_CAP, MotaCape.RED);
		PSMenu.Stext(getString("Tonoe_House_2"));
		PSMenu.endScene();
	}
	public static void house3() {
		PSMenu.startScene(Scene.VILLAGE_HOUSE, EntityType.MOTA_MASK, MotaCape.GREEN);
		if(!PSGame.hasFlag(Flags.INFO_TONOE_DAUGHTER)) {
			PSMenu.Stext(getString("Tonoe_House_3"));	
		}
		else {
			PSMenu.Stext(getString("Tonoe_House_3_Rescue"));
			PSGame.playSound(PS1Sound.CURE);
			getParty().healAll(false);
		}
		PSMenu.endScene();
	}
	public static void house4() {
		PSMenu.startScene(Scene.VILLAGE_HOUSE, EntityType.MOTA_MASK, MotaCape.BROWN);
		PSMenu.Stext(getString("Tonoe_House_4"));
		PSMenu.endScene();
	}
	public static void house5() {
		PSMenu.startScene(Scene.VILLAGE_HOUSE, EntityType.MOTA_CUSTOM, MotaCape.GREEN);
		PSMenu.Stext(getString("Tonoe_House_5"));
		PSMenu.endScene();
	}
	
	public static void ent1() {
		EntStart();
		PSMenu.Stext(getString("Tonoe_People_Ent1"));
		EntFinish();
	}
	public static void ent2() {
		EntStart();
		PSMenu.Stext(getString("Tonoe_People_Ent2"));
		EntFinish();
	}
	public static void ent3() {
		EntStart();
		PSMenu.Stext(getString("Tonoe_People_Ent3"));
		EntFinish();
	}
	
	public static void exit() {
		mapswitch(Planet.MOTAVIA, City.TONOE.getX(), City.TONOE.getY());
	}

	public static void cave() {
		mapswitch(Dungeon.BLUEBERRY_MINE);
	}

	
	
}
