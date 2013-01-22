package com.csci526.mobilegame;

public class Tex2f {

	public float s, t;
	
	public Tex2f() {
		s = 0.0f;
		t = 0.0f;
	}
	
	public Tex2f(float s, float t) {
		this.s = s;
		this.t = t;
	}
	
	public Tex2f(Tex2f v) {
		this.s = v.s;
		this.t = v.t;
	}
	
	public Tex2f add(Tex2f v) {
		return new Tex2f(this.s + v.s, this.t + v.t);
	}
	
	public Tex2f add(float s) {
		return new Tex2f(this.s + s, this.t + s);
	}
	
	public Tex2f sub(Tex2f v) {
		return new Tex2f(this.s - v.s, this.t - v.t);
	}
	
	public Tex2f sub(float s) {
		return new Tex2f(this.s - s, this.t - s);		
	}
	
	public Tex2f mul(Tex2f v) {
		return new Tex2f(this.s * v.s, this.t * v.t);
	}
	
	public Tex2f mul(float s) {
		return new Tex2f(this.s * s, this.t * s);
	}
	
	public Tex2f div(Tex2f v) {
		if (v.s == 0.0f || v.t == 0.0f)
			return new Tex2f();
		return new Tex2f(this.s / v.s, this.t / v.t);	
	}
	
	public Tex2f div(float s) {
		if (s == 0.0f)
			return new Tex2f();
		return new Tex2f(this.s / s, this.t / s);
	}

}
