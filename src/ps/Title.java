package ps;

import core.Script;
import domain.VImage;
import ps.oo.City;
import ps.oo.Enemy;
import ps.oo.Item;
import ps.oo.Job;
import ps.oo.PSBattle;
import ps.oo.PSGame;
import ps.oo.PSLibImage.PS1Image;
import ps.oo.PSLibSound.PS1Sound;
import ps.oo.PSMenu.SpecialEntity;
import ps.oo.Party;
import ps.oo.PartyMember;
import ps.oo.Specie;
import ps.oo.BattlePosition.SceneType;
import ps.oo.PSBattle.BattleMode;
import ps.oo.PSBattle.BattleOutcome;
import ps.oo.PSGame.GameType;
import ps.oo.PSGame.Planet;
import ps.oo.PSGame.ScreenSize;
import ps.oo.PSLibEnemy.PS1Enemy;
import ps.oo.PSLibItem.OriginalItem;
import ps.oo.PSLibMusic.PS1Music;
import ps.oo.PSMenu.Cancellable;
import ps.oo.PSMenu.EntityType;
import ps.oo.PSMenu.Scene;
import ps.oo.PartyMember.Gender;
import ps.oo.PSMenu;
import ps.oo.menuGUI.MenuImageBox;
import ps.oo.menuGUI.MenuLabelBox;
import ps.oo.menuGUI.MenuPromptBox;
import static core.Script.*;
import static core.VergeEngine.syncAfterLoading;
import static ps.oo.PSGame.format;
import static ps.oo.PSGame.getItem;
import static ps.oo.PSGame.getString;

public class Title {

	public static void startmap() {
		
		PSGame.playMusic(PS1Music.TITLE);
		
		PSGame.initGameScreen(ScreenSize.SCREEN_320_240); // ScreenSize.SCREEN_640_480
		PSGame.gameData.enableCheats = false;
		
		PSMenu.startScene(Scene.TITLE, SpecialEntity.NONE);

		while(true) {

			PSMenu.instance.push(PSMenu.instance.createPromptBox(90, 140, 
					new String[]{	PSGame.getString("Title_Newgame"),
									PSGame.getString("Title_Loadgame"),
									PSGame.getString("Title_Credits"),
									PSGame.getString("Title_Options_Language")}, true));
			int mainOpt = PSMenu.instance.waitOpt(Cancellable.TRUE) + 1;
			PSMenu.instance.pop();
			
			if(mainOpt==0) {
				continue;
			}
			
			if(mainOpt == 1) {
				if(newGameMenu()) {
					break;
				}
			}
			
			if(mainOpt == 2) {
				PSGame.initPSGame(GameType.PS_ORIGINAL);
				if(PSGame.loadGame()) {
					syncAfterLoading();
					break;
				}
				syncAfterLoading();
			}
			
			// Credits
			if(mainOpt == 3) {
				creditsMenu();
			}			

			if(mainOpt == 4) {
				PSGame.languageMenu(60, 120);
			}
		}

		PSMenu.endScene();
	}

	private static boolean newGameMenu() {
		//int opt = PSMenu.Prompt(PSGame.getString("Title_Newgame_Instructions"), 
		
		MenuPromptBox gameMenu = new MenuPromptBox(70, 130,	
				new String[]{PSGame.getString("Title_Newgame_Alis"),
							 PSGame.getString("Title_Newgame_Odin"),
							 PSGame.getString("Title_Newgame_Noah"),
							 PSGame.getString("Title_Newgame_Party"),
							 PSGame.getString("Title_Newgame_Extended"),
							 PSGame.getString("Title_Newgame_PSArena")}, true);
		PSMenu.instance.push(gameMenu);
		gameMenu.setDisabled(2);
		gameMenu.setDisabled(3);
		gameMenu.setDisabled(4);
		int opt = PSMenu.instance.waitOpt(Cancellable.TRUE);
		PSMenu.instance.pop();
		
		if(opt < 0) {
			return false;
		}
		
		stopmusic();

		if(opt == 0) {
			PSGame.initPSGame(GameType.PS_ORIGINAL);
			map("space/Space.map");
		} 
//		else if(opt == 2) {
//			PSGame.initPSGame(GameType.PS_ORIGINAL);
//			PSGame.gameData.current_planet = Planet.PALMA;
//			PSGame.mapswitch(City.CAMINEET, 29, 9);
//		}
		else if(opt == 1) {
			PSGame.initPSGame(GameType.PS_START_AS_ODIN);
			map("space/Space.map");
		}
		else if(opt == 2) {
			PSGame.initPSGame(GameType.PS_START_AS_NOAH);
			map("space/Space.map");
		}
		else if (opt == 4) { // Extended
			PSGame.initPSGame(GameType.PS_ORIGINAL);

			//PSGame.gameData.current_planet = Planet.PALMA;
			//PSGame.mapswitch(City.GOTHIC, 10, 16);
			
			//PSGame.mapswitch(Planet.DEZORIS, 100, 55); // Near Corona
			//PSGame.mapswitch(Planet.DEZORIS, 14, 32); // Near Frost Cave
			PSGame.mapswitch(Planet.DEZORIS, 133, 104); // Near Laerma Tree
		}
		else if(opt == 5) {
			PSGame.initPSGame(GameType.PS_ARENA);
			PhantasyArena.PhantasyArenaGame();
			Script.playmusic(load("music/Title.vgz"));
			startmap();
		}
		return true;
	}


