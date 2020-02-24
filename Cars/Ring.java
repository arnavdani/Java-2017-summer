import processing.core.PApplet;

public class Ring {
	PApplet parent;
	float x;
	float y;
	float size;
	Ring(PApplet p, float x, float y){
	this.parent = p;
	this.x = x;
	this.y = y;
}
	
	public void grow(){
		size+=1;
		if(size > 1000)
			size = 0;
	}
	public void display(){
		parent.fill(234,76,65);
		parent.ellipse(x,y,size,size);
	}
	
}
