package org.usfirst.frc.team1983.robot.services;

import java.util.*;

import edu.wpi.first.wpilibj.DriverStation;
import org.usfirst.frc.team1983.robot.Robot;
import org.usfirst.frc.team1983.robot.commands.drivebase.TurnAngle;
import org.usfirst.frc.team1983.robot.settings.Constants;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

public class OI {
    public static int m_type;
    private HashMap<Integer, Joystick> m_joysticks;
    private HashMap<Integer, JoystickButton[]> m_buttons;
    private HashMap<Integer, Boolean[]> m_lastButtonStates;

    public OI(int type) {
        m_type = type;

        m_joysticks = new HashMap<>();
        m_buttons = new HashMap<>();
        m_lastButtonStates = new HashMap<>();

        for (int joy = 0; joy < DriverStation.kJoystickPorts; joy++) {
            if (DriverStation.getInstance().getJoystickName(joy) != "") {
                m_joysticks.put(joy, new Joystick(joy));
                m_buttons.put(joy, new JoystickButton[m_joysticks.get(joy).getButtonCount()]);
                m_lastButtonStates.put(joy, new Boolean[m_joysticks.get(joy).getButtonCount()]);

                for (int button = 1; button <= m_joysticks.get(joy).getButtonCount(); button++) {
                    m_buttons.get(joy)[button - 1] = new JoystickButton(m_joysticks.get(joy), button);
                }
            }
        }

        //COMMAND BINDINGS
        bindToPressed(1, 0, new TurnAngle(true, 90));
    }

    public void update() {
        for(Integer joy : m_lastButtonStates.keySet()) {
            for(int button = 1; button < m_lastButtonStates.get(joy).length; button++) {
                m_lastButtonStates.get(joy)[button - 1] = isDown(joy, button);
            }
        }
    }

    public void bindToHeld(int joy, int button, Command command) {
        m_buttons.get(joy)[button].whileHeld(command);
    }

    public void bindToPressed(int joy, int button, Command command) {
        m_buttons.get(joy)[button].whenPressed(command);
    }

    public double getAxis(int joy, int axis) {
        return m_joysticks.get(joy).getRawAxis(axis);
    }

    public boolean isDown(int joy, int button) {
        return m_joysticks.get(joy).getRawButton(button);
    }

    public boolean isPressed(int joy, int button) {
        return isDown(joy, button) && !m_lastButtonStates.get(joy)[button - 1];
    }

    public boolean isReleased(int joy, int button) {
        return !isDown(joy, button) && m_lastButtonStates.get(joy)[button - 1];
    }
}