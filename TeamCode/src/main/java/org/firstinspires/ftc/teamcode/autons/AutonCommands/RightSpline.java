package org.firstinspires.ftc.teamcode.autons.AutonCommands;

import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.commands.DriveCommands.AutoCommands.SplineCommand;
import org.firstinspires.ftc.teamcode.commands.IntakeAndDropConeCommands.DropAutoConeCommand;
import org.firstinspires.ftc.teamcode.commands.PickConeAutoCommands.PrePickBConeCommands.*;
import org.firstinspires.ftc.teamcode.commands.Slide.SlideFCommands.SlideHighFCommand;
import org.firstinspires.ftc.teamcode.subsystems.Arm;
import org.firstinspires.ftc.teamcode.subsystems.Claw;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.Slide;
import org.firstinspires.ftc.teamcode.util.PoseStorage;


public class RightSpline extends SequentialCommandGroup{
    public RightSpline(Drivetrain drivetrain, Slide slide, Arm arm, Claw claw){
        /*Turn is Counterclockwise*/
        addCommands(
                new ParallelCommandGroup(
                        new SlideHighFCommand(slide, arm, claw, true),
                        new SplineCommand(drivetrain, new Vector2d(58.8, 8.4), Math.toRadians(32))    //Cycle
                ),
                new DropAutoConeCommand(claw, slide, arm, true),
                new ParallelCommandGroup(
                        new PrePickB5Command(slide, claw, arm),
                        new SplineCommand(drivetrain, new Vector2d(52.5, -23), Math.toRadians(268), true)   //Load
                ),


                new ParallelCommandGroup(
                        new SlideHighFCommand(slide, arm, claw, true),
                        new SplineCommand(drivetrain, new Vector2d(58.8, 8.4), Math.toRadians(32), PoseStorage.cycle)    //Cycle
                ),
                new DropAutoConeCommand(claw, slide, arm, true),
                new ParallelCommandGroup(
                        new PrePickB5Command(slide, claw, arm),
                        new SplineCommand(drivetrain, new Vector2d(52.5, -23), Math.toRadians(268), PoseStorage.load, true)   //Load
                )


//                new ParallelCommandGroup(
//                        new SlideHighFCommand(slide, arm, claw, true),
//                        new SplineCommand(drivetrain, new Vector2d(58.8, 8.4), Math.toRadians(32), PoseStorage.cycle)    //Cycle
//                ),
//                new DropAutoConeCommand(claw, slide, arm, true),
//                new ParallelCommandGroup(
//                        new PrePickB5Command(slide, claw, arm),
//                        new SplineCommand(drivetrain, new Vector2d(52.5, -23), Math.toRadians(268), PoseStorage.load, true)   //Load
//                ),
//
//                new ParallelCommandGroup(
//                        new SlideHighFCommand(slide, arm, claw, true),
//                        new SplineCommand(drivetrain, new Vector2d(58.8, 8.4), Math.toRadians(32), PoseStorage.cycle)    //Cycle
//                ),
//                new DropAutoConeCommand(claw, slide, arm, true),
//                new ParallelCommandGroup(
//                        new PrePickB5Command(slide, claw, arm),
//                        new SplineCommand(drivetrain, new Vector2d(52.5, -23), Math.toRadians(268), PoseStorage.load, true)   //Load
//                ),
//
//                new ParallelCommandGroup(
//                        new SlideHighFCommand(slide, arm, claw, true),
//                        new SplineCommand(drivetrain, new Vector2d(58.8, 8.4), Math.toRadians(32), PoseStorage.cycle)    //Cycle
//                ),
//                new DropAutoConeCommand(claw, slide, arm, true),
//                new ParallelCommandGroup(
//                        new PrePickB5Command(slide, claw, arm),
//                        new SplineCommand(drivetrain, new Vector2d(52.5, -23), Math.toRadians(268), PoseStorage.load, true)   //Load
//                ),
//
//
//                new ParallelCommandGroup(
//                        new SlideHighFCommand(slide, arm, claw, true),
//                        new SplineCommand(drivetrain, new Vector2d(58.8, 8.4), Math.toRadians(32), PoseStorage.cycle)    //Cycle
//                ),
//                new DropAutoConeCommand(claw, slide, arm, true),
//                new ParallelCommandGroup(
//                        new PrePickB5Command(slide, claw, arm),
//                        new SplineCommand(drivetrain, new Vector2d(52.5, -23), Math.toRadians(268), PoseStorage.load, true)   //Load
//                ),
//
//
//                /**Cone 1**/
//                new ParallelCommandGroup(
//                        new SlideHighFCommand(slide, arm, claw, true),
//                        new SplineCommand(drivetrain, new Vector2d(58, 8.5), Math.toRadians(23), PoseStorage.cycle)    //Cycle
//                ),
//                new DropAutoConeCommand(claw, slide, arm, true),
//
//                new SplineCommand(drivetrain, new Vector2d(58,8.5), Math.toRadians(0))
//                new TurnToCommand(drivetrain, 0) - Can't Use without IMU
        );
    }
}