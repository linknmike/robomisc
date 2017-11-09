package org.usfirst.frc.team1983.robot.subsystems;

import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1983.robot.commands.misc.RunCompressor;
import org.usfirst.frc.team1983.robot.sensors.Gyro;
import org.usfirst.frc.team1983.robot.settings.RobotMap;

public class Drivebase extends Subsystem {
    private Motor m_left1, m_left2, m_left3;
    private Motor m_right1, m_right2, m_right3;
    private Gyro m_gyro;

    public Drivebase() {
        m_left1 = new Motor(RobotMap.DRIVEBASE_LEFT1_PORT, false);
        m_left2 = new Motor(RobotMap.DRIVEBASE_LEFT2_PORT, false);
        m_left3 = new Motor(RobotMap.DRIVEBASE_LEFT3_PORT, false);

        m_right1 = new Motor(RobotMap.DRIVEBASE_RIGHT1_PORT, true);
        m_right2 = new Motor(RobotMap.DRIVEBASE_RIGHT2_PORT, true);
        m_right3 = new Motor(RobotMap.DRIVEBASE_RIGHT3_PORT, true);

        m_gyro = new Gyro();
    }

    public void initDefaultCommand() {
        setDefaultCommand(new RunCompressor());
    }

    public void setLeftThrottle(double throttle) {
        m_left1.set(throttle);
        m_left2.set(throttle);
        m_left3.set(throttle);
    }

    public void setRightThrottle(double throttle) {
        m_right1.set(throttle);
        m_right2.set(throttle);
        m_right3.set(throttle);
    }

    public void setThrottle(double leftThrottle, double rightThrottle) {
        setLeftThrottle(leftThrottle);
        setRightThrottle(rightThrottle);
    }

    public Gyro getGyro() {
        return m_gyro;
    }
}
