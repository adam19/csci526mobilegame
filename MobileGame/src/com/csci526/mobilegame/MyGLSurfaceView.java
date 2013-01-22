package com.csci526.mobilegame;

import android.content.Context;
import android.opengl.GLSurfaceView;

public class MyGLSurfaceView extends GLSurfaceView {

	public MyGLSurfaceView(Context context) {
		super(context);
		
		setEGLContextClientVersion(2);
		setRenderer(new GL20Renderer());
	}	

}
