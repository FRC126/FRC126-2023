/**********************************
	   _      ___      ____
	 /' \   /'___`\   /'___\
	/\_, \ /\_\ /\ \ /\ \__/
	\/_/\ \\/_/// /__\ \  _``\
	   \ \ \  // /_\ \\ \ \L\ \
	    \ \_\/\______/ \ \____/
		 \/_/\/_____/   \/___/

    Team 126 2023 Code       
	Go get em gaels!

***********************************/

package frc.robot;

public class RobotMap {
	// Controls for Xbox 360 / Xbox One
	public static int lStickX = 0; // Left stick X
	public static int lStickY = 1; // Left stick Y
	public static int rStickX = 4; // Right stick X
	public static int rStickY = 5; // Right stick Y
	public static int Rtrigger = 3; // Right trigger
	public static int Ltrigger = 2; // Left trigger
	public static int xboxA = 1; // A
	public static int xboxB = 2; // B
	public static int xboxX = 3; // X
	public static int xboxY = 4; // Y
	public static int xboxLTrig = 5; // Left trigger button
	public static int xboxRTrig = 6; // Right trigger button
	public static int xboxBack = 7; // Back
	public static int xboxStart = 8; // Start
	public static int xboxLStick = 9; // Left stick button
	public static int xboxRStick = 10; // Right stick button

    // Tower Arm Can Bus ID
	public static int TowerArmMotorID = 25;
	public static int TowerArmMotorInversion;

	// Extension Can Bus ID
	public static int ExtensionMotorID = 26;
	public static int ExtensionMotorInversion;

	// Grabber Can Bus ID
	public static int GrabberMotorID = 27;
	public static int GrabberMotorInversion;
	
	// Driver Motor Can ID's
	public static int leftDriveMotorCanID1 = 12;
	public static int leftDriveMotorCanID2 = 13;
	public static int rightDriveMotorCanID1 = 10;
	public static int rightDriveMotorCanID2 = 11;

	//Motor Inversions
    public static int left1Inversion;
	public static int left2Inversion;
	public static int right1Inversion;
	public static int right2Inversion;

	//Position Calibrations
	public static void setRobot(double robotID){
		if(robotID == 0) { 
			// 2023 DriveBase
			TowerArmMotorInversion = 1; // Motor inversions
			GrabberMotorInversion = 1; // Motor inversions
			GrabberMotorInversion = 1; // Motor inversions
			left1Inversion     = 1;
			left2Inversion     = 1;
			right1Inversion    = -1;
			right2Inversion    = -1;
		} else { 
			// 2023 Breadboard
			TowerArmMotorInversion = 1; // Motor inversions
			GrabberMotorInversion = 1; // Motor inversions
			GrabberMotorInversion = 1; // Motor inversions
			left1Inversion     = 1;
			left2Inversion     = 1;
			right1Inversion    = 1;
			right2Inversion    = 1;
		}
	}

}
