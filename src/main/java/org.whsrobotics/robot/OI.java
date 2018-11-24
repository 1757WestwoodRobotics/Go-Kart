package org.whsrobotics.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import org.whsrobotics.commands.BAPMDrive;
import org.whsrobotics.subsystems.DriveTrain;

import static org.whsrobotics.robot.RobotMap.FLIGHTSTICK;

public class OI {

    private static Joystick flightStick;
    private static OI instance;

    private static JoystickButton triggerButton;

    private OI() {
        flightStick = new Joystick(FLIGHTSTICK);
        triggerButton = new JoystickButton(flightStick, 1);

        triggerButton.whileHeld(new BAPMDrive());
    }

    public static Joystick getFlightStick() {
        return flightStick;
    }


    public static OI getInstance() {
        if (instance == null) {
            instance = new OI();
        }

        return instance;
    }
}
