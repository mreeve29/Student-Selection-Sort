import BreezySwing.*;

import java.util.ArrayList;

import javax.swing.*;
public class StudentSortGUI extends GBFrame{
	
	private AllStudents allStudents;
	
	private JButton addStudentButton = addButton("Add Student",1,1,1,1);
	private JButton nameSortButton = addButton("Sort by Name",2,1,1,1);
	
	public StudentSortGUI() {
		allStudents = new AllStudents();
		
		setTitle("Student Sort");
		setSize(400,400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new StudentSortGUI();
	}
	
	public void buttonClicked(JButton button) {
		if(button == addStudentButton) {
			new AddStudentDialog(this, allStudents);
		}else if(button == nameSortButton) {
			ArrayList<StudentInfo> sorted = allStudents.nameSort();
			String msg = "Students by name:\n";
			for(StudentInfo s : sorted) {
				msg += s.getInfo() + "\n\n";
			}
			messageBox(msg);
		}
	}

}
