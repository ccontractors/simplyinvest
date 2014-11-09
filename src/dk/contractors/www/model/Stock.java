package dk.contractors.www.model;

//import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Stock implements TimeSeries
{
    private String ticker;
    private Calendar date;
    private double open;
    private double high;
    private double low;
    private double close;
    private double volume;
/*
    private BigDecimal open;
	private BigDecimal high;
    private BigDecimal low;
    private BigDecimal close;
    private BigDecimal volume;
*/
    public Stock() { date = new GregorianCalendar(); }
    public void setTicker(String aTicker) { ticker = aTicker; }
    public String getTicker() { return ticker; }
    
    public void setDate(Calendar date)
    {
    	this.date = date;
    }
    
    public void setDate(int year, int month, int day)
	{
	    date.clear();
	    date.set(year, month, day); 
	}
    public Calendar getDate() { return date; }
    public void setOpen(double aOpen) { open = aOpen; }
    public double getOpen() { return open; }
    public void setHigh(double aHigh) { high = aHigh; }
    public double getHigh() { return high; }
    public void setLow(double aLow) { low = aLow; }
    public double getLow() { return low; }
    public void setClose(double aClose) { close = aClose; }
    public double getClose() { return close; }
    public void setVolume(double aVolume) { volume = aVolume; }
    public double getVolume() { return volume; }
    
    
    public double getDataValue(String dataType)
    {
    	
    	double value = 0.0d;
    	if(dataType.equals("CLOSE"))
    	{
    		value = getClose();
    	}
    	else if (dataType.equals("VOLUME"))
    	{
    		value = getVolume();
    	}
    	else if (dataType.equals("OPEN"))
    	{
    		value = getOpen();
    	}
    	else if (dataType.equals("HIGH"))
    	{
    		value = getHigh();
    	}
    	else if (dataType.equals("LOW"))
    	{
    		value = getLow();
    	}
		return value;
    }
    
    public Calendar getDataDate()
    {
    	
    	return date;
    }
    /*
    public BigDecimal getOpen() {
		return open;
	}
	public void setOpen(BigDecimal open) {
		this.open = open;
	}
	public BigDecimal getHigh() {
		return high;
	}
	public void setHigh(BigDecimal high) {
		this.high = high;
	}
	public BigDecimal getLow() {
		return low;
	}
	public void setLow(BigDecimal low) {
		this.low = low;
	}
	public BigDecimal getClose() {
		return close;
	}
	public void setClose(BigDecimal close) {
		this.close = close;
	}
	public BigDecimal getVolume() {
		return volume;
	}
	public void setVolume(BigDecimal volume) {
		this.volume = volume;
	}*/


/*
    public static void main(String[] args)
	{
	    Stock aStock = new Stock();
	    aStock.addDate("020608");
	}
*/
}


















