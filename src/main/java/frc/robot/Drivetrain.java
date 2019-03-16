/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.XboxController;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.GenericHID;

import edu.wpi.first.wpilibj.SpeedControllerGroup;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Drivetrain {

    //define numbers of talons
    public static int rearLeftnum = 1;
    public static int rearRightnum = 3;

    //define controllers
    public static WPI_VictorSPX frontLeft = new WPI_VictorSPX(6);
    public static WPI_VictorSPX frontRight = new WPI_VictorSPX(5);
    public static WPI_TalonSRX rearLeft = new WPI_TalonSRX(rearLeftnum);
    public static WPI_TalonSRX rearRight = new WPI_TalonSRX(rearRightnum);

    //create mecanum drive
    public static MecanumDrive mDrive = new MecanumDrive(frontLeft, rearLeft, frontRight, rearRight);
    Hand leftHand = GenericHID.Hand.kLeft;
    Hand rightHand = GenericHID.Hand.kRight;

    SpeedControllerGroup left = new SpeedControllerGroup(frontLeft, rearLeft);
    SpeedControllerGroup right = new SpeedControllerGroup(frontRight, rearRight);

    public DifferentialDrive dDrive = new DifferentialDrive(left, right);

    //define xbox controller for use with mecanum drive
    public static XboxController controller = new XboxController(0);


    public void init() {
        mDrive.setDeadband(0);
        mDrive.setSafetyEnabled(true);
        mDrive.setExpiration(0.5);
        dDrive.setSafetyEnabled(true);
        dDrive.setExpiration(0.5);
        rearLeft.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
        rearRight.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
    }

    public void main() {

        if (controller.getTriggerAxis(rightHand) > 0) {
            mDrive.driveCartesian((controller.getRawAxis(0) * 0.5), (controller.getRawAxis(1) * -0.5), (controller.getRawAxis(4) * 0.5));
            //System.out.println("HALF SPEED!");
        }
        else if (controller.getTriggerAxis(leftHand) > 0) {
            mDrive.driveCartesian((controller.getRawAxis(0) * 0.25), (controller.getRawAxis(1) * -0.25), (controller.getRawAxis(4) * 0.25));
            //System.out.println("QUARTER SPEED");
        }
        else {
            mDrive.driveCartesian((controller.getRawAxis(0) * 1), (controller.getRawAxis(1) * -1), (controller.getRawAxis(4) * 1));
        }


        //mDrive.driveCartesian((controller.getRawAxis(0) * 1), (controller.getRawAxis(1) * -1), (controller.getRawAxis(4) * 1));

        //send encoder values to smartdashboard
        int leftEncoder = rearLeft.getSelectedSensorPosition();
        int rightEncoder = rearRight.getSelectedSensorPosition();
        SmartDashboard.putNumber("Left Encoder", leftEncoder);
        SmartDashboard.putNumber("Right Encoder", rightEncoder);
    }

    public void driveStraight() {
        mDrive.drivePolar(.5,0,0);
    }

    public void driveRight() {
        mDrive.drivePolar(.3,90,0);
    }

    public void driveLeft() {
        mDrive.drivePolar(.3,-90,0);
    }

    // public void rotateAlign(double leftSpeed, double rightSpeed){
    //     frontLeft.set(leftSpeed);
    //     rearLeft.set(leftSpeed);
    //     frontRight.set(rightSpeed);
    //     rearRight.set(rightSpeed);
    // }

    // public void rotateLeft() {
    //     rearRight.set(.3);
    //     rearLeft.set(-.3);
    // }

    // public void rotateRight() {
    //     rearRight.set(-.3);
    //     rearLeft.set(.3);
    // }
}
