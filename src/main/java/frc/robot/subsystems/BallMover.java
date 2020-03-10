package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class BallMover extends SubsystemBase {

    // All motors declared
    // TODO: probably should rename these

    private WPI_TalonSRX spitLeft = new WPI_TalonSRX(Constants.MOTOR_LAUNCHER_LEFT);
    private WPI_TalonSRX spitRight = new WPI_TalonSRX(Constants.MOTOR_LAUNCHER_RIGHT);

    private WPI_TalonSRX beltFeed = new WPI_TalonSRX(Constants.MOTOR_CONVEYOR);

    private Solenoid ballHolder;

    public BallMover() {
        ballHolder = new Solenoid(Constants.SOLENOID_STOPPER);
        lowerBallHolder(); // Should default to being up.
    }

    private boolean isBeltOn = false;

    public void beltfeed(double speed) {
        if (!isBeltOn) {
            raiseBallHolder();

            beltFeed.set(-speed);

            isBeltOn = !(isBeltOn);
        } else {
            lowerBallHolder();
            beltFeed.stopMotor();

            isBeltOn = !(isBeltOn);
        }
    }

    public void toggleBallHolder() {
        if (!(ballHolder.get())) {
            ballHolder.set(true);
        } else {
            ballHolder.set(false);
        }
    }

    public void lowerBallHolder() {
        ballHolder.set(false);
    }

    public void raiseBallHolder() {
        ballHolder.set(true);
    }

    public void initDefaultCommand() {

    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }
}
