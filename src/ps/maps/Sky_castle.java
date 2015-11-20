package ps.maps;

import static ps.oo.PSGame.getString;
import static ps.oo.PSGame.mapswitch;
import ps.oo.Dungeon;
import ps.oo.PSBattle;
import ps.oo.PSBattle.BattleOutcome;
import ps.oo.PSGame;
import ps.oo.PSGame.Flags;
import ps.oo.PSLibEnemy.PS1Enemy;
import ps.oo.PSMenu;
import ps.oo.PSMenu.EntityClothes;
import ps.oo.PSMenu.EntityType;
import ps.oo.PSMenu.Scene;
import ps.oo.PSMenu.SpecialEntity;

public class Sky_castle {

	public static void house1() {
		PSMenu.startScene(Scene.BLUE_HOUSE, EntityType.VILLA_WMN_BLOND, EntityClothes.GREEN);
		PSMenu.Stext(getString("Air_Castle_House_1"));
		PSMenu.endScene();
	}

	public static void house2() {
		PSMenu.startScene(Scene.BLUE_HOUSE, SpecialEntity.OLDMAN);
		PSMenu.Stext(getString("Air_Castle_House_2"));
		PSMenu.endScene();
	}

	public static void house3() {
		PSMenu.startScene(Scene.BLUE_HOUSE, EntityType.VILLA_MAN_BLOND, EntityClothes.GREEN);
		PSMenu.Stext(getString("Air_Castle_House_3"));
		PSMenu.endScene();
	}
	
	public static void house4() {
		PSMenu.startScene(Scene.BLUE_HOUSE, EntityType.VILLA_MAN_BLOND, EntityClothes.RED);
		PSMenu.Stext(getString("Air_Castle_House_4"));
		PSMenu.endScene();
	}

	public static void house5() {
		if(!PSGame.hasFlag(Flags.MONSTER_SKY_SERPENT)) {
			PSBattle battle = new PSBattle();
			BattleOutcome outcome = battle.battleScene(Scene.BLUE_HOUSE, PSGame.getEnemy(PS1Enemy.SERPENT), 1);
			if(outcome == BattleOutcome.WIN) {
				PSGame.setFlag(Flags.MONSTER_SKY_SERPENT);
			}
		} else {
			PSMenu.startScene(Scene.BLUE_HOUSE, SpecialEntity.NONE);
			PSMenu.instance.waitAnyButton();
			PSMenu.endScene();
		}
		
		
	}

	public static void castle() {
		mapswitch(Dungeon.LASSIC_CASTLE);		
	}

	
	
}
