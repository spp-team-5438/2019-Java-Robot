/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.VictorSP;


/**
 * Add your docs here.
 */
public class Drivetrain {

    //define numbers of talons
    public static int rearLeftnum = 1;
    public static int rearRightnum = 3;

    //create speedcontroller entries for talons
    public static VictorSP frontLeft = new VictorSP(8);
    public static WPI_TalonSRX rearLeft = new WPI_TalonSRX(rearLeftnum);
    public static VictorSP frontRight = new VictorSP(9);
    public static WPI_TalonSRX rearRight = new WPI_TalonSRX(rearRightnum);

    //create mecanum drive
    public static MecanumDrive mDrive = new MecanumDrive(frontLeft, rearLeft, frontRight, rearRight);

    //define xbox controller for use with mecanum drive
    public static XboxController controller = new XboxController(0);

    public void init() {
        mDrive.setSafetyEnabled(true);
        mDrive.setExpiration(0.5);

        rearLeft.enableVoltageCompensation(true);
        rearRight.enableVoltageCompensation(true);

        rearLeft.configVoltageCompSaturation(12.0, 0);
        rearRight.configVoltageCompSaturation(12.0, 0);
    }

    public void main() {
        //create drivetrain with controller inputs and set safety
        mDrive.driveCartesian((controller.getRawAxis(4) * -1), (controller.getRawAxis(1) * -1), (controller.getRawAxis(0) * -1));
        mDrive.setDeadband(0);
        frontLeft.setInverted(true);
        frontRight.setInverted(true);
    }

//     public void driveStraight() {
//         mDrive.driveCartesian(0,.25,0);
//     }

//     public void driveRight() {
//         mDrive.driveCartesian(.5,0,0);
//     }

//     public void driveLeft() {
//         mDrive.drivePolar(.5,180,0);
//     }
}