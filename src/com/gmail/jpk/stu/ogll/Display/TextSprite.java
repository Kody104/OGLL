package com.gmail.jpk.stu.ogll.Display;

import java.awt.Font;

import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;

public class TextSprite extends Sprite{

	private Color color;
	private TrueTypeFont display;
	private String text;
	
	public TextSprite(String name, float X, float Y, Font font, String text, Color color) {
		super(name, X, Y);
		display = new TrueTypeFont(font, true);
		this.text = text;
		this.color = color;
	}
	
	@Override
	public void render() {
		if(isVisible) {
			display.drawString(X, Y, text, color);
		}
	}
	
	@Override
	public void update() {
		
	}
	
	public void updateFont(Font font) {
		display = new TrueTypeFont(font, true);
	}
	
	public int getTextWidth(String text) {
		return display.getWidth(text);
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
}
