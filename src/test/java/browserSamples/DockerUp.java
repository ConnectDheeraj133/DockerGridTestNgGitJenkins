package browserSamples;

import static org.testng.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DockerUp {
	
	
	
	public void makeDockerup() throws IOException, InterruptedException {
		boolean check = false;
		File file=new File("outputlog.txt");
		if(file.exists());
		file.delete();	
	Runtime run=Runtime.getRuntime(); 
	run.exec("cmd /c start dockerup.bat");
	System.out.println("cmd satrt");
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.SECOND, 120);
		long aftertime=cal.getTimeInMillis();
		System.out.println(aftertime);
		Thread.sleep(10000);
		String file1="outputlog.txt ";
		System.out.println("before while");
		while(System.currentTimeMillis()<aftertime) {
			System.out.println("first while");
		BufferedReader readfile=new BufferedReader(new FileReader(file1));
		String line=readfile.readLine();
		System.out.println("***"+line+"***"+check+"888");
		while(line!=null&check!=true) {
			System.out.println("secnd found");
		if(line.contains("The node is registered to the hub and ready to use")) {
			check=true;
			System.out.println("output found");
			break ;
		}
		line=readfile.readLine();	
		}
	
		readfile.close();	
		System.out.println("before second break");
		break;
		}
		
		Assert.assertTrue(check);
		run.exec("cmd /c start ScaleChrome.bat");
		run.exec("cmd /c start ScaleFirefox.bat");
		Thread.sleep(15000);
		
	}
	
	
	

}
