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
        double leftThrottle = 0, rightThrottle = 0;

        switch(Robot.m_oi.m_type) {
            case Constants.OIInputType.DoubleJoy:
                leftThrottle = Robot.m_oi.getAxis(Constants.OIJoystick.Left, Joystick.AxisType.kY.value);
                rightThrottle = Robot.m_oi.getAxis(Constants.OIJoystick.Right, Joystick.AxisType.kY.value);

                if(Robot.m_oi.isPressed(0, 1)) {
                    Robot.m_drivebase.switchDroppedState();
                }
                else if(Robot.m_oi.isReleased(0, 1)) {
                    Robot.m_drivebase.switchDroppedState();
                }
                if(Robot.m_oi.isPressed(1, 1))
                    Robot.m_drivebase.switchShiftedState();

                break;
            case Constants.OIInputType.Wheel:
                break;
        }

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
