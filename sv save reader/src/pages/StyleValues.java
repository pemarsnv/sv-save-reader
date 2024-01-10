package pages;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class StyleValues {
	
	public Color BACKGROUND = new Color(255, 210, 132);
	public Color FONT = new Color(131,75,43);
	public Color BORDER = new Color(190, 141, 88);
	
	public Font TEXTFONT;
	public Font TITLEFONT;
	
	private static StyleValues instance;
	
	private StyleValues() {
		
		try {
			TEXTFONT = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("fonts/Stardew_Valley.ttf"));
			TITLEFONT = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("fonts/Stardew Valley ALL CAPS.ttf"));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static synchronized StyleValues getInstance() {
		if (instance == null) {
			instance = new StyleValues();
		}
		return instance;
	}
	
}
