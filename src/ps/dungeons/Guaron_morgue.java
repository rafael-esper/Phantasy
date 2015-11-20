package ps.dungeons;

import static ps.oo.PSGame.getItem;
import core.Script;
import ps.PSDungeon;
import ps.oo.Enemy;
import ps.oo.PSBattle;
import ps.oo.PSGame;
import ps.oo.PSBattle.BattleOutcome;
import ps.oo.PSGame.Chest;
import ps.oo.PSGame.Flags;
import ps.oo.PSGame.Planet;
import ps.oo.PSGame.Trap;
import ps.oo.PSGame.Trapped;
import ps.oo.PSLibEnemy.PS1Enemy;
import ps.oo.PSLibItem.OriginalItem;
import ps.oo.PSMenu.Scene;

public class Guaron_morgue {
	
	public static void startmap() {
		PSDungeon dungeon = PSGame.currentDungeon;
		dungeon.setRandomEnemies(0, new PS1Enemy[]{PS1Enemy.BATALION, PS1Enemy.ZOMBIE, PS1Enemy.REVENANT});
		dungeon.setRandomEnemies(-1, new PS1Enemy[]{PS1Enemy.BATALION, PS1Enemy.ZOMBIE, PS1Enemy.REVENANT});

		dungeon.setFixedEnemies(0, new PS1Enemy[]{PS1Enemy.BATALION, PS1Enemy.REVENANT});
		dungeon.setFixedEnemies(-1, new PS1Enemy[]{PS1Enemy.ZOMBIE, PS1Enemy.REVENANT, PS1Enemy.BATALION});

		dungeon.startDungeon();
	}
	
	public static void chest1() {
		BattleOutcome outcome = BattleOutcome.WIN;
		if(!PSGame.gameData.chestFlags.contains(Chest.GUARON_MORGUE_CHEST1)) {
			PSBattle battle = new PSBattle();
			outcome = battle.battleScene(Scene.CORRIDOR, new Enemy[]{PSGame.getEnemy(PS1Enemy.DEATH_KNIGHT)});
		}
		if(outcome == BattleOutcome.WIN) {
			PSGame.chestFlag(Chest.GUARON_MORGUE_CHEST1, 0, Trapped.NO_TRAP, getItem(OriginalItem.Armor_Laconian_Armor));
		}
		
	}
	public static void chest2() {
		PSGame.chestFlag(Chest.GUARON_MORGUE_CHEST2, 0, Trapped.NO_TRAP, getItem(OriginalItem.Inventory_Dimate));
	}

	public static void stairs1_up() {
		PSGame.warp(5, 7, false);
	}
	public static void stairs1_down() {
		PSGame.warp(21, 10, false);
	}
	public static void stairs2_up() {
		PSGame.warp(12, 12, false);
	}
	public static void stairs2_down() {
		PSGame.warp(25, 13, false);
	}
	public static void stairs3_up() {
		PSGame.warp(9, 3, false);
	}
	public static void stairs3_down() {
		PSGame.warp(25, 6, false);
	}
	public static void stairs4_up() {
		PSGame.warp(13, 7, false);
	}
	public static void stairs4_down() {
		PSGame.warp(27, 8, false);
	}

	public static void trap1() {
		PSGame.trapRoutine(Trap.GUARON_TRAP1, Trap.INFO_GUARON_TRAP1, 25, 8);
	}
	public static void trap2() {
		PSGame.trapRoutine(Trap.GUARON_TRAP2, Trap.INFO_GUARON_TRAP2, 21, 12);
	}

	public static void exit() {
		PSGame.mapswitch(Planet.DEZORIS,80,7);
	}
}
