package dk.cccontractors.www.swing.dimension;

import java.util.LinkedList;

import dk.contractors.www.model.Stock;

public interface Extrema {

	public double getMaximum();
	public double getMinimum();
	public void calculateExtrema(int index,int size, LinkedList<Stock> loopBack);
	public void calculateExtrema();
	public ExtremaData getExtremeData(); 
}
