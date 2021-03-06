package browserSamples;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class DockerDown {

	@AfterTest

	public void makeDockerdown() throws IOException, InterruptedException {

		boolean check = false;

		Runtime run=Runtime.getRuntime(); 
		Thread.sleep(10000);
		run.exec("cmd /c start dockerdown.bat");
		System.out.println("cmd start");
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.SECOND, 60);
		long aftertime=cal.getTimeInMillis();
		System.out.println(aftertime);
		Thread.sleep(10000);
		String file1="outputlog.txt ";
		System.out.println("before while");
		while(System.currentTimeMillis()<aftertime) {
			System.out.println("first while");
			BufferedReader readfile=new BufferedReader(new FileReader(file1));
			String line=readfile.readLine();
			System.out.println("***"+line+"***"+check+"***");
			while(line!=null&check!=true) {
				System.out.println("second while");
				if(line.contains("selenium-hub exited")) {
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

	}
}
