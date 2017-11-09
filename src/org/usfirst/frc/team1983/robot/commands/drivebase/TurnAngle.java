package org.usfirst.frc.team1983.robot.commands.drivebase;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1983.robot.Robot;

public class TurnAngle extends Command implements PIDOutput {
    double ANGLE_TOLERANCE = 1; //If we are within ANGLE_TOLERANCE degrees, we're good to go.
    double startAngle;
    double endAngle;
    boolean offset; //If true, then startAngle = angle + getAngle(), else = angle
    PIDController controller;

    boolean disabled = true;

    public TurnAngle(boolean offset, double angle) {
        requires(Robot.m_drivebase);
        this.offset = offset;
        this.endAngle = angle;
    }

    protected void initialize() {
        endAngle = (offset) ? Robot.m_drivebase.getGyro().getAngle() + endAngle : endAngle;

        double p = 1; //TO BE TUNED
        double i = 0; //
        double d = 0; //
        double f = 0; //
        controller = new PIDController(p, i, d, f, Robot.m_drivebase.getGyro(), this);
        controller.setOutputRange(-1, 1);

        controller.setSetpoint(endAngle);

        disabled = false;
    }

    protected void execute() {

    }

    protected boolean isFinished() {
        return (Robot.m_drivebase.getGyro().getAngle() - endAngle) < ANGLE_TOLERANCE;
    }

    protected void interrupted() {
        end();
    }

    protected void end() {

    }

    public void pidWrite(double output) {
        if(!disabled) {
            Robot.m_drivebase.setLeftThrottle(output);   //Signs are guessed until I can test
            Robot.m_drivebase.setRightThrottle(-output);
        }
    }
}
