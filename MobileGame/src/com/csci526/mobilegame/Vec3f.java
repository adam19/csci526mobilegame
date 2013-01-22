package com.csci526.mobilegame;

public class Vec3f {

	public float x, y, z;
	
	public Vec3f() {
		x = 0.0f;
		y = 0.0f;
		z = 0.0f;
	}
	
	public Vec3f(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Vec3f(Vec3f v) {
		this.x = v.x;
		this.y = v.y;
		this.z = v.z;
	}
	
	public Vec3f add(Vec3f v) {
		return new Vec3f(this.x + v.x, this.y + v.y, this.z + v.z);
	}
	
	public Vec3f add(float s) {
		return new Vec3f(this.x + s, this.y + s, this.z + s);		
	}
	
	public Vec3f sub(Vec3f v) {
		return new Vec3f(this.x - v.x, this.y - v.y, this.z - v.z);		
	}
	
	public Vec3f sub(float s) {
		return new Vec3f(this.x - s, this.y - s, this.z - s);		
	}
	
	public Vec3f mul(Vec3f v) {
		return new Vec3f(this.x * v.x, this.y * v.y, this.z * v.z);		
	}
	
	public Vec3f mul(float s) {
		return new Vec3f(this.x * s, this.y * s, this.z * s);		
	}
	
	public Vec3f div(Vec3f v) {
		if (v.x == 0.0f || v.y == 0.0f || v.z == 0.0f)
			return new Vec3f();
		return new Vec3f(this.x / v.x, this.y / v.y, this.z / v.z);		
	}
	
	public Vec3f div(float s) {
		if (s == 0.0f)
			return new Vec3f();
		return new Vec3f(this.x / s, this.y / s, this.z / s);		
	}

}
