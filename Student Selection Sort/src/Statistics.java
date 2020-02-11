import java.util.ArrayList;

public class Statistics {
	
	private ArrayList<Double> averages;
	private AllStudents all;
	
	public Statistics(AllStudents s) {
		averages = new ArrayList<Double>();
		all = s;
	}
	
	public double getMean() {
		setAverages();
		double total = 0;
		for(double i : averages) {
			total += i;
		}
		return total / averages.size();
	}
	
	//finds the median
	public double getMedian() {
		setAverages();
		if(averages.size() % 2 == 0) {
			//even -> 2 nums at middle
			double num1 = averages.get(averages.size()/2);
			double num2 = averages.get(averages.size()/2-1);
			return (num1 + num2)/2.0;
		}else {
			//odd -> 1 num at middle
			return averages.get(averages.size()/2);
		}
	}
	
	//finds the mode(s)
	public ArrayList<Double> getModes() throws NoModeException{
		setAverages();
		ArrayList<Double> key = new ArrayList<Double>();
		ArrayList<Double> value = new ArrayList<Double>();
		
		for(double i : averages) {
			if(!key.contains(i)) {
				key.add(i);
				value.add(0.0);
			}
		}
		for(double i : averages) {
			int current = key.indexOf(i);
			value.set(current, value.get(current) + 1);
		}
		
		ArrayList<Double> modes = new ArrayList<Double>();
		
		double highestOcc = 0;
		
		for(int i = 0; i < value.size(); i++) {
			if(value.get(i) > highestOcc) {
				modes.clear();
				modes.add(key.get(i));
				highestOcc = value.get(i);
			}else if (value.get(i) == highestOcc) {
				modes.add(key.get(i));
			}
		}
		
		if(highestOcc == 1 && averages.size() >  1) {
			throw new NoModeException("No Mode in List");
		}
		
		return modes;
	}
	
	//calculates standard deviation
	public double getStandardDeviation() {
		setAverages();
		double mean = getMean();
		
		double total = 0;
		for(double i : averages) {
			total += Math.pow(i - mean,2);
		}
		double secondMean = total / averages.size();
		
		return Math.sqrt(secondMean);
	}
	
	private void setAverages() {
		averages.clear();
		for(StudentInfo i : all.getStudents()) {
			averages.add(i.getFinalAverage());
		}
	}
	
	
}
