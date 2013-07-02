package com.twelve47studios.android.games.framework.Screen;

import com.twelve47studios.android.games.framework.Game.GameIF;

public abstract class ScreenIF {
	protected final GameIF game;
	
	public ScreenIF(GameIF game){
		this.game = game;
	}
	
	public abstract void update(float deltaTime);
	
	public abstract void present(float deltaTime);
	
	public abstract void pause();
	
	public abstract void resume();

	public void dispose() {
		// TODO Auto-generated method stub
		
	}
}
