package ps.maps;

import static ps.oo.PSGame.*;
import ps.oo.Dungeon;
import ps.oo.PSGame;
import ps.oo.Item;
import ps.oo.PSLibItem.OriginalItem;
import ps.oo.PSMenu;
import ps.oo.PSMenu.EntityClothes;
import ps.oo.PSMenu.EntityType;
import ps.oo.PSMenu.Scene;
import ps.oo.PSMenu.SpecialEntity;

public class Skure {


	public static void church() {
		PSMenu.startScene(Scene.CHURCH, SpecialEntity.PRIEST);
		PSGame.Church(2);
		PSMenu.endScene();
	}

	public static void hospital() {
		PSMenu.startScene(Scene.HOSPITAL, EntityType.CITY_WMN_BLUE, EntityClothes.WHITE);
		PSGame.Hospital(2);
		PSMenu.endScene();
	}

	public static void weap_shop() {
		PSMenu.startScene(Scene.SHOP_WEAPON, EntityType.CITY_MAN_BLUE, EntityClothes.RED);
		Shop(getString("Shop_Weapon_Welcome"), false, new Item[]{	getItem(OriginalItem.Weapon_Psycho_Wand),
																		getItem(OriginalItem.Shield_Animal_Glove),
																		getItem(OriginalItem.Weapon_Laser_Gun)});
		PSMenu.endScene();
	}
	
	
	public static void food_shop() {
		PSMenu.startScene(Scene.SHOP_FOOD, EntityType.CITY_MAN_BLUE, EntityClothes.BLUE);
		Shop(getString("Shop_Pharmacy_Welcome"), false, new Item[]{	getItem(OriginalItem.Inventory_Monomate),
																		getItem(OriginalItem.Inventory_Dimate),
																		getItem(OriginalItem.Inventory_Trimate)}); // new
		PSMenu.endScene();
	}

	public static void hand_shop() {
		PSMenu.startScene(Scene.SHOP_HAND, EntityType.CITY_MAN_BLUE, EntityClothes.GREEN);
		Shop(getString("Shop_Tool_Welcome"), true, new Item[]{	getItem(OriginalItem.Inventory_Flash),
																	getItem(OriginalItem.Inventory_Escape_Cloth),
																	getItem(OriginalItem.Inventory_TranCarpet)});
		PSMenu.endScene();
	}	
	
	public static void house1() {
		PSMenu.startScene(Scene.BLUE_HOUSE, EntityType.CITY_WMN_BLUE, EntityClothes.RED);		
		PSMenu.Stext(getString("Skure_House_1"));
		PSMenu.endScene();
	}

	public static void house2() {
		PSMenu.startScene(Scene.YELLOW_HOUSE, EntityType.CITY_MAN_BLUE, EntityClothes.RED);
		PSMenu.Stext(getString("Skure_House_2"));
		PSMenu.endScene();
	}

	public static void house3() {
		PSMenu.startScene(Scene.YELLOW_HOUSE, EntityType.CITY_WMN_BLUE, EntityClothes.BLUE);
		PSMenu.Stext(getString("Skure_House_3"));
		PSMenu.endScene();
	}
	public static void house4() {
		PSMenu.startScene(Scene.YELLOW_HOUSE, EntityType.CITY_MAN_BLUE, EntityClothes.GREEN);		
		PSMenu.Stext(getString("Skure_House_4"));
		PSMenu.endScene();
	}

	public static void house5() {
		PSMenu.startScene(Scene.YELLOW_HOUSE, SpecialEntity.OLDMAN);
		PSMenu.Stext(getString("Skure_House_5"));
		PSMenu.endScene();
	}

	public static void house6() {
		PSMenu.startScene(Scene.YELLOW_HOUSE, EntityType.CITY_MAN_BLUE, EntityClothes.GREEN);
		PSMenu.Stext(getString("Skure_House_6"));
		PSMenu.endScene();
	}	
	
	public static void house7() {
		PSMenu.startScene(Scene.YELLOW_HOUSE, EntityType.CITY_WMN_BLUE, EntityClothes.GREEN);
		PSMenu.Stext(getString("Skure_House_7"));
		PSMenu.endScene();
	}		
	
	public static void ent1() {
		EntStart();
		PSMenu.Stext(getString("Skure_People_Ent1"));
		EntFinish();
	}
	public static void ent2() {
		EntStart();
		PSMenu.Stext(getString("Skure_People_Ent2"));
		EntFinish();
	}
	public static void ent3() {
		EntStart();
		PSMenu.Stext(getString("Skure_People_Ent3"));
		EntFinish();
	}

	public static void tunnel() {
		mapswitch(Dungeon.SKURE_TUNNEL_OUT);
	}
	
	
	
}
