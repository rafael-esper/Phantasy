package ps;

import static core.Script.*;
import static ps.PS.*;

public class Palma {


	public static void mapinit()   {
		current_map.horizontalWrapable =
			current_map.verticalWrapable = true; 
		cameratracking = 1;
		
		setplayer(AllocateEntity(gotox*16, gotoy*16, "alis.chr"));
		fadein(30, true);

		log("Palma::mapinit");
	}
	
	public static void camineet() {
		mapswitch("Camineet.map",32,14);
	}
	
	
}
