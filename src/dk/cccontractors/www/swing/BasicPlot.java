package dk.cccontractors.www.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import dk.cccontractors.www.swing.dimension.ScreenControl;
import dk.cccontractors.www.swing.plot.PlotType;
import dk.contractors.www.model.LoopBackData;
import dk.contractors.www.model.Stock;
import dk.contractors.www.model.TimeSeries;

public class BasicPlot extends Plot{

	LoopBackData<? extends TimeSeries> loopBackData;
	ArrayList<PlotType> plots;// = new ArrayList<PlotType>();
	@Deprecated
	public BasicPlot(ArrayList<PlotType> plots) {
		super();
		this.plots = plots;
		sc = new ScreenControl();
		sc.setScreenDimension(loopBackData.size());
		//drawable2 = new Drawable2(loopBackData, sc);
		//this.loopBackData = loopBackData;
		
		setPreferredSize(new Dimension((sc.getPrefScreenDim()).width,(sc.getPrefScreenDim()).height+15 ));
		plotWidth = sc.getPlotWidth(); //Plotwidth is reported back to listernes
	}

	Drawable2 drawable2;
	ScreenControl sc;
	ArrayList<Model> models = new ArrayList<Model>();
	
	public BasicPlot(LoopBackData<Stock> loopBackData) {
		super();
		
		// TODO Auto-generated constructor stub
		sc = new ScreenControl(loopBackData);
		sc.setScreenDimension(loopBackData.size());
		
		Model ochl = new Model();
		ochl.setModelName("OHCL");
		ochl.setPriority(1);
		models.add(ochl);
		
		Model volume = new Model();
		volume.setModelName("Volume");
		models.add(volume);
		
		Model rsi = new Model();
		rsi.setModelName("RSI");
		models.add(rsi);
		
		Model macd = new Model();
		macd.setModelName("MACD");
		models.add(macd);
		
		Model forceIndex = new Model();
		forceIndex.setModelName("ForceIndex");
		models.add(forceIndex);
		
		double yMax = sc.getPlotHeight(1);
		double yMax1st;
		double yMax2nd;
		
		int N = models.size();
		yMax1st = (3*N)/(2*Math.pow(N, 2));
		
		if(N>1)
			yMax2nd = (1 - yMax1st)/(N-1);
		else
			yMax2nd = (1 - yMax1st);
		
		int count=1;
		double yMaxExtended;
		double yMin;
		
		for(Model _model : models)
		{
			if(_model.getModelName().equals("OHCL"))
			{
				_model.setyMin(0.0);
				_model.setYheigt(yMax1st*yMax);
			}
			else
			{
				yMaxExtended=yMax1st*yMax + count*yMax2nd*yMax;
				yMin = yMaxExtended - yMax2nd*yMax;
				_model.setyMin(yMin);
				_model.setYheigt(yMaxExtended);
				count++;
			}
		}
		
		drawable2 = new Drawable2(loopBackData, sc, models);
		this.loopBackData = loopBackData;
		
		setPreferredSize(new Dimension((sc.getPrefScreenDim()).width,(sc.getPrefScreenDim()).height+15 ));
		plotWidth = sc.getPlotWidth(); //Plotwidth is reported back to listernes
		
	}

	protected void paintComponent(Graphics g1)
	{
	    super.paintComponent(g1);
	    sc.setG2d(g1);
	    sc.setRect(super.getVisibleRect());
	    
	    Color BACKGROUND = new Color(255,255,255); //White
		this.setBackground(BACKGROUND);
		
		drawable2.draw();
		repaint();
	}
	
}
