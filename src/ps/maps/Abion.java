package ps.maps;

import static ps.oo.PSGame.EntFinish;
import static ps.oo.PSGame.EntStart;
import static ps.oo.PSGame.Shop;
import static ps.oo.PSGame.getItem;
import static ps.oo.PSGame.getString;
import static ps.oo.PSGame.getYesNo;
import static ps.oo.PSGame.mapswitch;
import domain.VImage;
import ps.oo.City;
import ps.oo.Dungeon;
import ps.oo.Enemy;
import ps.oo.Item;
import ps.oo.PSBattle;
import ps.oo.PSBattle.BattleOutcome;
import ps.oo.PSGame;
import ps.oo.PSGame.Chest;
import ps.oo.PSGame.Flags;
import ps.oo.PSGame.Planet;
import ps.oo.PSGame.Trapped;
import ps.oo.PSLibEnemy.PS1Enemy;
import ps.oo.PSLibItem.OriginalItem;
import ps.oo.PSLibMusic.PS1Music;
import ps.oo.PSMenu;
import ps.oo.PSMenu.EntityClothes;
import ps.oo.PSMenu.EntityType;
import ps.oo.PSMenu.Scene;
import ps.oo.PSMenu.SpecialEntity;

public class Abion {

	
	public static void church() {
		PSMenu.startScene(Scene.CHURCH_VILLAGE, SpecialEntity.PRIEST);
		PSGame.Church(2);
		PSMenu.endScene();
	}	
	
	public static void hospital() {
		PSMenu.startScene(Scene.HOSPITAL_VILLAGE, EntityType.VILLA_WMN_BLOND, EntityClothes.WHITE);
		PSGame.Hospital(2);
		PSMenu.endScene();
	}

	public static void hand_shop() {
		PSMenu.startScene(Scene.SHOP_HAND_VILLAGE, EntityType.VILLA_MAN_BLOND, EntityClothes.GREEN);
		if(!PSGame.hasFlag(Flags.DEFEAT_DRMAD)) {
			PSMenu.Stext(getString("Abion_Shop_Close"));
		} else {
			Shop(getString("Shop_Tool_Welcome"), true, new Item[]{	getItem(OriginalItem.Inventory_Flash),
																	getItem(OriginalItem.Inventory_Magic_Hat),
																	getItem(OriginalItem.Inventory_Light_Pendant)});
		}
		PSMenu.endScene();
	}	
	
	
	public static void food_shop() {
		PSMenu.startScene(Scene.SHOP_FOOD_VILLAGE, EntityType.VILLA_MAN_BLOND, EntityClothes.BLUE);
		if(!PSGame.hasFlag(Flags.DEFEAT_DRMAD)) {
			PSMenu.Stext(getString("Abion_Shop_Close"));
		} else {		
			Shop(getString("Shop_Pharmacy_Welcome"), false, new Item[]{	getItem(OriginalItem.Inventory_Monomate),
																	getItem(OriginalItem.Inventory_Dimate),
																	getItem(OriginalItem.Quest_Polymeteral)});
		}
		PSMenu.endScene();
	}	
	
	public static void weap_shop() {
		PSMenu.startScene(Scene.SHOP_WEAPON_VILLAGE, EntityType.VILLA_MAN_BLOND, EntityClothes.RED);
		if(!PSGame.hasFlag(Flags.DEFEAT_DRMAD)) {
			PSMenu.Stext(getString("Abion_Shop_Close"));
		} else {		
			Shop(getString("Shop_Weapon_Welcome"), false, new Item[]{	getItem(OriginalItem.Weapon_Wood_Cane),
																	getItem(OriginalItem.Armor_Diamond_Mail), // changed
																	getItem(OriginalItem.Shield_Laser_Barrier)});
		}
		PSMenu.endScene();
	}	
	

	public static void house1() {
		PSMenu.startScene(Scene.VILLAGE_HOUSE, EntityType.VILLA_WMN_BLOND, EntityClothes.BLUE);
		PSMenu.Stext(getString("Abion_House_1"));
		PSMenu.endScene();
	}

	public static void house2() {
		PSMenu.startScene(Scene.VILLAGE_HOUSE, EntityType.VILLA_MAN_BLOND, EntityClothes.BLUE);
		PSMenu.Stext(getString("Abion_House_2"));
		PSMenu.endScene();
	}
	
	public static void ent1() {
		EntStart();
		PSMenu.Stext(getString("Abion_People_Ent1"));
		EntFinish();
	}

	public static void ent2() {
		EntStart();
		PSMenu.Stext(getString("Abion_People_Ent2"));
		EntFinish();
	}

	public static void ent3() {
		EntStart();
		PSMenu.Stext(getString("Abion_People_Ent3"));
		EntFinish();
	}
	
	public static void tunnel_in() {
		mapswitch(Dungeon.ABION_DUNGEON_IN);
	}
	public static void tunnel_out() {
		mapswitch(Dungeon.ABION_DUNGEON_OUT);
	}
	public static void drmad() {
		BattleOutcome outcome = BattleOutcome.WIN;
		if(PSGame.hasFlag(Flags.DEFEAT_DRMAD)) {
			PSMenu.startScene(Scene.VILLAGE_HOUSE, SpecialEntity.NONE);
			PSMenu.instance.waitAnyButton();
		}
		else {
			
			Enemy drmad = PSGame.getEnemy(PS1Enemy.DR_MAD);
			PSMenu.startScene(Scene.VILLAGE_HOUSE, drmad.getChr());
			if(PSMenu.Prompt(getString("Abion_DrMad"), getYesNo()) == 1) {
				PSMenu.StextLast(getString("Abion_DrMadYes"));
				PSGame.getParty().getMember(1).setHp(0);
			}
			else {
				PSMenu.StextLast(getString("Abion_DrMadNo"));
			}
			PSMenu.instance.entitySprite = null;
			PSBattle battle = new PSBattle();
			outcome = battle.startBattle(new Enemy[]{drmad}, PS1Music.BATTLE);
			if(outcome == BattleOutcome.WIN) {
				PSGame.setFlag(Flags.DEFEAT_DRMAD);
			} else {
				PSGame.gameOverRoutine();
			}
		}
		if(outcome == BattleOutcome.WIN) {
			PSGame.chestFlag(Chest.DR_MAD_CHEST, 0, Trapped.NO_TRAP, PSGame.getItem(OriginalItem.Quest_Laconian_Pot));
		}
		PSGame.getParty().reallocate();
		PSMenu.endScene();
	}
	
	public static void exit() {
		mapswitch(Planet.PALMA, City.ABION.getX(), City.ABION.getY());		
	}
	
}
