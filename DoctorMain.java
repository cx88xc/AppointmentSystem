import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;

//import Schedule.Appointment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DoctorMain {

	private JFrame frame;
	private JTextField txtTitle;
	private JTextField txtDescription;
	private JComboBox cboDate;
	private JComboBox cboStartTime;
	private JComboBox cboEndTime;
	private JComboBox cboWho;
	private ArrayList<Appointment> apptList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoctorMain window = new DoctorMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DoctorMain() {
		initialize();
		Appointment myAppt = new Appointment();
		apptList= myAppt.Initialize();
		//test();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 693, 308);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtTitle = new JTextField();
		txtTitle.setBounds(95, 16, 288, 26);
		frame.getContentPane().add(txtTitle);
		txtTitle.setColumns(10);
		
		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setBounds(11, 19, 69, 20);
		frame.getContentPane().add(lblTitle);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(11, 50, 69, 20);
		frame.getContentPane().add(lblDate);
		
		 cboDate = new JComboBox();
		cboDate.setBounds(95, 47, 89, 26);
		cboDate.addItem("10/10/1990");
		frame.getContentPane().add(cboDate);
		
		JLabel lblStartTime = new JLabel("Start Time:");
		lblStartTime.setBounds(11, 86, 89, 20);
		frame.getContentPane().add(lblStartTime);
		
		 cboStartTime = new JComboBox();
		cboStartTime.setBounds(95, 83, 121, 26);
		LoadTime(cboStartTime);
		frame.getContentPane().add(cboStartTime);
		
		JLabel lblEndTime = new JLabel("End Time:");
		lblEndTime.setBounds(251, 86, 89, 20);
		frame.getContentPane().add(lblEndTime);
		
		 cboEndTime = new JComboBox();
		cboEndTime.setBounds(340, 84, 104, 24);
		LoadTime(cboEndTime);
		frame.getContentPane().add(cboEndTime);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(11, 123, 89, 20);
		frame.getContentPane().add(lblDescription);
		
		txtDescription = new JTextField();
		txtDescription.setBounds(122, 125, 491, 26);
		frame.getContentPane().add(txtDescription);
		txtDescription.setColumns(10);
		
		JLabel lblWithWho = new JLabel("With Who?");
		lblWithWho.setBounds(11, 159, 109, 20);
		frame.getContentPane().add(lblWithWho);
		
		 cboWho = new JComboBox();
		cboWho.setBounds(132, 156, 371, 26);
		cboWho.addItem("Ryan");
		frame.getContentPane().add(cboWho);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AddItem();
				test();
			}
		});
		btnAdd.setBounds(468, 15, 115, 29);
		frame.getContentPane().add(btnAdd);
		
		JButton btnCalendar = new JButton("Calendar");
		btnCalendar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ApptCalendar cal = new ApptCalendar();
				cal.initialize(cal);
			}
		});
		btnCalendar.setBounds(468, 216, 115, 29);
		frame.getContentPane().add(btnCalendar);
	}
private void test(){
	Appointment appt = new Appointment();
	//Initialize the List for debugging purposes
	//ArrayList<Appointment> apptList = appt.Initialize();
	System.out.print(apptList.size());
for (int i= 0; i< apptList.size(); i++){
	System.out.print("list = " + apptList.get(i).apptTitle);
}

}
private void AddItem(){
	Appointment appt = new Appointment();
	System.out.print(cboDate.getItemCount());
	String tmpDate = cboDate.getSelectedItem().toString();

	String tmpStartTime = cboStartTime.getSelectedItem().toString();
	String tmpEndTime = cboEndTime.getSelectedItem().toString();
	String tmpWho = cboWho.getSelectedItem().toString();
	appt.addAppointment(apptList, txtTitle.getText(),tmpDate , tmpStartTime,tmpEndTime, txtDescription.getText(), tmpWho);
	
}
private void LoadTime(JComboBox<String> inCBO){
	inCBO.addItem("01:01:00");
	inCBO.addItem("02:02:00");

}
}
