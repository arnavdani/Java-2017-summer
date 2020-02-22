import java.util.ArrayList;
import processing.core.PApplet;

public class Main extends PApplet {
	ArrayList<Hat> hats;
	ArrayList<Balloon> balloons;
	ArrayList<Letterloon> letterloons;
	ArrayList<Cake> cakes;
	ArrayList<Confetti> confetti;
	static int textCnt = 0;
	float x, y;

	public static void main(String[] args) {
		PApplet.main("Main");

	}

	public void settings() {
		size(1500, 900);

	}

	public void setup() {
		hats = new ArrayList<Hat>();
		for (int i = 0; i < 8; i++) {
			hats.add(new Hat(this, random(width), random(height)));
		}
		balloons = new ArrayList<Balloon>();
		for (int j = 0; j < 8; j++) {
			
			balloons.add(new Balloon(this, random(width), random(height)));
		}
		letterloons = new ArrayList<Letterloon>();
		for (int z = 0; z < 1; z++) {
			
			letterloons.add(new Letterloon(this, random(width), random(height)));
		}
		cakes = new ArrayList<Cake>();
		for (int q = 0; q < 2; q++) {
			
			cakes.add(new Cake(this, random(width), random(height)));
		}
		confetti = new ArrayList<Confetti>();
		for(int u = 0; u < 2; u++){
			confetti.add(new Confetti(this, random(width), random(height)));
		}
	}

	public void draw() {
		fadeBackground();
		drawHats();
		moveHats();
		drawBalloons();
		moveBalloons();
		drawLetterloons();
		moveLetterloons();
		drawCakes();
		moveCakes();
		//drawConfetti();
		//moveConfetti();
		text();

	}

	public void fadeBackground() {
		rectMode(CORNER);
		fill(0, 50);
		rect(0, 0, width, height);
	}

	public void drawHats() {
		for (Hat h : hats) {
			h.draw();
		}
	}

	public void moveHats() {
		for (Hat h : hats) {
			h.move();
		}
	}

	public void drawBalloons() {
		for (Balloon b : balloons) {
			b.draw();
		}
	}

	public void moveBalloons() {
		for (Balloon b : balloons) {
			b.move();
		}
	}

	public void drawLetterloons() {
		for (Letterloon l : letterloons) {
			l.draw();
		}
	}

	public void moveLetterloons() {
		for (Letterloon l : letterloons) {
			l.move();
		}
	}

	public void drawCakes() {
		for (Cake c : cakes) {
			c.draw();
		}
	}

	public void moveCakes() {
		for (Cake c : cakes) {
			c.move();
		}
	}
	public void drawConfetti(){
		for(Confetti w : confetti){
			w.draw();
		}
	}
	public void moveConfetti(){
		for(Confetti w : confetti){
			w.move();
		}
	}
	public void text(){
		textSize(100);
		//if (textCnt > 5 ) {
		
			//textCnt = 0;
		//} else {
		//	textCnt++;
		//}
		
			fill(mouseX, mouseY, mouseX - mouseY);
	
		textMode(CENTER);
		text("Happy Birthday", mouseX, mouseY);
		text("Mama!!!", mouseX + 200, mouseY + 110);
		
	}
}
