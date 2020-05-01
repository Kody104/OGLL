package com.gmail.jpk.stu.ogll.Display;

import java.util.ArrayList;
import java.util.List;

import com.gmail.jpk.stu.ogll.Game.OglW;

public class Sprite {
	
	protected String name;
	protected boolean isVisible;
	protected List<Animation> animations;
	protected Animation currentAnimation;
	protected float X;
	protected float Y;
	protected float xThrust; // Velocity of x movement
	protected float yThrust; // Velocity of y movement
	
	public Sprite(String name, float X, float Y, Animation... anims) {
		this.name = name;
		this.isVisible = true;
		this.animations = new ArrayList<Animation>();
		for(Animation f : anims) {
			this.animations.add(new Animation(f.getName(), f.getDelayFrame(), f.getSpriteSheet()));
		}
		this.currentAnimation = anims[0];
		this.X = X;
		this.Y = Y;
		this.xThrust = 0.0f;
		this.yThrust = 0.0f;
	}
	
	public Sprite(String name, float X, float Y, List<Animation> anims) {
		this.name = name;
		this.isVisible = true;
		this.animations = new ArrayList<Animation>();
		for(Animation f : anims) {
			this.animations.add(new Animation(f.getName(), f.getDelayFrame(), f.getSpriteSheet()));
		}
		this.currentAnimation = anims.get(0);
		this.X = X;
		this.Y = Y;
		this.xThrust = 0.0f;
		this.yThrust = 0.0f;
	}
	
	public Sprite(String name, float X, float Y) {
		this.name = name;
		this.isVisible = true;
		this.animations = new ArrayList<Animation>();
		this.currentAnimation = null;
		this.X = X;
		this.Y = Y;
		this.xThrust = 0.0f;
		this.yThrust = 0.0f;
	}
	
	/**
	 * This method needs to be overridden. This method is called to render the sprite to the screen.
	 */
	public void render() {
	}
	
	/**
	 * This method needs to be overridden. This method is called to update variables of the sprite.
	 */
	public void update() {
		
	}
	
	public void addAnimation(Animation frame) {
		animations.add(frame);
	}
	
	/**
	 * 
	 * @param name	The name of the animation frame you want to call
	 * @return	True means it found the animation frame. False means it didn't.
	 */
	public boolean playAnimation(String name) {
		for(int i = 0; i < animations.size(); i++) {
			Animation f = animations.get(i);
			if(f.getName().toLowerCase().equals(name.toLowerCase())) {
				currentAnimation = f;
				return true;
			}
		}
		return false;
	}
	
	public boolean isColliding(Sprite sprite) {
		Hitbox thisHitbox = getCurrentAnimation().getHitbox();
		Hitbox thatHitbox = getCurrentAnimation().getHitbox();
		float thisActY = OglW.getGame().getScreenHeight() - this.getY();
		float thatActY = OglW.getGame().getScreenHeight() - sprite.getY();
		if(this.getX() < sprite.getX() + thatHitbox.getWidth() && this.getX() + thisHitbox.getWidth() > sprite.getX() &&
				thisActY > thatActY - thatHitbox.getHeight() && thisActY - thisHitbox.getHeight() < thatActY) {
			return true;
		}
		return false;
	}
	
	public boolean isAnimated() {
		return animations.size() > 1;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isVisible() {
		return isVisible;
	}

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}

	public List<Animation> getAnimations() {
		return animations;
	}

	public Animation getCurrentAnimation() {
		return currentAnimation;
	}

	public void setCurrentAnimation(Animation currentAnimation) {
		this.currentAnimation = currentAnimation;
	}

	public float getX() {
		return X;
	}

	public void setX(float x) {
		X = x;
	}

	public float getY() {
		return Y;
	}

	public void setY(float y) {
		Y = y;
	}

	public float getXThrust() {
		return xThrust;
	}

	public void setXThrust(float xThrust) {
		this.xThrust = xThrust;
	}

	public float getYThrust() {
		return yThrust;
	}

	public void setYThrust(float yThrust) {
		this.yThrust = yThrust;
	}
	
	@Override
	public Sprite clone() {
		Sprite toReturn = new Sprite(name, X, Y, animations);
		toReturn.setVisible(this.isVisible);
		toReturn.setXThrust(xThrust);
		toReturn.setYThrust(yThrust);
		toReturn.setCurrentAnimation(currentAnimation);
		return toReturn;
	}
}
