package ps.dungeons;

import static ps.oo.PSGame.getItem;
import ps.PSDungeon;
import ps.oo.City;
import ps.oo.PSGame;
import ps.oo.PSGame.Chest;
import ps.oo.PSGame.Flags;
import ps.oo.PSGame.Trapped;
import ps.oo.PSLibItem.OriginalItem;

public class Warehouse {
	
	public static void startmap() {
		PSDungeon dungeon = PSGame.currentDungeon;
		dungeon.startDungeon();
	}
	
	public static void chest1() {
		PSGame.chestFlag(Chest.WAREHOUSE_CHEST1, 50, Trapped.NO_TRAP, null);
	}
	
	public static void chestKey() {
		if(PSGame.hasFlag(Flags.INFO_KEY)) {
			PSGame.chestFlag(Chest.WAREHOUSE_CHESTKEY, 0, Trapped.NO_TRAP, getItem(OriginalItem.Quest_Dungeon_Key));
		}
	}	
	
	public static void exit() {
		PSGame.mapswitch(City.CAMINEET,32,7);
	}
	
	public static void trap() {
		//PSGame.chestFlag(Chest.WAREHOUSE_CHEST1, 50, Trapped.EXPLOSION, null);
		
		// PSGame.randomBattle(Scene.CORRIDOR, new PS1Enemy[]{PS1Enemy.SWORM});
		//PSGame.trapRoutine(Trap.NAHARU_TRAP, Trap.INFO_NAHARU_TRAP, 11, 6);
	}
}
