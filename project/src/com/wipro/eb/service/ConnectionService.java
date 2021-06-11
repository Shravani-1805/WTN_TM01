package com.wipro.eb.service;
import com.wipro.eb.entity.Connection;
import com.wipro.eb.exception.InvalidReadingException;

public class ConnectionService {
	public boolean validate ( int cr, int pr, String t) throws InvalidReadingException{
		boolean valid=true;
	
		if(cr<pr || cr<0 || pr<0) {
			valid = false;
			throw new InvalidReadingException(); 
		}
		if (!(t.equalsIgnoreCase("Commercial") || t.equalsIgnoreCase("Domestic"))) {
			valid=false;
			throw new InvalidReadingException();
		}
		return valid;
	}
	public float calculateBillAmt(int cr,int pr,String t) {
		float result=0;
		try {
			
		if (this.validate(cr, pr, t)) {
			Connection c;
			if(t.equalsIgnoreCase("Commercial")) 
				c= new Commercial(cr,pr);
				else c=new Domestic(cr,pr);
				result=c.computeBill();
			
		}

		}
		catch(InvalidReadingException ire) {
			return -1;
		}
		catch(InvalidConnectionException ice) {
			return -2;
		}
		return result;
	}
	public String generateBill(int cr,int pr,String t) {
		float result=this.calculateBillAmt(cr,pr,t);
		if(result==-1) return "Incorrect reading";
		if (result==-2) return "Invalid Connection type";
		
			System.out.println("Invalid Connection Type");
	}
}
