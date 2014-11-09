package dk.contractors.www.indicators;

import java.math.BigDecimal;
import java.util.LinkedList;

import dk.contractors.www.model.LoopBackData;
import dk.contractors.www.model.Stock;
import dk.contractors.www.model.TimeSeries;

public class MACD2Study {

	protected LoopBackData<Stock> loopBackData;
	
	


public MACD2Study(LoopBackData<Stock> loopBackData) {
		super();
		this.loopBackData = loopBackData;
	    createMACDLines(loopBackData);
	   createMCADHistogram(loopBackData);
		
	}

//	public void createStudy()
//	{
//		int loopBackPeriod = 20;
//		LoopBackData<Stock> loopBackData = dataProducer.produceData("test", loopBackPeriod);
//		
//		//Do model calculations here....
//		//Test data (only close values )..
//		//LoopBackData<Stock> loopBackData = elderTestDataMACD();
//
//		//Simple moving average..
//		LinkedList<Double> SMA = sma(10, loopBackData);
//		
//		//Exponential moving average
//		LinkedList<Double> EMA = ema(10, loopBackData);
//
//		int EMA_LENGTH = 10;
//		LinkedList<Double> UPPER_CHANNEL = new LinkedList<Double>();
//		LinkedList<Double> LOWER_CHANNEL = new LinkedList<Double>();
//		
//		double K = 2/(EMA_LENGTH+1);
//		double CHANNEL_COEFFICIENT = 0.025d;
//		
//		for(int i=0; i!=loopBackData.size(); i++)
//		{
//			Double ema = emaPointValue(EMA_LENGTH, loopBackData, K, EMA, i);
//			UPPER_CHANNEL.add(ema+(ema*CHANNEL_COEFFICIENT));
//			LOWER_CHANNEL.add(ema-(ema*CHANNEL_COEFFICIENT));
//		}
//		
//		//Calculate a 12-day EMA of closing prices
//		LinkedList<Double> EMA_12 = ema(12, loopBackData);
//		//Calculate a 26 EMA of closing proces
//		LinkedList<Double> EMA_26 = ema(26, loopBackData);
//		//Fast Line Subtract the 26-day EMA from the 12 day EMA
//		LinkedList<Double> MACD_FAST = new LinkedList<Double>();
//		double EMA12;
//		double EMA26;
//		for(int i=0; i!=EMA_12.size(); i++)
//		{
//			EMA26 = EMA_26.get(i);
//			EMA12 = EMA_12.get(i);
//			MACD_FAST.add(i, EMA26 - EMA12);
//		}
//		//Slow or signal line is the 9-day EMA of the fast line..
//		LinkedList<Double> MACD_SLOW = ema(26, MACD_FAST);
//
//		double FAST_VAL; 
//		double SLOW_VAL;
//		boolean printBuy = false;
//		boolean printSell = false;
//		for(int i = 0; i!=MACD_FAST.size(); i++ )
//		{
//			FAST_VAL = MACD_FAST.get(i);
//			SLOW_VAL = MACD_SLOW.get(i);
//			
//			if(FAST_VAL > SLOW_VAL)
//			{
//				if(printBuy) System.out.println(i+ " BUY");
//				printBuy = false;
//				printSell = true;
//			}
//			else
//			{
//				if(printSell)System.out.println(i+ " SELL");
//				printSell = false;
//				printBuy=true;
//			}
//		}
//		
//		LinkedList<BigDecimal> MACD_HIST = new LinkedList<BigDecimal>();
//		
//		//for(int i=0; i<(MACD_FAST.size()-10); i++)
//		for(int i=0; i!=MACD_FAST.size(); i++)
//		{
////			if(i!=MACD_SLOW.size()-1)
////			{
//			//System.out.println(i);
//			FAST_VAL = (MACD_FAST.get(i)).doubleValue();
//			SLOW_VAL = (MACD_SLOW.get(i)).doubleValue();
//			MACD_HIST.add(i, new BigDecimal(FAST_VAL - SLOW_VAL));
//			System.out.println(i + "  hist  " +(FAST_VAL - SLOW_VAL));
//			System.out.println(i + "  hiso  " +MACD_HIST.get(i));
////			}
//		}
//
//		//Force index..
//		LinkedList<Double> FORCE_INDEX = new LinkedList<Double>();
//		Stock stock;
//		double closeToday;
//		double volumeToday;
//		double closeYesterday;
//		for(int i=0; i!=loopBackData.size(); i++)
//		{
//			stock = loopBackData.get(i);
//			closeToday = stock.getClose();
//			if(i>0) closeYesterday = loopBackData.get(i-1).getClose(); else closeYesterday=0d;
//			volumeToday = stock.getVolume();
//			FORCE_INDEX.add((closeToday-closeYesterday)*volumeToday);
//			System.out.println(i + " " + FORCE_INDEX.get(i));
//						
//		}
//		
//		LinkedList<Double> FORCE_EMA2 = new LinkedList<Double>();
//		FORCE_EMA2 = ema(2,FORCE_INDEX);
//		for(int i=0; i!=FORCE_EMA2.size(); i++)
//		{
//			System.out.println(FORCE_EMA2.get(i).doubleValue());
//			
//		}
//		
//		LinkedList<Double> FORCE_EMA13 = new LinkedList<Double>();
//		FORCE_EMA13 = ema(13,FORCE_INDEX);
//		for(int i=0; i!=FORCE_EMA13.size(); i++)
//		{
//			System.out.println(FORCE_EMA13.get(i));
//		}
//		
//		/*
//		for(int i=0; i!=UPPER_CHANNEL.size(); i++)
//		{
//			double upperVal = ((loopBackData.get(i)).getClose()).doubleValue();
//			double close = (UPPER_CHANNEL.get(i)).doubleValue();
//			
//			if(close > upperVal)
//			{
//				System.out.println(i+ " close: " + close + " upperval: " +upperVal);
//			}
//			
//		}*/
//		
//		
//		/*
//		ArrayList<PlotType> plots = new ArrayList<PlotType>();
//		
//		OCHL ochl = new OCHL(loopBackData);
//		Volume volume = new Volume(loopBackData);
//		
//		plots.add(ochl);
//		plots.add(volume);
//		
//		Plot plot = new BasicPlot(plots);
//		*/
//		
//		
//		//Create plot
//		//Plot plot = new XYPlot(loopBackData);
//	}

