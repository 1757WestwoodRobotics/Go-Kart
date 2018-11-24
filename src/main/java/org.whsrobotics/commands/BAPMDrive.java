package org.whsrobotics.commands;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Command;
import org.whsrobotics.robot.OI;
import org.whsrobotics.subsystems.DriveTrain;

public class BAPMDrive extends Command {

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
        DriveTrain.stopDrive();
        (new FlightStickDrive()).start();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}