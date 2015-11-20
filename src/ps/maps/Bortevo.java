package ps.maps;

import static ps.oo.PSGame.EntFinish;
import static ps.oo.PSGame.EntStart;
import static ps.oo.PSGame.Shop;
import static ps.oo.PSGame.getItem;
import static ps.oo.PSGame.getString;
import static ps.oo.PSGame.getYesNo;
import static ps.oo.PSGame.mapswitch;
import ps.oo.City;
import ps.oo.Item;
import ps.oo.PSGame;
import ps.oo.PSGame.Flags;
import ps.oo.PSGame.Planet;
import ps.oo.PSLibItem.OriginalItem;
import ps.oo.PSMenu;
import ps.oo.PSMenu.EntityClothes;
import ps.oo.PSMenu.EntityType;
import ps.oo.PSMenu.LargeEntity;
import ps.oo.PSMenu.Scene;
import ps.oo.PSMenu.SpecialEntity;

public class Bortevo {

	
	public static void house() {
		PSMenu.startScene(Scene.RUINED_HOUSE, SpecialEntity.BEGGAR);
		PSMenu.Stext(getString("Bortevo_People_Man_2"));
		PSMenu.endScene();
	}

	public static void hapsby() {
		if(!PSGame.hasFlag(Flags.GOT_HAPSBY)) {
			PSMenu.startScene(Scene.RUINED_HOUSE, LargeEntity.JUNK);
		} else {
			PSMenu.startScene(Scene.RUINED_HOUSE, SpecialEntity.NONE);
		}
		
		PSMenu.instance.waitB1();
		if(!PSGame.hasFlag(Flags.GOT_HAPSBY) && PSGame.getParty().hasQuestItem(getItem(OriginalItem.Quest_Polymeteral))) {
			PSMenu.Stext(getString("Bortevo_House_Hapsby"));
			PSMenu.startScene(Scene.SCREEN_NOFADE, LargeEntity.HAPSBY);
			PSMenu.instance.waitDelay(30);
			PSMenu.Stext(getString("Bortevo_Hapsby_Free"));
			PSMenu.StextNext(getString("Bortevo_Hapsby"));
			PSGame.getParty().removeItem(getItem(OriginalItem.Quest_Polymeteral));
			PSGame.setFlag(Flags.GOT_HAPSBY);
			
		} else {
			PSMenu.Stext(getString("Chest_Search"));
		}
		PSMenu.endScene();
	}
	
	public static void junk() {
		PSMenu.startScene(Scene.RUINED_HOUSE, LargeEntity.JUNK);
		PSMenu.instance.waitB1();
		PSMenu.Stext(getString("Chest_Search"));
		PSMenu.endScene();
	}	
	
	public static void hovercraft() {
		PSMenu.startScene(Scene.RUINED_HOUSE, LargeEntity.JUNK);
		PSMenu.instance.waitB1();
		if(PSGame.hasFlag(Flags.INFO_HOVER) && !PSGame.getParty().hasQuestItem(getItem(OriginalItem.Vehicle_FlowMover))) {
			PSMenu.Stext(getString("Bortevo_House_Hovercraft"));
			PSGame.getParty().addQuestItem(getItem(OriginalItem.Vehicle_FlowMover));
		} else {
			PSMenu.Stext(getString("Chest_Search"));
		}
		PSMenu.endScene();
	}

	public static void ent1() {
		EntStart();
		PSMenu.Stext(getString("Bortevo_People_Man_1"));
		EntFinish();
	}

	public static void exit() {
		mapswitch(Planet.PALMA, City.BORTEVO.getX(), City.BORTEVO.getY());		
	}

	
	
}
