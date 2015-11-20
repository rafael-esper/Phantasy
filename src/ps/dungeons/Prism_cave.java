package ps.dungeons;

import static ps.oo.PSGame.getItem;
import ps.PSDungeon;
import ps.oo.PSBattle;
import ps.oo.PSBattle.BattleOutcome;
import ps.oo.PSGame;
import ps.oo.PSGame.Chest;
import ps.oo.PSGame.Planet;
import ps.oo.PSGame.Trapped;
import ps.oo.PSLibEnemy.PS1Enemy;
import ps.oo.PSLibItem.OriginalItem;
import ps.oo.PSMenu;
import ps.oo.PSMenu.EntityClothes;
import ps.oo.PSMenu.EntityType;
import ps.oo.PSMenu.Scene;

public class Prism_cave {
	
	public static void startmap() {
		PSDungeon dungeon = PSGame.currentDungeon;
		dungeon.setRandomEnemies(0, new PS1Enemy[]{PS1Enemy.TITAN, PS1Enemy.FROSTMAN, PS1Enemy.WT_DRAGN});
		dungeon.startDungeon();
	}
	
	public static void chest() {
		PSGame.chestFlag(Chest.PRISM_CAVE_CHEST1, 0, Trapped.NO_TRAP, getItem(OriginalItem.Inventory_Magic_Hat));
	}
	
	public static void woman() {
		PSMenu.startScene(Scene.DUNGEON, EntityType.VILLA_WMN_BLUE, EntityClothes.RED);
		PSMenu.Stext(PSGame.getString("Cave_Deep_Dezo_Woman"));
		PSMenu.endScene();
	}

	public static void titan() {
		if(!PSGame.gameData.chestFlags.contains(Chest.PRISM_CAVE_CHEST2)) {
			PSBattle battle = new PSBattle();
			BattleOutcome outcome = battle.battleScene(Scene.CORRIDOR, PSGame.getEnemy(PS1Enemy.CYCLOP), 2);
			if(outcome == BattleOutcome.WIN) {
				PSGame.chestFlag(Chest.PRISM_CAVE_CHEST2, 0, Trapped.NO_TRAP, PSGame.getItem(OriginalItem.Quest_Aeroprism));
			}
		}
	}

	public static void exit() {
		PSGame.mapswitch(Planet.DEZORIS,71,86);
	}
}
