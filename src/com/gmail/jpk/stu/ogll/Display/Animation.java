package com.gmail.jpk.stu.ogll.Display;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.opengl.Texture;

import com.gmail.jpk.stu.ogll.Game.OglW;

public class Animation {
	
	private class Frame {
		private Hitbox hitbox;
		private float xStart, xWidth, yStart, yWidth;
		
		public Frame(Hitbox hitbox, float xStart, float yStart, float xWidth, float yWidth) {
			this.hitbox = hitbox;
			this.xStart = xStart;
			this.yStart = yStart;
			this.xWidth = xWidth;
			this.yWidth = yWidth;
		}
	}
	
	private Texture spriteSheet;
	private String name;
	private long delayFrame;
	private long lastTime;
	private int currentFrame;
	private List<Frame> animationFrames;
	
	public Animation(String name, long delayFrame, Texture spriteSheet) {
		this.name = name;
		this.delayFrame = delayFrame;
		this.spriteSheet = spriteSheet;
		this.currentFrame = 0;
		animationFrames = new ArrayList<Frame>();
	}
	
	public void play() {
		long time = OglW.getTime();
		if(time > lastTime + delayFrame) {
			lastTime = time;
			if(currentFrame + 1 >= animationFrames.size()) {
				currentFrame = 0;
			}
			else {
				currentFrame++;
			}
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public long getDelayFrame() {
		return delayFrame;
	}
	
	public void setDelayFrame(long delayFrame) {
		this.delayFrame = delayFrame;
	}
	
	public int getCurrentFrame() {
		return currentFrame;
	}
	
	public void setCurrentFrame(int currentFrame) {
		this.currentFrame = currentFrame;
	}
	
	public Texture getSpriteSheet() {
		return spriteSheet;
	}
	
	public Hitbox getHitbox() {
		return animationFrames.get(currentFrame).hitbox;
	}
	
	public Hitbox getHitbox(int index) {
		return animationFrames.get(index).hitbox;
	}
	
	public float getFrameXStart() {
		return animationFrames.get(currentFrame).xStart;
	}
	
	public float getFrameYStart() {
		return animationFrames.get(currentFrame).yStart;
	}
	
	public float getFrameXWidth() {
		return animationFrames.get(currentFrame).xWidth;
	}
	
	public float getFrameYWidth() {
		return animationFrames.get(currentFrame).yWidth;
	}
	
	public void createFrame(Hitbox hitbox, float xStart, float yStart, float xWidth, float yWidth) {
		animationFrames.add(new Frame(hitbox, xStart, yStart, xWidth, yWidth));
	}
}
