package com.twelve47studios.android.games.framework.graphics;

public interface GraphicsIF {
	public static enum PixmapFormat {
		ARGB8888, ARGB4444, RGB565
	}
	
	/**
	 * Loads an image in JPEG or PNG format.  Resulting pixmap might have different format.
	 * This is done to control memory footprint of loaded images.  Filename specifies asset in applications APK file.			
	 * @param fileName
	 * @param format
	 * @return
	 */
	public Pixmap newPixmap(String fileName, PixmapFormat format);
	
	/**
	 * Clears framebuffer with given color specified as 32 bit ARGB8888 value.
	 * @param color
	 */
	public void clear(int color);
	
	/**
	 * Method will set pixel at (x,y) in the framebuffer to given color.  Coordinates outside of screen are ignored.
	 * @param x
	 * @param y
	 * @param color
	 */
	public void drawPixel(int x, int y, int color);
	
	/**
	 * Extension of drawPixel
	 * @param x
	 * @param y
	 * @param x2
	 * @param y2
	 * @param color
	 */
	public void drawLine(int x, int y, int x2, int y2, int color);
	
	/**
	 * Extension of drawLine
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param color
	 */
	public void drawRect(int x, int y, int width, int height, int color);
	
	/**
	 * Draws rectangular portions of Pixmap to framebuffer.  The (x,y) coordinates specify the top-left
	 * corner's position of the Pixmap's target location in the framebuffer.  The arguments srcX and srcY
	 * specify the corresponding top-left corner of the rectangular region that is used from the Pixmap, given
	 * in the Pixmap's own coordinate system.  srcWidth and srcHeight specify the size of the portion that we take from the
	 * Pixmap.
	 * @param pixmap
	 * @param x
	 * @param y
	 * @param srcX
	 * @param srcY
	 * @param srcWidth
	 * @param srcHeight
	 */
	public void drawPixmap(Pixmap pixmap, int x, int y, int srcX, int srcY, int srcWidth, int srcHeight);
	
	/**
	 * Draws rectangular portions of Pixmap to framebuffer.  The (x,y) coordinates specify the top-left
	 * corner's position of the Pixmap's target location in the framebuffer.
	 * @param pixmap
	 * @param x
	 * @param y
	 */
	public void drawPixmap(Pixmap pixmap, int x, int y);
	
	/**
	 * Returns width of the framebuffer in pixels
	 * @return
	 */
	public int getWidth();
	
	/**
	 * Returns height of the framebuffer in pixels
	 * @return
	 */
	public int getHeight();
}
