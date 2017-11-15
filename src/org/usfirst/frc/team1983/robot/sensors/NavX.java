package org.usfirst.frc.team1983.robot.sensors;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.SerialPort;
import org.usfirst.frc.team1983.util.Vector3;

public class NavX implements PIDSource {
    private AHRS m_ahrs;

    public NavX() {
        m_ahrs = new AHRS(SerialPort.Port.kMXP);
        m_ahrs.reset();
    }

    public void setPIDSourceType(PIDSourceType sourceType) {
        m_ahrs.setPIDSourceType(sourceType);
    }

    public PIDSourceType getPIDSourceType() {
        return m_ahrs.getPIDSourceType();
    }

    public double pidGet() {
        return getRotation().y;
    }

    public Vector3 getVelocity() {
        return new Vector3(m_ahrs.getVelocityX(), m_ahrs.getVelocityY(), m_ahrs.getVelocityZ());
    }

    public Vector3 getAcceleration() {
        return new Vector3(m_ahrs.getRawAccelX(), m_ahrs.getRawAccelY(), m_ahrs.getRawAccelZ());
    }

    public Vector3 getRotation() {
        return new Vector3(m_ahrs.getPitch(), m_ahrs.getYaw(), m_ahrs.getRoll());
    }
}