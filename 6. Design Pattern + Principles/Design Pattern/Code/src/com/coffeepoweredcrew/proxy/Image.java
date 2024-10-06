package com.coffeepoweredcrew.proxy;


//Interface implemented by proxy and concrete objects
public interface Image {

	void setLocation(Point2D point2d);
	
	Point2D getLocation();
	
	void render();
	
}
