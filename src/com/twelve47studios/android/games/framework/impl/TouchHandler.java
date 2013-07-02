package com.twelve47studios.android.games.framework.impl;

import java.util.List;

import android.view.View.OnTouchListener;

import com.twelve47studios.android.games.framework.input.InputIF.TouchEvent;

public interface TouchHandler extends OnTouchListener {
	public boolean isTouchDown(int pointer);
	
	public int getTouchX(int pointer);
	
	public int getTouchY(int pointer);
		
	public List<TouchEvent> getTouchEvents();

}
