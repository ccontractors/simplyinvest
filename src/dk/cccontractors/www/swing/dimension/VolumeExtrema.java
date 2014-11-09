package dk.cccontractors.www.swing.dimension;

import java.util.Calendar;
import java.util.LinkedList;

import dk.contractors.www.model.Stock;

public class VolumeExtrema implements Extrema {

	private int _index;
	private int _size;
	private Stock stock;
	private double _lowVolume = 0;
	private double _highVolume = Double.MAX_VALUE;
	private double min;
	private double max;
	private LinkedList _loopBack;
	
	private ExtremaData extremeData;
	
	public ExtremaData getExtremeData() {
		return extremeData;
	}

	//@Override
	public double getMaximum() {
		return max;
	}

	//@Override
	public double getMinimum() {
		return min;
	}
	public VolumeExtrema() {
		super();
		
		
	}

	//LinkedList<Double> data = new LinkedList<Double>();
	
	double[] data; 
	
	public VolumeExtrema(LinkedList<Stock> loopBack) {
		super();
		
		copy2doubleArray(loopBack, "VOLUME");
		
	}

	private void copy2doubleArray(LinkedList<Stock> loopBack, String dataType) {
		data = new double[loopBack.size()]; 
		
		for(int i = 0; i!=loopBack.size(); i++)
		{
			data[i] = loopBack.get(i).getDataValue(dataType);
		}
	}
	
	private double lowValue = 0;
	private double highValue = Double.MAX_VALUE;
	private double maxValueInSet;
	private double minValueInSet;
	
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
	
	
	
	public VolumeExtrema(int index, int size, LinkedList<Stock> loopBack) {
		super();
		_index = index;
		_size = size;
		_loopBack = loopBack;
		calculateExtrema();
	}
	//@Override
	public void calculateExtrema(int index, int size,
			LinkedList<Stock> loopBack) {
		Calendar _minDate=null, _maxDate=null, dateMax, dateMin;
		_size = size;
		//_index = index;

		Stock tmpStock = (Stock)loopBack.get(index);

		if (size>loopBack.size())
		{
			_size=loopBack.size();
		}		
		
			_lowVolume = tmpStock.getVolume();
			_highVolume = tmpStock.getVolume();
			// Find the highest and lowest values for accurate painting
	
			while(index < _size)
			{
				tmpStock = (Stock)loopBack.get(index);

				if(_lowVolume > tmpStock.getVolume())
				{
				    _lowVolume = tmpStock.getVolume();
					_minDate = tmpStock.getDate();
				}
				if(_highVolume < tmpStock.getVolume())
				{
				    _highVolume = tmpStock.getVolume();
					_maxDate = tmpStock.getDate();
				}
					index++;
			}

//		dateMax = _maxDate;
//		dateMin = _minDate ;
//		System.out.println(_maxDate);
//		System.out.println(_minDate);
		max=_highVolume;
		min=_lowVolume;
		
	
	}
	@Deprecated
	public void calculateExtrema() {

		Stock tmpStock = (Stock)_loopBack.get(_index);

		if (_size>_loopBack.size())
		{
			_size=_loopBack.size();
		}		
		
			_lowVolume = tmpStock.getVolume();
			_highVolume = tmpStock.getVolume();
			// Find the highest and lowest values for accurate painting
	
			while(_index < _size)
			{
				tmpStock = (Stock)_loopBack.get(_index);

				if(_lowVolume > tmpStock.getVolume())
				    _lowVolume = tmpStock.getVolume();
				if(_highVolume < tmpStock.getVolume())
				    _highVolume = tmpStock.getVolume();
			    _index++;
			}

		max=_highVolume;
		min=_lowVolume;
		
		extremeData = new ExtremaData();
		extremeData.setMax(max);
		extremeData.setMin(min);
	}
	
	


}
