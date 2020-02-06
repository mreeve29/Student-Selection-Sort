
public class StudentInfo implements Comparable<StudentInfo>{

	private String name;
	private double[] tests;
	private double[] quizes;
	private double hwAverage;
	private double finalAverage;
	
	public StudentInfo() {
		name = "";
		tests = new double[5];
		quizes = new double[8];
		hwAverage = 0;
		finalAverage = 0;
	}
	
	public StudentInfo(String n, double[] ts, double[] qs, double hw) {
		name = n;
		tests = ts;
		quizes = qs;
		hwAverage = hw;
		finalAverage = calculateFinalAverage();
	}
	
	private double calculateFinalAverage() {
		//final average=0.5(Test Average)+0.3(Quiz Average)+0.2( Homework Average)
		double test = average(tests);
		double quiz = average(quizes);
		return 0.5 * test + 0.3 * quiz + 0.2 * hwAverage;
	}
	
	private double average(double[] t) {
		double total = 0;
		for(double i : t) {
			total += i;
		}
		return total / t.length;
	}
	
	
	@Override
	public int compareTo(StudentInfo o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
