import java.io.Serializable;
public abstract class Car implements Payabel,Serializable{
    
	protected String plateNo;
    protected double pricePerDay;
    protected String model;
    protected String color;
    protected boolean available;
    protected Customer cr;

    Car(String plate, double price, String model, String color) {
        
    	plateNo = plate;
        pricePerDay = price;
        this.model = model;
        this.color = color;
        available=true; //means its doesn't rent it yet
        
    }

    void setCustomer(Customer c) {
        cr = c;
    }

    String getPlateNo() {
        return plateNo;
    }

    boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String toString() {
        return "\n Car information :" + "plateNo=" + plateNo + ", pricePerDay=" + pricePerDay + ", model=" + model + ", color=" + color + ", available=" + available ;
    }
    
    public abstract String printBill(int days);
    
    
    
    
    
    
    
}
