package org.whsrobotics.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import org.whsrobotics.commands.FlightStickDrive;
import org.whsrobotics.subsystems.DriveTrain;

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

    private enum FlightstickButton {
            kTrigger(1);

            private int value;

            FlightstickButton(int value) {
                this.value = value;

        }
    }

    public static Joystick getFlightStick() {
        return flightStick;
    }

    public static double flightstickCurve(double value) {
        return value;
    }

}