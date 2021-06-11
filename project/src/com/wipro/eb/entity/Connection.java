package com.wipro.eb.entity;

public abstract class Connection {
	//member
	protected int previousReading;
	protected int currentReading;
	//protected float[] slabs;
	

	protected Connection(int cr, int pr){
		this.currentReading=cr;
		this.previousReading=pr;
	}
	public abstract float computeBill();  
}