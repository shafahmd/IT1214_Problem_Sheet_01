

class Vehicle{
	private String licensePlate;
	private String ownerName;
	private int hoursParked;
	
	Vehicle(String licensePlate,String ownerName,int hoursParked){
		this.licensePlate=licensePlate;
		this.ownerName=ownerName;
		this.hoursParked=hoursParked;
	}
	
	String getLicensePlate(){
		return licensePlate;
	}
	
	String getOwnerName(){
		return ownerName;
	}
	
	int getHoursParked(){
		return hoursParked;
	}
	
	public void displayDetails(){
		System.out.println(licensePlate+"\t\t"+ownerName+"\t\t"+hoursParked);
	}
}

class ParkingLot{
	private Vehicle[] vehicles;
	private static int parkCount;
	
	public ParkingLot(){
		this.vehicles= new Vehicle[5];
		this.parkCount=0;
	}
	
	public void addVehicle(Vehicle vehicle){
		if(parkCount<5){
			vehicles[parkCount++]=vehicle;
			System.out.println("Vehicle has been parked.");
		}
		else{
			System.out.println("Parking lot is full.");
		}
	}
	
	public void removeVehicle(String licensePlate){
		for(int i=0;i<parkCount;i++){
			if(vehicles[i].getLicensePlate()==licensePlate){
				int j=i+1;
				while(i<parkCount && j<parkCount){
					vehicles[i]=vehicles[j];
					i++;
					j++;
				}
				vehicles[parkCount-1]=null;
				parkCount=parkCount-1;
			}
		}
	}
	
	public void displayAllDetails(){
		if(parkCount==0){
			System.out.println("No vehicle is parked.");
		}
		else{
			for(int i=0;i<parkCount;i++){
				vehicles[i].displayDetails();
			}
		}
	}
	
}

class Main{
	public static void main(String[] args){
		ParkingLot p1=new ParkingLot();
		p1.addVehicle(new Vehicle("ABC123","John Doe",2));
		p1.addVehicle(new Vehicle("XYZ789","Jane Smith",4));
		p1.addVehicle(new Vehicle("LMN456","Bob Brown",1));
		p1.displayAllDetails();
		p1.removeVehicle("XYZ789");
		p1.displayAllDetails();
	}
}
