package ps;

import static core.Script.cameratracking;
import static core.Script.log;
import static core.Script.screen;
import static core.Script.setSystemPath;
import static core.Script.setAppName;
import ps.oo.PSGame;
import ps.oo.PSMenu;
import core.VergeEngine;

public class Phantasy extends VergeEngine {

	public static void main(String args[]) {
		
		setSystemPath(new Phantasy().getClass());
		initVergeEngine(args);
	}
	
	public static void autoexec() {
		setAppName("Phantasy Star Extended v1.06");
	}


	// Generic startmap function
	public static void startmap()   {
		
		log("PS::startmap");
		cameratracking=1;

		PSGame.getParty().allocate(PSGame.getgotox(), PSGame.getgotoy());
		
		screen.fadeIn(30, true);
		
		PSMenu.menuOn();
		PSGame.transportOff();
		
		//current_map.horizontalWrapable = current_map.verticalWrapable = true;
	}
	
}
