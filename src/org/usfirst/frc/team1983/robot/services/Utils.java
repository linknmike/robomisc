package org.usfirst.frc.team1983.robot.services;

public class Utils {
    public double map(double startMin, double startMax, double endMin, double endMax, double input) {
        return (input - startMin) * (endMax - endMin) / (startMax - startMin) + endMin;
    }
}
