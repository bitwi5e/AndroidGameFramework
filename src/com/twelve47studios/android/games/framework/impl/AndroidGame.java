package com.twelve47studios.android.games.framework.impl;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.view.Window;
import android.view.WindowManager;

import com.twelve47studios.android.games.framework.Game.GameIF;
import com.twelve47studios.android.games.framework.Screen.ScreenIF;
import com.twelve47studios.android.games.framework.audio.AudioIF;
import com.twelve47studios.android.games.framework.fileio.FileIOIF;
import com.twelve47studios.android.games.framework.graphics.GraphicsIF;
import com.twelve47studios.android.games.framework.input.InputIF;

public class AndroidGame extends Activity implements GameIF {
	AndroidFastRenderView renderView;
	GraphicsIF graphics;
	AudioIF audio;
	InputIF input;
	FileIOIF fileIO;
	ScreenIF screen;
	WakeLock wakeLock;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		boolean isLandscape = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
		int frameBufferWidth = isLandscape ? 480 : 320;
		int frameBufferHeight = isLandscape ? 320 : 480;
		Bitmap frameBuffer = Bitmap.createBitmap(frameBufferWidth, frameBufferHeight, Config.RGB_565);
		
		float scaleX = (float) frameBufferWidth / getWindowManager().getDefaultDisplay().getWidth();
		float scaleY = (float) frameBufferHeight / getWindowManager().getDefaultDisplay().getHeight();
		
		renderView = new AndroidFastRenderView(this, frameBuffer);
		graphics = new AndroidGraphics(getAssets(), frameBuffer);
		fileIO = new AndroidFileIO(getAssets());
		audio = new AndroidAudio(this);
		input = new AndroidInput(this, renderView, scaleX, scaleY);
		screen = getStartScreen();
		setContentView(renderView);
		
		PowerManager powerManager = (PowerManager) getSystemService(Context.POWER_SERVICE);
		wakeLock = powerManager.newWakeLock(PowerManager.FULL_WAKE_LOCK, "GLGame");
	}
	
	@Override
	public void onResume() {
		super.onResume();
		wakeLock.acquire();
		screen.resume();
		renderView.resume();
	}
	
	@Override
	public void onPause() {
		super.onPause();
		wakeLock.release();
		renderView.pause();
		screen.pause();
		
		if(isFinishing())
			screen.dispose();
	}
	
	@Override
	public InputIF getInput() {
		return input;
	}

	@Override
	public FileIOIF getFileIO() {
		return fileIO;
	}

	@Override
	public GraphicsIF getGraphics() {
		return graphics;
	}

	@Override
	public AudioIF getAudio() {
		return audio;
	}

	@Override
	public void setScreen(ScreenIF screen) {
		if (screen == null)
			throw new IllegalArgumentException("Screen must not be null");
		
		this.screen.pause();
		this.screen.dispose();
		screen.resume();
		screen.update(0);
		this.screen = screen;
	}

	@Override
	public ScreenIF getCurrentScreen() {
		return screen;
	}

	@Override
	public ScreenIF getStartScreen() {
		// TODO Auto-generated method stub
		return null;
	}

}
