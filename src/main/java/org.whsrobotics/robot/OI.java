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

        (new JoystickButton(flightStick, 1)).whileHeld(new Command() {

            /**
            * Billy's new brake command, created on 5/17/18
            * Happy birthday, Spencer
            * I think I did it this time, but I have no idea which button this is
            **/

            @Override
            protected void initialize() {
                System.out.println("Billy's Brake Command has initialized and is beginning to brake the robot");
                DriveTrain.setBrakeMode();
            }

            @Override
            protected void end() {
                DriveTrain.setCoastMode();
            }

            @Override
            protected void interrupted() {
                System.out.println("Billy's Brake Command was rudely interrupted");
            }

            @Override
            protected boolean isFinished() {
                return false;
            }
        });

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
