package com.gmail.jpk.stu.ogll.Game;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class Camera {
	
	private static float X, Y, Z;
	private static float Zoom;
	
	private static float maxSpeed;
	
	public static void create() {
		maxSpeed = 0.5f;
		X = 0.0f;
		Y = 0.0f;
		Z = 1.0f;
		Zoom = 1.0f;
	}
	
	
	public static void apply() {
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, OglW.getGame().getScreenWidth() * Zoom, OglW.getGame().getScreenHeight() * Zoom, 0, -1, 1);
		GL11.glTranslatef(X, Y, Z);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
	}
	
	public static void acceptInput(float delta) {
		boolean keyFast = Keyboard.isKeyDown(Keyboard.KEY_RSHIFT);
		boolean keyLeft = Keyboard.isKeyDown(Keyboard.KEY_LEFT);
		boolean keyRight = Keyboard.isKeyDown(Keyboard.KEY_RIGHT);
		boolean keyUp = Keyboard.isKeyDown(Keyboard.KEY_UP);
		boolean keyDown = Keyboard.isKeyDown(Keyboard.KEY_DOWN);
		boolean keyZoomIn = Keyboard.isKeyDown(Keyboard.KEY_EQUALS);
		boolean keyZoomOut = Keyboard.isKeyDown(Keyboard.KEY_SUBTRACT);
		
		float speed;
		
		if(keyFast) {
			speed = maxSpeed * 5;
		}
		else {
			speed = maxSpeed;
		}
		
		speed *= delta;
		
		if(keyLeft) {
			X += speed;
		}
		if(keyRight) {
			X -= speed;
		}
		if(keyUp) {
			Y += speed;
		}
		if(keyDown) {
			Y -= speed;
		}
		if(keyZoomIn) {
			Zoom = 0.5f;
		}
		if(keyZoomOut) {
			Zoom = 1.0f;
		}
	}
	
	public void setCameraPosition(float X, float Y, float Z) {
		Camera.X = X;
		Camera.Y = Y;
		Camera.Z = Z;
	}

	public static float getX() {
		return X;
	}

	public static void setX(float x) {
		X = x;
	}

	public static float getY() {
		return Y;
	}

	public static void setY(float y) {
		Y = y;
	}
	
	public static float getZ() {
		return Z;
	}
	
	public static void setZ(float z) {
		Z = z;
	}

	public static float getZoom() {
		return Zoom;
	}

	public static void setZoom(float zoom) {
		Zoom = zoom;
	}

	public static float getMaxSpeed() {
		return maxSpeed;
	}

	public static void setMaxSpeed(float maxSpeed) {
		Camera.maxSpeed = maxSpeed;
	}
}