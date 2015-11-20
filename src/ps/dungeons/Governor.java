package ps.dungeons;

import static core.Script.current_map;
import static core.Script.entity;
import static core.Script.player;
import static ps.oo.PSGame.getItem;
import static ps.oo.PSGame.getString;
import static ps.oo.PSGame.getYesNo;
import ps.PSDungeon;
import ps.oo.City;
import ps.oo.Enemy;
import ps.oo.PSGame;
import ps.oo.PSGame.Flags;
import ps.oo.PSLibEnemy.PS1Enemy;
import ps.oo.PSLibItem.OriginalItem;
import ps.oo.PSMenu;
import ps.oo.PSMenu.Scene;
import core.Script;
import domain.Entity;

public class Governor {
	
	public static void startmap() {
		
		PSDungeon dungeon = PSGame.currentDungeon;
		dungeon.startDungeon();
	}
	
	public static void robot() {
		if(!PSGame.hasFlag(Flags.GOVERNOR_CAKE)) {
			
			Enemy robotcop = PSGame.getEnemy(PS1Enemy.ROBOTCOP);
			PSMenu.startScene(Scene.CORRIDOR, robotcop.getChr());

			if(PSMenu.Prompt(getString("Paseo_Passageway_Cop"), getYesNo()) == 1) {
				if(PSGame.getParty().hasQuestItem(getItem(OriginalItem.Quest_Shortcake))) {
					PSGame.getParty().removeItem(getItem(OriginalItem.Quest_Shortcake));
					PSMenu.StextLast(getString("Paseo_Passageway_Cop_Gift"));
					PSGame.setFlag(Flags.GOVERNOR_CAKE);
				}
				else {
					PSMenu.StextLast(getString("Paseo_Passageway_Cop_NoGiftYes"));
				}
			}
			else {
				PSMenu.StextLast(getString("Paseo_Passageway_Cop_NoGiftNo"));
			}

			PSMenu.endScene();
			// Unless the party gives the cake, they get backed off
			if(!PSGame.hasFlag(Flags.GOVERNOR_CAKE)) {
				PSGame.currentDungeon.turnBack();
			}
		}
		
	}
	public static void governor() {
		PSGame.mapswitch(City.PASEO,19,11);	
	}	
	public static void exit() {
		PSGame.mapswitch(City.PASEO,22,18);	
	}
}
