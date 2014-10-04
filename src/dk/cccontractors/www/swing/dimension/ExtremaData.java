package dk.cccontractors.www.swing.dimension;

import java.util.LinkedList;

import dk.contractors.www.model.Stock;

public class ExtremaData {

	public ExtremaData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public double getMin() {
		return min;
	}
	public void setMin(double min) {
		this.min = min;
	}
	public double getMax() {
		return max;
	}
	public void setMax(double max) {
		this.max = max;
	}
	private double min;
	private double max;
	
	double[] data; 
	
	public ExtremaData(LinkedList<Stock> loopBack) {
		super();
		
		copy2doubleArray(loopBack, "VOLUME");
		
	}

	private double lowValue = 0;
	private double highValue = Double.MAX_VALUE;
	private double maxValueInSet;
	private double minValueInSet;

	private void copy2doubleArray(LinkedList<Stock> loopBack, String dataType) {
		data = new double[loopBack.size()]; 
		
		for(int i = 0; i!=loopBack.size(); i++)
		{
			data[i] = loopBack.get(i).getDataValue(dataType);
		}
	}
	
	public double getMaxValueInSet() {
		return maxValueInSet;
	}
	public double getMinValueInSet() {
		return minValueInSet;
	}

	public void findMinMaxSetValue(int index, int size)
	{
		lowValue = data[0];
		highValue = data[0];
		
		while(index < size)
		{
			lowValue = data[index];
			highValue = data[index];
			
			if(lowValue > data[index])
			    lowValue = data[index];
			if(highValue < data[index])
			    highValue = data[index];
		    index++;			
		}
		maxValueInSet = highValue;
		minValueInSet = lowValue;
	}	
}
