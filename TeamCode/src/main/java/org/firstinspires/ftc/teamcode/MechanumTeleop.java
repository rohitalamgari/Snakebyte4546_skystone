package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

//eventually we will want to refactor the name of this class
@TeleOp(name = "Skystone TeleOp", group = "4546")
public class MechanumTeleop extends OpMode {

    //declaring all of our things up here, don't do it in the init
    RobotSkystone robot = new RobotSkystone();
    double deadZone = 0.1;

    @Override
    public void init() {
        //init is only for initializing the robot and other things such as
        //Vuforia Key Tokens, although we will probably not use those here

        robot.init(hardwareMap, telemetry);
    }

    //this is where we do our calculations for sending power to the motors so it can
    //move in all directions
    //calculates this via a weighted Average
    public double weightAvg(double x, double y, double z){
        double power = 0;
        if ((Math.abs(x) + Math.abs(y) + Math.abs(z)) != 0){
            power = ((x * Math.abs(x)) + (y * Math.abs(y)) + (z * Math.abs(z)))
                    /(Math.abs(x) + Math.abs(y) + Math.abs(z));
        }
        return power;
    }

    @Override
    public void loop() {
        double fwd = gamepad1.right_stick_y;
        double strafe = gamepad1.right_stick_x;
        double turn = gamepad1.left_stick_x;

        if (Math.abs(fwd) > deadZone){ fwd = fwd;}
        else { fwd = 0; }

        if (Math.abs(turn) > deadZone){ turn = turn;}
        else { turn = 0; }

        if (Math.abs(strafe) > deadZone){ strafe = strafe;}
        else { strafe = 0; }


        robot.driveTrain.mtrFR.setPower(weightAvg(fwd,strafe,turn));
        robot.driveTrain.mtrFL.setPower(weightAvg(fwd,strafe,turn));
        robot.driveTrain.mtrBR.setPower(weightAvg(fwd,strafe,turn));
        robot.driveTrain.mtrBL.setPower(weightAvg(fwd,strafe,turn));

    }
}

