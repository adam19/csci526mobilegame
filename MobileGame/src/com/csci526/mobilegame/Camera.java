package com.csci526.mobilegame;

import android.opengl.GLES20;
import android.opengl.Matrix;

public class Camera {

	public int width;
	public int height;
	public float ratio;
	
	public Vec3f pos;
	public Vec3f target;
	public Vec3f up;
	
	public float fovy;
	public float zNear;
	public float zFar;
	
	public float projMatrix[];
	public float viewMatrix[];
	public float modelViewProjMatrix[];

	public Camera(int width, int height) {
		this.width = width;
		this.height = height;
		
		pos = new Vec3f(0,0,2);
		target = new Vec3f(0,0,0);
		up = new Vec3f(0,1,0);
		
		fovy = 90.0f;
		zNear = 0.1f;
		zFar = 100.0f;
		
		projMatrix = new float[16];
		viewMatrix = new float[16];
		modelViewProjMatrix = new float[16];
		
		buildMatrices();
	}
	
	public void setPos(Vec3f pos) {
		this.pos.x = pos.x;
		this.pos.y = pos.y;
		this.pos.z = pos.z;
	}
	
	public void setTarget(Vec3f target) {
		this.target.x = target.x;
		this.target.y = target.y;
		this.target.z = target.z;
	}
	
	public void setUp(Vec3f up) {
		this.up.x = up.x;
		this.up.y = up.y;
		this.up.z = up.z;		
	}
	
	public void resize(int width, int height) {
		this.width = width;
		this.height = height;
		
		buildMatrices();
	}
	
	public void buildMatrices() {
		GLES20.glViewport(0, 0, this.width, this.height);
		
		ratio = (float)width / (float)height;
		
		//Matrix.frustumM(projMatrix, 0, -ratio, ratio, -1.0f, 1.0f, 0.1f, 100.0f);
		//Matrix.perspectiveM(projMatrix, 0, 90.0f, ratio, 0.1f, 100.0f);
		perspective(fovy, zNear, zFar);
		
		Matrix.setLookAtM(viewMatrix, 0, 
			pos.x, pos.y, pos.z, 
			target.x, target.y, target.z,
			up.x, up.y, up.z);
	
		Matrix.multiplyMM(modelViewProjMatrix, 0, projMatrix, 0, viewMatrix, 0);
	}
	
	public void perspective(float fovy, float zNear, float zFar) {
		float yScale = 1.0f / (float)Math.tan(Math.toRadians(fovy) / 2.0f);
		float xScale = yScale / ratio;
		
		this.fovy = fovy;
		this.zNear = zNear;
		this.zFar = zFar;
		
		projMatrix[0] = xScale;
		projMatrix[1] = 0.0f;
		projMatrix[2] = 0.0f;
		projMatrix[3] = 0.0f;
		
		projMatrix[4] = 0.0f;
		projMatrix[5] = yScale;
		projMatrix[6] = 0.0f;
		projMatrix[7] = 0.0f;
		
		projMatrix[8] = 0.0f;
		projMatrix[9] = 0.0f;
		projMatrix[10]= (zFar + zNear) / (zNear - zFar);
		projMatrix[11]= -1.0f;
		
		projMatrix[12]= 0.0f;
		projMatrix[13]= 0.0f;
		projMatrix[14]= (2.0f * zNear * zFar) / (zNear - zFar);
		projMatrix[15]= 0.0f;
	}
}
