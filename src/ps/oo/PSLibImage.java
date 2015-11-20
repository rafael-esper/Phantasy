package ps.oo;

import static core.Script.load;

public class PSLibImage {

		public enum PS1Image {

			// Scenes
			BLUE_HOUSE ("/ps/images/original/scene/C_House1.png"),
			YELLOW_HOUSE ("/ps/images/original/scene/C_House1.png"),
			VILLAGE_HOUSE ("/ps/images/original/scene/C_House2.png"),
			RUINED_HOUSE ("/ps/images/original/scene/C_Ruined.png"),
			SHOP_FOOD ("/ps/images/original/scene/C_Food1.png"),
			SHOP_HAND ("/ps/images/original/scene/C_Hand1.png"),
			SHOP_WEAPON ("/ps/images/original/scene/C_Weap1.png"),
			HOSPITAL ("/ps/images/original/scene/C_Hosp1.png"),
			CHURCH ("/ps/images/original/scene/C_Church1.png"),
			SHOP_FOOD_VILLAGE ("/ps/images/original/scene/C_Food2.png"),
			SHOP_HAND_VILLAGE ("/ps/images/original/scene/C_Hand2.png"),
			SHOP_WEAPON_VILLAGE ("/ps/images/original/scene/C_Weap2.png"),
			HOSPITAL_VILLAGE ("/ps/images/original/scene/C_Hosp2.png"),
			CHURCH_VILLAGE ("/ps/images/original/scene/C_Church2.png"),
			SPACESHIP ("/ps/images/original/scene/C_Space.png"),
			PALACE ("/ps/images/original/scene/C_Palace.png"),
			VILLA ("/ps/images/original/scene/C_Villa.png"),
			CITY ("/ps/images/original/scene/C_Town.png"),
			BAYA ("/ps/images/original/scene/C_Baya.png"),

			// Battle scenes
			FOREST ("/ps/images/original/scene/C_Forest.png"),
			FIELDS ("/ps/images/original/scene/C_Fields.png"),
			DESERT ("/ps/images/original/scene/C_Desert.png"),
			ARTIC ("/ps/images/original/scene/C_Artic.png"),
			PINES ("/ps/images/original/scene/C_Pines.png"),
			SKY ("/ps/images/original/scene/C_Sky.png"),
			ALTAR ("/ps/images/original/scene/C_Altar.png"),
			CAVE ("/ps/images/original/scene/C_Cave.png"),
			
			// Cinematics
			CINE_ALIS ("/ps/images/original/cine/S_Alis.png"),
			CINE_MYAU ("/ps/images/original/cine/S_Myau.png"),
			CINE_ODIN ("/ps/images/original/cine/S_Odin.png"),
			CINE_NOAH ("/ps/images/original/cine/S_Noah.png"),
			CINE_NERO1 ("/ps/images/original/cine/S_Nero1.png"),
			CINE_NERO2 ("/ps/images/original/cine/S_Nero2.png"),
			CINE_PROMISE ("/ps/images/original/cine/S_Promise.png"),
			CINE_BEAST1 ("/ps/images/original/cine/S_Beast1.png"),
			CINE_BEAST2 ("/ps/images/original/cine/S_Beast2.png"),
			
			CINE_INTRO1("/ps/images/original/cine/S_Intro1.png"),
			CINE_INTRO2("/ps/images/original/cine/S_Intro2.png"),
			CINE_ODIN2 ("/ps/images/original/cine/S_Odin2.png"),
			
			// CREDITS
			CINE_CREDIT1 ("/ps/images/original/credits/Credits1.png"),
			CINE_CREDIT2 ("/ps/images/original/credits/Credits2.png"),
			CINE_CREDIT3 ("/ps/images/original/credits/Credits3.png"),
			CINE_CREDIT4 ("/ps/images/original/credits/Credits4.png"),
			CINE_CREDIT5 ("/ps/images/original/credits/Credits5.png"),
			
			
			// Portraits
			PORTRAIT_ALIS ("/ps/images/original/portraits/Alis.png"),
			PORTRAIT_MYAU ("/ps/images/original/portraits/Myau.png"),
			PORTRAIT_ODIN ("/ps/images/original/portraits/Odin.png"),
			PORTRAIT_NOAH ("/ps/images/original/portraits/Noah.png"),
			IMG_TALK_ALIS ("/ps/images/original/portraits/S_Alis.png"),
			IMG_TALK_MYAU ("/ps/images/original/portraits/S_Myau.png"),
			IMG_TALK_ODIN ("/ps/images/original/portraits/S_Odin.png"),
			IMG_TALK_NOAH ("/ps/images/original/portraits/S_Noah.png"),
			
			TITLE ("/ps/images/original/Title.png"),
			ENDING("/ps/images/original/Ending.png");
			
			private String url;
			
			PS1Image(String s) {
				this.url = s;
			}
			
			public String getUrl() {
				return this.url;
			}
		};
		
		
	
	
}
