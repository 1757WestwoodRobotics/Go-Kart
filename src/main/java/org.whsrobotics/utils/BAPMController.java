package org.whsrobotics.utils;

import edu.wpi.first.wpilibj.AnalogOutput;

public class BAPMController {

    private AnalogOutput ao;

    private static final double LOWER_VOLTAGE = 0.0;
    private static final double UPPER_VOLTAGE = 5.0;

    public BAPMController(int port) {
        ao = new AnalogOutput(port);
    }

    public void setPercentVoltage(double percentVoltage) {

        if (percentVoltage > 1.0) {
            setVoltage(UPPER_VOLTAGE);
        } else if (percentVoltage < 0.0) {
            setVoltage(LOWER_VOLTAGE);
        } else {
            setVoltage(percentVoltage * 5.0);
        }

    }

    private void setVoltage(double normalizedVoltage) {
        ao.setVoltage(normalizedVoltage);
    }

}
