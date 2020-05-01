package com.gmail.jpk.stu.ogll.Game;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;

import com.gmail.jpk.stu.ogll.Display.Sprite;

public class Scene {
	private String name;
	private Color bgColor;
	private List<Sprite> allSprites;
	
	public Scene(String name, Sprite... sprites) {
		this.name = name;
		bgColor = Color.black;
		allSprites = new ArrayList<Sprite>();
		for(Sprite s : sprites) {
			allSprites.add(s);
		}
	}
	
	/**
	 * Add a new sprite to the display.
	 * @param child	Sprite to add
	 */
	public void addChild(Sprite child) {
		allSprites.add(child);
	}
	
	public void render() {
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		for(Sprite s : allSprites) {
			s.render();
		}
	}
	
	public void update() {
		for(Sprite s : allSprites) {
			s.update();
		}
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setBgColor(Color color) {
		this.bgColor = color;
	}
	
	public Color getBgColor() {
		return bgColor;
	}
	
	public List<Sprite> getAllSprites() {
		return allSprites;
	}
}
