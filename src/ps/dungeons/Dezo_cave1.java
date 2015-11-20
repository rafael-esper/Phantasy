package ps.dungeons;

import ps.PSDungeon;
import ps.oo.PSGame;
import ps.oo.PSGame.Chest;
import ps.oo.PSGame.Planet;
import ps.oo.PSGame.Trapped;
import ps.oo.PSLibEnemy.GenericEnemy;
import ps.oo.PSLibEnemy.PS1Enemy;
import ps.oo.PSLibEnemy.PS4Enemy;
import ps.oo.PSMenu.Scene;

public class Dezo_cave1 {
	
	public static void startmap() {
		PSDungeon dungeon = PSGame.currentDungeon;
		dungeon.setRandomEnemies(0, new GenericEnemy[]{PS1Enemy.SCORPIUS, PS1Enemy.SCORPIUS, PS1Enemy.STORM_FLY, PS1Enemy.GHOUL, PS4Enemy.BLUE_SCORPION});
		dungeon.setFixedEnemies(0, new PS1Enemy[]{PS1Enemy.SCORPIUS, PS1Enemy.STORM_FLY, PS1Enemy.STORM_FLY});
		dungeon.startDungeon();
	}
	
	public static void chest1() {
		PSGame.chestFlag(Chest.DEZO_CAVE1_CHEST1, 0, Trapped.ARROW, null);
	}
	public static void chest2() {
		PSGame.chestFlag(Chest.DEZO_CAVE1_CHEST2, 100, Trapped.NO_TRAP, null);
	}

	public static void exit() {
		PSGame.mapswitch(Planet.DEZORIS,182,92);
	}
	public static void nextArea() {
		PSGame.mapswitch(Planet.DEZORIS,164,92);
	}
	
}
