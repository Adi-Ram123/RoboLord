package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class ShootAuto extends SequentialCommandGroup
{

    public ShootAuto(double transportSpeed, double pulleySpeed, double shooterSpeed)
    {
        addCommands(new MoveTransport(transportSpeed), new MovePulley(pulleySpeed), new MoveShooter(shooterSpeed));
    }
    
}
