package org.firstinspires.ftc.teamcode.autons.Misc;

import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.autons.AutonCommands.JustONECone;
import org.firstinspires.ftc.teamcode.autons.AutonCommands.LeftSpline;
import org.firstinspires.ftc.teamcode.autons.LeftStrafe;
import org.firstinspires.ftc.teamcode.driveTrainAuton.MatchOpMode;
import org.firstinspires.ftc.teamcode.subsystems.Claw;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.MecanumDrive;
import org.firstinspires.ftc.teamcode.subsystems.Arm;
import org.firstinspires.ftc.teamcode.subsystems.SensorColor;
import org.firstinspires.ftc.teamcode.subsystems.Slide;
import org.firstinspires.ftc.teamcode.subsystems.TurnServo;

@Autonomous(group = "RED/BLUE")
public class TestAutonWithoutCam extends MatchOpMode {

    // Subsystems
    private Arm arm;
    private Claw claw;
    private Drivetrain drivetrain;
    private Slide slide;
    private TurnServo turnServo;
    private SensorColor sensorColor;

//    public MecanumDrive mecanumDrive;


    @Override
    public void robotInit() {
        claw = new Claw( telemetry, hardwareMap);
        arm = new Arm(telemetry, hardwareMap);
        slide = new Slide(telemetry, hardwareMap);
        turnServo = new TurnServo(telemetry, hardwareMap);
        sensorColor = new SensorColor(hardwareMap, telemetry);
        drivetrain = new Drivetrain(new MecanumDrive(hardwareMap, telemetry, false), telemetry, hardwareMap);
        drivetrain.init();
    }


    public void matchStart() {
//        waitForStart();
        schedule(
                new SequentialCommandGroup(
                        new JustONECone(drivetrain, slide, arm, claw, turnServo, sensorColor)
//                        new LeftStrafe(drivetrain, slide, arm, turnServo, sensorColor, claw)
//                        new RightSpline(drivetrain, slide, arm, claw)
//                      new LeftSpline(drivetrain, slide, arm, claw, turnServo, sensorColor)
//                        new Test(drivetrain, slide, arm, claw, turnServo)
                )
        );
//        PoseStorage.currentPose = drivetrain.getPoseEstimate();
    }


};