package lst;

import robocode.*;
import java.awt.Color;

public class Tonic extends TeamRobot {
	boolean avancando;

	public void run() {
		setBodyColor(Color.blue);
		setGunColor(Color.red);
		setRadarColor(Color.blue);
		setBulletColor(Color.blue);
		setRadarColor(Color.blue);

		while (true) {
			avancando = true;
			turnRadarRight(360);
		}
	}

	// Ao escanear um robô
	public void onScannedRobot(ScannedRobotEvent e) {
		if (isTeammate(e.getName()) == false) {
			turnRight(e.getBearing());
			ahead(e.getDistance() - 200);
			fire(3);
			scan();
		} else {}
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
		if(isTeammate(e.getName()) == false) {
			turnRight(e.getBearing());
			fire(6);
			scan();
		} else {}
	}

	// Ao ser atingido por uma bala
	public void onHitByBullet(HitByBulletEvent e) {
		if(isTeammate(e.getName()) == false) {
			turnRight(e.getBearing());
			fire(3);
			scan();
		} else {}
	}

	// Ao bater na parede
	public void onHitWall(HitWallEvent e) {
		direcaoReversa();
	}
}