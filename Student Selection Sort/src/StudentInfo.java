import java.util.ArrayList;

public class StudentInfo{

	private String name;
	private ArrayList<Double> tests;
	private ArrayList<Double> quizes;
	private double hwAverage;
	private double finalAverage;
	
	public StudentInfo() {
		name = "";
		tests = new ArrayList<Double>();
		quizes = new ArrayList<Double>();
		hwAverage = 0;
		finalAverage = 0;
	}
	
	public StudentInfo(String n, ArrayList<Double> ts, ArrayList<Double> qs, double hw) {
		name = n;
		tests = ts;
		quizes = qs;
		hwAverage = hw;
		finalAverage = calculateFinalAverage();
	}
	
	private double calculateFinalAverage() {
		//final average=0.5(Test Average)+0.3(Quiz Average)+0.2( Homework Average)
		double test = average(tests);
		if(Double.isNaN(test))test = 0;
		double quiz = average(quizes);
		if(Double.isNaN(quiz))quiz = 0;
		double average = 0.5 * test + 0.3 * quiz + 0.2 * hwAverage;
		return average;
	}
	
	private double average(ArrayList<Double> t) {
		double total = 0;
		for(double i : t) {
			total += i;
		}
		return total / t.size();
	}
	
	public void setName(String n) {
		name = n;
	}

	public void setTests(ArrayList<Double> t) {
		tests = t;
		calculateFinalAverage();
	}
	
	public void setTest(int pos, double score) {
		tests.set(pos, score);
		calculateFinalAverage();
	}
	
	public void setQuizes(ArrayList<Double> q) {
		quizes = q;
		calculateFinalAverage();
	}
	
	public void setQuiz(int pos, double score) {
		quizes.set(pos, score);
		calculateFinalAverage();
	}
	
	public void setHWAverage(double average) {
		hwAverage = average;
		calculateFinalAverage();
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<Double> getTests() {
		return tests;
	}
	
	public double getTest(int test) {
		return tests.get(test);
	}
	
	public ArrayList<Double> getQuizes() {
		return quizes;
	}
	
	public double getQuiz(int quiz) {
		return quizes.get(quiz);
	}
	
	public double getHWAverage() {
		return hwAverage;
	}
	
	public double getFinalAverage() {
		return finalAverage;
	}
	
	public String getInfo() {
		String info = "";
		info += "Name: " + getName() + '\n'+
				"Test Grades: " + tests.toString().substring(1,tests.toString().length()-1) + '\n' +
				"Quiz Grades: " + quizes.toString().substring(1,quizes.toString().length()-1) + '\n' +
				"Homework Average: " + getHWAverage() + "\n" +
				"Final Average: " + getFinalAverage();
		return info;
	}

}
