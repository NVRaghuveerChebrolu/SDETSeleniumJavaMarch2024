package swapnaAssignments;




		import java.io.IOException;

        import org.openqa.selenium.WebDriver;
        import com.utility.Library;

		public class assignmentsecond extends Library {
		
	    public static void main(String[] args) throws IOException {
		     
		  ReadPropertiesFile();
		 LaunchBrowser(); 
		driver.get(objProp.getProperty("walmartURL"));
		PageLoadTimeOut();

		 // driver.quit();
		

	}

}
