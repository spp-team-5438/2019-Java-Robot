/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.XboxController;

 public class Pneumatics {

    //define solenoids and compressor
    DoubleSolenoid solenoid = new DoubleSolenoid(3, 0);
    Compressor compressor = new Compressor();

    //define controller
    XboxController controller = new XboxController(0);

    public void main() {
        //set the compressor mode to turn on when pressure low and vice-versa
        compressor.setClosedLoopControl(true);

        //set the solenoid to extend when A is pressed and retract when X is pressed
        if (controller.getAButtonPressed()) {
            solenoid.set(Value.kForward);
            System.out.println("Extending Solenoid!");
        }
        else if (controller.getXButtonPressed()) {
            solenoid.set(Value.kReverse);
            System.out.println("Retracting Solenoid!");
        }
        else {
            solenoid.set(Value.kOff);
        }
    }
}
