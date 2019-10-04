package com.graphql.mortgages.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Utility {
	
	private static List<String> address = Arrays.asList(
			"Fifth Avenue, 542, New York"
		   ,"Sant Quarter, 253, Philadelphia"
		   ,"Miguel Cervantes, 23, Barcelona"
		   ,"Sant Gabriel, 1323, Ottawa"
		   ,"Antonio Marques, 76, Tarragona"
		   ,"Sao Cristovao, 232, São Paulo"
		   ,"Everglades Dino, 654, Florida"
		   );
	private static Random rndAddress = new Random(address.size() - 1);
	
	
	public static String address() {
		return address.get(rndAddress.nextInt());
	}
	
	private static List<String> company = Arrays.asList(
			"Apple"
		   ,"Google"
		   ,"Microsoft"
		   ,"Deutsche Bank"
		   ,"Santander"
		   ,"Banc Sabadell"
		   ,"Art Bo"
		   );
	private static Random rndCompany = new Random(company.size() - 1);
	
	
	public static String company() {
		return company.get(rndCompany.nextInt());
	}
	
	private static List<String> email = Arrays.asList(
			"jsmith@google.com"
		   ,"jja@outlook.com"
		   ,"rew09@sabis.tech"
		   ,"roberto@google.com"
		   ,"jstevens@google.com"
		   ,"tsantson@yahoo.com"
		   ,"quer7yh@google.com"
		   );
	private static Random rndEmail = new Random(email.size() - 1);
	
	
	public static String email() {
		return email.get(rndEmail.nextInt());
	}
	
	private static List<String> phone = Arrays.asList(
			"123 8784 343"
		   ,"0374 349 343"
		   ,"23432 434 22"
		   ,"123 653 222"
		   ,"091 233 765"
		   ,"982 434 123"
		   ,"549 341 333"
		   );
	private static Random rndPhone = new Random(phone.size() - 1);
	
	
	public static String phone() {
		return phone.get(rndPhone.nextInt());
	}
	
	private static List<String> dates = Arrays.asList(
			"10/10/2019"
		   ,"03/05/2018"
		   ,"23/10/2015"
		   ,"01/10/2005"
		   ,"07/01/1975"
		   ,"12/05/1948"
		   ,"03/04/1969"
		   );
	private static Random rndDates = new Random(dates.size() - 1);
	
	
	public static String dates() {
		return dates.get(rndDates.nextInt());
	}

}
