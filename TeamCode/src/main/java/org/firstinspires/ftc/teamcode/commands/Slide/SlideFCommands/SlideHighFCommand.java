package org.firstinspires.ftc.teamcode.commands.Slide.SlideFCommands;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.subsystems.Arm;
import org.firstinspires.ftc.teamcode.subsystems.Claw;
import org.firstinspires.ftc.teamcode.subsystems.Slide;

public class SlideHighFCommand extends SequentialCommandGroup {
    public SlideHighFCommand(Slide slide, Arm arm, Claw claw, boolean auto){
        if (auto){
            addCommands(
                    new ParallelCommandGroup(
                            new InstantCommand(() ->
                                    new Thread(() -> {
                                        claw.clawClose();
                                        slide.slideAutoHigh();
                                        arm.moveHighFAuto();
                                    }).start())
                    ),
                    new WaitCommand(520),
                    new InstantCommand(claw::setFClawPos)
            );
        }
        else {
            addCommands(
                    new ParallelCommandGroup(
                            new InstantCommand(() ->
                                    new Thread(() -> {
                                        claw.clawClose();
                                        slide.slideHigh();
                                        arm.moveHighF();
                                    }).start())
                    ),
                    new WaitCommand(800),
                    new InstantCommand(claw::setFClawPos)
            );
        }
    }   
}
