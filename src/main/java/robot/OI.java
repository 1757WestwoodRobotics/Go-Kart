package robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import commands.BAPMDrive;

public class OI {

    // Flight stick hardware
    private static Joystick flightStick;
    private static JoystickButton triggerButton;

    private static OI instance;

    /**
     * Private constructor to be called through a singleton accessor.
     */
    private OI() {
        flightStick = new Joystick(RobotMap.FLIGHTSTICK);

        // Binds the BAPMDrive() command to trigger button (1).
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
