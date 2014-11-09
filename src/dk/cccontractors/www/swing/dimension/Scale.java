package dk.cccontractors.www.swing.dimension;

public class Scale {

	private double _scale;
	private double _offset;
	private double _yHeight;
	private double _yMin;
	
	public Scale(double yHeight, double yMin)
	{
		_yHeight = yHeight;
		_yMin= yMin;
	}
	
	public double getScale(double max, double min)
	{
		
		double delta = 0;
//		if(min<0)
//		{
//			//min=min*-1;
//			delta=Math.abs(min-max);
//			_scale = (Math.abs(_yMin-_yHeight )) / delta;
//		}
//		else
//		{
			delta=max-min;
			_scale = (_yHeight - _yMin) / delta;
//		}
		

		
		return _scale;
	}
	
	//offset = getOffset(scale, minVol, yMin);
	public double getOffset(double min)
	{
		//if(min<0)min=min*-1;
		_offset = (_scale * min) ;//- (_yMin + 20);
		//_offset = (_scale * min) ;
		//System.out.println(_offset);
		return _offset;
	}
}
