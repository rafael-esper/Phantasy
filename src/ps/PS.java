package ps;

import static core.Script.*;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import ps.oo.MenuStack;

import core.VergeEngine;

public class PS extends VergeEngine {

	static Locale locale = new Locale("en", "US");
	static ResourceBundle rb = ResourceBundle.getBundle("ps/Script", locale);		

	public static void main(String args[]) {
		
		setSystemPath(new PS().getClass());
		initVergeEngine(args);
	}
	
	// SYSTEM.JAVA
	static int gotox, gotoy;
	
	public static void mapswitch(String mapname, int x, int y) {
		gotox=x;gotoy=y;
		fadeout(30); //tvout();
		map(mapname);
	}

	public static void autoexec() {
		setappname("Phantasy Star: Remake");

		//playerdiagonals = false;
		//playerstep = 16;
		
		gotox = 83;
		gotoy = 50;
		playmusic(load("Title.vgz"));

		//Stext("Testing á é í ó ú ça va?");
		Stext("This is not a working demo. It is just a demonstration of wrapable maps and some little peeking on my PS Remake with JVerge.");
		Stext("For a full tech demo, see Sully Chronicles.");
		Stext("Press enter to enter Palma.");
	}

	static int Prompt(String text, String[] choices) {
		List<String> rows = splitTextIntoRows(text, 38);
		if(rows.size() == 1) {
			MenuStack.instance.push(MenuStack.instance.createTextBox(20,185,280,42,rows.get(0), ""));
		}
		else if(rows.size() > 1) {
			MenuStack.instance.push(MenuStack.instance.createTextBox(20,185,280,42,rows.get(0), rows.get(1)));			
		}
		MenuStack.instance.push(MenuStack.instance.createPromptBox(220+choices.length*20,145, choices));
		int ret = MenuStack.instance.waitOpt(false);
		MenuStack.instance.pop();
		MenuStack.instance.pop();
		return ret+1; // Start counting options from 1
	}

	static void Stext(String text) {
		List<String> rows = splitTextIntoRows(text, 38);
		
		// Show multiples textboxes with at most two rows for the text
		for(int j=0; j<rows.size(); j++) {
			
			String r2 = "";
			if(j+1 < rows.size())
				r2 = rows.get(j+1);
			MenuStack.instance.push(MenuStack.instance.createTextBox(20,185,280,42,rows.get(j), r2));
			MenuStack.instance.waitB1();
			MenuStack.instance.pop();
			j++;
		}
	}

	// Generic startmap function
	public static void startmap()   {
		
		log("PS::startmap");
		playerstep = 16;
		cameratracking=1;

		setplayer(AllocateEntity(gotox*16, gotoy*16, "alis.chr"));
		render();fadein(30, false);
		//tvin();	
		//int char1 = AllocateEntity(current_map.startX*16, current_map.startY*16, "alis.chr");
		//entitystalk(char1, player);
		//current_map.horizontalWrapable = current_map.verticalWrapable = true;
		
		//Ente[1]=EntitySpawn(gotox, gotoy, Name[Party[1]]+".CHR");
		//SetPlayer(EntitySpawn(gotox, gotoy, Name[Party[0]]+".CHR"));
	}

	
	// Useful stuff to do while talking to entities or in some scenes, from Sully
	static int _Ent_tmpvar;

	public static void EntStart() {
		// MenuOff();
		if(event_entity >= 0 && event_entity < entity.size()) {
			_Ent_tmpvar = entity.get(event_entity).speed;
			entity.get(event_entity).speed=0;
		}
		pauseplayerinput();	
	}

	public static void EntFinish() {
		// MenuOn();
		if(event_entity >= 0 && event_entity < entity.size()) {
			entity.get(event_entity).speed = _Ent_tmpvar;
		}
		unpauseplayerinput();
	}	

	
}
