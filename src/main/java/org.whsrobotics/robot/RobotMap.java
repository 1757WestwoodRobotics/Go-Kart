package org.whsrobotics.robot;

import edu.wpi.first.wpilibj.SPI;

public class RobotMap {

    public enum MotorControllers {

        //TODO: Set these to the right talons
        DRIVE_LEFT_FRONT(5), DRIVE_RIGHT_FRONT(7),
        DRIVE_LEFT_BACK(6), DRIVE_RIGHT_BACK(8);

        public int tal;

        MotorControllers(int tal) {
            this.tal = tal;
        }

    }

    public static final int FLIGHTSTICK = 0;

    public static void init() {

    }
}