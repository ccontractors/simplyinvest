package dk.cccontractors.www.swing.plot;



//import com.simplyinvest.graphics.test.Stock;

//public abstract class PlotType {
public interface PlotType {
//	public PlotType() {
//	
//	
//	}
/*
    @Deprecated
	public void draw(int x, double yMin, double yHeight ,Stock stock, ScreenConstants scrConst){}
    @Deprecated
    public void draw(int x, Stock stock, ScreenConstants scrConst){}
    @Deprecated

    public void draw(int x, Stock stock){}*/

    //public void draw(int x, int index);
    
    public void draw(int index);
    
    //public void construct(YBorder yborder);
    
    //public void draw(double x, int index);
}
