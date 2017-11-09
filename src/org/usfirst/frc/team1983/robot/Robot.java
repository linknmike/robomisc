package org.usfirst.frc.team1983.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Scheduler;

import org.usfirst.frc.team1983.robot.services.OI;
import org.usfirst.frc.team1983.robot.settings.Constants;

import org.usfirst.frc.team1983.robot.subsystems.Drivebase;
import edu.wpi.first.wpilibj.Compressor;

import org.usfirst.frc.team1983.robot.commands.RunTankDrive;

public class Robot extends IterativeRobot {
    public static OI m_oi;
    public static Drivebase m_drivebase;
    public static Compressor m_compressor;

    @Override
    public void robotInit() {
        m_oi = new OI(Constants.OIInputType.DoubleJoy);
        m_drivebase = new Drivebase();
        m_compressor = new Compressor(1);
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

        m_oi.update();
    }
}
