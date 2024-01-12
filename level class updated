package culminating;

import java.util.ArrayList;
import java.awt.*;

public class Level {
	
	private ArrayList<Rectangle> platformList;
	private ArrayList<Rectangle> hazardList;
	private ArrayList<Rectangle> platformListOg;
	private ArrayList<Rectangle> hazardListOg;
	
	Level() {
		platformList = new ArrayList<Rectangle>();
		hazardList = new ArrayList<Rectangle>();
		platformListOg = new ArrayList<Rectangle>();
		hazardListOg = new ArrayList<Rectangle>();
	}
	
	public void addPlatform(int x, int y, int w, int h) {
		this.platformList.add(new Rectangle(x, y, w, h));
		this.platformListOg.add(new Rectangle(x, y, w, h));
	}
	
	public void addHazard(int x, int y, int w, int h) {
		this.hazardList.add(new Rectangle(x, y, w, h));
		this.hazardListOg.add(new Rectangle(x, y, w, h));
	}
	
	public ArrayList<Rectangle> getPlatforms() {
		return this.platformList;
	}
	
	public ArrayList<Rectangle> getHazards() {
		return this.hazardList;
	}
	
	public int getScrollStop() {
		int largest = 0;
		for (Rectangle r: this.platformList) {
			if (r.x + r.width > largest) largest = r.x + r.width;
		}
		return largest;
	}
	
	public ArrayList<Rectangle> getOgPlatforms() {
		return this.platformListOg;
	}
	
	public ArrayList<Rectangle> getOgHazards() {
		return this.hazardListOg;
	}
	
	

}
