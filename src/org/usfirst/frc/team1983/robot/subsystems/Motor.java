package org.usfirst.frc.team1983.robot.subsystems;

import edu.wpi.first.wpilibj.CANSpeedController;
import edu.wpi.first.wpilibj.Talon;
import org.usfirst.frc.team1983.robot.settings.Constants;

public class Motor {
    Talon m_talon;
    int m_port;

    public Motor() {}

    public Motor(int port, boolean reversed) {
        m_talon = new Talon(port);
        m_talon.setInverted(reversed);

        m_port = port;
    }

    public void set(double value) {
        m_talon.set(value);
    }

    public void reverse() {
        m_talon.setInverted(!m_talon.getInverted());
    }

    public void setReversed(boolean reversed) {
        m_talon.setInverted(reversed);
    }
}