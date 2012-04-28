package ps.oo;

import java.awt.Color;
import java.awt.Font;
import java.net.URL;
import java.util.Stack;

import static core.VergeEngine.*;
import static core.Script.*;
import static core.Controls.*;

public class MenuStack {

	public static MenuStack instance = new MenuStack();
	protected static Font menu_font = new Font("Monospaced", Font.PLAIN, 12);
	protected static URL menuSound = load("menu.wav"); 
	
	//public static Font menu_font = new Font(load("smallfont.gif"));
	
	Stack<MenuType> menus = new Stack<MenuType>();
	String scene = null; //"black"; // change to Scene Object
	
	public void push(MenuType menu) {
		menus.push(menu);
	}
	
	public void pop() {
		MenuType m = menus.pop();
		/*if(m instanceof PromptBox) {
			return ((PromptBox) m).selected;
		}
		return 0;*/
	}
	
	public void drawMenus() {
		
		if(scene == null)
			render();
		else
			rectfill(0, 0, screen.width, screen.height, Color.BLACK, screen);

		for(MenuType m: menus) {
			m.draw();
		}
	}
	
	public void startScene(String type) {
		fade(15, true);
		scene = "black";
	}
	public void endScene() {
		scene = null;
		fade(15, false);
	}
	
	public TextBox createTextBox(int x, int y, int wx, int wy, String r1, String r2) {
		return new TextBox(x, y, wx, wy, r1, r2);
	}
	public PromptBox createPromptBox(int x, int y, String[] options) {
		return new PromptBox(x, y, options);
	}

	public static void drawTextBox(int x, int y, String text) {
		drawBox(x, y, 10+text.length()*12, 26);
		screen.g.setFont(MenuStack.menu_font);
		screen.g.setColor(Color.WHITE);
		screen.g.drawString(text, x+20, y+17);	
	}

	static void drawBox(int a, int b, int c, int d) {
		setlucent(15);
		rectfill(a+4,b+4,c+a,d+b, new Color(30,30,150), screen);
		rect(a+3,b+3,c+a-3,d+b-3,new Color(60,60,60), screen);
		rect(a+2,b+2,c+a-2,d+b-2,new Color(90,90,90), screen);
		rect(a+1,b+1,c+a-1,d+b-1,new Color(90,90,90), screen);
		rect(a,b,c+a,d+b,new Color(60,60,60), screen);
		setlucent(0);
	}
	
	public void waitB1() {
		//pauseplayerinput();
		try {
		while(!b1) {
			drawMenus();
			//colorfilter(1, screen);
			showpage();
		}
		unpress(1);
		//unpauseplayerinput();
		}
		catch(Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	public int waitOpt(boolean cancellable) {
		//pauseplayerinput();
		unpress(9);
		while(!b1) {
			if(up) {
				playsound(menuSound);
				((PromptBox) menus.lastElement()).previousOption();
				UnUp();
			}
			if(down) {
				playsound(menuSound);
				((PromptBox) menus.lastElement()).nextOption();
				UnDown();
			}
			if(b2 && cancellable) {
				unpress(2);
				//unpauseplayerinput();
				return -1;
			}
			
			drawMenus();
			showpage();
		}
		unpress(1);
		//unpauseplayerinput();
		return ((PromptBox) menus.lastElement()).selected;
	}	
	
}

/*************  MENU TYPE abstract class ***********************/

abstract class MenuType {

	public abstract void draw();
	
}

/*************  MENU TYPE TextBox ***********************/

class TextBox extends MenuType {
	
	final int FIRST_ROW = 193+8;
	final int SECOND_ROW = 210+8;
	
	String text1;
	String text2;
	
	int x, y, wx, wy;
	
	public TextBox() {
		
	}
	
	public TextBox(int x2, int y2, int wx2, int wy2, String r1, String r2) {
		this.x = x2;
		this.y = y2;
		this.wx = wx2;
		this.wy = wy2;
		this.text1 = r1;
		this.text2 = r2;
	}

	public void draw() {
		MenuStack.drawBox(20,185,280,42);
		screen.g.setFont(MenuStack.menu_font);
		screen.g.setColor(Color.WHITE);
		screen.g.drawString(text1, 28, FIRST_ROW);
		screen.g.drawString(text2, 28, SECOND_ROW);
		//Printstring(28,FIRST_ROW,screen, MenuStack.menu_font, text1);
		//Printstring(28,SECOND_ROW,screen, MenuStack.menu_font, text2);
	}
}

/*************  MENU TYPE PromptBox ***********************/

class PromptBox extends MenuType {
	
	String [] options;
	int x, y;
	boolean cancellable = false;
	int selected = 0;
	int wx, wy;
	
	public PromptBox(int x2, int y2, String[] options2) {
		this.x = x2;
		this.y = y2;
		this.options = options2;

		int max = 0;
		for(String s: options) {
			if(s.length() > max)
				max = s.length();
		}
		wx = 15 + max*12;
		wy = 10 + options.length * 16;
	
	}

	public void previousOption() {
		selected--;
		if(selected <0)
			selected = options.length -1;
	}

	public void nextOption() {
		selected++;
		if(selected >= options.length) 
			selected = 0;
	}

	public void draw() {
		
		
		MenuStack.drawBox(x, y, wx, wy); // 45,40
		
		for(int i=0; i<options.length; i++) { // 220, 145
			screen.g.setFont(MenuStack.menu_font);
			screen.g.setColor(Color.WHITE);
			screen.g.drawString(options[i], x+20, y+17+16*i);
			
			//Circle(x+6, y+9+17*i, 6, 6, Color.GRAY, screen);
			screen.g.setColor(Color.GRAY);
			screen.g.drawRoundRect(x+6, y+8+16*i, 8, 8, 3, 3);
			
			if(selected == i && (timer/25)%2==1) {
				screen.g.setColor(new Color(200, 40, 40));
				screen.g.fillRect(x+7, y+9+16*i, 7, 7);

				screen.g.setColor(new Color(235, 20, 20));
				screen.g.fillOval(x+7, y+10+16*i, 5, 5);

				//CircleFill(x+6, y+7+17*i, 6, 6, Color.RED, screen);
			}
		}
		
		
		//Printstring(228, 153, screen, menu_font, "Yes");
		//Printstring(228, 170, screen, menu_font, "No");
		//WaitB1();
	}
}