	private LinkedList<Double> ema(int EMA_LENGTH, LoopBackData<Stock> loopBackData) {
		
		double K =  2d/(EMA_LENGTH+1d) ;
		
		LinkedList<Double> EMA = new LinkedList<Double>();		
		for(int i=0; i!=loopBackData.size(); i++)
		{
			EMA.add( emaPointValue(EMA_LENGTH, loopBackData, K, EMA, i));
			//System.out.println(EMA);
		}
		return EMA; 
	}

	//Overload using a value in stead of a stock object
	private LinkedList<Double> ema(int EMA_LENGTH, LinkedList<Double> loopBackData) {
		
		double K =  2d/(EMA_LENGTH+1d) ;
		
		LinkedList<Double> EMA = new LinkedList<Double>();		
		for(int i=0; i!=loopBackData.size(); i++)
		{
			EMA.add( emaPointValue(EMA_LENGTH, loopBackData, K, EMA, i));
			//System.out.println(EMA);
		}
		return EMA; 
	}
	
	//Overload using a value in steaed of a stock object
	private double emaPointValue(int EMA_LENGTH,
			LinkedList<Double> loopBackData, double K,
			LinkedList<Double> EMA, int i) {
		if(i>EMA_LENGTH-1)
		{
			//Stock  stock = loopBackData.get(i);
			return ((loopBackData.get(i)*K)+(EMA.get(i-1)*(1-K)));
		}
		else if(i==EMA_LENGTH-1)
		{
			return maPointValue(loopBackData, EMA_LENGTH, i);
		}
		else
		{
			return 0.0d;
		}

	}
	
	
	private double emaPointValue(int EMA_LENGTH,
			LoopBackData<Stock> loopBackData, double K,
			LinkedList<Double> EMA, int i) {
		if(i>EMA_LENGTH-1)
		{
			Stock  stock = loopBackData.get(i);
			return (stock.getClose()*K)+((EMA.get(i-1))*(1-K));
		}
		else if(i==EMA_LENGTH-1)
		{
			return maPointValue(loopBackData, EMA_LENGTH, i);
		}
		else
		{
			return 0.0d;
		}

	}
	
	

