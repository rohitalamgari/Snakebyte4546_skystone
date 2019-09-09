package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class tankDrive extends robotPart {
    public DcMotor mtrL = null;
    public DcMotor mtrR = null;


    public void init(HardwareMap hwmap, Telemetry myTelemetry){
        super.init(hwmap, myTelemetry);
        mtrL = hwmap.dcMotor.get("mtrFL");
        mtrR = hwmap.dcMotor.get("mtrFR");
    }

    public void forward(double power){
        mtrL.setPower(power);
        mtrR.setPower(power);
    }

    public void turn(double power){
        mtrL.setPower(-power);
        mtrR.setPower(power);
    }
}
