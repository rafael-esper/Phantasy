package ps.oo;

public class PSLibCHR {

		public enum PS1CHR {

			// Misc 
			CHEST ("/ps/images/original/chest.chr"),
			SKY_CASTLE("/ps/images/original/sky_castle.chr"),
			ODIN_STATUE("/ps/images/original/odin_stone.chr"),
			MYAU_FLAPPING("/ps/images/original/myau_flapping.chr"),
			
			// Battle Animations
			ENEMY_FIRE ("/ps/battle/enemy_fire.chr"),
			ENEMY_THUNDER ("/ps/battle/enemy_thunder.chr"),
			PLAYER_FIRE ("/ps/battle/pl_fire.chr"),
			PLAYER_WIND ("/ps/battle/pl_wind.chr"),
			PLAYER_THUNDER("/ps/battle/pl_thunder.chr"),
			PLAYER_GIFIRE("/ps/battle/pl_gifire.chr"),
			
			// Scenes
			ANIM_BEACH ("/ps/images/original/scene/Beach.chr"),
			ANIM_SEA ("/ps/images/original/scene/Sea.chr"),
			ANIM_LAVA ("/ps/images/original/scene/Lava.chr"),
			ANIM_GAS ("/ps/images/original/scene/Gas.chr"),

			// Entities
			IMG_ENTITIES ("/ps/images/original/entities.chr"),
			IMG_ENTITIES_LARGE ("/ps/images/original/lentities.chr");
			
			private String url;
			
			PS1CHR(String s) {
				this.url = s;
			}
			
			public String getUrl() {
				return this.url;
			}
		};
		
		
	
	
}
