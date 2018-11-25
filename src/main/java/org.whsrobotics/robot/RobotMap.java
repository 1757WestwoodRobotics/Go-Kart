package org.whsrobotics.robot;

/**
 * Defines the hardware constants of the robot such as port numbers and IDs.
 */
public class RobotMap {

    /**
     * Defines the CAN IDs of TalonSRX.
     */
    public enum MotorControllers {

        DRIVE_LEFT_FRONT(1), DRIVE_RIGHT_FRONT(3),
        DRIVE_LEFT_BACK(2), DRIVE_RIGHT_BACK(4);

        public int id;

        /**
         * Constructor for assigning the enum constants to TalonSRX IDs.
         * @param id the CAN id assigned to the TalonSRX in the RoboRIO web interface
         */
        MotorControllers(int id) {
            this.id = id;
        }

    }

    public static final int FLIGHTSTICK = 0;        // USB Joystick slot 0 on the Driver Station

    public static void init() {

    }
}