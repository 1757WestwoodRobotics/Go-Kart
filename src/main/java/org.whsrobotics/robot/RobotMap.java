package org.whsrobotics.robot;

import edu.wpi.first.wpilibj.SPI;

public class RobotMap {

    public enum MotorControllers {

        //TODO: Set these to the right talons
        DRIVE_LEFT_FRONT(1), DRIVE_RIGHT_FRONT(3),
        DRIVE_LEFT_BACK(2), DRIVE_RIGHT_BACK(4);

        public int tal;

        MotorControllers(int tal) {
            this.tal = tal;
        }

    }

    public static final int FLIGHTSTICK = 0;

    public static void init() {

    }
}