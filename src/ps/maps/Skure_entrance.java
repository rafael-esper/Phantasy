package ps.maps;

import static ps.oo.PSGame.*;
import ps.oo.City;
import ps.oo.Dungeon;
import ps.oo.PSGame;
import ps.oo.Item;
import ps.oo.PSLibItem.OriginalItem;
import ps.oo.PSMenu;
import ps.oo.PSMenu.EntityClothes;
import ps.oo.PSMenu.EntityType;
import ps.oo.PSMenu.LargeEntity;
import ps.oo.PSMenu.Outcome;
import ps.oo.PSMenu.Scene;
import ps.oo.PSMenu.SpecialEntity;

public class Skure_entrance {


	public static void tunnel() {
		mapswitch(Dungeon.SKURE_TUNNEL_IN);
	}
	
	public static void exit() {
		mapswitch(Planet.DEZORIS, City.SKURE_ENTRANCE.getX(),City.SKURE_ENTRANCE.getY());
	}
	
	public static void spaceship() {
		PSMenu.startScene(Scene.ARTIC, LargeEntity.HAPSBY);
		PSGame.hapsbyRoutine(City.SKURE);
		PSMenu.endScene(Outcome.FADE_HOUSE);
	}
	
	
}
