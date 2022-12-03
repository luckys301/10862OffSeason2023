package org.firstinspires.ftc.teamcode.commands.PickConeAutoCommands.Back;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.commands.DriveCommands.AutoCommands.DriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.DriveCommands.AutoCommands.SlowDriveForwardCommand;
import org.firstinspires.ftc.teamcode.subsystems.Arm;
import org.firstinspires.ftc.teamcode.subsystems.ClawServos;
import org.firstinspires.ftc.teamcode.subsystems.DrivetrainCOrrect;
import org.firstinspires.ftc.teamcode.subsystems.Slide;

public class PickC1BCommand extends SequentialCommandGroup{
    public PickC1BCommand(Slide slide, ClawServos clawServos, Arm arm, DrivetrainCOrrect drivetrainCorrect){
        addCommands(
//                new InstantCommand(arm::moveIntakeB),
//                new InstantCommand(clawServos::clawOpen),
//                new InstantCommand(slide::slideCone1),
//                new SlowDriveForwardCommand(drivetrain, 5),
//                new InstantCommand(clawServos::clawClose),
//                new WaitCommand(50),
//                new InstantCommand(slide:: slideLow)


                new SlowDriveForwardCommand(drivetrainCorrect, -3),
                new InstantCommand(clawServos::clawClose),
                new WaitCommand(100),
                new InstantCommand(slide:: slideLow),
                new DriveForwardCommand(drivetrainCorrect, 4)
        );
    }
}