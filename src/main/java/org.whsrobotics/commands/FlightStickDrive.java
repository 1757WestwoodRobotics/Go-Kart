package org.whsrobotics.commands;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Command;
import org.whsrobotics.robot.OI;
import org.whsrobotics.subsystems.DriveTrain;

public class FlightStickDrive extends Command {

    public FlightStickDrive() {
        requires(DriveTrain.getInstance());
    }

    @Override
    protected void execute() {

        DriveTrain.drive(OI.getFlightStick().getX(GenericHID.Hand.kRight),
                OI.getFlightStick().getY(GenericHID.Hand.kRight),true);
    }

    @Override
    protected void end() {
        DriveTrain.stopDrive();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}