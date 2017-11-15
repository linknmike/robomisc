package org.usfirst.frc.team1983.util;

public class Vector3 {
    public double x, y, z;

    public Vector3(double x_, double y_, double z_) {
        x = x_;
        y = y_;
        z = z_;
    }

    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}
