package com.csci526.mobilegame;

import android.opengl.GLES20;

public class Shader {

	public String vertexShaderCode;
	public String fragmentShaderCode;
	public int vertexShader;
	public int fragmentShader;
	public int program;
	
	public Shader() {
		vertexShaderCode = "" +
				"attribute vec4 vPos;" +
				"uniform mat4 mvpMatrix;" +
				"void main() {" +
				"	gl_Position = mvpMatrix * vPos;" +
				"}";
		fragmentShaderCode = "" +
				"precision mediump float;" +
				"uniform vec4 vColor;" +
				"void main() {" +
				"	gl_FragColor = vColor;" +
				"}";
	}
	
	public static int loadShader(int type, String shaderCode) {
		int shader = GLES20.glCreateShader(type);
		
		GLES20.glShaderSource(shader, shaderCode);
		GLES20.glCompileShader(shader);
		
		return shader;
	}
	
	public int buildShader() {
		program = GLES20.glCreateProgram();
		GLES20.glAttachShader(program, vertexShader);
		GLES20.glAttachShader(program, fragmentShader);
		GLES20.glLinkProgram(program);
		
		return 0;
	}
}
