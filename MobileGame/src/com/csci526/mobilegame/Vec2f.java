package com.csci526.mobilegame;

public class Vec2f {

	public float x, y;
	
	public Vec2f() {
		x = 0.0f;
		y = 0.0f;
	}
	
	public Vec2f(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public Vec2f(Vec2f v) {
		this.x = v.x;
		this.y = v.y;
	}
	
	public Vec2f add(Vec2f v) {
		return new Vec2f(this.x + v.x, this.y + v.y);
	}
	
	public Vec2f add(float s) {
		return new Vec2f(this.x + s, this.y + s);		
	}
	
	public Vec2f sub(Vec2f v) {
		return new Vec2f(this.x - v.x, this.y - v.y);		
	}
	
	public Vec2f sub(float s) {
		return new Vec2f(this.x - s, this.y - s);		
	}
	
	public Vec2f mul(Vec2f v) {
		return new Vec2f(this.x * v.x, this.y * v.y);		
	}
	
	public Vec2f mul(float s) {
		return new Vec2f(this.x * s, this.y * s);		
	}
	
	public Vec2f div(Vec2f v) {
		if (v.x == 0.0f || v.y == 0.0f)
			return new Vec2f();
		return new Vec2f(this.x / v.x, this.y / v.y);		
	}
	
	public Vec2f div(float s) {
		if (s == 0.0f)
			return new Vec2f();
		return new Vec2f(this.x / s, this.y / s);		
	}

}
