package com.csci526.mobilegame;

public class Color {
	public float r, g, b, a;
	
	public Color() {
		r = g = b = a = 1.0f;
	}
	
	public Color(float r, float g, float b, float a) {
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = a;
	}
	
	public Color(short r, short g, short b, short a) {
		this.r = (float)r / 255.0f;
		this.g = (float)g / 255.0f;
		this.b = (float)b / 255.0f;
		this.a = (float)a / 255.0f;
	}
	
	public void add(Color r, Color c1, Color c2) {
		r.r = Math.max(c1.r + c2.r, 1.0f);
		r.g = Math.max(c1.g + c2.g, 1.0f);
		r.b = Math.max(c1.b + c2.b, 1.0f);
		r.a = Math.max(c1.a + c2.a, 1.0f);
	}
	
	public void sub(Color r, Color c1, Color c2) {
		r.r = Math.min(c1.r - c2.r, 0.0f);
		r.g = Math.min(c1.g - c2.g, 0.0f);
		r.b = Math.min(c1.b - c2.b, 0.0f);
		r.a = Math.min(c1.a - c2.a, 0.0f);
	}
	
	public void mul(Color r, Color c1, Color c2) {
		r.r = c1.r * c2.r;
		r.g = c1.g * c2.g;
		r.b = c1.b * c2.b;
		r.a = c1.a * c2.a;
	}
	
	public void mul(Color r, float s) {
		r.r *= s;
		r.g *= s;
		r.b *= s;
		r.a *= s;
	}
	
	public void div(Color r, float s) {
		if (s <= 0.0f)
			return;
		
		r.r /= s;
		r.g /= s;
		r.b /= s;
		r.a /= s;
	}
	
	/** 
	 * Not fully tested yet
	 */
	public void lerp(Color r, Color c1, Color c2, float t) {
		r.r = ((c2.r - c1.r) * t) + c1.r;
		r.g = ((c2.g - c1.g) * t) + c1.g;
		r.b = ((c2.b - c1.b) * t) + c1.b;
		r.a = ((c2.a - c1.a) * t) + c1.a;
	}
	
	public static final Color WHITE = new Color(1.0f, 1.0f, 1.0f, 1.0f);
	public static final Color BLACK = new Color(1.0f, 1.0f, 1.0f, 1.0f);
	public static final Color RED = new Color(1.0f, 0.0f, 0.0f, 1.0f);
	public static final Color GREEN = new Color(0.0f, 1.0f, 0.0f, 1.0f);
	public static final Color BLUE = new Color(0.0f, 0.0f, 1.0f, 1.0f);
	public static final Color YELLOW = new Color(1.0f, 1.0f, 0.0f, 1.0f);
	public static final Color MAGENTA = new Color(1.0f, 0.0f, 1.0f, 1.0f);
	public static final Color CYAN = new Color(0.0f, 1.0f, 1.0f, 1.0f);
}
