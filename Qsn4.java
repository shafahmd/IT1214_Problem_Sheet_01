
class Ticket{
	int ticketNumber;
	String customerName;
	int seatnumber;
	
	Ticket(int ticketNumber,String customerName,int seatnumber){
		this.ticketNumber=ticketNumber;
		this.customerName=customerName;
		this.seatnumber=seatnumber;
	}
	
	int getTicketNumber(){
		return ticketNumber;
	}
	
	String getCustomerName(){
		return customerName;
	}
	
	int getSeatNumber(){
		return seatnumber;
	}
	
	public void displayDetails(){
		System.out.println(ticketNumber+"\t\t"+customerName+"\t\t"+seatnumber);
	}
}

class BookingSystem{
	int[] bookedseat=new int[10];
	int[] canceledseat=new int[10];
	private Ticket[] tickets;
	int no_of_seatsbooked;
	int i=1;
	int canceledseats=0;
	int b=0;
	
	public BookingSystem(){
		this.tickets= new Ticket[10];
		this.no_of_seatsbooked=0;
	}
	
	
	public int booking(){
		bookedseat[no_of_seatsbooked]=i;
		no_of_seatsbooked=no_of_seatsbooked+1;
		i++;
		return i-1;
	}
	
	public void bookingseat(Ticket ticket){
		if(canceledseats==0){
			if(no_of_seatsbooked<10){
				tickets[no_of_seatsbooked-1]=ticket;
				System.out.println("Your booking is successful and your seat no is "+bookedseat[no_of_seatsbooked-1]);
			}
			else{
				System.out.println("Housefull no more tickets available.");
			}
		}
		else{
			for(int c=0;c<canceledseats;c++){
				no_of_seatsbooked=no_of_seatsbooked+1;
				if(canceledseat[c]==ticket.getSeatNumber()){
					bookedseat[no_of_seatsbooked-1]=ticket.getSeatNumber();
					tickets[no_of_seatsbooked-1]=ticket;
				}
			}
		}
	}
	
	public void cancelticket(int seatnumber){
		for(int j=0;j<no_of_seatsbooked;j++){
			if(bookedseat[j]==seatnumber){
				canceledseats=canceledseats+1;
				canceledseat[b]=seatnumber;
				System.out.println("\nYour booking has been canceled for seat no "+seatnumber);
				int a=j+1;
				while(j<no_of_seatsbooked && a<no_of_seatsbooked){
					tickets[j]=tickets[a];
					j++;
					a++;
				}
				tickets[no_of_seatsbooked-1]=null;
				no_of_seatsbooked=no_of_seatsbooked-1;
			}
		}
	}
	
	public void displayAllDetails(){
		if(no_of_seatsbooked==0){
			System.out.println("No booking available.");
		}
		else{
			System.out.println("\nBooking details ");
			for(int d=0;d<no_of_seatsbooked;d++){
				tickets[d].displayDetails();
			}
		}
	}
}

class Main{
	public static void main(String[] args){
		int c=0;
		BookingSystem b1=new BookingSystem();
		b1.bookingseat(new Ticket(++c,"Alice",b1.booking()));
		b1.bookingseat(new Ticket(++c,"Bob",b1.booking()));
		b1.bookingseat(new Ticket(++c,"Namal",b1.booking()));
		b1.displayAllDetails();
		b1.cancelticket(2);
		b1.displayAllDetails();
		b1.bookingseat(new Ticket(++c,"Bob",2));
		b1.displayAllDetails();
	}
}
