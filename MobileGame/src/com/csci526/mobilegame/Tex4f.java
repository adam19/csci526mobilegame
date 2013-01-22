package com.csci526.mobilegame;

public class Tex4f {

	public float s, t, r, q;
	
	public Tex4f() {
		s = 0.0f;
		t = 0.0f;
		r = 0.0f;
		q = 0.0f;
	}
	
	public Tex4f(float s, float t, float r, float q) {
		this.s = s;
		this.t = t;
		this.r = r;
		this.q = q;
	}
	
	public Tex4f(Tex4f v) {
		this.s = v.s;
		this.t = v.t;
		this.r = v.r;
		this.q = v.q;
	}
	
	public Tex4f add(Tex4f v) {
		return new Tex4f(this.s + v.s, this.t + v.t, this.r + v.r, this.q + v.q);
	}
	
	public Tex4f add(float s) {
		return new Tex4f(this.s + s, this.t + s, this.r + s, this.q + s);
	}
	
	public Tex4f sub(Tex4f v) {
		return new Tex4f(this.s - v.s, this.t - v.t, this.r - v.r, this.q - v.q);
	}
	
	public Tex4f sub(float s) {
		return new Tex4f(this.s - s, this.t - s, this.r - s, this.q - s);		
	}
	
	public Tex4f mul(Tex4f v) {
		return new Tex4f(this.s * v.s, this.t * v.t, this.r * v.r, this.q * v.q);
	}
	
	public Tex4f mul(float s) {
		return new Tex4f(this.s * s, this.t * s, this.r * s, this.q * s);
	}
	
	public Tex4f div(Tex4f v) {
		if (v.s == 0.0f || v.t == 0.0f || v.r == 0.0f || v.q == 0.0f)
			return new Tex4f();
		return new Tex4f(this.s / v.s, this.t / v.t, this.r / v.r, this.q / v.q);	
	}
	
	public Tex4f div(float s) {
		if (s == 0.0f)
			return new Tex4f();
		return new Tex4f(this.s / s, this.t / s, this.r / s, this.q / s);
	}

}
