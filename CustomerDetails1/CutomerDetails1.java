package com.Ebrain;
import java.util.ArrayList;     //nandha, nandha@gmail.com,Thanjavur,tamilnadu,India
import java.util.Collections;   //Madhavan,madhavan@gmail.com,Thanjavur,tamilnadu,India
import java.util.Comparator;    //AjithKumar,ajith@gmail.com,Trichy,TamilNdu,India
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class CutomerDetails1 {
    private String name;
    private String email;
    private String city;
    private String state;
    private String country;

    public CutomerDetails1(String name, String email, String city, String state, String country) {
    	
        this.name = name;
        this.email = email;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of customers: ");
        int numCustomers = input.nextInt();

        List<CutomerDetails1> customers = new ArrayList<CutomerDetails1>();

        for (int i = 0; i < numCustomers; i++) {
            System.out.printf("Enter details for customer %d:%n", i+1);
            System.out.print("Name: ");
            String name = input.next();
            System.out.print("Email: ");
            String email = input.next();
            System.out.print("City: ");
            String city = input.next();
            System.out.print("State: ");
            String state = input.next();
            System.out.print("Country: ");
            String country = input.next();

            CutomerDetails1 customer = new CutomerDetails1(name, email, city, state, country);
            customers.add(customer);}
        

            // Display customer details
            System.out.println("--------------------------------------Display Customer Details:------------------------------------------");
            
            for(CutomerDetails1 customer : customers) {
            System.out.println("Name:"+customer.name +"    "+"Email:"+ customer.email +"    "+"City:"+ customer.city +"    "+"State:"+ customer.state +"    "+"Country:"+ customer.country); 
            }                   
        

        Map<String, Integer> cityCounts = new HashMap<String,Integer>();

        for (CutomerDetails1 customer : customers) {
            String city = customer.city;
            int count = cityCounts.getOrDefault(city, 0);
            cityCounts.put(city, count + 1);
        }

        List<Map.Entry<String, Integer>> entries = new ArrayList<Entry<String, Integer>>(cityCounts.entrySet());
        Collections.sort(entries, new Comparator<Entry<String, Integer>>() {
			public int compare(Entry<String, Integer> a, Entry<String, Integer> b) {
				return b.getValue().compareTo(a.getValue());
			}
		});

        System.out.println("-------------------------------------------Customer comes from cities-------------------------------------");
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println( "City:"+ entry.getKey() +"-------------------->"+  entry.getValue());
        }
    }
}