	private LoopBackData<Stock> elderTestData() {
		LoopBackData<Stock> loopBackData = new LoopBackData<Stock>();
		Stock stock1 = new Stock(); stock1.setClose(447.3);loopBackData.add(stock1);
		Stock stock2 = new Stock(); stock2.setClose(456.8 );loopBackData.add(stock2);
		Stock stock3 = new Stock(); stock3.setClose(451.0);loopBackData.add(stock3);
		Stock stock4 = new Stock(); stock4.setClose(452.5);loopBackData.add(stock4);
		Stock stock5 = new Stock(); stock5.setClose(453.4);loopBackData.add(stock5);
		Stock stock6 = new Stock(); stock6.setClose(455.5);loopBackData.add(stock6);
		Stock stock7 = new Stock(); stock7.setClose(456.0);loopBackData.add(stock7);
		Stock stock8 = new Stock(); stock8.setClose(454.7);loopBackData.add(stock8);
		Stock stock9 = new Stock(); stock9.setClose(453.5);loopBackData.add(stock9);
		Stock stock10 = new Stock(); stock10.setClose(456.5);loopBackData.add(stock10);
		Stock stock11 = new Stock(); stock11.setClose(459.5);loopBackData.add(stock11);
		Stock stock12 = new Stock(); stock12.setClose(465.2);loopBackData.add(stock12);
		Stock stock13 = new Stock(); stock13.setClose(460.8);loopBackData.add(stock13);
		Stock stock14 = new Stock(); stock14.setClose(460.8);loopBackData.add(stock14);
		return loopBackData; 
		
	}

	private LoopBackData<Stock> elderTestDataMACD() {
		LoopBackData<Stock> loopBackData = new LoopBackData<Stock>();
		Stock stock1 = new Stock(); stock1.setClose(20.70);loopBackData.add(stock1);
		Stock stock2 = new Stock(); stock2.setClose(20.55 );loopBackData.add(stock2);
		Stock stock3 = new Stock(); stock3.setClose(20.72);loopBackData.add(stock3);
		Stock stock4 = new Stock(); stock4.setClose(21.03);loopBackData.add(stock4);
		Stock stock5 = new Stock(); stock5.setClose(21.10);loopBackData.add(stock5);
		Stock stock6 = new Stock(); stock6.setClose(21.29);loopBackData.add(stock6);
		Stock stock7 = new Stock(); stock7.setClose(21.09);loopBackData.add(stock7);
		Stock stock8 = new Stock(); stock8.setClose(21.48);loopBackData.add(stock8);
		Stock stock9 = new Stock(); stock9.setClose(21.23);loopBackData.add(stock9);
		return loopBackData; 
		
	}	
	
	private LinkedList<Double> sma(int MA_LENGTH, LoopBackData<Stock> loopBackData) {
		LinkedList<Double> MA = new LinkedList<Double>();		

		for(int i=0; i!=loopBackData.size(); i++)
		{
			if(i>=MA_LENGTH-1)
			{
				double maPointVal = maPointValue(loopBackData, MA_LENGTH, i);
				MA.add(maPointVal);
			}
			else
			{
				MA.add(0.0d);	
			}
			//System.out.println(MA);
		}
		return MA;
	}

	
	//Dividing problem
	// search Non-terminating decimal expansion; no exact representable decimal result.
	//Link http://stackoverflow.com/questions/4591206/non-terminating-decimal-expansion-no-exact-representable-decimal-result
	//http://jaydeepm.wordpress.com/2009/06/04/bigdecimal-and-non-terminating-decimal-expansion-error/
	
