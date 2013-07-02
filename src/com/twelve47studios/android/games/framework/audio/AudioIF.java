package com.twelve47studios.android.games.framework.audio;

public interface AudioIF {
	public MusicIF newMusic(String fileName);
	
	public SoundIF newSound(String filename);
}
