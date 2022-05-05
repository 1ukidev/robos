package lst;

import robocode.*;
import java.awt.Color;

public class Tonic extends AdvancedRobot {
	int sentido = 1;
	boolean avancando;

	public void run() {
		setBodyColor(Color.blue);
		setGunColor(Color.red);
		setRadarColor(Color.blue);
		setBulletColor(Color.blue);
		setRadarColor(Color.blue);

		while (true) {
			turnRadarRight(360);
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
		ahead(e.getDistance() - 250);
		fire(4);
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
		fire(4);
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
		fire(4);
	}

	// Ao bater na parede
	public void onHitWall(HitWallEvent e) {
		direcaoReversa();
	}
}