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
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

/**
 * Add your docs here.
 */
public class Autonomous {

    public static int frontLeftnum = 2;
    public static int rearLeftnum = 1;
    public static int frontRightnum = 4;
    public static int rearRightnum = 3;

    //create speedcontroller entries for talons
    public static WPI_TalonSRX frontLeft = new WPI_TalonSRX(frontLeftnum);
    public static WPI_TalonSRX rearLeft = new WPI_TalonSRX(rearLeftnum);
    public static WPI_TalonSRX frontRight = new WPI_TalonSRX(frontRightnum);
    public static WPI_TalonSRX rearRight = new WPI_TalonSRX(rearRightnum);


    public static void displayvalues() {
    }

    public void init() {
        frontLeft.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
        rearLeft.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
        frontRight.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
        rearRight.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);

        boolean testbool;
        testbool = true;

        while (testbool) {
            frontLeft.set(ControlMode.Position, 5000); //doesnt work but should?
        }
        
    }
}
