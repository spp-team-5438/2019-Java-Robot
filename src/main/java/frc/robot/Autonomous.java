/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.Vision;

public class Autonomous {

    //define all controllers
    private WPI_VictorSPX frontLeft = new WPI_VictorSPX(6);
    private WPI_VictorSPX frontRight = new WPI_VictorSPX(5);
    private WPI_TalonSRX rearLeft = new WPI_TalonSRX(1);
    private WPI_TalonSRX rearRight = new WPI_TalonSRX(3);
    private WPI_TalonSRX eMotor = new WPI_TalonSRX(4);
    private WPI_TalonSRX armMotor = new WPI_TalonSRX(2);

    //circumference of wheels and encoder counts for a full rotation
    double circumferenceInInches = 18.84;
    double pulsesPerRotation = 4096;

    Vision vision = new Vision();

    public void init() {
      
        //drivetrain safety
        frontLeft.setSafetyEnabled(true);
        frontRight.setSafetyEnabled(true);
        rearLeft.setSafetyEnabled(true);
        rearRight.setSafetyEnabled(true);
        frontLeft.setExpiration(0.5);
        frontRight.setExpiration(0.5);
        rearLeft.setExpiration(0.5);
        rearRight.setExpiration(0.5);

        //elevator and intake safety
        eMotor.setSafetyEnabled(true);
        eMotor.setExpiration(0.5);
        armMotor.setSafetyEnabled(true);
        armMotor.setExpiration(0.5);
      
        //configure encoders
        rearLeft.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
        rearRight.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
        rearLeft.setSelectedSensorPosition(0);
        rearRight.setSelectedSensorPosition(0);
        frontLeft.follow(rearLeft);
        frontRight.follow(rearRight);
    }

    //autonomous target following using vision tracking
    public void vision_based() {
        vision.auto_vision();
    }

    public void drive_forward(int distance_inches) {
        double targetPulseCount = distance_inches * circumferenceInInches * pulsesPerRotation;
        rearLeft.set(ControlMode.Position, targetPulseCount);
        rearRight.set(ControlMode.Position, targetPulseCount);

        SmartDashboard.putNumber("Left Encoder (auto)", rearLeft.getSelectedSensorPosition());
        SmartDashboard.putNumber("Right Encoder (auto)", rearRight.getSelectedSensorPosition());
    }

    public void rightturn() {
        rearRight.set(ControlMode.Position, -2048);
        rearLeft.set(ControlMode.Position, 2048);

        SmartDashboard.putNumber("Left Encoder (auto)", rearLeft.getSelectedSensorPosition());
        SmartDashboard.putNumber("Right Encoder (auto)", rearRight.getSelectedSensorPosition());
    }

    public void leftturn() {
        rearRight.set(ControlMode.Position, 2048);
        rearLeft.set(ControlMode.Position, -2048);

        SmartDashboard.putNumber("Left Encoder (auto)", rearLeft.getSelectedSensorPosition());
        SmartDashboard.putNumber("Right Encoder (auto)", rearRight.getSelectedSensorPosition());
    }

    public void drive_backward(int distance_inches) {
        double targetPulseCount = distance_inches * circumferenceInInches * pulsesPerRotation * -1;
        rearLeft.set(ControlMode.Position, targetPulseCount);
        rearRight.set(ControlMode.Position, targetPulseCount);

        SmartDashboard.putNumber("Left Encoder (auto)", rearLeft.getSelectedSensorPosition());
        SmartDashboard.putNumber("Right Encoder (auto)", rearRight.getSelectedSensorPosition());
    }
}
