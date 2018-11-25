package commands;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Command;
import robot.OI;
import subsystems.DriveTrain;

/**
 * A WPILib Command that controls the BAPM Controller. Designed to work with a DriveTrain subsystem. Uses the flight
 * stick joystick as defined in OI.
 */
public class BAPMDrive extends Command {

    /**
     * Constructor for the Command.
     */
    public BAPMDrive() {
        requires(DriveTrain.getInstance());
    }

    @Override
    protected void execute() {
        DriveTrain.BAPMdrive(OI.getFlightStick().getY(GenericHID.Hand.kRight),
                -OI.getFlightStick().getX(GenericHID.Hand.kRight));
    }

    @Override
    protected void end() {
        DriveTrain.stopDrive();     // Stop the motors
        (new FlightStickDrive()).start();       // Start the FlightStickDrive() Command to run in-place of this
    }

    @Override
    protected boolean isFinished() {
        return !DriveTrain.getBAPMmode();       // Only allow this command to run if the BAPM mode switch is turned on
    }

}