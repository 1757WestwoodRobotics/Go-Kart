package org.whsrobotics.robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;

import java.util.HashMap;

public class Telemetry {

    private static NetworkTable nt;
    private static HashMap<String, Object> data;

    public static void init() {
        nt = NetworkTableInstance.getDefault().getTable("Robot/Telemetry");
    }

    // Items to Publish
    public static void recordTelemetry(String name, Object item) {
        data.put(name, item);
    }

    public static void periodic() {
        // Check if data has changed
        // If not, publishTelemetry()
        publishTelemetry();
    }

    // Publish telemetry to NetworkTable – new Thread?
    private static void publishTelemetry() {
        data.forEach((key, value) -> nt
                .getEntry(key)
                .setValue(value));
    }

}
