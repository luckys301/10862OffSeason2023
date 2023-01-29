package org.firstinspires.ftc.teamcode.TeleOps.Misc;

import static org.firstinspires.ftc.teamcode.subsystems.Claw.*;
import static org.firstinspires.ftc.teamcode.subsystems.TurnServo.F_POS_S3;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
@Disabled
@TeleOp
public class ClawServoTest extends OpMode {
    //hardware initialization stuff
//    Servo servo3;
    Servo servo2;
    double pos = F_POS_S3, pos2 = CLOSE_POS_S1;

    /**
     * User defined init method
     * <p>
     * This method will be called once when the INIT button is pressed.
     */
    @Override
    public void init() {
//        servo3 = hardwareMap.get(Servo.class, "clawS3");
        servo2 = hardwareMap.get(Servo.class, "clawS2");
    }

    /**
     * User defined loop method
     * <p>
     * This method will be called repeatedly in a loop while this op mode is running
     */
    @Override
    public void loop() {
//        if(gamepad1.a){
//            pos -= 0.001;
//        }
//        else if(gamepad1.y){
//            pos += 0.001;
//        }

        if(gamepad1.dpad_down){
            pos2 -= 0.001;
        }
        else if(gamepad1.dpad_up){
            pos2 += 0.001;
        }

        if(gamepad1.right_bumper){
//            pos = CLOSE_POS_S1;
            pos2  = CLOSE_POS_S1;
        }
        else if(gamepad1.left_bumper){
//            pos = OPEN_POS_S1;
            pos2  = OPEN_POS_S1;
        }


//        if(gamepad1.right_bumper){
//            clawS2.set(1);
//            telemetry.addData("Se21: ", servo1.getPosition());
//
//        }
//        else if(gamepad1.left_bumper){
//            clawS2.set(-1);
//            telemetry.addData("Sev-1: ", servo1.getPosition());
//
//        }
//        else{
//            clawS2.stop();
//        }

//         pos = Math.min(Math.max(pos, 0), 1);
//        servo3.setPosition(pos);
//        telemetry.addData("Servo pos1: ",servo3.getPosition());
//        telemetry.addData("Desired pos1: ", pos);

        pos2 = Math.min(Math.max(pos2, 0), 1);
        servo2.setPosition(pos2);
        telemetry.addData("Servo pos2: ",servo2.getPosition());
        telemetry.addData("Desired pos2: ", pos2);
        telemetry.update();

    }
}