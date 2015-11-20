package ps.maps;

import static ps.oo.PSGame.*;
import ps.oo.City;
import ps.oo.Dungeon;
import ps.oo.PSGame;
import ps.oo.Item;
import ps.oo.PSGame.Flags;
import ps.oo.PSLibItem.OriginalItem;
import ps.oo.PSMenu;
import ps.oo.PSMenu.EntityClothes;
import ps.oo.PSMenu.EntityType;
import ps.oo.PSMenu.Scene;
import ps.oo.PSMenu.SpecialEntity;

public class Casba {

	public static void hospital() {
		PSMenu.startScene(Scene.HOSPITAL_VILLAGE, EntityType.VILLA_MAN_BROWN, EntityClothes.WHITE);
		PSGame.Hospital(2); // more expensive
		PSMenu.endScene();
	}
	
	public static void church() {
		PSMenu.startScene(Scene.CHURCH_VILLAGE, SpecialEntity.PRIEST);
		PSGame.Church(2); // more expensive
		PSMenu.endScene();
	}	
	
	public static void hand_shop1() {
		PSMenu.startScene(Scene.SHOP_HAND_VILLAGE, EntityType.VILLA_MAN_BROWN, EntityClothes.GREEN);
		Shop(getString("Shop_Tool_Welcome"), true, new Item[]{	getItem(OriginalItem.Inventory_Flash),
																	getItem(OriginalItem.Inventory_TranCarpet),
																	getItem(OriginalItem.Inventory_Magic_Hat)});
		PSMenu.endScene();
	}	
	public static void hand_shop2() {
		PSMenu.startScene(Scene.SHOP_HAND_VILLAGE, EntityType.VILLA_MAN_BROWN, EntityClothes.RED);
		Shop(getString("Shop_Tool_Welcome"), true, new Item[]{	getItem(OriginalItem.Vehicle_LandMaster)});
		PSMenu.endScene();
	}	
	
	
	public static void house1() {
		PSMenu.startScene(Scene.VILLAGE_HOUSE, EntityType.VILLA_MAN_BROWN, EntityClothes.RED);
		if(PSMenu.Prompt(getString("Casba_House_1"), getYesNo()) == 1) {
			PSMenu.StextLast(getString("Casba_House_1Yes"));
			PSGame.setFlag(Flags.INFO_HOVER);
		} else {
			PSMenu.StextLast(getString("Casba_House_1No"));
		}
		PSMenu.endScene();
	}
	public static void house2() {
		PSMenu.startScene(Scene.VILLAGE_HOUSE, EntityType.VILLA_MAN_BROWN, EntityClothes.BLUE);
		PSMenu.Stext(getString("Casba_House_2"));
		PSMenu.endScene();
	}
	public static void house3() {
		PSMenu.startScene(Scene.RUINED_HOUSE, SpecialEntity.BEGGAR);
		PSMenu.Stext(getString("Casba_House_3"));
		PSMenu.endScene();
	}
	public static void house4() {
		PSMenu.startScene(Scene.VILLAGE_HOUSE, SpecialEntity.OLDMAN);
		PSMenu.Stext(getString("Casba_House_4"));
		PSMenu.endScene();
	}

	public static void ent1() {
		EntStart();
		PSMenu.Stext(getString("Casba_People_Ent2"));
		EntFinish();
	}
	public static void ent2() {
		EntStart();
		PSMenu.Stext(getString("Casba_People_Ent1"));
		EntFinish();
	}
	
	public static void exit() {
		mapswitch(Planet.MOTAVIA, City.CASBA.getX(), City.CASBA.getY());
	}

	public static void tunnel() {
		mapswitch(Dungeon.CASBA_CAVE_OUT); 
	}

	
	
}
