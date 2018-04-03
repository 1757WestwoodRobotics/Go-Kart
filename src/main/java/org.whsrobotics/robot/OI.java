package org.whsrobotics.robot;

import edu.wpi.first.wpilibj.Joystick;
import org.whsrobotics.subsystems.DriveTrain;

import static org.whsrobotics.robot.RobotMap.FLIGHTSTICK;

public class OI {

    private static Joystick flightStick;
    private static OI instance;


    private OI() {

        flightStick = new Joystick(FLIGHTSTICK);

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