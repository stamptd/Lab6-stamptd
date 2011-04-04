import static org.junit.Assert.*;

import java.util.Date;
import java.util.Locale;

import javax.xml.ws.ServiceMode;

import org.junit.Before;
import org.junit.Test;

public class TestPrintBalance {
	private static String name;
	private static Date today;
	private PrintBalance german(){
		return new PrintBalance(new Locale("de","DE"));
	}
	private PrintBalance english(){
		return new PrintBalance(new Locale("en","US"));
	}
	private PrintBalance french(){
		return new PrintBalance(new Locale("fr","FR"));
	}
	@Before
	public void setup(){
		TestPrintBalance.name = "Bob Flanders";
		TestPrintBalance.today = new Date(0);
		
	}
	@Test
	public void testEnglish(){
		PrintBalance printer = english();
		assertEquals("Hello World",printer.hello());
		assertEquals("Please enter your name",printer.enterName());
		assertEquals("I am pleased to meet you " + name,printer.nameString(name));
		assertEquals("As of : December 31, 1969",printer.dateString(today));
		assertEquals("You owe the school $9,876,543.21",printer.owed(9876543.21));
		assertEquals("Good Bye",printer.bye());
	}
	@Test
	public void testFrench(){
		PrintBalance printer = french();
		assertEquals("Bonjour monde",printer.hello());
		assertEquals("Entrez-vous votre nom s'il vous-plait",printer.enterName());
		assertEquals("Enchant�, " + name,printer.nameString(name));
		assertEquals("En date du : 31 d�cembre 1969",printer.dateString(today));
		assertEquals("Vous devez l'�cole 9�876�543,21 �",printer.owed(9876543.21));
		assertEquals("Au revoir",printer.bye());
	}
	@Test
	public void testGerman(){
		PrintBalance printer = german();
		assertEquals("Hallo Welt",printer.hello());
		assertEquals("Bitte geben Sie Ihren Namen",printer.enterName());
		assertEquals("Ich freue mich, Sie kennen zu lernen " + name,printer.nameString(name));
		assertEquals("Ab: 31. Dezember 1969",printer.dateString(today));
		assertEquals("Sie schulden die Schule 9.876.543,21 �",printer.owed(9876543.21));
		assertEquals("Lebewohl",printer.bye());
	}

}
