/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.I2C;

public class NavX {

    public void init() {
        AHRS gyro = new AHRS(I2C.Port.kMXP);
        System.out.println("gyro created!");
    }

    public void measure() {
    }




}
