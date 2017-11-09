package org.usfirst.frc.team1983.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Scheduler;

import org.usfirst.frc.team1983.robot.services.OI;
import org.usfirst.frc.team1983.robot.settings.Constants;

import org.usfirst.frc.team1983.robot.subsystems.Drivebase;
import edu.wpi.first.wpilibj.Compressor;

import org.usfirst.frc.team1983.robot.commands.drivebase.RunTankDrive;

public class Robot extends IterativeRobot {
    public static OI m_oi;
    public static Drivebase m_drivebase;
    public static Compressor m_compressor;

    @Override
    public void robotInit() {
        m_oi = new OI();
        m_drivebase = new Drivebase();
        m_compressor = new Compressor(1);

        m_drivebase.getGyro().initGyro();
    }

    @Override
    public void autonomousInit() {
        Scheduler.getInstance().removeAll();
    }

    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {
        Scheduler.getInstance().removeAll();

        Scheduler.getInstance().add(new RunTankDrive());
    }

    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();

        System.out.println("left: " + m_oi.getAxis(Constants.OIJoystick.Left, Joystick.AxisType.kY.value));
        System.out.println("right: " + m_oi.getAxis(Constants.OIJoystick.Right, Joystick.AxisType.kY.value));
        System.out.println("gyro: " + m_drivebase.getGyro().getAngle());

        m_oi.update();
    }
}
