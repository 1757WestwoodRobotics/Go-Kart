package org.whsrobotics.commands;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Command;
import org.whsrobotics.robot.OI;
import org.whsrobotics.subsystems.DriveTrain;

public class FlightStickDrive extends Command {

    private static FlightStickDrive instance;

    public FlightStickDrive() {
        requires(DriveTrain.getInstance());
    }

    @Override
    protected void execute() {

        DriveTrain.drive(OI.getFlightStick().getY(GenericHID.Hand.kRight),
                -OI.getFlightStick().getX(GenericHID.Hand.kRight),false);
    }

    @Override
    protected void end() {
        DriveTrain.stopDrive();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    public static FlightStickDrive getInstance() {
        if (instance == null) {
            instance = new FlightStickDrive();
        }

        return instance;
    }

}