package com.gmail.jpk.stu.ogll.Game;

import org.lwjgl.Sys;

public class OglW {
	
	private static int lastFPS;
	private static int fps;
	private static long elapsed;
	private static OglGame game;
	
	/**
	 * This method will return the current fps.
	 * 
	 */
	public static int getFPS() {
		if(getTime() - lastFPS > 1000) {
			fps = 0;
			lastFPS += 1000;
		}
		fps++;
		return fps;
	}
	
	/**
	 * Used for calculating physics for frames.
	 * @return	The time between this call and the last call of this method.
	 */
	public static int getDelta() {
		long time = getTime();
		int delta = (int) (time - elapsed);
		elapsed = time;
		
		return delta;
	}
	
	/**
	 * 
	 * @return	The time in milliseconds.
	 */
	public static long getTime() {
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}
	
	/**
	 * 	Sets the current instance of the game to this global class.
	 * @param game	The instance of your game.
	 */
	protected static void setGame(OglGame game) {
		if(OglW.game == null)
			OglW.game = game;
	}
	
	public static OglGame getGame() {
		return OglW.game;
	}
}
