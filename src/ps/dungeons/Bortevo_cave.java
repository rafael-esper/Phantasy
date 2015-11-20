package ps.dungeons;

import ps.PSDungeon;
import ps.oo.PSGame;
import ps.oo.PSGame.Chest;
import ps.oo.PSGame.Planet;
import ps.oo.PSGame.Trapped;
import ps.oo.PSLibEnemy.PS1Enemy;
import ps.oo.PSLibItem.OriginalItem;
import ps.oo.PSMenu;
import ps.oo.PSMenu.Scene;
import ps.oo.PSMenu.SpecialEntity;

public class Bortevo_cave {
	
	public static void startmap() {
		PSDungeon dungeon = PSGame.currentDungeon;
		dungeon.setRandomEnemies(0, new PS1Enemy[]{PS1Enemy.GHOUL, PS1Enemy.EVILDEAD, PS1Enemy.SKELETON, PS1Enemy.VAMPIRE});
		dungeon.setFixedEnemies(0, new PS1Enemy[]{PS1Enemy.SKELETON, PS1Enemy.GHOUL});
		
		dungeon.startDungeon();
	}
	
	public static void chest1() {
		PSGame.chestFlag(Chest.BORTEVO_CHEST1, 100, Trapped.NO_TRAP, null);
	}
	public static void chest2() {
		PSGame.chestFlag(Chest.BORTEVO_CHEST2, 0, Trapped.ARROW, null);
	}
	public static void chest3() {
		PSGame.chestFlag(Chest.BORTEVO_CHEST3, 0, Trapped.NO_TRAP, PSGame.getItem(OriginalItem.Inventory_Escape_Cloth));
	}
	public static void chest4() {
		PSGame.chestFlag(Chest.BORTEVO_CHEST4, 0, Trapped.NO_TRAP, PSGame.getItem(OriginalItem.Inventory_Flash));
	}

	public static void man() {
		PSMenu.startScene(Scene.DUNGEON, SpecialEntity.BEGGAR);
		PSMenu.StextLast(PSGame.getString("Bortevo_People_Cave"));
		PSMenu.endScene();
	}
	
	public static void exit() {
		PSGame.mapswitch(Planet.PALMA,26,48);
	}
	public static void abion_island() {
		PSGame.mapswitch(Planet.PALMA,23,38);
	}
	
}
