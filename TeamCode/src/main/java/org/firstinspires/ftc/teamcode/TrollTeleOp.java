package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "TrollBotTeleOp", group = "opMode")
public class TrollTeleOp extends TrollBot{

    public void loop(){

        boolean tank = true;
        if (gamepad1.left_bumper) tank = false;
        if (gamepad1.right_bumper) tank = true;

        if (tank){
            startMotors(-gamepad1.left_stick_y, -gamepad1.right_stick_y);
        }

    }

}