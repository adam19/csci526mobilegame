package com.csci526.mobilegame;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import android.opengl.GLES20;

public class Triangle {

	private FloatBuffer vertexBuffer;
	static final int COORDS_PER_VERTEX = 3;
	private int numVerts = 3;
	
	private Shader shader;
	
	static float coords[] = {
		0.0f, 1.0f, 0.0f,
		-1.0f, -1.0f, 0.0f,
		1.0f, -1.0f, 0.0f
	};
	
	static float color[] = {
		0.0f, 1.0f, 0.0f, 1.0f
	};
	
	public Triangle() {
		ByteBuffer bb = ByteBuffer.allocateDirect(coords.length * 4);
		bb.order(ByteOrder.nativeOrder());
		
		vertexBuffer = bb.asFloatBuffer();
		vertexBuffer.put(coords);
		vertexBuffer.position(0);
		
		shader = new Shader();
		shader.vertexShader = Shader.loadShader(GLES20.GL_VERTEX_SHADER, shader.vertexShaderCode);
		shader.fragmentShader = Shader.loadShader(GLES20.GL_FRAGMENT_SHADER, shader.fragmentShaderCode);
		shader.buildShader();
	}
	
	public void draw(float mvpMatrix[]) {
		GLES20.glUseProgram(shader.program);
		
		int positionHandle = GLES20.glGetAttribLocation(shader.program, "vPos");		
		GLES20.glEnableVertexAttribArray(positionHandle);
		GLES20.glVertexAttribPointer(positionHandle, COORDS_PER_VERTEX, GLES20.GL_FLOAT, false, 0, vertexBuffer);
		
		int mvpMatrixHandle = GLES20.glGetUniformLocation(shader.program, "mvpMatrix");
		GLES20.glUniformMatrix4fv(mvpMatrixHandle, 1, false, mvpMatrix, 0);
		
		int colorHandle = GLES20.glGetUniformLocation(shader.program, "vColor");
		GLES20.glUniform4fv(colorHandle, 1, color, 0);
		
		GLES20.glDrawArrays(GLES20.GL_TRIANGLES, 0, numVerts);
		GLES20.glDisableVertexAttribArray(positionHandle);
	}

}
