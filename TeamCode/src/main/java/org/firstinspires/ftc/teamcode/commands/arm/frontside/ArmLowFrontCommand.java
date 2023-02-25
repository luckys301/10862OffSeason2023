package org.firstinspires.ftc.teamcode.commands.arm.frontside;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.subsystems.Pivot;
import org.firstinspires.ftc.teamcode.subsystems.Claw;
import org.firstinspires.ftc.teamcode.subsystems.Slide;
import org.firstinspires.ftc.teamcode.subsystems.TurnServo;

public class ArmLowFrontCommand extends SequentialCommandGroup {
    public ArmLowFrontCommand(Slide slide, Pivot pivot, Claw claw, TurnServo turnServo, boolean auto) {
        if (auto){
            addCommands(

                    new InstantCommand(claw::clawClose),
                    new ParallelCommandGroup(
                            new InstantCommand(slide::slideLow),
                            new InstantCommand(pivot::moveFAuto)
                    ),
                    new WaitCommand(200),
                    new InstantCommand(turnServo::setFClawPos)
            );
        }
        else {
            addCommands(
                    new ParallelCommandGroup(
                            new InstantCommand(() ->
                                    new Thread(() -> {
                                        claw.clawClose();
                                        slide.slideLow();
                                        pivot.moveF();
                                    }).start())
                    ),
                    new WaitCommand(800),
                    new InstantCommand(turnServo::setFClawPos)
            );
        }
    }
}
