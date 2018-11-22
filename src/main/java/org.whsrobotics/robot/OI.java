package org.whsrobotics.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import org.whsrobotics.subsystems.DriveTrain;

import static org.whsrobotics.robot.RobotMap.FLIGHTSTICK;

public class OI {

    private static Joystick flightStick;
    private static OI instance;


    private OI() {

        flightStick = new Joystick(FLIGHTSTICK);

//        (new JoystickButton(flightStick, 1)).whileHeld(new Command() {});


    }

    public static Joystick getFlightStick() {
        return flightStick;
    }

    public static double flightstickCurve(double value) {
        return value;
    }


    public static OI getInstance() {
        if (instance == null) {
            instance = new OI();
        }

        return instance;
    }
}
