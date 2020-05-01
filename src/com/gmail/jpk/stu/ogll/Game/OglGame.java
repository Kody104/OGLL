package com.gmail.jpk.stu.ogll.Game;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import com.gmail.jpk.stu.ogll.Tools.OglTimer;

public class OglGame {
	
	private int screenWidth;
	private int screenHeight;
	private String title;
	private Scene currentScene;
	private List<OglTimer> allTimers;
	
	public OglGame(int SCREEN_WIDTH, int SCREEN_HEIGHT, String TITLE) {
		this.screenWidth = SCREEN_WIDTH;
		this.screenHeight = SCREEN_HEIGHT;
		this.title = TITLE;
		this.currentScene = null;
		this.allTimers = new ArrayList<OglTimer>();
		try {
			initGL();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		OglW.setGame(this);
	}
	
	public void begin() {
		while(!Display.isCloseRequested()) {
			if(currentScene != null) {
				render();
				update();
			}
			Display.update();
		}
		Display.destroy();
	}
	
	private void initGL() throws LWJGLException {
		Display.setDisplayMode(new DisplayMode(screenWidth, screenHeight));
		Display.setTitle(title);
		Display.create();
		Display.setVSyncEnabled(true);
		
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		
		GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
		
			// enable alpha blending
        	GL11.glEnable(GL11.GL_BLEND);
        	GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
     
        	GL11.glViewport(0, 0, screenWidth, screenHeight);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0, screenWidth, screenHeight, 0, -1, 1);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
	}
	
	protected void render() {
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		currentScene.render();
	}
	
	protected void update() {
		currentScene.update();
		for(int i = 0; i < allTimers.size(); i++) {
			OglTimer t = allTimers.get(i);
			if(t.isMustDestroy()) {
				allTimers.remove(i);
				i--;
				continue;
			}
			t.update();
		}
	}

	public int getScreenWidth() {
		return screenWidth;
	}

	public void setScreenWidth(int screenWidth) {
		this.screenWidth = screenWidth;
	}

	public int getScreenHeight() {
		return screenHeight;
	}

	public void setScreenHeight(int screenHeight) {
		this.screenHeight = screenHeight;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
		Display.setTitle(title);
	}

	public Scene getCurrentScene() {
		return currentScene;
	}

	public void setCurrentScene(Scene currentScene) {
		this.currentScene = currentScene;
	}
	
	public void addTimer(OglTimer timer) {
		allTimers.add(timer);
	}

	public List<OglTimer> getAllTimers() {
		return allTimers;
	}
}
