package com.twelve47studios.android.games.framework.fileio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface FileIOIF {
	public InputStream readAsset(String fileName) throws IOException;
	
	public InputStream readFile(String fileName) throws IOException;
	
	public OutputStream writeFile(String fileName) throws IOException;
}
