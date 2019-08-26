package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public abstract class TrollBot extends OpMode{

    public DcMotor FR;
    public DcMotor FL;
    public DcMotor BR;
    public DcMotor BL;

    public void init(){

        FR = hardwareMap.dcMotor.get("FR");
        FL = hardwareMap.dcMotor.get("FL");
        BR = hardwareMap.dcMotor.get("BR");
        BL = hardwareMap.dcMotor.get("BL");

    }

    public void startMotors(double l, double r){

        FR.setPower(r);
        BR.setPower(r);
        FL.setPower(l);
        BL.setPower(l);

    }

    public void stopMotors(){

        FR.setPower(0);
        BR.setPower(0);
        FL.setPower(0);
        BL.setPower(0);

    }
}