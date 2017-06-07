import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Appointment {
	//should be private for later
	public int id;
	public String apptTitle;
	public String apptDate;
	public String startTime;
	public String endTime;
	public String apptDesc;
	public String apptWithWho;
	
public Appointment(){

	
}

 public ArrayList<Appointment> Initialize(){
	// Initialize the DB ( ArrayList) for debugging purposes
	//Ultimately we'll load this from the DB to initialize
	
	//May need these if we decide to store these as date and time formats instead of strings
	DateFormat format = new SimpleDateFormat("MM/DD/YYYY", Locale.ENGLISH);
	SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a"); //if 24 hour format
	
	ArrayList<Appointment> myArray=new ArrayList<Appointment>();
	Appointment newAppt = new Appointment();
	//ITEM 1
	this.addAppointment(myArray, "Title 1", "01/23/2000", "05:06:00", "07:04:00", "New Desc 1", "New Guy1");
	//Item 2
	this.addAppointment(myArray, "Title 2", "02/23/2000", "05:06:00", "07:04:00", "New Desc 2", "New Guy2");
	//Item 3
	this.addAppointment(myArray, "Title 3", "07/23/2000", "05:06:00", "07:04:00", "New Desc 3", "New Guy3");
	
	return myArray;
}
public void addAppointment(ArrayList<Appointment> myArray,  String inApptTitle,
							String inApptDate, String inApptStartTime, String inApptEndTime,
							String inApptDesc, String inApptWithWho){
	
	Appointment newAppt = new Appointment();
	newAppt.id = myArray.size()-1;
	newAppt.apptTitle = inApptTitle;
	newAppt.apptDate = inApptDate;
	newAppt.startTime = inApptStartTime;
	newAppt.endTime =  inApptEndTime;
	newAppt.apptDesc = inApptDesc;
	newAppt.apptWithWho = inApptWithWho;
	myArray.add(newAppt);
}
}
