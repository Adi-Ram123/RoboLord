package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Elevator extends SubsystemBase
{

    private SpeedController leftElevatorController, rightElevatorController;
    private Encoder leftElevatorEncoder, rightElevatorEncoder;
    private DigitalInput elevatorSwitch;

    public Elevator(SpeedController leftElevatorController, SpeedController rightElevatorController, Encoder leftElevatorEncoder, Encoder rightElevatorEncoder, DigitalInput elevatorSwitch)
    {
        this.leftElevatorController = leftElevatorController;
        this.rightElevatorController = rightElevatorController;
        this.leftElevatorEncoder = leftElevatorEncoder;
        this.rightElevatorEncoder = rightElevatorEncoder;
        this.elevatorSwitch = elevatorSwitch;
    }

    @Override
    public void periodic()
    {
        if(elevatorSwitch.get() || leftElevatorEncoder.getDistance() > Constants.ENCODER_LIMIT || rightElevatorEncoder.getDistance() > Constants.ENCODER_LIMIT)
            stopElevator();
    }

    public void moveElevator(double speed)
    {
        leftElevatorController.set(speed);
        rightElevatorController.set(speed);
    }


    public void stopElevator()
    {
        leftElevatorController.stopMotor();
        rightElevatorController.stopMotor();
    }

    public Encoder getLeftElevatorEncoder()
    {
        return leftElevatorEncoder;
    }

    public Encoder getRightElevatorEncoder()
    {
        return rightElevatorEncoder;
    }

    public DigitalInput getElevatorSwitch()
    {
        return elevatorSwitch;
    }

    
}
