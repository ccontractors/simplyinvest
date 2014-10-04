package dk.contractors.www.data;

import java.util.ArrayList;

import dk.contractors.www.model.LoopBackData;
import dk.contractors.www.model.Stock;
import dk.contractors.www.model.enums.Perspective;
import dk.simplyinvest.yahoodriver.YahooStockData;

public abstract class DataProducer {

	abstract public LoopBackData<Stock>  createData(Perspective perspective,  ArrayList<YahooStockData> yahooData);
	
//	@Deprecated
//	abstract public LoopBackData<Stock>  createData(String type, Perspective perspective);
//	
//	public LoopBackData<Stock> produceData(String type, int loopBackPeriod, Perspective perspective){
//		
//		LoopBackData<Stock> loopBack = createData(type, perspective);
//		return loopBack;
//		
//	}
	
	
	
}
