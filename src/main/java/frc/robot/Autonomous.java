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
import edu.wpi.first.wpilibj.VictorSP;

import frc.robot.Vision;

public class Autonomous {

    //define all controllers
    private VictorSP frontLeft = new VictorSP(8);
    private VictorSP frontRight = new VictorSP(9);
    private WPI_TalonSRX rearLeft = new WPI_TalonSRX(1);
    private WPI_TalonSRX rearRight = new WPI_TalonSRX(3);
    private WPI_TalonSRX eMotor = new WPI_TalonSRX(4);
    private WPI_TalonSRX armMotor = new WPI_TalonSRX(2);

    Vision vision = new Vision();
    
    public void init() {
        rearLeft.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
        rearRight.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
        rearLeft.setSelectedSensorPosition(0);
        rearRight.setSelectedSensorPosition(0);
    }

    //autonomous target following using vision tracking
    public void vision_based() {
        vision.auto_vision();
    }

}
