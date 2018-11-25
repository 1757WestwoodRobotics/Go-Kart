package org.whsrobotics.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import org.whsrobotics.subsystems.DriveTrain;

public class Robot extends TimedRobot {

    /**
     * Robot-wide initialization code should go here.
     */
    @Override
    public void robotInit() {
        DriveTrain.getInstance();
        OI.getInstance();
        Telemetry.init();

        System.out.println("The Go-Kart is ready");
    }

    /**
     * Code that is run every loop regardless of mode. Put telemetry and health in here.
     */
    @Override
    public void robotPeriodic() {
        Telemetry.periodic();
    }

    /**
     * Periodic code for teleop mode should go here.
     */
    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }


    /**
     * Initialization code for disabled mode should go here. Called each time the robot is disabled.
     */
    @Override
    public void disabledInit() {
        DriveTrain.stopDrive();
    }

}
