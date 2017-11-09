package org.usfirst.frc.team1983.robot.sensors;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.SerialPort;

public class Gyro implements PIDSource {
    AHRS gyro;
    Boolean dead = false;
    public void initGyro() {
        gyro = new AHRS(SerialPort.Port.kMXP);

        int counter = 0;

        while(!gyro.isConnected()) {
            counter++;
            if(counter > 500) {
                dead = true;
                break;
            }

            System.out.println("Is it dead: " + dead);
            System.out.println("Is it connected: " + gyro.isConnected());
        }
    }

    public void setPIDSourceType(PIDSourceType pidSource) {
        return; //No, please don't set my PIDSourceType
    }

    public PIDSourceType getPIDSourceType() {
        return PIDSourceType.kDisplacement;
    }

    public double pidGet() {
        return gyro.getAngle();
    }

    public double getAngle() {
        return gyro.getAngle();
    }
}
