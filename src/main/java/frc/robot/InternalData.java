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

package frc.robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.RobotState;
import edu.wpi.first.wpilibj.Timer;

public class InternalData {
	static ADXRS450_Gyro gyro;

	// Match stats

	/**********************************************************************************
	 * Is the robot in auto mode?
	 **********************************************************************************/
	
	public boolean isAuto() {
		return  RobotState.isAutonomous();
	}

	/**********************************************************************************
	 * Or is it in teleop mode?
	 **********************************************************************************/
	
	public boolean isTeleop() {
		return  RobotState.isTeleop();
	}

	/**********************************************************************************
	 *  Or is it just enabled at all?
	 **********************************************************************************/
	
	public boolean isEnabled() {
		return  RobotState.isEnabled();
	}

	/**********************************************************************************
	 * Get the time left in the match
	 **********************************************************************************/
	
	public double getMatchTime() {
		return  Timer.getMatchTime();
	}

	/**********************************************************************************
	 * Get battery voltage
	 **********************************************************************************/
	
	public double getVoltage() {
		return RobotController.getBatteryVoltage();
	}

	/**********************************************************************************
	 **********************************************************************************/
	
	public void initGyro() {
		if(gyro == null) {
			try {
				gyro = new ADXRS450_Gyro();
			} catch(Exception e) {
				gyro = null;
			}
		}
	}

	/**********************************************************************************
	 **********************************************************************************/
	
	public void resetGyro() {
		if(gyro != null) {
			gyro.reset();
		}
	}

	/**********************************************************************************
	 **********************************************************************************/
	
	public double getGyroAngle() {
		if(gyro != null) {
			return gyro.getAngle();
		} else {
			return 0;
		}
	}

}