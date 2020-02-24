import java.util.ArrayList;

import processing.core.PApplet;

public class CarStart extends PApplet {
	ArrayList<Car> myCars;
	Ring myRing;
	public static void main(String[] args) {

		PApplet.main("CarStart");

	}

	public void settings() {
		size(1000, 900);
	}

	public void setup(){
		background(255);
		myCars = new ArrayList<Car>();
		
		myRing = new Ring(this, width/2, height/2);
	}

	public void draw() {
		float a = random(100,255);
		float b = random(100,255);
		float d = random(100,200);
		
		myCars.add(new Car(this, random(width),random(height)));
		for (Car c : myCars){ fill(a,b,d,255);
		stroke(a,b,d);c.move();
		c.display();
		}		myRing.grow();
		myRing.display();
		noStroke();
		fill(0,0,0,10);
		rectMode(CORNER);
		rect(0,0,width,height);

	}

}