	private static void creditsMenu() {
		PSMenu.instance.push(PSMenu.instance.createPromptBox(90, 140, 
				new String[]{	PSGame.getString("Title_Credits_About"),
								PSGame.getString("Title_Credits_Game"),
								PSGame.getString("Title_Credits_Contact")}, true));
		int creditsOpt = PSMenu.instance.waitOpt(Cancellable.TRUE) + 1;
		PSMenu.instance.pop();
		
		
		if(creditsOpt == 0) {
			return;
		}
		
		if(creditsOpt == 1) {
			PSMenu.startScene(Scene.BLACK, SpecialEntity.NONE);
			PSMenu.instance.push(MenuImageBox.MenuImage(40, 0, PSGame.getImage(PS1Image.CINE_CREDIT1)));
			PSMenu.Stext(getString("Title_Credits_About_1"));
			PSMenu.instance.pop();
			screen.fade(25, false);
			PSMenu.instance.push(MenuImageBox.MenuImage(40, 0, PSGame.getImage(PS1Image.CINE_CREDIT2)));
			PSMenu.Stext(getString("Title_Credits_About_2"));
			PSMenu.instance.pop();
			screen.fade(25, false);
			PSMenu.instance.push(MenuImageBox.MenuImage(40, 0, PSGame.getImage(PS1Image.CINE_CREDIT3)));
			PSMenu.Stext(getString("Title_Credits_About_3"));
			PSMenu.instance.pop();
			screen.fade(25, false);
			PSMenu.instance.push(MenuImageBox.MenuImage(40, 0, PSGame.getImage(PS1Image.CINE_CREDIT4)));
			PSMenu.Stext(getString("Title_Credits_About_4"));
			PSMenu.instance.pop();			
			screen.fade(25, false);
			PSMenu.instance.push(MenuImageBox.MenuImage(40, 0, PSGame.getImage(PS1Image.CINE_CREDIT5)));
			PSMenu.Stext(getString("Title_Credits_About_5"));
			PSMenu.instance.pop();			
			
			PSMenu.endScene();
		}
		
		// GAME CREDITS
		if(creditsOpt == 2) {
			int pos = 0;
			int rows = 12;
			String[] sCredits = new String[rows*2-1];
			for(int i=0; i<rows; i++) {
				sCredits[pos++] = PSGame.getString("Title_Credits_Game_" + (i+1));
				if(pos<sCredits.length)
					sCredits[pos++] = "";
			}
			
			MenuLabelBox creditsLabelBox = PSMenu.instance.createLabelBox(10, 10, sCredits, true);
			PSMenu.instance.push(creditsLabelBox);
			PSMenu.instance.waitAnyButton();

			pos = 0;
			String[] sCreditsNext = new String[rows*2-1];
			for(int i=0; i<rows; i++) {
				sCreditsNext[pos++] = PSGame.getString("Title_Credits_Game_" + (i+1+rows));
				if(pos<sCreditsNext.length)
					sCreditsNext[pos++] = "";
			}
			
			MenuLabelBox nextCreditsLabelBox = PSMenu.instance.createLabelBox(80, 10, sCreditsNext, true);
			PSMenu.instance.push(nextCreditsLabelBox);
			PSMenu.instance.waitAnyButton();
			
			PSMenu.instance.pop();
			PSMenu.instance.pop();
						
		}
		
		// CONTACT
		if(creditsOpt == 3) {
			int pos = 0;
			int rows = 12;
			String[] sCredits = new String[rows*2-1];
			for(int i=0; i<rows; i++) {
				sCredits[pos++] = PSGame.getString("Title_Credits_Contact_" + (i+1));
				if(pos<sCredits.length)
					sCredits[pos++] = "";
			}
			
			MenuLabelBox contactLabelBox = PSMenu.instance.createLabelBox(40, 10, sCredits, true);
			PSMenu.instance.push(contactLabelBox);
			PSMenu.instance.waitAnyButton();
			PSMenu.instance.pop();
		}
		
		
		PSMenu.startScene(Scene.TITLE, SpecialEntity.NONE);		
	}
	
	
	// Unused
	private static void optionsMenu() {
		PSMenu.instance.push(PSMenu.instance.createPromptBox(90, 140, 
				new String[]{	PSGame.getString("Title_Options_Language"),
								//PSGame.getString("Title_Options_Music"),
								PSGame.getString("Title_Options_Difficulty")}, true));
		int opt = PSMenu.instance.waitOpt(Cancellable.TRUE) + 1;
		PSMenu.instance.pop();
		
		if(opt==1) {
			PSGame.languageMenu(60, 120);
		}
		
		//if(opt==2) {
			//PSGame.musicMenu(80, 120);
		//}

		if(opt==2) {
			
		}
		
		return;
	}
	
}
