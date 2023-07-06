package stepDefinition;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.gherkin.model.Feature;

import Base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class Hooks extends BaseClass{
	
	
	@After(order=1)
	public void tearDown(Scenario scenario) throws Throwable {
		
		System.err.println(scenario.getStatus());
		System.err.println(scenario.getId());
		System.err.println(scenario.getName());
		System.err.println(scenario.getClass());
		
		
		Thread.sleep(3000);
		//ScreenShot for all failure to attach in Email
		if (scenario.isFailed()) {
			TakesScreenshot ts = (TakesScreenshot) driver;
		    File source = ts.getScreenshotAs(OutputType.FILE);
		    FileUtils.copyFile(source, new File("./ScreenShot/"+scenario.getName()+".png"));
		    System.out.println("ScreenShot Taken");
		} else {}
		 
		
		// Screenshot for all failure to add in Cucumber HTML Report *****
		//WebDriver driver = null;
		 if(scenario.isFailed())
	        {
	       
			 byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
             scenario.attach(screenshot, "image/png", Feature.getGherkinName());
	        
             Thread.sleep(5000);
            // mail_report();
	        }       
		

		 // Mail Level
		
		 if (!(scenario.isFailed())) {
		//	 mail_report();
		} else {

		}
			if (scenario.isFailed()) {
		//		mail_report();
			//	BaseClass.writeData("Mail", 2, 1, "2");
			} else {
				
				BaseClass.writeData("Mail", 1, 1, "1");
				BaseClass.writeData("Mail", 2, 1, "1");
				BaseClass.writeData("Mail", 3, 1, "1");

			}
			
			
			
			String level1 = getExcelDataUrl("Mail", 1, 1);
			System.out.println(level1);
			String level2 = getExcelDataUrl("Mail", 2, 1);
			System.out.println(level2);
			String level3 = getExcelDataUrl("Mail", 3, 1);
			System.err.println(level3);
			
			if (level3.equals("2")) {
			//	mail_report();
				
			} else {
				
			}
			
			if (level2.equals("2")) {
				mail_report();
				BaseClass.writeData("Mail", 3, 1, "2");
			} else {

			}
			
			if (scenario.isFailed()) {
			//		mail_report();
					BaseClass.writeData("Mail", 2, 1, "2");
				}
		
		System.out.println("After scenario executed successfully");
		
	}
	
	@After(order=0)
	private void mail() {
		System.out.println("Sending Mail");
	//	mail_report();
	}
	
	//////////////////////////////////////////
	
	public static void screenshot(WebDriver driver, long ms)
	{

	try {
	    TakesScreenshot ts = (TakesScreenshot) driver;
	    File source = ts.getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(source, new File("./ScreenShot/m1.png"));
	    System.out.println("ScreenShot Taken");
	} 
	catch (Exception e) 
	{
	    System.out.println("Exception while taking ScreenShot "+e.getMessage());
	}


	}
	
	
	////////////////////////////////////

	public static void mail_report() {
		
	  final String username = "application.alert@netmeds.com";
	  final String password = "hrdggllzsubiapzp"; 
	  
	  
	 /* final String username = "cbsautomationreport@gmail.com";
	final String password = "cbstest123"; */
	Date date=new Date();
	  Properties props = new Properties();
	  props.put("mail.smtp.auth", true);
	  props.put("mail.smtp.starttls.enable", true);
	  props.put("mail.smtp.host", "smtp.gmail.com");
	  props.put("mail.smtp.port", "587");

	  Session session = Session.getInstance(props, new javax.mail.Authenticator() {
	      protected PasswordAuthentication getPasswordAuthentication() {
	          return new PasswordAuthentication(username, password);
	      }
	  });
	  Message message = new MimeMessage(session);

	  try {

	     // message.setFrom(new InternetAddress("cbsautomationreport@gmail.com"));
	      message.setFrom(new InternetAddress("application.alert@netmeds.com"));
	      message.setSubject("Take Action Alert Mail"+date);

	     message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("amudhan.nagarajan@netmeds.com,amudhan.nagarajan@ril.com"));
	      //message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(,balasanthoshkumar.r@netmeds.com)
	      Multipart multipart = new MimeMultipart();

	      MimeBodyPart messageBodyPart = new MimeBodyPart();
	      messageBodyPart.setText("Hi Team,"+"\n\n"+"Looks like some functionality  is unstable in the Netmeds Application.."+"\n"+"\n"+"\n"+"\n\n\n"+"Regards,"+"\n"+"Automation Testing Team.");
	      MimeBodyPart attachmentBodyPart = new MimeBodyPart();
	      String file = System.getProperty("user.dir")+"/Report/PdfReport/Extentpdf.pdf";  // File To Attach
	      
	      String file1 = System.getProperty("user.dir")+"/ScreenShot/Search the any of the Product and add into the Cart and Place the Order.png";
	      BodyPart attachmentBodyPart1 = new MimeBodyPart();
	      DataSource source1 = new FileDataSource(file1);
	      // messageBodyPart.setDataHandler(new DataHandler(source));
	      attachmentBodyPart1.setDataHandler(new DataHandler(source1));
	       DataSource source = new FileDataSource(file);
	       // messageBodyPart.setDataHandler(new DataHandler(source));
	       attachmentBodyPart.setDataHandler(new DataHandler(source));
	       //attachmentBodyPart.setText(file);
	       attachmentBodyPart.setFileName(file);
	       attachmentBodyPart1.setFileName(file1);

	       multipart.addBodyPart(messageBodyPart);
	       multipart.addBodyPart(attachmentBodyPart);
	       multipart.addBodyPart(attachmentBodyPart1);
	       
	       /*

	     String file = "D:\\WorkSpace\\Cucumber\\Report\\HtmlReports";  // File To Attach
	   //   String url=currentUrl;

	      //String fileName = "CBS-AutomationReport-Desktop";
	      DataSource source = new FileDataSource(file);
	      messageBodyPart.setDataHandler(new DataHandler(source));
	    //  attachmentBodyPart.setDataHandler(new DataHandler(source));
	      attachmentBodyPart.setText(file);
	      //attachmentBodyPart.setFileName("Login.png");

	      multipart.addBodyPart(messageBodyPart);
	      multipart.addBodyPart(attachmentBodyPart);
*/
	      message.setContent(multipart);
	      

	      System.out.println("Sending....");

	      Transport.send(message);

	      System.out.println("Mail Sent Successfully");

	  } catch (MessagingException e) {
	      e.printStackTrace();
	  }
		

	}

	

	

}
