package com.coffeepoweredcrew.objectpool;

public class Point2D {

	private float x, y;
	
	public Point2D(float x, float y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point2D [x=" + x + ", y=" + y + "]";
	}
	
}
