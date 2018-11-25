package org.whsrobotics.robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;

import java.util.HashMap;

/**
 * Handles the publishing of robot data and health onto NetworkTables through a simpler abstraction.
 */
public class Telemetry {

    private static NetworkTable nt;     // Reference to the NetworkTableInstance table
    private static HashMap<String, Object> data;        // Stores a dictionary of the telemetry data

    /**
     * Connects this NetworkTable reference to the default robot NT instance.
     */
    public static void init() {
        nt = NetworkTableInstance.getDefault().getTable("Robot/Telemetry");
    }

    /**
     * Places the data into the data HashMap (dictionary)
     *
     * @param name the key/name of the data that is being described
     * @param item the value of the data
     */
    public static void recordTelemetry(String name, Object item) {
        data.put(name, item);
    }

    /**
     * Checks if data has changed, and if so, publish a new copy onto the NetworkTable.
     * This should be called every loop of the robot program.
     */
    public static void periodic() {
        // TODO: Check if data has changed
        //  If not, publishTelemetry()
        //  One way is to check individually and publish individually
        publishTelemetry();
    }

    /**
     * Private method that publishes the data HashMap onto the NetworkTable.
     */
    private static void publishTelemetry() {
        data.forEach((key, value) -> nt
                .getEntry(key)
                .setValue(value));

        // TODO: Look into whether or not this needs to be in its own thread
    }

}