	//Overload using a value in steaed of a stock object
	private double maPointValue(LinkedList<Double> loopBackData,
			int MA_LENGTH, int i) {
		double tot=0.0d;
		for( int k=MA_LENGTH; k!=0; k--)
		{
			tot = tot+loopBackData.get(i-(k-1));
		}
		return  tot/MA_LENGTH;
	}

	private double maPointValue(LoopBackData<Stock> loopBackData,
			int MA_LENGTH, int i) {
		double tot=0.0d;
		for( int k=MA_LENGTH; k!=0; k--)
		{
			tot = tot + (loopBackData.get(i-(k-1))).getClose()  ;
		}
		double result = 0.0d;
		try {
			result = tot/MA_LENGTH;
		} catch (java.lang.ArithmeticException e) {
			// TODO Auto-generated catch block
			System.out.println("Aritme i: "+i + " value: " + new BigDecimal(MA_LENGTH) + " TOT: " + tot + "\n");
			e.printStackTrace();
		}
		
		return result;
	}
	
	

	
	
	public LinkedList<Double> getMACD_FAST() {
		return MACD_FAST;
	}


	private LinkedList<Double> MACD_FAST;
	private LinkedList<Double> MACD_SLOW;
	public LinkedList<Double> getMACD_SLOW() {
		return MACD_SLOW;
	}

	
	LinkedList<Double> EMA_12;
	

	

	
	
	public void createMACDLines(LoopBackData<? extends TimeSeries> loopBackData)
	{
		
		
		//Calculate a 12-day EMA of closing prices
		LinkedList<Double> EMA_12 = ema(12, (LoopBackData<Stock>) loopBackData);
		//Calculate a 26 EMA of closing proces
		@SuppressWarnings("unchecked")
		LinkedList<Double> EMA_26 = ema(26, (LoopBackData<Stock>) loopBackData);
		//Fast Line Subtract the 26-day EMA from the 12 day EMA
		MACD_FAST = new LinkedList<Double>();
		double EMA12;
		double EMA26;
		for(int i=0; i!=EMA_12.size(); i++)
		{
			EMA26 = EMA_26.get(i);
			EMA12 = EMA_12.get(i);
			MACD_FAST.add(i, EMA26 - EMA12);
		}
		//Slow or signal line is the 9-day EMA of the fast line..
		MACD_SLOW = ema(9, MACD_FAST);

		/*
		double FAST_VAL; 
		double SLOW_VAL;
		boolean printBuy = false;
		boolean printSell = false;
		for(int i = 0; i!=MACD_FAST.size(); i++ )
		{
			FAST_VAL = (MACD_FAST.get(i)).doubleValue();
			SLOW_VAL = (MACD_SLOW.get(i)).doubleValue();
			
			if(FAST_VAL > SLOW_VAL)
			{
				if(printBuy) System.out.println(i+ " BUY");
				printBuy = false;
				printSell = true;
			}
			else
			{
				if(printSell)System.out.println(i+ " SELL");
				printSell = false;
				printBuy=true;
			}
		}*/		
		 //System.out.println("MACD");
	}
	double FAST_VAL; 
	double SLOW_VAL;
	
	LinkedList<Double> MACD_HIST = new LinkedList<Double>();
	public LinkedList<Double> getMACD_HIST() {
		return MACD_HIST;
	}

	public void createMCADHistogram(LoopBackData<? extends TimeSeries> loopBackData)
	{
		

		
		//for(int i=0; i!=MACD_FAST.size(); i++)
		for(int i=0; i!=loopBackData.size(); i++)
		{
//			if(i!=MACD_SLOW.size()-1)
//			{
			//System.out.println(i);
			FAST_VAL = MACD_FAST.get(i);
			SLOW_VAL = MACD_SLOW.get(i);
			MACD_HIST.add(i, FAST_VAL - SLOW_VAL);
			//System.out.println(i + " " +(FAST_VAL - SLOW_VAL));
//			}
		}		
	}
	
//	/**
//	 * @param args
//	 */
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		MACD2Study MACD2Study = new MACD2Study();
//		MACD2Study.createStudy();
//		
//
//	}


}
