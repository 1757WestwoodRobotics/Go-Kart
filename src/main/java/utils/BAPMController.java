package utils;

import edu.wpi.first.wpilibj.AnalogOutput;

/**
 * A class representing an analog motor controller set by a 5V potentiometer.
 */
public class BAPMController {

    // AnalogOutput channel (0-5V) on the MXP header.
    private AnalogOutput ao;

    // Constants that define the minimum and maximum bus voltage for the AnalogOutput channel.
    private static final double LOWER_VOLTAGE = 0.0;
    private static final double UPPER_VOLTAGE = 5.0;

    /**
     * Constructor for the BAPM Controller.
     * @param port the MXP AnalogOutput channel (either 0 or 1)
     */
    public BAPMController(int port) {
        ao = new AnalogOutput(port);
    }

    /**
     * Stops the BAPM by sending 0V to the motor controller.
     */
    public void stopMotor() {
        setPercentVoltage(LOWER_VOLTAGE);
    }

    /**
     * Maps the values from [0, 1.0] to [LOWER_VOLTAGE, UPPER_VOLTAGE]. These values are standard from WPILib.
     * @param percentVoltage the percent voltage sent to the motor controller. 0 represents 0% and 1.0 represents 100%.
     */
    public void setPercentVoltage(double percentVoltage) {
        // Bound it within limits
        if (percentVoltage > 1.0) {
            setVoltage(UPPER_VOLTAGE);
        } else if (percentVoltage < 0.0) {
            setVoltage(LOWER_VOLTAGE);
        } else {
            // Scale it to [LOWER_VOLTAGE, UPPER_VOLTAGE]
            setVoltage(percentVoltage * UPPER_VOLTAGE);
        }

    }

    /**
     * Internal method to set the normalized voltage to the motor controller.
     * @param normalizedVoltage direct output between LOWER_VOLTAGE and UPPER_VOLTAGE
     */
    private void setVoltage(double normalizedVoltage) {
        ao.setVoltage(normalizedVoltage);
    }

}
