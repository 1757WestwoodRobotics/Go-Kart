package org.whsrobotics.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import org.whsrobotics.commands.FlightStickDrive;
import org.whsrobotics.subsystems.DriveTrain;

public class Robot extends TimedRobot {

    /**
     * Robot-wide initialization code should go here.
     */
    @Override
    public void robotInit() {
        FlightStickDrive.getInstance();
        DriveTrain.getInstance();
        OI.getInstance();

        System.out.println("Go-Kart ready");
    }

    /**
     * Code that is run every loop regardless of mode. Put telemetry and health in here.
     */
    @Override
    public void robotPeriodic() {

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

    }

}
