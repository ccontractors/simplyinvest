package dk.cccontractors.www.swing.dimension;

import java.util.LinkedList;

import dk.contractors.www.model.Stock;

public class ExtremaInTimeSeries {
	
	private int _index;
	private int _size;
	private Stock stock;
	private double _low = 0;;
	private double _high = Double.MAX_VALUE;
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
	
	LinkedList<Double> _loopBack;
	
	public ExtremaInTimeSeries() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void calculateExtrema(int index, int size, LinkedList<Double> loopBack) {


		//Stock tmpStock = (Stock)_loopBack.get(_index);



		double tmpVal = loopBack.get(index);
		_size = size;
		_index = index;

		if (size>loopBack.size())
		{
			_size=loopBack.size();
		}
		
			_low = tmpVal;
			_high = tmpVal;
			// Find the highest and lowest values for accurate painting
	
			while(index < _size)
			{
				tmpVal= loopBack.get(index);

				if(_low > tmpVal)
				    _low = tmpVal;
				if(_high < tmpVal)
				    _high = tmpVal;
			    index++;
			}

		max=_high;
		min=_low;
	}
	

}
