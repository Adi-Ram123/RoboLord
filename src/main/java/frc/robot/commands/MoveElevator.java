package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class MoveElevator extends CommandBase
{
    private double speed;

    public MoveElevator(double speed)
    {
        this.speed = speed;
    }

    @Override
    public void initialize()
    {
        Robot.m_robotContainer.getElevator().moveElevator(speed);
    }

    @Override
    public void execute()
    {
        Robot.m_robotContainer.getElevator().moveElevator(speed);
    }

    @Override
    public boolean isFinished()
    {
        if(speed >= 0)
        {
            if(Robot.m_robotContainer.getJoystick().getRawButtonPressed(Constants.ELEVATOR_UP_BUTTON) && Robot.m_robotContainer.getElevator().getLeftElevatorEncoder().getDistance() < Constants.ENCODER_LIMIT && Robot.m_robotContainer.getElevator().getRightElevatorEncoder().getDistance() < Constants.ENCODER_LIMIT)
                return false;
            
            else
                return true;
        }

        else
        {
            if(Robot.m_robotContainer.getJoystick().getRawButtonPressed(Constants.ELEVATOR_UP_BUTTON) && Robot.m_robotContainer.getElevator().getElevatorSwitch().get() == false)
                return false;
            
            else
                return true;
        }
    }

    @Override
    public void end(boolean interrupted)
    {
        Robot.m_robotContainer.getElevator().stopElevator();
    }

    
}
