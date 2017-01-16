package org.usfirst.frc.team79.robot.subsystems;

import org.usfirst.frc.team79.robot.RobotMap;
import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {
    
private RobotDrive Drive;

public static CANTalon FrontLeft, BackLeft, FrontRight, BackRight , MiddleLeft, MiddleRight;

public AnalogGyro gyro;
	
public DriveTrain(){
		
		FrontLeft = new CANTalon(RobotMap.ForntLeftMotor);
		BackLeft = new CANTalon(RobotMap.BackLeftMotor);
	    FrontRight = new CANTalon(RobotMap.FrontRightMotor);
	    BackRight = new CANTalon(RobotMap.BackRightMotor);
	    
	    Drive = new RobotDrive(BackLeft, FrontLeft, BackRight, FrontRight);
	    
		gyro = new AnalogGyro(RobotMap.GYRO);
		
	}

    public void initDefaultCommand() {
    	
    }

    public void arcadeDrive(Joystick stick){
    	Drive.arcadeDrive(stick);
    }
    
    public void arcadeDrive(double x, double y) {
    	Drive.arcadeDrive(x, y);
    }
    
    public double GetGyroAngle() {
    	return gyro.getAngle();
    }
    
    public double getNormalAngle() {
    	double angle = gyro.getAngle() % 360;
    	return angle / 360;
    }
    
    public void resetGyro() {
    	gyro.reset();
    }

}