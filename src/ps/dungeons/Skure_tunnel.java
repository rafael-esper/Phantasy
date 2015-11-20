package ps.dungeons;

import ps.PSDungeon;
import ps.oo.City;
import ps.oo.PSGame;
import ps.oo.PSGame.Chest;
import ps.oo.PSGame.Trapped;
import ps.oo.PSLibEnemy.PS1Enemy;

public class Skure_tunnel {
	
	public static void startmap() {
		PSDungeon dungeon = PSGame.currentDungeon;
		dungeon.setRandomEnemies(0, new PS1Enemy[]{PS1Enemy.BL_SLIME, PS1Enemy.WEREBAT});
		dungeon.setFixedEnemies(0, new PS1Enemy[]{PS1Enemy.WEREBAT, PS1Enemy.WING_EYE});
		dungeon.startDungeon();
	}
	
	public static void chest() {
		PSGame.chestFlag(Chest.SKURE_CHEST, 500, Trapped.NO_TRAP, null);
	}
	public static void exit() {
		PSGame.mapswitch(City.SKURE_ENTRANCE,11,11);
	}
	public static void skure() {
		PSGame.mapswitch(City.SKURE,20,7);
	}
	
}
