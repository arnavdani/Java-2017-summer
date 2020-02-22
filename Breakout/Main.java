import java.awt.Color;
import java.util.ArrayList;

import processing.core.PApplet;

public class Main extends PApplet {
	ArrayList<Rectangle> blocks;
	ArrayList<Ball> balls;
	Paddle paddle;
	public int lives = 3;
	boolean isGameOver;
	boolean isGameWon;
	float score = 0;
	int numberWide = 10;
	int numberLong = 1;
	int speedMod = 0;
	int wins = 0;
	

	public static void main(String[] args) {
		PApplet.main("Main");
	}

	public void settings() {
		size(400, 600);
	}

	public void setup() {
		winUpdate();
		isGameOver = false;
		isGameWon = false;
		score = 0;
		balls = new ArrayList<Ball>();
		balls.add(new Ball(this, width / 2, height / 2, 8, Color.CYAN, speedMod));

		paddle = new Paddle(this, width, 100, 20, Color.GREEN);
		blocks = new ArrayList<Rectangle>();
		for (int i = 0; i < numberWide; i++) {
			for (int j = 0; j < numberLong; j++) {
				blocks.add(new Rectangle(this, 20 + 40 * i, 100 + 15 * j, 40, 15, Color.RED, Color.BLACK));

			}

		}
		

	}

	public void draw() {
		rectMode(CORNER);
		fill(0, 30);
		rect(0, 0, width, height);
		fill(0, 255, 0);
		textSize(20);

		for (int i = 0; i < blocks.size(); i++) {
			Rectangle r = blocks.get(i);
			r.display();
			for (Ball b : balls)
				if (r.collide(b)) {
					b.flipY();
					blocks.remove(r);
					score = score + random(1, 2);

				}
		}
		for (Ball b : balls) {
			b.update();
			b.display();
		}
		paddle.update();
		paddle.display();
		for (Ball b : balls)
			if (paddle.collide(b)) {
				b.flipY();
			}
		for (int i = 0; i < balls.size(); i++) {
			Ball b = balls.get(i);
			if (b.y + b.size / 2 > height) {
				isGameOver = true;
			}
		}
		
		if (blocks.isEmpty() || score > 150) {
			isGameWon = true;
		}
		text(score, width / 2, 21);
		text("Wins: " + wins +"", width/2 + 100, 21);
		gameOver();
		win();
	}

	public void gameOver() {
		if (isGameOver == true) {
			balls.clear();
			background(0);
			textSize(50);
			text("YOU LOSE..", width / 4 - 20, height / 4);
			textSize(25);
			text("Press any key to restart.", width / 8, height / 2);

		}

		if (keyPressed == true) {
			isGameOver = false;
			setup();
			

		}

	}

	public void winUpdate(){
		if (isGameWon) {
			wins++;
			isGameWon=false;
		}
		
		
	}
	public void win() {
		if (isGameWon) {
			blocks.clear();
			balls.clear();
			background(0);
			textSize(50);
			
				//speedMod++;
				
			text("YOU WIN!!!!", width / 4 - 50, height / 4);
			textSize(25);
			text("Press any key to play again!", width / 10 - 10, height / 2);
			
		}

		if (keyPressed) {
			setup();
			

		}
	}

}
