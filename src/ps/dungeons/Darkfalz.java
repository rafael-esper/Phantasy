package ps.dungeons;

import ps.PSDungeon;
import ps.maps.Paseo;
import ps.oo.City;
import ps.oo.Enemy;
import ps.oo.PSBattle;
import ps.oo.PSGame;
import ps.oo.PSGame.Flags;
import ps.oo.PSGame.Trap;
import ps.oo.PSMenu.SpecialEntity;
import ps.oo.PSBattle.BattleOutcome;
import ps.oo.PSLibEnemy.PS1Enemy;
import ps.oo.PSLibMusic.PS1Music;
import ps.oo.PSMenu;
import ps.oo.PSMenu.Scene;

public class Darkfalz {
	
	public static void startmap() {
		PSMenu.menuOn();
		PSDungeon dungeon = PSGame.currentDungeon;

		dungeon.setRandomEnemies(0, new PS1Enemy[]{PS1Enemy.NANO_COP, PS1Enemy.ANDROCOP, PS1Enemy.RD_DRAGN});
		dungeon.setRandomEnemies(-1, new PS1Enemy[]{PS1Enemy.NESSIE, PS1Enemy.NANO_COP, PS1Enemy.SORCERER, PS1Enemy.MAGICIAN});
		dungeon.setRandomEnemies(-2, new PS1Enemy[]{PS1Enemy.NESSIE, PS1Enemy.NANO_COP, PS1Enemy.SORCERER, PS1Enemy.MAGICIAN});

		dungeon.setFixedEnemies(0, new PS1Enemy[]{PS1Enemy.NANO_COP, PS1Enemy.ANDROCOP, PS1Enemy.NANO_COP});
		dungeon.setFixedEnemies(-1, new PS1Enemy[]{PS1Enemy.SORCERER, PS1Enemy.MAGICIAN});
		dungeon.setFixedEnemies(-2, new PS1Enemy[]{PS1Enemy.NESSIE, PS1Enemy.MAGICIAN});
		
		dungeon.startDungeon();
	}
	
	public static void trap1() {
		PSGame.trapRoutine(Trap.DARKFALZ_TRAP1, Trap.INFO_DARKFALZ_TRAP1, 25, 1);
	}
	public static void trap2() {
		PSGame.trapRoutine(Trap.DARKFALZ_TRAP2, Trap.INFO_DARKFALZ_TRAP2, 16, 23);
	}
	public static void darkfalz() {
		PSMenu.setMapOff();
		PSGame.playMusic(PS1Music.DARKFALZ);
		PSMenu.startScene(Scene.BLACK, SpecialEntity.NONE);
		PSMenu.instance.waitDelay(200);
		PSBattle battle = new PSBattle();
		
		BattleOutcome outcome = battle.startBattle(new Enemy[]{PSGame.getEnemy(PS1Enemy.DARKFALZ)}, PS1Music.DARKFALZ);
		if(outcome == BattleOutcome.DEFEAT) {
			PSGame.gameOverRoutine();
		}
		else {
			PSMenu.instance.waitDelay(200);
			PSGame.setFlag(Flags.DEFEAT_DARKFALZ);
			Paseo.governor();
		}
		
		//PSMenu.endScene();
		
	}
	
	public static void exit() {
		PSGame.mapswitch(City.PASEO,20,7);
	}
}
