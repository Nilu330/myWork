package espocrm_testng;

import org.testng.TestNG;

//create Executable Jar File

public class Runnable_EpsoCRM {

	public static void main(String[] args) 
	{
		System.out.println("Running EspoCRM Test");
		TestNG test=new TestNG();
		test.setTestClasses(new Class[] {Main_Class_EspoCRM.class});
		test.run();
	
	}

}
