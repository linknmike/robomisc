package org.usfirst.frc.team1983.robot.subsystems;

import java.util.*;

public class MotorGroup extends Motor {
    private ArrayList<Motor> m_motors;

    public MotorGroup(ArrayList<Motor> motors) {
        m_motors = motors;
    }

    public void set(double value) {
        for(Motor m : m_motors) {
            m.set(value);
        }
    }

    public void reverse() {
        for(Motor m : m_motors) {
            m.reverse();
        }
    }

    public void setReversed(boolean reversed) {
        for(Motor m : m_motors) {
            m.setReversed(reversed);
        }
    }
}
