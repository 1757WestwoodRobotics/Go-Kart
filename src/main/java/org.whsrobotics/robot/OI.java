package org.whsrobotics.robot;

import edu.wpi.first.wpilibj.Joystick;

import static org.whsrobotics.robot.RobotMap.FLIGHTSTICK;

public class OI {

    private static Joystick flightStick;


    private OI() {

        flightStick = new Joystick(FLIGHTSTICK);

    }

    public static Joystick getFlightStick() {
        return flightStick;
    }

    public static double flightstickCurve(double value) {
        return value;
    }

}