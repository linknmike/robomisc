package org.usfirst.frc.team1983.robot.commands.drivebase;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team1983.robot.settings.Constants;
import org.usfirst.frc.team1983.robot.Robot;

public class RunTankDrive extends Command {
    public RunTankDrive() {
        requires(Robot.m_drivebase);
    }

    protected void initialize() {
        
    }

    protected void execute() {
        double leftThrottle = Robot.m_oi.getAxis(Constants.OIJoystick.Left, Joystick.AxisType.kY.value);
        double rightThrottle = Robot.m_oi.getAxis(Constants.OIJoystick.Right, Joystick.AxisType.kY.value);

        Robot.m_drivebase.setThrottle(leftThrottle, rightThrottle);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void interrupted() {
        end();
    }

    protected void end() {

    }
}
