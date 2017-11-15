package org.usfirst.frc.team1983.robot.settings;

public class Constants {
    public static double JOYSTICK_DEADZONE = 0.15;

    public static class OIInputType {
        public static final int DoubleJoy = 0;
        public static final int Wheel = 1;
    }

    public static class OIJoystick {
        public static final int Left = 0;
        public static final int Right = 1;
        public static final int Wheel = 0;
        public static final int Throttle = 1;
        public static final int Buttons = 2;
    }
}
