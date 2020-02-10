import java.awt.Font;
import java.util.ArrayList;

import javax.swing.*;

import BreezySwing.*;

public class AddStudentDialog extends GBDialog {

	private AllStudents as;
	private ArrayList<Double> tests;
	private ArrayList<Double> quizes;
	
	private JLabel nameLabel = addLabel("Name:",1,1,1,1);
	private JTextField nameField = addTextField("",1,2,1,1);
	
	private JLabel testLabel = addLabel("Add Test Grades(up to 5)",2,1,1,1);
	private DoubleField testField = addDoubleField(0,2,2,1,1);
	private JButton testButton = addButton("Add Test Grade",3,2,1,1);
	
	private JLabel quizLabel = addLabel("Add Quiz Grades(up to 8)",4,1,1,1);
	private DoubleField quizField = addDoubleField(0,4,2,1,1);
	private JButton quizButton = addButton("Add Quiz Grade",5,2,1,1);
	
	private JLabel hwAverageLabel = addLabel("Homework Average:",6,1,1,1);
	private DoubleField hwField = addDoubleField(0,6,2,1,1);
	
	private JLabel currentTestsLabel = addLabel("Current Tests:",7,1,1,1);
	private JTextArea currentTestsArea = addTextArea("",8,1,1,1);
	
	private JLabel currentQuizesLabel = addLabel("Current Quizes:",7,2,1,1);
	private JTextArea currentQuizesArea = addTextArea("",8,2,1,1);
	
	private JButton addButton = addButton("Add Student",9,2,1,1);
	
	public void buttonClicked(JButton button) {
		if(button == testButton) {
			if(!testField.isValidNumber()) {
				messageBox("Please eneter a valid number");
				return;
			}
			if(tests.size() < 5) {
				double test = testField.getNumber();
				if(test < 0 || test > 100) {
					messageBox("Test must be between 0 and 100");
					return;
				}
				tests.add(test);
				updateTests();
				if(tests.size() >= 5) {
					testButton.setEnabled(false);
				}
			}
		}else if(button == quizButton) {
			if(!quizField.isValidNumber()) {
				messageBox("Please eneter a valid number");
				return;
			}
			if(quizes.size() < 8) {
				double quiz = quizField.getNumber();
				if(quiz < 0 || quiz > 100) {
					messageBox("Quiz must be between 0 and 100");
					return;
				}
				quizes.add(quiz);
				updateQuizes();
				if(quizes.size() >= 8) {
					quizButton.setEnabled(false);
				}
			}
		}else if(button == addButton) {
			//error check first
			if(isBlank(nameField.getText())) {
				messageBox("Empty name");
				return;
			}
			
			double hwAverage = hwField.getNumber();
			if(hwAverage < 0 || hwAverage > 100) {
				messageBox("Homework average must be within 0 and 100");
				return;
			}
			
			int response = JOptionPane.showConfirmDialog(null,"Are you sure you want to add: \n" + getStudentInfo(), "Add " + nameField.getText() + "?", JOptionPane.YES_NO_OPTION);
			if(response == JOptionPane.YES_OPTION) {
				as.addStudent(new StudentInfo(nameField.getText(),tests,quizes,hwAverage));
			}
		}
	}
	
	public AddStudentDialog(JFrame parent, AllStudents all) {
		super(parent);
		as = all;
		currentTestsArea.setEditable(false);
		currentQuizesArea.setEditable(false);
		
		currentTestsArea.setFont(new Font("Sans-Serif",0,16));
		currentQuizesArea.setFont(new Font("Sans-Serif",0,16));
		
		tests = new ArrayList<Double>();
		quizes = new ArrayList<Double>();
		
		setTitle("Add Student");
		setSize(700,750);
		setVisible(true);
	}

	private void updateTests(){	
		currentTestsArea.setText(tests.toString().substring(1,tests.toString().length()-1).replaceAll(",", "\n").replaceAll(" ", ""));
	}
	
	private void updateQuizes(){	
		currentQuizesArea.setText(quizes.toString().substring(1,quizes.toString().length()-1).replaceAll(",", "\n").replaceAll(" ", ""));
	}
	
	//error checking helper method
	private boolean isBlank(String s) {
		for(int i = 0; i < s.length(); i++) {
			if(!Character.isWhitespace(s.charAt(i))) return false;
		}
		return true;
	}
	
	
	private String getStudentInfo() {
		String info = "";
		info += "Name: " + nameField.getText() + '\n'+
				"Test Grades: " + tests.toString().substring(1,tests.toString().length()-1) + '\n' +
				"Quiz Grades: " + quizes.toString().substring(1,quizes.toString().length()-1) + '\n' +
				"Homework Average: " + hwField.getNumber();
		return info;
	}
	
	
}
