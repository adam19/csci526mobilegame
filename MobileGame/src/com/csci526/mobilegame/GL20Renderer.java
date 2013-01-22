package com.csci526.mobilegame;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLU;
import android.opengl.Matrix;



public class GL20Renderer implements GLSurfaceView.Renderer {
	
	public Triangle triangle;
	public Square square;
	
	public Shader basicShader; 
	
	public Camera camera;
	
	public void onDrawFrame(GL10 arg0) {
		GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT | GLES20.GL_DEPTH_BUFFER_BIT);
		
		triangle.draw(camera.modelViewProjMatrix);
	}

	public void onSurfaceChanged(GL10 arg0, int width, int height) {		
		if (camera != null)
			camera.resize(width, height);
	}

	public void onSurfaceCreated(GL10 arg0, EGLConfig arg1) {
		GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
		
		triangle = new Triangle();
		square = new Square();
		
		camera = new Camera(1280, 720);
		camera.pos = new Vec3f(0.0f, 0.0f, 2.0f);
		camera.target = new Vec3f(0.0f, 0.0f, 0.0f);
		camera.buildMatrices();
	}


}
