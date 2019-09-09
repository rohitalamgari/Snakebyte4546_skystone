package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class MecanumDrive extends robotPart {
    // declaring our motors
    public DcMotor mtrFL = null;
    public DcMotor mtrFR = null;
    public DcMotor mtrBL = null;
    public DcMotor mtrBR = null;

    //method for declaring our sensors
    Sensors sensors = new Sensors();


    //these are the variables for
    int encodersPerRev = 1120;
    double wheelCircumference = Math.PI * (100/2.54);


    public void init(HardwareMap hwmap, Telemetry myTelemetry) {
        super.init(hwmap, myTelemetry);
        //initialize your motors, setting mode, and direction
        mtrFL = hwmap.dcMotor.get("mtrFL");
        mtrFR = hwmap.dcMotor.get("mtrFR");
        mtrBL = hwmap.dcMotor.get("mtrBL");
        mtrBR = hwmap.dcMotor.get("mtrBR");


        //these directions may have to change based upon which ways the Drive Train is actually geared/belted/chained
        mtrFL.setDirection(DcMotorSimple.Direction.FORWARD);
        mtrBL.setDirection(DcMotorSimple.Direction.FORWARD);
        mtrFR.setDirection(DcMotorSimple.Direction.REVERSE);
        mtrBR.setDirection(DcMotorSimple.Direction.REVERSE);

        mtrFL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        mtrFR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        mtrBL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        mtrBR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        //initializing our sensors
        sensors.init(hwmap, myTelemetry);
    }

    //this method sends power so that the robot will move in forwards/backwards vectors
    public void forward(double power){
        mtrFL.setPower(power);
        mtrFR.setPower(power);
        mtrBL.setPower(power);
        mtrBR.setPower(power);
    }

    //this method sends power so that the robot rotates on its center axis point
    public void turn(double power){
        mtrFL.setPower(power);
        mtrBL.setPower(power);
        mtrFR.setPower(-power);
        mtrBR.setPower(-power);
    }

    //this method sends power so that the robot will move in left/right vectors
    //power is based upon what type of wheel the motor is spinning
    public void strafe(double power){
        mtrFL.setPower(-power);
        mtrBR.setPower(-power);
        mtrFR.setPower(power);
        mtrBL.setPower(power);
    }

}
