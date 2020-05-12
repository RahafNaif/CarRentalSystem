public class VIP extends Car{
	
	private Driver d;
	
	VIP(String plate,double price,String model,String color,Driver d) {
		
		super(plate,price,model,color);
		this.d=d;
		
	}
	
	public String printBill(int days) {
		
		double bill=(pricePerDay*days)+(days*100);
		return bill+"";
			
	}

	
	public String toString() {
		return super.toString()+ d ;
	}
	
	

}
