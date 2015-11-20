package ps.maps;

import static ps.oo.PSGame.EntFinish;
import static ps.oo.PSGame.EntStart;
import static ps.oo.PSGame.Shop;
import static ps.oo.PSGame.getItem;
import static ps.oo.PSGame.getString;
import static ps.oo.PSGame.getYesNo;
import static ps.oo.PSGame.mapswitch;
import ps.oo.City;
import ps.oo.Item;
import ps.oo.PSGame;
import ps.oo.PSGame.Planet;
import ps.oo.PSLibItem.OriginalItem;
import ps.oo.PSMenu;
import ps.oo.PSMenu.EntityClothes;
import ps.oo.PSMenu.EntityType;
import ps.oo.PSMenu.Scene;
import ps.oo.PSMenu.SpecialEntity;

public class Loar {

	
	public static void church() {
		PSMenu.startScene(Scene.CHURCH_VILLAGE, SpecialEntity.PRIEST);
		PSGame.Church(2);
		PSMenu.endScene();
	}	
	
	public static void hospital() {
		PSMenu.startScene(Scene.HOSPITAL_VILLAGE, EntityType.VILLA_WMN_BLOND, EntityClothes.BLUE);
		PSGame.Hospital(2);
		PSMenu.endScene();
	}

	public static void weap_shop() {
		PSMenu.startScene(Scene.SHOP_WEAPON_VILLAGE, EntityType.VILLA_MAN_BLOND, EntityClothes.RED);
		Shop(getString("Shop_Weapon_Welcome"), false, new Item[]{	getItem(OriginalItem.Armor_White_Cloak),
																	getItem(OriginalItem.Weapon_Heat_Gun),
																	getItem(OriginalItem.Weapon_Silver_Tusk)});
		PSMenu.endScene();
	}	
	

	public static void house1() {
		PSMenu.startScene(Scene.RUINED_HOUSE, SpecialEntity.BEGGAR);
		if(PSMenu.Prompt(getString("Loar_House_1"), getYesNo()) == 1) {
			PSMenu.StextLast(getString("Loar_House_1Yes"));
		} else {
			PSMenu.StextLast(getString("Loar_House_1No"));
		}
		PSMenu.endScene();
	}
	
	public static void house2() {
		PSMenu.startScene(Scene.VILLAGE_HOUSE, EntityType.VILLA_WMN_BLOND, EntityClothes.GREEN);
		PSMenu.Stext(getString("Loar_House_2"));
		PSMenu.endScene();
	}

	public static void house3() {
		PSMenu.startScene(Scene.VILLAGE_HOUSE, EntityType.VILLA_MAN_BLOND, EntityClothes.GREEN);
		PSMenu.Stext(getString("Loar_House_3"));
		PSMenu.endScene();
	}
	
	public static void house4() {
		PSMenu.startScene(Scene.VILLAGE_HOUSE, EntityType.VILLA_MAN_BLOND, EntityClothes.RED);
		PSMenu.Stext(getString("Loar_House_4"));
		PSMenu.endScene();
	}

	public static void ent1() {
		EntStart();
		PSMenu.Stext(getString("Loar_People_Man"));
		EntFinish();
	}

	public static void exit() {
		mapswitch(Planet.PALMA, City.LOAR.getX(), City.LOAR.getY());		
	}

	
	
}
