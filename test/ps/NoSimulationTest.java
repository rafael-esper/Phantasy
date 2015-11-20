

package ps;

import static core.Script.TEST_OPTIONS;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ps.dungeons.*;
import ps.maps.*;
import ps.oo.GameData;
import ps.oo.PSGame;
import ps.oo.PartyMember;
import ps.oo.PSGame.Flags;
import ps.oo.PSGame.GameType;
import ps.oo.PSGame.ScreenSize;
import ps.oo.PSLibItem.OriginalItem;
import core.Script;
import core.VergeEngine;
import domain.VImage;

public class NoSimulationTest {

	boolean SAVE_ON = true;

	@BeforeClass
	public static void initStructures() {
		Script.TEST_POS = 0;

		Script.screen = new VImage(320, 240);
	}

	@Before
	public void init() {
		Phantasy.main(new String[]{});
		PSGame.initGameScreen(ScreenSize.SCREEN_320_240);
		PSGame.initPSGame(GameType.PS_ORIGINAL);
	}

	@Test
	public void testCamineet() {
		Camineet.suelo();

		//assertTrue(PSGame.getParty().hasQuestItem(PSGame.getItem(OriginalItem.Quest_Laconian_Pot)) == false);

		//Camineet.nekise();

		//assertTrue(PSGame.getParty().hasQuestItem(PSGame.getItem(OriginalItem.Quest_Laconian_Pot)));
	}

	
}
