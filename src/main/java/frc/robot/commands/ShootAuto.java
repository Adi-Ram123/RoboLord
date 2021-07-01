package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.Pulley;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Transport;

public class ShootAuto extends CommandBase
{

    private Transport transport;
    private Pulley pulley;
    private Shooter shooter;

    public ShootAuto(Transport transport, Pulley pulley, Shooter shooter)
    {
        this.transport = transport;
        this.pulley = pulley;
        this.shooter = shooter;
    }

    @Override
    public void initialize()
    {
        transport.moveTransport(Constants.TRANSPORT_SPEED);
        pulley.movePulley(Constants.PULLEY_SPEED);
        shooter.moveShooter(Constants.SHOOTER_SPEED);
    }

    @Override
    public void execute()
    {
        transport.moveTransport(Constants.TRANSPORT_SPEED);
        pulley.movePulley(Constants.PULLEY_SPEED);
        shooter.moveShooter(Constants.SHOOTER_SPEED);
    }

    @Override
    public boolean isFinished()
    {
        return !Robot.m_robotContainer.getJoystick().getRawButtonPressed(Constants.SHOOT_AUTO_BUTTON);
    }

    @Override
    public void end(boolean interrupted)
    {
        transport.stopTransport();
        pulley.stopPulley();
        shooter.stopShooter();
    }

}
