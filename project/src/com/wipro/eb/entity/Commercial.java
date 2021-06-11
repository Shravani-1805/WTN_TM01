package com.wipro.eb.entity;

public class Commercial extends Connection{
	public static final float[] slabs= {5.2f,6.8f,8.3f};
	Commercial(int cr, int pr){
		super(cr,pr);
		
	}
	public float computeBill() {
		int units = this.currentReading-this.previousReading;
	    float amount=(units<=50)?units*slabs[0]:((units<=100)?50*slabs[0]+(units-50)*slabs[1]:50*slabs[1]:50*slabs[0]);
	    return 
	}
	float duty(float amount) {
		if(amount>=10000) return 0.09f;
		if(amount>=5000) return 0.06f;
		return 0.02f;
	}

}
