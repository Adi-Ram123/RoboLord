package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;

public class Pulley {

    private SpeedController pulley;

    public Pulley(SpeedController pulley)
    {
        this.pulley = pulley;
    }

    public void movePulley(double speed)
    {
        pulley.set(speed);
    }

    public void stopPulley()
    {
        pulley.stopMotor();
    }
    
}
