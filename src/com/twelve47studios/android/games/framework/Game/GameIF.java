package com.twelve47studios.android.games.framework.Game;

import com.twelve47studios.android.games.framework.Screen.ScreenIF;
import com.twelve47studios.android.games.framework.audio.AudioIF;
import com.twelve47studios.android.games.framework.fileio.FileIOIF;
import com.twelve47studios.android.games.framework.graphics.GraphicsIF;
import com.twelve47studios.android.games.framework.input.InputIF;

public interface GameIF {
	public InputIF getInput();
	
	public FileIOIF getFileIO();
	
	public GraphicsIF getGraphics();
	
	public AudioIF getAudio();
	
	public void setScreen(ScreenIF screen);
	
	public ScreenIF getCurrentScreen();
	
	public ScreenIF getStartScreen();
}
