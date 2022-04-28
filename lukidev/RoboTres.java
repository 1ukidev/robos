package tnq;
import robocode.*;
import java.awt.*;

public class RoboTres extends AdvancedRobot
{
	int direcao = 1;

	public void run() {
		setBodyColor(Color.green);
		setGunColor(Color.green);
		setRadarColor(Color.green);
		setBulletColor(Color.blue);

		while(true) {
			turnRight(5 * direcao);
			setAhead(40000);
			setTurnRight(90);
			waitFor(new TurnCompleteCondition(this));
			setTurnLeft(180);
			waitFor(new TurnCompleteCondition(this));
			setTurnRight(180);
			waitFor(new TurnCompleteCondition(this));			
		}
	}
	
	public void onScannedRobot(ScannedRobotEvent e) {
		if(e.getBearing() >= 0) {
			direcao = 1;
		} else {
			direcao = -1;
		}
		
		turnRight(e.getBearing());
		ahead(e.getDistance());
		scan();
	}
	
	public void onHitRobot(HitRobotEvent e) {
		if(e.getBearing() >= 0) {
			direcao = 1;
		} else {
			direcao = -1;
		}
		turnRight(e.getBearing());
		fire(3);

		ahead(40);
	}

	public void onHitByBullet(HitByBulletEvent e) {
		setAhead(40000);
		waitFor(new TurnCompleteCondition(this));
		setTurnRight(90);
		waitFor(new TurnCompleteCondition(this));
	}

	public void onHitWall(HitWallEvent e) {
		setAhead(40000);
		waitFor(new TurnCompleteCondition(this));
		setTurnRight(90);
		waitFor(new TurnCompleteCondition(this));
	}	
}
