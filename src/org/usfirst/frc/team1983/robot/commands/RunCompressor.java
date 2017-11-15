package org.usfirst.frc.team1983.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1983.robot.Robot;

public class RunCompressor extends Command {
    public RunCompressor() {

    }

    protected void initialize() {

    }

    protected void execute() {
        if(Robot.m_compressor.getPressureSwitchValue())
            Robot.m_compressor.stop();
        else if(!Robot.m_compressor.enabled())
            Robot.m_compressor.start();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void interrupted() {
        end();
    }

    protected void end() {
        Robot.m_compressor.stop();
    }
}
