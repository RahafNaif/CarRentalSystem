public class Economy extends Car{
	
	Economy(String plate,double price,String model,String color){
		
		super(plate,price,model,color);
		
	}
	
	public String printBill(int days) {
		
		double bill=pricePerDay*days;
		
		if(days>7)
			return bill-(bill*0.20)+"";
		
		return bill+"";
			
		
	}
	
}
