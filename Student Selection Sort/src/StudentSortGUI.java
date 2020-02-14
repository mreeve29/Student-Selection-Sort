import BreezySwing.*;

import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.*;
public class StudentSortGUI extends GBFrame{
	
	//class objects
	private AllStudents allStudents;
	private Statistics stats;
	
	//swing elements
	private JButton addStudentButton = addButton("Add Student",1,1,1,1);
	private JButton nameSortButton = addButton("Sort by Name",2,1,1,1);
	private JButton averageSortButton = addButton("Sort by Final Average",3,1,1,1);
	
	private JMenuItem meanMI = addMenuItem("Compute","Mean");
	private JMenuItem medianMI = addMenuItem("Compute","Median");
	private JMenuItem modeMI = addMenuItem("Compute","Mode");
	private JMenuItem stdMI = addMenuItem("Compute","Standard Deviation");
	
	//constructor
	public StudentSortGUI() {
		allStudents = new AllStudents();
		stats = new Statistics(allStudents);
		setTitle("Student Sort");
		setSize(400,400);
		setVisible(true);
	}
	
	//main
	public static void main(String[] args) {
		new StudentSortGUI();
	}
	
	//button event listener
	public void buttonClicked(JButton button) {
		if(button == addStudentButton) {
			if(allStudents.size() < AllStudents.MAX_STUDENTS) {
				new AddStudentDialog(this, allStudents);
			}else {
				messageBox("Cannot add anymore students, max: " + AllStudents.MAX_STUDENTS);
			}
			
		}else if(button == nameSortButton) {
			if(allStudents.size() == 0) {
				messageBox("There are no students");
			}else {
				ArrayList<StudentInfo> sorted = allStudents.nameSort();
				String msg = "Students by name:\n";
				for(StudentInfo s : sorted) {
					msg += s.getInfo() + "\n\n";
				}
				messageBox(msg);
			}
		}else if(button == averageSortButton) {
			if(allStudents.size() == 0) {
				messageBox("There are no students");
			}else {
				ArrayList<StudentInfo> sorted = allStudents.averageSort();
				String msg = "Students by final average:\n";
				for(StudentInfo s : sorted) {
					msg += s.getInfo() + "\n\n";
				}
				messageBox(msg);
			}
		}
	}
	
	//menu event listener
	public void menuItemSelected(JMenuItem menuItem){
		if(menuItem == meanMI) {
			if(allStudents.getStudents().size() == 0) {
				messageBox("There are no students");
			}else {
				messageBox("The mean is " + round(stats.getMean()));
			}
		}else if(menuItem == medianMI) {
			if(allStudents.getStudents().size() == 0) {
				messageBox("There are no students");
			}else {
				messageBox("The median is " + stats.getMedian());
			}
		}else if(menuItem == modeMI) {
			if(allStudents.getStudents().size() == 0) {
				messageBox("There are no students");
				return;
			}
			ArrayList<Double> modes;
			try {
				modes = stats.getModes();
				messageBox("Mode: " + modes);
			}catch (NoModeException e) {
				messageBox("There is no mode");
			}
		}else if (menuItem == stdMI) {
			if(allStudents.getStudents().size() == 0) {
				messageBox("There are no students");
			}else {
				messageBox("The standard deviation is " + round(stats.getStandardDeviation()));
			}
		}
	}

	//rounds decimals
	private String round(double d) {
		DecimalFormat df = new DecimalFormat("##.##");
		return df.format(d);
	}
		
}
