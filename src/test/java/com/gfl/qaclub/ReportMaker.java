package com.gfl.qaclub;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class ReportMaker {

	public static void main(String[] args) {
		//Run class 'JUnitWebDriverTest' using JUnitCore and assign result to the object 'result'
		Result result = JUnitCore.runClasses(JUnitWebDriverTest.class);
		//If test was run successfully
		if (result.wasSuccessful()) {
			//Print string "Success!"
			System.out.println("Success!");
			//If not
		} else {
			//Using loop for in the foreach variant
			for (Failure failure : result.getFailures()) {
				//Print string "Failure - " and message of exception with it
				System.err.println("Failure - " + failure.getMessage());
			}
		}

	}

}
