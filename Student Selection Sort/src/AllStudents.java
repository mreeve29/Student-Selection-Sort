import java.util.ArrayList;

public class AllStudents {
	private ArrayList<StudentInfo> students;
	
	public AllStudents() {
		students = new ArrayList<StudentInfo>();
	}
	
	
	public ArrayList<StudentInfo> averageSort(){
		ArrayList<StudentInfo> sorted = new ArrayList<StudentInfo>(students);
		ArrayList<Double> averages = new ArrayList<Double>();
		
		for(StudentInfo i : students) {
			averages.add(i.getFinalAverage());
		}
		
		for(int i = 0; i < sorted.size()-1; i++) {
			int min_index = i;
			for(int j = i+1; j < sorted.size(); j++) {
				if(averages.get(j) > averages.get(min_index)) {
					min_index = j;
				}
			}
			
			double temp = averages.get(min_index);
			averages.set(min_index, averages.get(i));
			averages.set(i, temp);
			
			StudentInfo tempS = sorted.get(min_index);
			sorted.set(min_index, sorted.get(i));
			sorted.set(i, tempS);
			
		}
		
		return sorted;
	}
	
	public ArrayList<StudentInfo> nameSort(){
		ArrayList<StudentInfo> sorted = new ArrayList<StudentInfo>(students);
		ArrayList<String> names = new ArrayList<String>();
		
		for(StudentInfo i : students) {
			names.add(i.getName());
		}
		
		for(int i = 0; i < sorted.size()-1; i++) {
			int min_index = i;
			for(int j = i+1; j < sorted.size(); j++) {
				if(names.get(j).toLowerCase().compareTo(names.get(min_index).toLowerCase()) < 0) {
					min_index = j;
				}
			}
			
			String temp = names.get(min_index);
			names.set(min_index, names.get(i));
			names.set(i, temp);
			
			StudentInfo tempS = sorted.get(min_index);
			sorted.set(min_index, sorted.get(i));
			sorted.set(i, tempS);
			
		}
		
		return sorted;
	}
	
	
	public void addStudent(StudentInfo s) {
		students.add(s);
	}
	
	public ArrayList<StudentInfo> getStudents(){
		return students;
	}
	
	
}
