package dk.contractors.www.model;

//import java.math.BigDecimal;
import java.util.Calendar;
import java.util.LinkedList;

public class LoopBackData<E extends Stock> extends LinkedList<Stock> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -524486822796805446L;
	LoopBackData<Stock> weekly ;
	LoopBackData<Stock> monthly;
	LoopBackData<Stock> daily;

	LoopBackData<Stock> stockList;
	
//	public LoopBackData(LoopBackData<Stock> stockList)
//	{
//		super();
//		this.stockList = stockList;
//	}

	public LoopBackData<Stock> getWeeklyData(LoopBackData<Stock> loopBack)
	{
		stockList = loopBack; 
		Calendar date2 = stockList.peek().getDate();
		date2.setLenient(false);
		
		//date2.setLenient(false);
	    double open = 0;
	    double high = 0;
	    double low = 0;
	    double close = 0;
	    double volume = 0;
		Stock weeklyVal;
		Stock dailyVal;
		int averageCount = 0;

		weekly = new LoopBackData<Stock>();
		for (Stock stock : stockList)
		{
			Calendar date = stock.getDate();
			date.setLenient(false);
			
			System.out.println("date " + date);
			
			date.setLenient(false);
			//System.out.println(date2.get(Calendar.WEEK_OF_YEAR));
			//System.out.println(date.get(Calendar.WEEK_OF_YEAR));
			if(date2.get(Calendar.WEEK_OF_YEAR)==date.get(Calendar.WEEK_OF_YEAR))
			{

//				open += (stock.getOpen()).doubleValue();
//				high += (stock.getHigh()).doubleValue();
//				low += (stock.getLow()).doubleValue();
//				close += (stock.getClose()).doubleValue();
//				volume+= (stock.getVolume()).doubleValue();
//				averageCount++;

				open += stock.getOpen();
				high += stock.getHigh();
				low += stock.getLow();
				close += stock.getClose();
				volume+= stock.getVolume();
				averageCount++;
			
			
			}
			else
			{
				weeklyVal = new Stock();
				weeklyVal.setDate(date2);

				//				weeklyVal.setOpen(new BigDecimal(open/averageCount));
//				weeklyVal.setHigh(new BigDecimal(high/averageCount));
//				weeklyVal.setLow(new BigDecimal(low/averageCount));
//				weeklyVal.setClose(new BigDecimal(close/averageCount));
//				weeklyVal.setVolume(new BigDecimal(volume/averageCount));

				weeklyVal.setOpen(open/averageCount);
				weeklyVal.setHigh(high/averageCount);
				weeklyVal.setLow(low/averageCount);
				weeklyVal.setClose(close/averageCount);
				weeklyVal.setVolume(volume/averageCount);
				
				
				weekly.add(weeklyVal);
				date2 = date;
			    open = 0;
			    high = 0;
			    low = 0;
			    close = 0;
			    volume = 0;
			    weeklyVal = null;
			    averageCount = 0;
			    
				open += stock.getOpen();
				high += stock.getHigh();
				low += stock.getLow();
				close += stock.getClose();
				volume+= stock.getVolume();
				averageCount++;
			}
		}
		return weekly;
	}
	
	public LoopBackData<Stock> getMonthlyData(LoopBackData<Stock> loopBack)
	{
		stockList = loopBack; 
		Calendar date2 = stockList.peek().getDate();
		date2.setLenient(false);
		
		//date2.setLenient(false);
	    double open = 0;
	    double high = 0;
	    double low = 0;
	    double close = 0;
	    double volume = 0;
		Stock weeklyVal;
		Stock monthlyVal;
		Stock dailyVal;
		int averageCount = 0;

		monthly = new LoopBackData<Stock>();
		for (Stock stock : stockList)
		{
			Calendar date = stock.getDate();
			date.setLenient(false);
			
			System.out.println("date " + date);
			
			date.setLenient(false);
			//System.out.println(date2.get(Calendar.WEEK_OF_YEAR));
			//System.out.println(date.get(Calendar.WEEK_OF_YEAR));
			if(date2.get(Calendar.MONTH)==date.get(Calendar.MONTH))
			{
				open += stock.getOpen();
				high += stock.getHigh();
				low += stock.getLow();
				close += stock.getClose();
				volume+= stock.getVolume();
				averageCount++;
			}
			else
			{
				monthlyVal = new Stock();
				monthlyVal.setDate(date2);
				monthlyVal.setOpen(open/averageCount);
				monthlyVal.setHigh(high/averageCount);
				monthlyVal.setLow(low/averageCount);
				monthlyVal.setClose(close/averageCount);
				monthlyVal.setVolume(volume/averageCount);
				
				monthly.add(monthlyVal);
				date2 = date;
			    open = 0;
			    high = 0;
			    low = 0;
			    close = 0;
			    volume = 0;
			    weeklyVal = null;
			    averageCount = 0;
			    
				open += stock.getOpen();
				high += stock.getHigh();
				low += stock.getLow();
				close += stock.getClose();
				volume+= stock.getVolume();
				averageCount++;
			}
		}
		return monthly;
	}
	
	public String toString()
	{
		
		StringBuffer strBuf = new StringBuffer("[");
		
		
		
		strBuf.append("[Date, Open, High, Low, Close, Volume, Adj. Close*]\n");
		for(Stock stock : this)
		{
			strBuf.append("[");
			strBuf.append(stock.getDate()+", ");
			strBuf.append(stock.getOpen()+ ", ");
			strBuf.append(stock.getHigh()+ ", ");
			strBuf.append(stock.getLow()+ ", ");
			strBuf.append(stock.getClose());
			
			strBuf.append(stock.getVolume());
			//strBuf.append(stock.getAdjClose());
			strBuf.append("]\n");
			
			
		}
		strBuf.append("]");
		return strBuf.toString();
	}
	
}
