package lst;

import robocode.*;
import java.awt.Color;

public class RoboDois extends AdvancedRobot {
	int sentido = 1;
	boolean avancando;

	public void run() {
		setBodyColor(Color.blue);
		setGunColor(Color.red);
		setRadarColor(Color.blue);
		setBulletColor(Color.blue);
		setRadarColor(Color.blue);

		while (true) {
			turnRight(5 * sentido);
			setAhead(40000);
			avancando = true;
			setTurnRight(90);
			waitFor(new TurnCompleteCondition(this));
			setTurnLeft(180);
			waitFor(new TurnCompleteCondition(this));
			setTurnRight(180);
			waitFor(new TurnCompleteCondition(this));
		}
	}

	// Ao escanear um robô
	public void onScannedRobot(ScannedRobotEvent e) {
		if (e.getBearing() >= 0) {
			sentido = 1;
		} else {
			sentido = -1;
		}

		turnRight(e.getBearing());
		ahead(e.getDistance() - 100);
		fire(2);
		scan();
	}

	// Função para fazer o robô ir pra direção oposta
	public void direcaoReversa() {
		if (avancando) {
			setBack(40000);
			avancando = false;
		} else {
			setAhead(40000);
			avancando = true;
		}
	}

	// Ao atingir um robô
	public void onHitRobot(HitRobotEvent e) {
		if (e.getBearing() >= 0) {
			sentido = 1;
		} else {
			sentido = -1;
		}

		turnRight(e.getBearing());
		fire(3);
		scan();
	}

	// Ao ser atingido por uma bala
	public void onHitByBullet(HitByBulletEvent e) {
		if (e.getBearing() >= 0) {
			sentido = 1;
		} else {
			sentido = -1;
		}

		turnRight(e.getBearing());
		fire(2);
	}

	// Ao bater na parede
	public void onHitWall(HitWallEvent e) {
		direcaoReversa();
	}
}