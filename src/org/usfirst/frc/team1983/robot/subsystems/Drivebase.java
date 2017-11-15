package org.usfirst.frc.team1983.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1983.robot.commands.misc.RunCompressor;
import org.usfirst.frc.team1983.robot.sensors.Gyro;
import org.usfirst.frc.team1983.robot.settings.RobotMap;

import java.util.ArrayList;
import java.util.Arrays;

public class Drivebase extends Subsystem {
    private Gyro m_gyro;
    private MotorGroup m_leftDrive, m_rightDrive;
    private Encoder m_leftEncoder, m_rightEncoder;
    private DoubleSolenoid m_drop1, m_drop2;
    private DoubleSolenoid m_shifter;

    public Drivebase() {
        m_leftDrive = new MotorGroup(new ArrayList<>(Arrays.asList(
                new Motor(RobotMap.DRIVEBASE_LEFT1_PORT, false),
                new Motor(RobotMap.DRIVEBASE_LEFT2_PORT, false),
                new Motor(RobotMap.DRIVEBASE_LEFT3_PORT, false)
        )));

        m_rightDrive = new MotorGroup(new ArrayList<>(Arrays.asList(
                new Motor(RobotMap.DRIVEBASE_RIGHT1_PORT, true),
                new Motor(RobotMap.DRIVEBASE_RIGHT2_PORT, true),
                new Motor(RobotMap.DRIVEBASE_RIGHT3_PORT, true)
        )));

        m_drop1 = new DoubleSolenoid(RobotMap.PCM_ID, RobotMap.DRIVEBASE_DROP_FORWARD1_PORT,
                RobotMap.DRIVEBASE_DROP_REVERSE1_PORT);

        m_drop2 = new DoubleSolenoid(RobotMap.PCM_ID, RobotMap.DRIVEBASE_DROP_FORWARD2_PORT,
                RobotMap.DRIVEBASE_DROP_REVERSE2_PORT);

        m_shifter = new DoubleSolenoid(RobotMap.PCM_ID, RobotMap.DRIVEBASE_SHIFTER_FORWARD_PORT,
                RobotMap.DRIVEBASE_SHIFTER_REVERSE_PORT);

        m_gyro = new Gyro();
    }

    public void initDefaultCommand() {
        setDefaultCommand(new RunCompressor());
    }

    public void shiftToState(boolean high) {
        m_shifter.set(high ? DoubleSolenoid.Value.kForward : DoubleSolenoid.Value.kReverse);
    }

    public void setDroppedState(boolean dropped) {
        m_drop1.set(dropped ? DoubleSolenoid.Value.kReverse : DoubleSolenoid.Value.kForward);
        m_drop2.set(dropped ? DoubleSolenoid.Value.kReverse : DoubleSolenoid.Value.kForward);
    }

    public void switchShiftedState() {
        shiftToState(m_shifter.get() != DoubleSolenoid.Value.kForward);
    }

    public void switchDroppedState() {
        m_drop1.set(m_drop1.get() == DoubleSolenoid.Value.kForward ? DoubleSolenoid.Value.kReverse : DoubleSolenoid.Value.kForward);
        m_drop2.set(m_drop2.get() == DoubleSolenoid.Value.kForward ? DoubleSolenoid.Value.kReverse : DoubleSolenoid.Value.kForward);
    }

    public void setLeftThrottle(double throttle) {
        m_leftDrive.set(throttle);
    }

    public void setRightThrottle(double throttle) {
        m_rightDrive.set(throttle);
    }

    public void setThrottle(double leftThrottle, double rightThrottle) {
        setLeftThrottle(leftThrottle);
        setRightThrottle(rightThrottle);
    }

    public Gyro getGyro() {
        return m_gyro;
    }
}
