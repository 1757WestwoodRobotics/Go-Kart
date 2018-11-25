package subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import commands.FlightStickDrive;
import robot.RobotMap;
import robot.Telemetry;
import utils.BAPMController;

/**
 * Code that pertains to the drive train mechanism of the Go-Kart
 * (encoders, motors, motor controllers, drive algorithms, etc.)
 */
public class DriveTrain extends Subsystem {

    private static WPI_TalonSRX leftFront;
    private static WPI_TalonSRX leftBack;
    private static WPI_TalonSRX rightFront;
    private static WPI_TalonSRX rightBack;
    private static BAPMController bapmController;

    private static SpeedControllerGroup leftDrive;
    private static SpeedControllerGroup rightDrive;

    private static DifferentialDrive differentialDrive;

    private static DriveTrain instance;
    private static boolean BAPMmode;

    /**
     * Constructor that instantiates the hardware objects and set configurations
     */
    public DriveTrain() {

        bapmController = new BAPMController(0);

        // Regular DriveTrain

        leftFront = new WPI_TalonSRX(RobotMap.MotorControllers.DRIVE_LEFT_FRONT.id);
        rightFront = new WPI_TalonSRX(RobotMap.MotorControllers.DRIVE_RIGHT_FRONT.id);
        leftBack = new WPI_TalonSRX(RobotMap.MotorControllers.DRIVE_LEFT_BACK.id);
        rightBack = new WPI_TalonSRX(RobotMap.MotorControllers.DRIVE_RIGHT_BACK.id);

        setBrakeMode();

        leftDrive = new SpeedControllerGroup(leftFront, leftBack);
        rightDrive = new SpeedControllerGroup(rightFront, rightBack);

        differentialDrive = new DifferentialDrive(leftDrive, rightDrive);

        SmartDashboard.putBoolean("BAPM Mode", false);
    }

    /**
     * The various states that the drive train subsystem can be in.
     */
    private enum Modes {
        NONE, REGULAR, BAPM
    }

    /**
     * Determines the mode of the drive train by analyzing the current running Command. May be inaccurate.
     * @return the current mode of the drive train subsystem
     */
    private Modes determineMode() {
        String commandName = getCurrentCommandName();

        if (commandName.contains("BAPMDrive")) {
            return Modes.BAPM;
        } else if (commandName.contains("FlightStickDrive")) {
            return Modes.REGULAR;
        } else {
            return Modes.NONE;
        }

    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new FlightStickDrive());      // Always start with normal drive automatically ready.
    }

    @Override
    public void periodic() {
        BAPMmode = SmartDashboard.getBoolean("BAPM Mode", false);

        // Current Drive Mode
        Telemetry.recordTelemetry("Drive Mode", determineMode().toString());

        // Encoder values?

        // Motor currents
        Telemetry.recordTelemetry("MotorFL_Current", leftFront.getOutputCurrent());
        Telemetry.recordTelemetry("MotorBL_Current", leftBack.getOutputCurrent());
        Telemetry.recordTelemetry("MotorFR_Current", rightFront.getOutputCurrent());
        Telemetry.recordTelemetry("MotorBR_Current", rightBack.getOutputCurrent());
    }

    /**
     * Normal method for driving the Go-Kart using WPILib's DifferentialDrive class and arcade style driving.
     *
     * @param speed the back and forth output to the drive train [0, 1.0]
     * @param rotation the rotation output (turning by spinning opposing sides in different directions) [0, 1.0]
     */
    public static void drive(double speed, double rotation) {
        differentialDrive.arcadeDrive(speed, rotation);
    }

    /**
     * BAPM method for driving the Go-Kart normally with the BAPM enabled in certain instances. It only works if the Go-Kart
     * is moving forward and NOT rotating.
     *
     * @param speed the back and forth output to the drive train [0, 1.0]
     * @param rotation the rotation output (turning by spinning opposing sides in different directions) [0, 1.0]
     */
    public static void BAPMdrive(double speed, double rotation) {

        // Only enable BAPM if speed is greater than 0.05 (positive) AND rotation is minimal (0.1)!!!
        if (BAPMmode && speed > 0.05 && rotation < 0.1) {
            bapmController.setPercentVoltage(speed);
        }

        drive(speed, rotation);

    }


    public static DriveTrain getInstance() {
        if (instance == null) {
            instance = new DriveTrain();
        }

        return instance;
    }

    /**
     * Stops all motors
     */
    public static void stopDrive() {
        differentialDrive.stopMotor();
        bapmController.stopMotor();
    }

    /**
     * Sets brake mode for the main drive train motor controllers (not the BAPM)
     */
    public static void setBrakeMode() {
        leftFront.setNeutralMode(NeutralMode.Brake);
        leftBack.setNeutralMode(NeutralMode.Brake);
        rightFront.setNeutralMode(NeutralMode.Brake);
        rightBack.setNeutralMode(NeutralMode.Brake);
    }

    /**
     * Sets coast mode for the main drive train motor controllers (not the BAPM)
     */
    public static void setCoastMode() {
        leftFront.setNeutralMode(NeutralMode.Coast);
        leftBack.setNeutralMode(NeutralMode.Coast);
        rightFront.setNeutralMode(NeutralMode.Coast);
        rightBack.setNeutralMode(NeutralMode.Coast);
    }

    /**
     * A getter method to get the status of the switch in the user interface.
     *
     * @return whether BAPMmode is enabled in the user interface
     */
    public static boolean getBAPMmode() {
        return BAPMmode;
    }

}