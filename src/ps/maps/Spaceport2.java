package ps.maps;

import static ps.oo.PSGame.*;
import static core.Script.playermove;
import ps.oo.City;
import ps.oo.PSGame;
import ps.oo.Item;
import ps.oo.PSMenu;
import ps.oo.PSGame.Planet;
import ps.oo.PSLibItem.OriginalItem;
import ps.oo.PSMenu.*;

public class Spaceport2 {

	
	public static void paseo() {
		PSMenu.Stext(getString("Paseo_People_Cop_Pass"));
		mapswitch(Planet.MOTAVIA,78,42);
	}
	

	public static void spaceship() {
		PSMenu.startScene(Scene.SPACESHIP, EntityType.CITY_MAN_BLOND, EntityClothes.BLUE);
		if(PSMenu.Prompt(getString("Paseo_Spaceport_Shuttle"), getYesNo()) == 1) {
			PSGame.spaceshipRoutineStart(City.PASEO, City.CAMINEET);
		}
		PSMenu.endScene(Outcome.FADE_HOUSE);
	}	
	
	public static void ent1() {
		EntStart();
		PSMenu.Stext(getString("Paseo_Spaceport_Ent1"));
		EntFinish();
	}
	public static void ent2() {
		EntStart();
		PSMenu.Stext(getString("Paseo_Spaceport_Ent2"));
		EntFinish();
	}
	public static void ent3() {
		EntStart();
		PSMenu.Stext(getString("Paseo_Spaceport_Ent3"));
		EntFinish();
	}
	
}
