// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.cameraserver.CameraServer;
/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
    PWMSparkMax in= new PWMSparkMax(5);
    PWMSparkMax fl= new PWMSparkMax(1);
    PWMSparkMax fr= new PWMSparkMax(3);
    PWMSparkMax bl= new PWMSparkMax(2);
    PWMSparkMax br= new PWMSparkMax(4);
    PWMSparkMax climb= new PWMSparkMax(8);
    PWMSparkMax out= new PWMSparkMax(6);
    PWMSparkMax outStop= new PWMSparkMax(7);
    MotorControllerGroup left= new MotorControllerGroup(fl, bl);
    MotorControllerGroup right= new MotorControllerGroup(fr, br);
    DifferentialDrive diffDrive= new DifferentialDrive(left, right);
    Joystick joystick1= new Joystick(0);
    Joystick joystick2= new Joystick(1);
  @Override
  public void robotInit() {
    CameraServer.startAutomaticCapture();

  }

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {
    diffDrive.tankDrive(-joystick2.getY(), joystick1.getY());
    if(joystick1.getTrigger()){
      out.set(-.6);
    }else{
      out.set(0);
    }

    if(joystick2.getTrigger()){
      in.set(-.6);
    }else{
      in.set(0);
    }

    if(joystick1.getRawButtonPressed(2)){
      outStop.set(.8);
    }else if(!joystick1.getRawButton(2)){
      outStop.set(0);
    }
    

    if(joystick2.getRawButton(2)){
      climb.set(0.5);
    } else if(joystick2.getRawButton(3)){
      climb.set(-0.5);
    } else{
      climb.set(0);
    }

  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}
}
