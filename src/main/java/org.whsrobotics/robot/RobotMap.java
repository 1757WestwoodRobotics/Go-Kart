package org.whsrobotics.robot;

import edu.wpi.first.wpilibj.SPI;

public class RobotMap {

    public enum MotorControllers {

        DRIVE_LEFT_FRONT(1), DRIVE_RIGHT_FRONT(2),
        DRIVE_LEFT_BACK(3), DRIVE_RIGHT_BACK(4),
        DRIVE_LEFT_MIDDLE(5), DRIVE_RIGHT_MIDDLE(6);

        public int tal;

        MotorControllers(int tal) {
            this.tal = tal;
        }

    }

    public static final int FLIGHTSTICK = 3;

    public static void init() {

    }
}