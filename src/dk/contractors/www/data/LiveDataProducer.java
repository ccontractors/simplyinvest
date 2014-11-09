package dk.contractors.www.data;


import java.util.ArrayList;

import dk.contractors.www.model.LoopBackData;
import dk.contractors.www.model.Stock;
import dk.contractors.www.model.enums.Perspective;
import dk.simplyinvest.yahoodriver.SIDate;
import dk.simplyinvest.yahoodriver.YahooDataDriver;
import dk.simplyinvest.yahoodriver.YahooStockData;

public class LiveDataProducer extends DataProducer {

	
	@Override
	public LoopBackData<Stock> createData(Perspective perspective, ArrayList<YahooStockData> yahooData) {
		
		LoopBackData<Stock> loopBack = null;
		

			loopBack = new LoopBackData<Stock>();

			Stock stock;
			for(int i=0; i!= yahooData.size();i++)
			{
				try
				{
					stock= new Stock();
					stock.setDate(yahooData.get(i).getDate());
					stock.setOpen(new Double(yahooData.get(i).getOpen()));
					stock.setLow(new Double(yahooData.get(i).getLow()));
					stock.setHigh(new Double(yahooData.get(i).getHigh()));
					stock.setClose(new Double(yahooData.get(i).getClose()));
					stock.setVolume(new Double(yahooData.get(i).getVolume()));
					loopBack.addFirst(stock);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}			
		
		
		switch (perspective) {
		case DAILY:
			
			break;
		case WEEKLY:
			loopBack = loopBack.getWeeklyData(loopBack);
			break;
		
		case MONTHLY:
			loopBack = loopBack.getMonthlyData(loopBack);
			break;
		default:
			break;
		}
		
		
	
		
		return loopBack;
	}	
	
	
//	@Override
//	public LoopBackData<Stock> createData(String type, Perspective perspective) {
//		
//		LoopBackData<Stock> loopBack = null;
//		
//		if(type.equals("live"))
//		{
//			DBData dbData = new DBData();
//			loopBack = dbData.getStockList("LULU");
//		}
//		else if(type.equals("yahoo"))
//		{
//			YahooDataDriver yahooDriver = new YahooDataDriver();
//			
//			SIDate fromDate = new SIDate("01", "01", "2011");
//			SIDate toDate = new SIDate("12", "27", "2012");
//			
//			loopBack = new LoopBackData<Stock>();
//
//			String stockName 	= "VWS.CO";
//			ArrayList<YahooStockData> yahooData = yahooDriver.getData(stockName, fromDate, toDate);
//
//			YahooStockData yahooStock = new YahooStockData();
//
//			Stock stock;
//			for(int i=0; i!= yahooData.size();i++)
//			{
//				//System.out.println("[yahoo, output:] "+yahooData.get(i));
//				try
//				{
//					stock= new Stock();
//					yahooStock = yahooData.get(i);
//					stock.setDate(yahooStock.getDate());
//					stock.setOpen(new Double(yahooStock.getOpen()));
//					stock.setLow(new Double(yahooStock.getLow()));
//					stock.setHigh(new Double(yahooStock.getHigh()));
//					stock.setClose(new Double(yahooStock.getClose()));
//					stock.setVolume(new Double(yahooStock.getVolume()));
//					loopBack.addFirst(stock);
//				}
//				catch (Exception e)
//				{
//					e.printStackTrace();
//				}
//			}			
//		}
//		
//		switch (perspective) {
//		case DAILY:
//			
//			break;
//		case WEEKLY:
//			loopBack = loopBack.getWeeklyData(loopBack);
//			break;
//		
//		case MONTHLY:
//			loopBack = loopBack.getMonthlyData(loopBack);
//			break;
//		default:
//			break;
//		}
//		
//		
//	
//		
//		return loopBack;
//	}
}
