// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.commands.DriveWithJoystick;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.MoveIntake;
import frc.robot.commands.MovePulley;
import frc.robot.commands.MoveShooter;
import frc.robot.commands.MoveTransport;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Pulley;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Transport;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);


  private SpeedController leftBottom, leftTop, rightBottom, rightTop;
  private SpeedControllerGroup left, right;
  private DifferentialDrive drive;
  private DriveTrain driveTrain;
  private Joystick joystick;

  private SpeedController intakeSpeed;
  private Intake intake;
  private Button intakeButton;
  
  private SpeedController transportControl;
  private Transport transport;
  private Button transportButton;
  
  private SpeedController pulleyController;
  private Pulley pulley;
  private Button pulleyButton;

  private SpeedController leftShooter, rightShooter;
  private Shooter shooter;
  private Button shooterButton;

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

    leftBottom = new SteelTalonsController(Constants.DRIVETRAIN_LEFT_BOTTOM, false, 1);
    leftTop = new SteelTalonsController(Constants.DRIVETRAIN_LEFT_TOP, false, 1);
    rightBottom = new SteelTalonsController(Constants.DRIVETRAIN_RIGHT_BOTTOM, false, 1);
    rightTop = new SteelTalonsController(Constants.DRIVETRAIN_RIGHT_TOP, false, 1);

    left = new SpeedControllerGroup(leftBottom, leftTop);
    right = new SpeedControllerGroup(rightBottom, rightTop);

    drive = new DifferentialDrive(left, right);

    driveTrain = new DriveTrain(left, right, drive);
    driveTrain.setDefaultCommand(new DriveWithJoystick());

    intakeSpeed = new SteelTalonsController(Constants.INTAKE_SPEED_CONTROLLER, false, 1);
    intake = new Intake(intakeSpeed);

    transportControl = new SteelTalonsController(Constants.TRANSPORT_CONTROLLER, false, 1);
    transport = new Transport(transportControl);

    pulleyController = new SteelTalonsController(Constants.PULLEY_CONTROLLER, false, 1);
    pulley = new Pulley(pulleyController);

    leftShooter = new SteelTalonsController(Constants.LEFT_SHOOTER, false, 1);
    rightShooter = new SteelTalonsController(Constants.RIGHT_SHOOTER, false, 1);
    shooter = new Shooter(leftShooter, rightShooter);



    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() 
  {
    joystick = new Joystick(0);

    intakeButton = new JoystickButton(joystick, Constants.INTAKE_BUTTON);
    intakeButton.whileHeld(new MoveIntake(Constants.INTAKE_SPEED));

    transportButton = new JoystickButton(joystick, Constants.TRANSPORT_BUTTON);
    transportButton.whileHeld(new MoveTransport(Constants.TRANSPORT_SPEED));

    pulleyButton = new JoystickButton(joystick, Constants.PULLEY_BUTTON);
    pulleyButton.whileHeld(new MovePulley(Constants.PULLEY_SPEED));

    shooterButton = new JoystickButton(joystick, Constants.SHOOTER_BUTTON);
    shooterButton.whileHeld(new MoveShooter(Constants.SHOOTER_SPEED));
  
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }

  public DriveTrain getDriveTrain()
  {
    return driveTrain;
  }

  public Joystick getJoystick()
  {
    return joystick;
  }

  public Intake getIntake()
  {
    return intake;
  }

  public Transport getTransport()
  {
    return transport;
  }

  public Pulley getPulley()
  {
    return pulley;
  }

  public Shooter getShooter()
  {
    return shooter;
  }
}
