package com.gmail.jpk.stu.ogll.Tools;

import com.gmail.jpk.stu.ogll.Game.OglW;

public abstract class OglTimer {
	
	private boolean isRunning;
	private boolean mustDestroy;
	private long startTimer;
	private long targetTimer;
	
	public OglTimer(long targetTimer) {
		this.isRunning = true;
		this.mustDestroy = false;
		this.startTimer = OglW.getTime();
		this.targetTimer = startTimer + targetTimer;
	}
	
	/**
	 * Checks the time to see if the timer is called.
	 */
	public void update() {
		if(isRunning) {
			if(OglW.getTime() >= targetTimer) {
				executeTimer();
			}
		}
	}
	
	/**
	 * Override this to do things when the timer ends.
	 */
	public abstract void executeTimer();

	public boolean isRunning() {
		return isRunning;
	}

	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}

	public boolean isMustDestroy() {
		return mustDestroy;
	}

	public void setMustDestroy(boolean mustDestroy) {
		this.mustDestroy = mustDestroy;
	}

	public long getStartTimer() {
		return startTimer;
	}

	public void setStartTimer(long startTimer) {
		this.startTimer = startTimer;
	}

	public long getTargetTimer() {
		return targetTimer;
	}

	public void setTargetTimer(long targetTimer) {
		this.targetTimer = targetTimer;
	}
}
