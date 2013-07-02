package com.twelve47studios.android.games.framework.impl;

import android.media.SoundPool;

import com.twelve47studios.android.games.framework.audio.SoundIF;

public class AndroidSound implements SoundIF {
	int soundId;
	SoundPool soundPool;
	
	public AndroidSound(SoundPool soundPool, int soundId){
		this.soundId = soundId;
		this.soundPool = soundPool;
	}
	
	@Override
	public void play(float volume) {
		soundPool.play(soundId, volume, volume, 0, 0, 1);

	}

	@Override
	public void dispose() {
		soundPool.unload(soundId);
	}

}