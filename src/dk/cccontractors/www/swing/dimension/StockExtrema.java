package dk.cccontractors.www.swing.dimension;

import java.util.LinkedList;

import dk.contractors.www.model.Stock;

public class StockExtrema implements Extrema {

	private int _index;
	private int _size;
	private Stock stock;
	private double _low = 0;;
	private double _high = Double.MAX_VALUE;
	private double min;
	private double max;
	
	private LinkedList _loopBack;
	

	public StockExtrema() {
		super();
	}

	public StockExtrema(int index, int size, LinkedList<Stock> loopBack) {
		super();
		_index = index;
		_size = size;
		_loopBack = loopBack;
		calculateExtrema();
	}

	//@Override
	public double getMaximum() {
		// TODO Auto-generated method stub
		return max;
	}

	//@Override
	public double getMinimum() {
		// TODO Auto-generated method stub
		return min;
	}
	private ExtremaData extremeData;
	
	public ExtremaData getExtremeData() {
		return extremeData;
	}
	//@Override
	public void calculateExtrema(int index, int size,
			LinkedList<Stock> loopBack) {
		_size = size;
		_index = index;

		Stock tmpStock = (Stock)loopBack.get(index);

		if (size>loopBack.size())
		{
			_size=loopBack.size();
		}		
		
			_low = tmpStock.getLow();
			_high = tmpStock.getHigh();

			// Find the highest and lowest values for accurate painting
			while(index < _size)
			{
				tmpStock = (Stock)loopBack.get(index);
				if(_low > tmpStock.getLow()) 
				    _low = tmpStock.getLow();
				if(_high < tmpStock.getHigh())
				    _high = tmpStock.getHigh();
			    index++;
			}
		max=_high;
		min=_low;
	}

	//@Override
	//@deprecated
	public void calculateExtrema() {


		Stock tmpStock = (Stock)_loopBack.get(_index);

		if (_size>_loopBack.size())
		{
			_size=_loopBack.size();
		}		
		
			_low = tmpStock.getLow();
			_high = tmpStock.getHigh();

			// Find the highest and lowest values for accurate painting
			while(_index < _size)
			{
				tmpStock = (Stock)_loopBack.get(_index);
				if(_low > tmpStock.getLow()) 
				    _low = tmpStock.getLow();
				if(_high < tmpStock.getHigh())
				    _high = tmpStock.getHigh();
			    _index++;
			}
		max=_high;
		min=_low;
		
		extremeData = new ExtremaData();
		extremeData.setMax(max);
		extremeData.setMin(min);
	}

}
