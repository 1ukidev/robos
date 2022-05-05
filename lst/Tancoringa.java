package lst;

import robocode.*;
import java.awt.Color;

public class Tancoringa extends AdvancedRobot {
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
		switch(e.getName()) {
			case "Tancoringa":
				break;
			case "Tonic":
				break;
			default:
				if (e.getBearing() >= 0) {
					sentido = 1;
				} else {
					sentido = -1;
				}

				turnRight(e.getBearing());
				ahead(e.getDistance() - 100);
				fire(2);
				scan();
				break;
			}
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
		fire(1);
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
		fire(1);
	}

	// Ao bater na parede
	public void onHitWall(HitWallEvent e) {
		direcaoReversa();
	}
}