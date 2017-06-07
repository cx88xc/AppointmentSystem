import java.awt.EventQueue;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ApptCalendar {

	private JFrame frame;
	private JTable tblApptCalendar;
	private JComboBox<Integer> cboYear;
	private JComboBox<String> cboMonth;
	

	public  ApptCalendar()  {

	}


	/**
	 * @wbp.parser.entryPoint
	 */
	public void initialize(ApptCalendar window) {
		try {
			frame = new JFrame();
			frame.setBounds(100, 100, 537, 347);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			tblApptCalendar = new JTable();
			tblApptCalendar.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
				},
				new String[] {
					"New column", "New column", "New column", "New column", "New column", "New column", "New column"
				}
			));
			tblApptCalendar.setRowHeight(45);
			tblApptCalendar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tblApptCalendar.setBounds(35, 59, 465, 225);
			frame.getContentPane().add(tblApptCalendar);
			
			 cboMonth = new JComboBox();
			cboMonth.setBounds(100, 16, 136, 26);
			cboMonth.addItem("January");
			cboMonth.addItem("February");
			cboMonth.addItem("March");
			cboMonth.addItem("April");
			cboMonth.addItem("May");
			cboMonth.addItem("June");
			cboMonth.addItem("July");
			cboMonth.addItem("August");
			cboMonth.addItem("September");
			cboMonth.addItem("October");
			cboMonth.addItem("November");
			cboMonth.addItem("December");
			frame.getContentPane().add(cboMonth);
			
			JLabel lblMonth = new JLabel("Month");
			lblMonth.setBounds(16, 16, 69, 20);
			frame.getContentPane().add(lblMonth);
			
			JLabel lblYear = new JLabel("Year");
			lblYear.setBounds(366, 19, 69, 20);
			frame.getContentPane().add(lblYear);
			
			 cboYear = new JComboBox();
			cboYear.setBounds(439, 16, 61, 26);
			for (int i = 1901; i<2100; i++){
				cboYear.addItem(i);
			}
			frame.getContentPane().add(cboYear);
			
			JButton btnFormatCal = new JButton("Format Cal");
			btnFormatCal.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					FormatApptCalendar();
				}
			});
			btnFormatCal.setBounds(247, 14, 115, 29);
			frame.getContentPane().add(btnFormatCal);
			window.frame.setVisible(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
		FormatApptCalendar();
	}
	private void FormatApptCalendar(){
		//** Use the month and year selected to find the day of week for the first of the month as well as the total number 
		//** of days in that month.  Then fill in the ApptCalendar days from there.
		int year = (int) cboYear.getSelectedItem();
		int month = (int) cboMonth.getSelectedIndex()+1;
		System.out.print("Month = " + month);
		int day = 1;
		Calendar cal = Calendar.getInstance();
		//cal.set(year,  month, day);
		cal.set(2017,  7, 1);
		System.out.print("Year = " + cal.get(Calendar.YEAR));
		System.out.print("Month = " + cal.get(Calendar.MONTH));
		System.out.print("Day = " + cal.get(Calendar.DAY_OF_MONTH));
		int dow = cal.get(Calendar.DAY_OF_WEEK);//* Determines the day of week for the 1st of this month
		int num_days = cal.getActualMaximum(Calendar.DAY_OF_MONTH);//** Number of days in this month in this year
		
		//**clear current table values
		System.out.print(" DOW = " + dow);
		
		for (int x = 0; x< tblApptCalendar.getRowCount(); x++){
			for (int y = 0; y<tblApptCalendar.getColumnCount(); y++ ){
				tblApptCalendar.setValueAt(null, x, y);
			}
		}
		//** Set values ## Still need logic to loop throgh remaining days - just set the 1st day for now
		tblApptCalendar.setValueAt(1, 1, dow-1);
		}
}
