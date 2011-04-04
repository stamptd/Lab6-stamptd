import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * TODO A simple class that needs to be localized
 * 
 * @author mohan. Created Mar 27, 2010.
 */
public class PrintBalance {
	public Locale currentLocale;
	public ResourceBundle messages;
	/**
	 * Simple Java Method that is crying out to be localized.
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		PrintBalance printer = new PrintBalance(new Locale("fr","FR"));
		System.out.println(printer.hello());
		System.out.println(printer.enterName());
		Scanner scanInput = new Scanner(System.in);
		String name = scanInput.nextLine();
		System.out.println(printer.nameString(name));
		Date today = new Date();
		System.out.println(printer.dateString(today));
		System.out.println(printer.owed(9876543.21));
		System.out.println(printer.bye());
	}
	
	public PrintBalance(Locale currentLocale) {
		this.currentLocale = currentLocale;
		this.messages = ResourceBundle.getBundle("MessageBundle",currentLocale);
	}
	
	public String bye() {
		return messages.getString("goodbye");
		
	}
	public String owed(double d) {
		NumberFormat nf = NumberFormat.getCurrencyInstance(currentLocale);
		return String.format(messages.getString("youowe"),nf.format(9876543.21));
		
	}
	public String dateString(Date today) {
		DateFormat df = DateFormat.getDateInstance(DateFormat.LONG,currentLocale);
		return String.format(messages.getString("asof"),df.format(today));
		
	}
	public String nameString(String name) {
		return String.format(messages.getString("nicetomeetyou"),name);
		
	}
	public String enterName() {
		return messages.getString("entername");
		
	}
	public String hello() {
		return messages.getString("helloworld");
	}
}
