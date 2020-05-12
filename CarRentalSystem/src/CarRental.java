import java.io.*;
import javax.swing.JOptionPane;

public class CarRental {
	
	private Car[]carlist;
	private int numOfCars;
	
	CarRental(int size) {
		
		carlist=new Car[size];
		
	}
	
	void addCar(Car c) {
		
		if(numOfCars>=carlist.length)
			JOptionPane.showMessageDialog(null, "The cars list is full!");
		
		else {
			if(c instanceof Economy) {
				carlist[numOfCars++]=c;
				JOptionPane.showMessageDialog(null, "New Economy Car Added successfully");
			}
				
			else if(c instanceof VIP) {
					carlist[numOfCars++]=c;
					JOptionPane.showMessageDialog(null, "New VIP Car Added successfully");
				 }
			else
				JOptionPane.showMessageDialog(null, "the new car can't added succesfully");
			}
				
	}
	
	void saveToFile() throws IOException{
		
		ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("cars.dat"));
		
		oos.writeObject(carlist);
		oos.close();
		
	}
	
	void loadFromFile() throws IOException, ClassNotFoundException{
		
		ObjectInputStream ois=new ObjectInputStream(new FileInputStream("cars.dat"));
		
		carlist=(Car[])ois.readObject();
		ois.close();
		
	}
	
	void rentCar(String plateNo,Customer c,int numOfDay) throws IOException{
		String price="";
		PrintWriter pr=new PrintWriter(new FileOutputStream(c.getName()+"_"+c.getId()+".txt"));
		for(int i=0;i<numOfCars;i++)
			if(plateNo.toLowerCase().equals(carlist[i].getPlateNo().toLowerCase()))
				if(carlist[i].isAvailable()) {
					carlist[i].setCustomer(c);
					carlist[i].setAvailable(false);
					
					if(carlist[i] instanceof Economy) {
						price=((Economy)carlist[i]).printBill(numOfDay);
						JOptionPane.showMessageDialog(null,carlist[i].toString()+c.toString()+"\n"+price+"SR");
					}
					
					if(carlist[i] instanceof VIP) {
						price=((VIP)carlist[i]).printBill(numOfDay);
						JOptionPane.showMessageDialog(null,carlist[i].toString()+"\n"+price+"SR");
					}
					
				}
				else
					JOptionPane.showMessageDialog(null,"the car is not available");
			else
				JOptionPane.showMessageDialog(null,"the car plate number not found");
		
		pr.println(price);
		pr.close();
	
	}
	
	void returnCar(String plateNo) {
		
		for(int i=0;i<numOfCars;i++)
			if(plateNo.toLowerCase().equals(carlist[i].getPlateNo().toLowerCase()))
				if(!carlist[i].isAvailable()) {
					carlist[i].setAvailable(true);
					carlist[i].setCustomer(null);
					JOptionPane.showMessageDialog(null,"the car is found and returned");
				}
				else
					JOptionPane.showMessageDialog(null,"the car is already available!!");
			else
				JOptionPane.showMessageDialog(null,"the car plate number not found");
		
	}
	
	VIP[]searchAvailableVIP(){
		
		int count=0;
		for(int i=0;i<numOfCars;i++)
			if(carlist[i] instanceof VIP && carlist[i].isAvailable())
				count++;
		VIP[]VIPList=new VIP[count];
		
		count=0;
		for(int i=0;i<numOfCars;i++)
			if(carlist[i] instanceof VIP && carlist[i].isAvailable())
				VIPList[count++]=((VIP)carlist[i]);
		
		return VIPList;
		
	}
	
	Economy[]searchAvailableEconomy(){
		
		int count=0;
		for(int i=0;i<numOfCars;i++)
			if(carlist[i] instanceof Economy && carlist[i].isAvailable())
				count++;
		Economy[]EconomyList=new Economy[count];
		
		count=0;
		for(int i=0;i<numOfCars;i++)
			if(carlist[i] instanceof Economy && carlist[i].isAvailable())
				EconomyList[count++]=((Economy)carlist[i]);
		
		return EconomyList;
		
	}
	
	Car getCar(String PN) {
		
		for(int i=0;i<numOfCars;i++)
			if(PN.equals(carlist[i].getPlateNo()))
				return carlist[i];
		return null;
		
	}


}
