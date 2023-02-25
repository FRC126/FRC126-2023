/**********************************
	   _      ___      ____
	 /' \   /'___`\   /'___\
	/\_, \ /\_\ /\ \ /\ \__/
	\/_/\ \\/_/// /__\ \  _``\
	   \ \ \  // /_\ \\ \ \L\ \
	    \ \_\/\______/ \ \____/
		 \/_/\/_____/   \/___/
    Team 126 2022 Code       
	Go get em gaels!
***********************************/

package frc.robot.commands;

import frc.robot.Robot;
//import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.CommandBase;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**********************************************************************************
 **********************************************************************************/

 public class MoveTowerArm extends CommandBase {
    double targetPos;
    int iters;
    int targetReached=0;

	/**********************************************************************************
	 **********************************************************************************/
	
    public MoveTowerArm(double targetIn, int iters_in ) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        targetPos = targetIn;
        iters = iters_in;
        targetReached = 0;
    }

	/**********************************************************************************
     * Called just before this Command runs the first time
	 **********************************************************************************/
	
    public void initialize() {
    }

	/**********************************************************************************
     * Called repeatedly when this Command is scheduled to run
	 **********************************************************************************/
	
    public void execute() {

        double curPos=Robot.robotTowerArm.getPos();
        double speed=0;
        double driftTolerance=1.5;
        double maxSpeed=1;
        double minSpeed=.25;

        if (curPos < targetPos - driftTolerance) { 
            Robot.boundSpeed(((targetPos-curPos)/50), maxSpeed, minSpeed);
            targetReached=0;
        } else if (curPos > targetPos + driftTolerance) { 
            Robot.boundSpeed(((targetPos-curPos)/50), maxSpeed*-1, minSpeed*-1);
            targetReached=0;
        } else {
            speed=0;
            targetReached++;
            Robot.robotTowerArm.brakesOn();
        }

        Robot.robotTowerArm.MoveArm(speed);

    }

	/**********************************************************************************
     * Make this return true when this Command no longer needs to run execute()
	 **********************************************************************************/
	
    public boolean isFinished() {
        iters--;

        if (targetReached > 5 || iters <= 0) {
            // We have reached our target angle or run out of time to do so.
            Robot.robotTowerArm.cancel();
            return true;
        }

        return false;
    }

	/**********************************************************************************
     * Called once after isFinished returns true
	 **********************************************************************************/
	
    public void end(boolean isInteruppted) {
        Robot.robotTowerArm.cancel();
    }
}