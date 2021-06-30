package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase{

    private SpeedController leftShooter, rightShooter;

    public Shooter(SpeedController leftShooter, SpeedController rightShooter)
    {
        this.leftShooter = leftShooter;
        this.rightShooter = rightShooter;
    }

    public void moveShooter(double speed)
    {
        leftShooter.set(speed);
        rightShooter.set(speed);
    }

    public void stopShooter()
    {
        leftShooter.stopMotor();
        rightShooter.stopMotor();
    }
    
}
