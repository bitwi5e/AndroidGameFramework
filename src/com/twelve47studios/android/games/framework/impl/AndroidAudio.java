package com.twelve47studios.android.games.framework.impl;

import java.io.IOException;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;

import com.twelve47studios.android.games.framework.audio.AudioIF;
import com.twelve47studios.android.games.framework.audio.MusicIF;
import com.twelve47studios.android.games.framework.audio.SoundIF;

public class AndroidAudio implements AudioIF {
	AssetManager assets;
	SoundPool soundPool;

	public AndroidAudio(Activity activity) {
		activity.setVolumeControlStream(AudioManager.STREAM_MUSIC);
	}

	@Override
	public MusicIF newMusic(String fileName) {
		try {
			AssetFileDescriptor assetDescriptor = assets.openFd(fileName);
			return new AndroidMusic(assetDescriptor);
		} catch (IOException e) {
			throw new RuntimeException("Couldn't load music '" + fileName + "'");
		}
	}

	@Override
	public SoundIF newSound(String fileName) {
		try {
			AssetFileDescriptor assetDescriptor = assets.openFd(fileName);
			int soundId = soundPool.load(assetDescriptor, 0);
			return new AndroidSound(soundPool, soundId);
		} catch (IOException e) {
			throw new RuntimeException("Couldn't load sound '" + fileName + "'");
		}
	}

}
