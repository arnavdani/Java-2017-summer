import processing.core.PApplet;

public class Car{
	PApplet parent;
	public float x;
	public float y;

	
	Car(PApplet p,float newX, float newY){
		this.x = newX;
		this.y = newY;
		parent = p;
		
	}
	
	public void move(){
	x+=1;
	if(x > parent.width)
		x = -30;
	}
	
	public void display(){
		parent.rectMode(parent.CENTER); 
		float a = parent.random(100,255);
		float b = parent.random(100,255);
		float d = parent.random(100,200);
		parent.fill(a,b,d);
		parent.rect(x,y,30,10);
	}
}


