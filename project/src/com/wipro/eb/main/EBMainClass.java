package com.wipro.eb.main;
import com.wipro.eb.entity.*;
import com.wipro.eb.service.ConnectionService;

public class EBMainClass {
	public static void main(String[] args) {
	
		System.out.println(new ConnectionService().generateBill(300,100,"Domestic"));
	}

}
