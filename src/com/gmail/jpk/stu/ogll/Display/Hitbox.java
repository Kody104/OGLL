package com.gmail.jpk.stu.ogll.Display;

public class Hitbox {
	private float X, Y; // In relation to parent texture
	private float width, height;
	
	public Hitbox(int X, int Y, int width, int height) {
		this.X = X;
		this.Y = Y;
		this.width = width;
		this.height = height;
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

	public float getWidth() {
		return X + width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return Y + height;
	}

	public void setHeight(float height) {
		this.height = height;
	}
}
