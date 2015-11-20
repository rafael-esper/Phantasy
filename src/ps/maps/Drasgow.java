package ps.maps;

import static ps.oo.PSGame.EntFinish;
import static ps.oo.PSGame.EntStart;
import static ps.oo.PSGame.getString;
import static ps.oo.PSGame.mapswitch;
import ps.oo.City;
import ps.oo.Dungeon;
import ps.oo.PSGame.Planet;
import ps.oo.PSMenu;
import ps.oo.PSMenu.EntityClothes;
import ps.oo.PSMenu.EntityType;
import ps.oo.PSMenu.Scene;

public class Drasgow {

	public static void house1() {
		PSMenu.startScene(Scene.BLUE_HOUSE, EntityType.CITY_MAN_BLOND, EntityClothes.RED);
		PSMenu.Stext(getString("Drasgow_House_1"));
		PSMenu.endScene();
	}

	public static void house2() {
		PSMenu.startScene(Scene.YELLOW_HOUSE, EntityType.CITY_WMN_BROWN, EntityClothes.BLUE);
		PSMenu.Stext(getString("Drasgow_House_2"));
		PSMenu.endScene();
	}
	
	public static void ent1() {
		EntStart();
		PSMenu.Stext(getString("Drasgow_People_Ent1"));
		EntFinish();
	}
	public static void ent2() {
		EntStart();
		PSMenu.Stext(getString("Drasgow_People_Ent2"));
		EntFinish();
	}
	public static void ent3() {
		EntStart();
		PSMenu.Stext(getString("Drasgow_People_Ent3"));
		EntFinish();
	}	

	public static void exit() {
		mapswitch(Planet.PALMA, City.DRASGOW.getX(), City.DRASGOW.getY());		
	}
	
	public static void tunnel() {
		mapswitch(Dungeon.DRASGOW_DUNGEON);
	}

	
	
}
