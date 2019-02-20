// /*----------------------------------------------------------------------------*/
// /* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
// /* Open Source Software - may be modified and shared by FRC teams. The code   */
// /* must be accompanied by the FIRST BSD license file in the root directory of */
// /* the project.                                                               */
// /*----------------------------------------------------------------------------*/

// package frc.robot;

// import com.ctre.phoenix.motorcontrol.ControlMode;
// import com.ctre.phoenix.motorcontrol.FeedbackDevice;
// import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
// import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

// import edu.wpi.first.wpilibj.VictorSP;

// public class Autonomous {

//     //define drivetrain
//     private WPI_TalonSRX frontLeft = new WPI_TalonSRX(2);
//     private WPI_TalonSRX rearLeft = new WPI_TalonSRX(1);
//     private WPI_TalonSRX frontRight = new WPI_TalonSRX(4);
//     private WPI_TalonSRX rearRight = new WPI_TalonSRX(3);
    
//     //define elevator
//     private WPI_VictorSPX eMotor = new WPI_VictorSPX(5);

//     //define arm
//     private VictorSP armMotor = new VictorSP(0);


//     public static void displayvalues() {
//     }

//     public void init() {
//         frontLeft.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
//         rearLeft.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
//         frontRight.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
//         rearRight.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);

//         frontLeft.setSelectedSensorPosition(0);
//         rearLeft.setSelectedSensorPosition(0);
//         frontRight.setSelectedSensorPosition(0);
//         rearRight.setSelectedSensorPosition(0);

//         frontLeft.config_kP(0, 1);
//         rearLeft.config_kP(0, 1);
//         frontRight.config_kP(0, 1);
//         rearRight.config_kP(0, 1);
//     }

//     public void main() {
//         frontLeft.set(ControlMode.Position, 5000);

//     }

// }
