package com.twelve47studios.android.games.framework.graphics;

import com.twelve47studios.android.games.framework.graphics.GraphicsIF.PixmapFormat;

public interface Pixmap {
	public int getWidth();
	
	public int getHeight();
	
	public PixmapFormat getFormat();
	
	public void dispose();
}
