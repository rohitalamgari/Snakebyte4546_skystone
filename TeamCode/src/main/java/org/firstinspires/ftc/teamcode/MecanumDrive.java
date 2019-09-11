package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;

import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;

import java.util.Locale;

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

    //gyro
    public BNO055IMU gyro;
    Orientation angles;
    Acceleration gravity;
    BNO055IMU.Parameters parameters;

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

        //gyro parameters
        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        parameters.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        parameters.calibrationDataFile = "AdafruitIMUCalibration.json";
        parameters.loggingEnabled = true;
        parameters.loggingTag = "IMU";
        parameters.accelerationIntegrationAlgorithm = new JustLoggingAccelerationIntegrator();
        gyro = hwmap.get(BNO055IMU.class, "imu");
        gyro.initialize(parameters);
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
    public void strafeLeft(double power){
        mtrFL.setPower(-power);
        mtrBR.setPower(-power);
        mtrFR.setPower(power);
        mtrBL.setPower(power);
    }

    public void strafeRight(double power)
    {
        mtrFL.setPower(power);
        mtrBR.setPower(power);
        mtrFR.setPower(-power);
        mtrBL.setPower(-power);
    }

    public void updateValues(){
        angles = gyro.getAngularOrientation();
    }

    public boolean resetGyro(){
        return gyro.initialize(parameters);
    }

    //returns positive angle to turn right & negative angle to turn left
    public double angleDiff(double goalAngle) {
        double currAngle = gyroYaw();
        if (currAngle >= 0 && goalAngle >= 0 || currAngle <= 0 && goalAngle <= 0) { //curr & goal are both positive or both negative
            return -(currAngle - goalAngle);
        } else if (Math.abs(currAngle - goalAngle) <= 180) {//diff btwn curr & goal is less than or equal to 180
            return -(currAngle - goalAngle);
        } else if (currAngle > goalAngle) {//curr is greater than goal
            return (360 - (currAngle - goalAngle));
        } else {//goal is greater than curr
            return -(360 + (currAngle - goalAngle));
        }
    }

    //gyro method to get yaw
    public double gyroYaw(){
        updateValues();
        double yaw = angles.firstAngle * -1;
        if (angles.firstAngle < -180){
            yaw -= 360;
        }
        return yaw;
    }

    //gyro method to get pitch
    public double gyroPitch(){
        updateValues();
        double pitch = angles.secondAngle;
        return pitch;
    }

    //gyro method to get roll
    public double gyroRoll(){
        updateValues();
        double roll = angles.thirdAngle;
        return roll;
    }

    String formatAngle(AngleUnit angleUnit, double angle) {
        return formatDegrees(AngleUnit.DEGREES.fromUnit(angleUnit, angle));
    }

    String formatDegrees(double degrees){
        return String.format(Locale.getDefault(), "%.1f", AngleUnit.DEGREES.normalize(degrees));
    }

}
