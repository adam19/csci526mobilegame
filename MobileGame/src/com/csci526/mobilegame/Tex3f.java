package com.csci526.mobilegame;

public class Tex3f {

	public float s, t, r;
	
	public Tex3f() {
		s = 0.0f;
		t = 0.0f;
		r = 0.0f;
	}
	
	public Tex3f(float s, float t, float r) {
		this.s = s;
		this.t = t;
		this.r = r;
	}
	
	public Tex3f(Tex3f v) {
		this.s = v.s;
		this.t = v.t;
		this.r = v.r;
	}
	
	public Tex3f add(Tex3f v) {
		return new Tex3f(this.s + v.s, this.t + v.t, this.r + v.r);
	}
	
	public Tex3f add(float s) {
		return new Tex3f(this.s + s, this.t + s, this.r + s);
	}
	
	public Tex3f sub(Tex3f v) {
		return new Tex3f(this.s - v.s, this.t - v.t, this.r - v.r);
	}
	
	public Tex3f sub(float s) {
		return new Tex3f(this.s - s, this.t - s, this.r - s);		
	}
	
	public Tex3f mul(Tex3f v) {
		return new Tex3f(this.s * v.s, this.t * v.t, this.r * v.r);
	}
	
	public Tex3f mul(float s) {
		return new Tex3f(this.s * s, this.t * s, this.r * s);
	}
	
	public Tex3f div(Tex3f v) {
		if (v.s == 0.0f || v.t == 0.0f || v.r == 0.0f)
			return new Tex3f();
		return new Tex3f(this.s / v.s, this.t / v.t, this.r / v.r);	
	}
	
	public Tex3f div(float s) {
		if (s == 0.0f)
			return new Tex3f();
		return new Tex3f(this.s / s, this.t / s, this.r / s);
	}

}
