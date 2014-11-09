package dk.ccontractors.www.ext;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import dk.cccontractors.www.swing.BasicPlot;
import dk.cccontractors.www.swing.Plot;
import dk.cccontractors.www.swing.SIFrame;
import dk.contractors.www.data.LiveDataProducer;
import dk.contractors.www.indicators.MACD2Study;
import dk.contractors.www.model.LoopBackData;
import dk.contractors.www.model.Stock;
import dk.simplyinvest.yahoodriver.SIDate;
import dk.simplyinvest.yahoodriver.YahooDataDriver;

public class Server {

	enum exhangePostfix { CO, NO}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		YahooDataDriver yahooDriver = new YahooDataDriver();
		LiveDataProducer dataProducer = new LiveDataProducer();
		
		List<String> stockList = getStockList();

		//List<LoopBackData<Stock>> stockDataList;
		
		SIDate fromDate = new SIDate("01", "01", "2011");
		SIDate toDate = new SIDate("12", "27", "2012");
		
		LoopBackData<Stock>  stocks;
//		for(String stockName : stockList){
//			
//			stocks = dataProducer.createData(dk.contractors.www.model.enums.Perspective.WEEKLY, yahooDriver.getData("DSV" + ".CO", fromDate, toDate));
//System.out.println(stocks);			
//			
//		}
		stocks = dataProducer.createData(dk.contractors.www.model.enums.Perspective.MONTHLY, yahooDriver.getData("DSV" + ".CO", fromDate, toDate));

		
		
	    MACD2Study macdStudy = new MACD2Study(stocks);

	    LinkedList<Double> mcadHist = macdStudy.getMACD_HIST();
		
	    
		System.out.println("|a:| "+stocks);			
		
		Plot plot = new BasicPlot(stocks);
		
		SIFrame testFrame = new SIFrame(stocks, plot);
		
		

		
		
		
		
	}

	private static List<String> getStockList() {
		//prepare instrument list (stock) for study
		List<String> lst = new ArrayList<String>();
		lst.add("" + exhangePostfix.CO);
		
		lst.add("MAERSK A" + ".CO");
		lst.add("MAERSK B" + ".CO");
		lst.add("CARL B" + ".CO");
		lst.add("CHR" + ".CO");
		lst.add("COLO B" + ".CO");
		lst.add("DSV" + ".CO");
		lst.add("DANSKE" + ".CO");
		lst.add("FLS" + ".CO");
		lst.add("GN" + ".CO");
		lst.add("JYSK" + ".CO");
		lst.add("NDA DKK" + ".CO");
		lst.add("NZYM B" + ".CO");
		lst.add("PNDORA" + ".CO");
		lst.add("TDC" + ".CO");
		lst.add("TOP" + ".CO");
		lst.add("TRYG" + ".CO");
		lst.add("VWS" + ".CO");
		lst.add("WDH" + ".CO");
		lst.add("NOVO B" + ".CO");
		lst.add("GEN" + ".CO");
		
		return lst;
	}

}
