package org.whsrobotics.robot;

import edu.wpi.first.wpilibj.Joystick;

import static org.whsrobotics.robot.RobotMap.FLIGHTSTICK;

public class OI {

    public static Joystick flightStick;
    public static OI instance;



    private OI() {

        flightStick = new Joystick(FLIGHTSTICK);

    }

    public static OI getInstance() {
        if (instance == null) {
            instance = new OI();
        }

        return instance;
    }

    public static Joystick getFlightStick() {
        return flightStick;
    }

    public static double flightstickCurve(double value) {
        return value;
    }

}