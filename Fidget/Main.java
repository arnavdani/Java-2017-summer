import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import processing.core.PApplet;

public class Main extends PApplet {
	ArrayList<Enemy> enemies;
	ArrayList<Dot> dots;
	ArrayList<Virus> viruses;
	public static Random rand;
	float dotSpawnRate = 1;
	int maxDots = 1000;
	Player player;

	public static void main(String[] args) {
		PApplet.main("Main");
		rand = new Random();
	}

	public void settings() {
		size(1900, 950);

	}

	public void setup() {
		enemies = new ArrayList<Enemy>();
		dots = new ArrayList<Dot>();
		viruses = new ArrayList<Virus>();
		for (int i = 0; i < 18; i++) {
			viruses.add(new Virus(this, random(width), random(height), 60, Color.GREEN));
		}

		frameRate(60);
		background(0, 0, 0);
		player = new Player(this);
		for (int i = 0; i < 3; i++) {

			enemies.add(new Enemy(this));
		}
	}

	public void draw() {
		fadeBackground();
		spawnDots();
		drawDots();
		player.move();
		player.draw();
		checkForEatingDots();
		score();
		drawViruses();
		checkForHittingVirus();
		moveEnemies();
		checkForEnemiesEating();
		checkForEnemiesHittingPlayer();
		drawEnemies();
		checkIfGameOver();

	}

	public void fadeBackground() {
		rectMode(CORNER);
		fill(0, 50);
		rect(0, 0, width, height);
	}

	public void spawnDots() {
		if (dots.size() < maxDots && frameCount % dotSpawnRate == 0) {
			dots.add(new Dot(this, random(0, width), random(0, height), 15, .1f,
					new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat())));

		}

	}

	public void drawDots() {

		for (Dot d : dots) {

			d.draw();
		}
	}

	public void checkForEatingDots() {
		for (int i = 0; i < dots.size(); i++) {

			if (Math.sqrt(Math.pow((dots.get(i).x - player.x), 2)
					+ Math.pow(dots.get(i).y - player.y, 2)) < dots.get(i).size / 2 + 25) {
				player.speedUp(2 * dots.get(i).value);
				dots.remove(i);
			}
		}

	}

	public void score() {

		fill(0, 255, 0);
		textSize(30);
		text("Score: " + (int) player.speed + "", 100, 868);
	}

	public void drawViruses() {

		for (Virus v : viruses) {
			v.draw();
		}
	}

	public void checkForHittingVirus() {
		for (int i = 0; i < viruses.size(); i++) {

			if (Math.sqrt(Math.pow((viruses.get(i).x - player.x), 2)
					+ Math.pow(viruses.get(i).y - player.y, 2)) < viruses.get(i).size / 2 + 25) {
				if (player.speed > 1f) {
					player.speedDown(25);
					viruses.remove(viruses.get(i));
					viruses.add(new Virus(this, random(width), random(height), 80, Color.GREEN));
				}
			}
		}

	}

	public void moveEnemies() {
		for (Enemy e : enemies) {
			e.move();
		}

	}

	public void drawEnemies() {
		for (Enemy e : enemies) {
			e.draw();
		}
	}

	public void checkForEnemiesEating() {
		if (enemies.size() > 0 && dots.size() > 0)
			for (int e = 0; e < enemies.size(); e++)
				for (int i = 0; i < dots.size(); i++) {
					if (Math.sqrt(Math.pow((dots.get(i).x - enemies.get(e).x), 2)
							+ Math.pow(dots.get(i).y - enemies.get(e).y, 2)) < 50) {
						enemies.get(e).speedUp(2 * dots.get(i).value);
						dots.remove(i);
						return;
					}
				}

	}

	public void checkForEnemiesHittingPlayer() {
		for (Enemy e : enemies) {
			if (Math.sqrt(Math.pow((e.x - player.x), 2) + Math.pow((e.y - player.y), 2)) < 50) {
				if (player.speed > e.speed) {
					e.speedDown(.5f);
				} else {
					player.speedDown(.5f);

				}

			}

		}

	}

	public void checkIfEnemyHitVirus() {
		for (int i = 0; i < viruses.size(); i++) {

			for (Enemy e : enemies) {
				if (Math.sqrt(Math.pow((e.x - viruses.get(i).x), 2) + Math.pow((e.y - viruses.get(i).y), 2)) < 50) {
					e.speedDown(2);
					viruses.remove(i);
					viruses.add(new Virus(this, random(width), random(height), 25, Color.green));
				}
			}
		}

	}
	
	public void checkIfGameOver(){
		if (player.speed <= 0){
			dots.clear();
			viruses.clear();
			enemies.clear();
			background(0);
			fill(255,0,0);
			textSize(70);		
			text("HAHA YOU LOSE. RESTART GAME TO PLAY AGAIN",950, 450 );
			textMode(CORNER);
			textSize(50);
			}
			
			
		}
	public void checkWin(){
		if (player.speed > 2000){
			dots.clear();
			viruses.clear();
			enemies.clear();
			background(0);
			fill(255,0,0);
			textSize(70);		
			text("YAY YOU WON!! RESTART GAME TO PLAY AGAIN",950, 450 );
			textMode(CORNER);
			textSize(50);
			}
		
	}
	
	}

