package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase
{

    private SpeedControllerGroup left;
    private SpeedControllerGroup right;
    private DifferentialDrive drive;

    public DriveTrain(SpeedControllerGroup left, SpeedControllerGroup right, DifferentialDrive drive)
    {
        this.left = left;
        this.right = right;
        this.drive = drive;
    }

    public void takeJoystickInputs(Joystick joy)
    {
        drive.arcadeDrive(joy.getY(), joy.getZ());
    }

    public void drive(double leftSpeed, double rightSpeed)
    {
        left.set(leftSpeed);
        right.set(rightSpeed);
    }

    public void stop()
    {
        left.stopMotor();
        right.stopMotor();
    }
    
}
