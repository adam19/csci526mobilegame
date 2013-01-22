package com.csci526.mobilegame;

public class Vec4f {

	public float x, y, z, w;
	
	public Vec4f() {
		x = 0.0f;
		y = 0.0f;
		z = 0.0f;
		w = 0.0f;
	}
	
	public Vec4f(float x, float y, float z, float w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}
	
	public Vec4f(Vec4f v) {
		this.x = v.x;
		this.y = v.y;
		this.z = v.z;
		this.w = v.w;
	}
	
	public Vec4f add(Vec4f v) {
		return new Vec4f(this.x + v.x, this.y + v.y, this.z + v.z, this.w + v.w);
	}
	
	public Vec4f add(float s) {
		return new Vec4f(this.x + s, this.y + s, this.z + s, this.w + s);
	}
	
	public Vec4f sub(Vec4f v) {
		return new Vec4f(this.x - v.x, this.y - v.y, this.z - v.z, this.w - v.w);
	}
	
	public Vec4f sub(float s) {
		return new Vec4f(this.x - s, this.y - s, this.z - s, this.w - s);		
	}
	
	public Vec4f mul(Vec4f v) {
		return new Vec4f(this.x * v.x, this.y * v.y, this.z * v.z, this.w * v.w);
	}
	
	public Vec4f mul(float s) {
		return new Vec4f(this.x * s, this.y * s, this.z * s, this.w * s);
	}
	
	public Vec4f div(Vec4f v) {
		if (v.x == 0.0f || v.y == 0.0f || v.z == 0.0f || v.w == 0.0f)
			return new Vec4f();
		return new Vec4f(this.x / v.x, this.y / v.y, this.z / v.z, this.w / v.w);	
	}
	
	public Vec4f div(float s) {
		if (s == 0.0f)
			return new Vec4f();
		return new Vec4f(this.x / s, this.y / s, this.z / s, this.w / s);
	}

}
