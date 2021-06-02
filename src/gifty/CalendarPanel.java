package gifty;

import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;

import com.mindfusion.common.DateTime;
import com.mindfusion.scheduling.Calendar;
import com.mindfusion.scheduling.ThemeType;
import com.mindfusion.scheduling.model.Appointment;
import com.mindfusion.scheduling.model.Recurrence;

@SuppressWarnings("serial")
public class CalendarPanel extends JPanel {
	
	public static JList<String> datesList;
	
	public static DefaultListModel<String> datesListDLM;

	public CalendarPanel() {
		setLayout(null);
		setBounds(137, 148, 733, 349);
		setBackground(new Color(100, 149, 237));

		Calendar calendar = new Calendar();
		calendar.setBounds(196, 41, 340, 270);
		calendar.setTheme(ThemeType.Light);
		
		DateTime dt = new DateTime(Login.userDateOfBirth);
		
		Appointment app = new Appointment();
		app.setStartTime(dt);
		app.setEndTime(dt);
		app.setHeaderText("Naslov");
		
		Recurrence rec = new Recurrence();
		
		rec.setStartDate(dt);
		rec.setDays(2);
		rec.setMonthOfYear(6);
		rec.setEndDate(dt);
		
		app.setRecurrence(rec);
		
		calendar.getSchedule().getItems().add(app);
		
		add(calendar);
	}
}
