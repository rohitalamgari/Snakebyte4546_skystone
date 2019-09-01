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

public class Sensors extends robotPart{

    public BNO055IMU gyro;
    Orientation angles;
    Acceleration gravity;

    //init method to set parameters and hwmap sensors
    public void init(HardwareMap hwmap, Telemetry myTelemetry){
        super.init(hwmap, myTelemetry);
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

    public void updateValues(){
        angles = gyro.getAngularOrientation();
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
