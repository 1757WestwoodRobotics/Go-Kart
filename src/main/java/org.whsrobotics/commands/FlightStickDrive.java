package org.whsrobotics.commands;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Command;
import org.whsrobotics.robot.OI;
import org.whsrobotics.subsystems.DriveTrain;

/**
 * A WPILib Command that controls a DriveTrain. Uses the flight stick joystick as defined in OI.
 */
public class FlightStickDrive extends Command {

    public FlightStickDrive() {
        requires(DriveTrain.getInstance());
    }

    @Override
    protected void execute() {
        DriveTrain.drive(OI.getFlightStick().getY(GenericHID.Hand.kRight),
                -OI.getFlightStick().getX(GenericHID.Hand.kRight));
    }

    @Override
    protected void end() {
        DriveTrain.stopDrive();     // Stop the motors
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}