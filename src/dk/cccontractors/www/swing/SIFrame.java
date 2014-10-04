package dk.cccontractors.www.swing;

import java.awt.Component;
import java.awt.GraphicsConfiguration;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JViewport;

import dk.cccontractors.www.swing.snapshot.SnapShot;
import dk.contractors.www.model.LoopBackData;
import dk.contractors.www.model.Stock;

public class SIFrame extends JFrame{

	SnapShot snapShot = new SnapShot();;
	private LoopBackData<Stock> loopBackData;
	protected Plot plot;
	
	
	public LoopBackData<Stock> getLoopBackData() {
		return loopBackData;
	}

	public void setLoopBackData(LoopBackData<Stock> loopBackData) {
		this.loopBackData = loopBackData;
	}


	public SIFrame(Plot plot){
		super();
		initFrame(plot);
	}	
	public SIFrame(LoopBackData<Stock> loopBackData, Plot plot){
		super();
		this.loopBackData = loopBackData; 
		initFrame(loopBackData, plot);
	}

	private void initFrame(LoopBackData<Stock> loopBackData, Plot plot) {
		
		//Plot plot = new XYPlot(loopBackData);
		class rightClickListener extends MouseAdapter
		{
			    JFrame  frame;
			    private SIPopupMenu popupMenu;
			    //setYMax
			    SnapShot snapShot = new SnapShot();;
				public rightClickListener(JFrame  frame)
			    {
			    	this.frame=frame;
					popupMenu= new SIPopupMenu();
					popupMenu.setInvoker(frame);
					//snapShot.snapShot3(frame);
			    }
				
//				public void mousePressed(MouseEvent e)
//				{
//					int button = e.getButton();
//					
//					//snapShot.snapShot(this);
//					//snapShot.snapShot(frame);
//					System.out.println("shote");
//					
//					//if(e.getComponent() instanceof BasicPlot) snapShot.snapShot3(e.getComponent());
//					//if(e.getComponent() instanceof BasicPlot) snapShot.snapShot3(this.);
//					snapShot.snapShot3(frame);
//					
//					if(button==3)
//					{
//						Dimension screen = 
//						      Toolkit.getDefaultToolkit().getScreenSize(); 
//						
//						Rectangle r = frame.getBounds();    
//						Point p =getLocationOnScreen();
//						int x = screen.width- (screen.width - (p.x + (r.width/2))); 
//					    int y = screen.height - (screen.height - (p.y + (r.height/2))); 
//						
//						popupMenu.setVisible(true);
//						popupMenu.setLocation(x,y);
//						
//						snapShot = new SnapShot();
//						//snapShot.snapShot(this);
//						snapShot.snapShot(frame);
//						System.out.println("shotv");
//					}
//				}
		};
		Component glassPane = this.getGlassPane();
		glassPane.addMouseListener(new rightClickListener(this));
//
//		this.addMouseListener(new rightClickListener(this));		
		this.plot = plot;
		
		plot.addMouseListener(new rightClickListener(this));
		
		add(plot);
		setScrollPaneOnPlot(plot);
		pack(); /** If pack() is not called the panel will not be drawn on frame. See note 2*/
		setVisible(true);
		snapShot.snapShot3(this);
		
		//SnapShot snapShot = new SnapShot();
		//snapShot.snapShot(this);
		//snapShot.snapShot(plot);
//		JRootPane test = (JRootPane) getComponent(0);
//		snapShot.snapShot(test);
		
//		Component[] components = getComponents();
//		for(int i=0; i!=components.length;i++)
//		{
//			if(components[i] instanceof XYPlot){
//				snapShot.snapShot((XYPlot) components[i]);
//			}
//		}
//		
	}

	private void initFrame(Plot plot) {

		class rightClickListener extends MouseAdapter
		{
			    JFrame  frame;
			
				public rightClickListener(JFrame  frame)
			    {
			    	this.frame=frame;
			    }
				
				public void mousePressed(MouseEvent e)
				{
					int button = e.getButton();
					if(button==3)
					{
					    /*
						Dimension screen = 
						      Toolkit.getDefaultToolkit().getScreenSize(); 

						Rectangle r = getVisibleRect();    
						Point p =getLocationOnScreen();
						int x = screen.width - (screen.width - (p.x + (r.width/2))); 
					    int y = screen.height - (screen.height - (p.y + (r.height/2))); 
						
						popupMenu.setVisible(true);
						popupMenu.setLocation(x,y);
						*/
						SnapShot snapShot = new SnapShot();
						//snapShot.snapShot(this);
						snapShot.snapShot2(frame);
						System.out.println("shot2");
					}
				}
		};
		
		this.addMouseListener(new rightClickListener(this));
		add(plot);
		setScrollPaneOnPlot(plot);
		pack(); /** If pack() is not called the panel will not be drawn on frame. See note 2*/
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setVisible(true);
		//SnapShot snapShot = new SnapShot();
//		snapShot.snapShot(this);
//		JRootPane test = (JRootPane) getComponent(0);
//		snapShot.snapShot(test);
		
//		Component[] components = getComponents();
//		for(int i=0; i!=components.length;i++)
//		{
//			if(components[i] instanceof XYPlot){
//				snapShot.snapShot((XYPlot) components[i]);
//			}
//		}
//		
		
	}	
	
	
	private void setScrollPaneOnPlot(Plot plot) {
		JScrollPane scrollPane = new JScrollPane(plot, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.getHorizontalScrollBar().setMaximum(plot.getPlotWidth());
		scrollPane.getHorizontalScrollBar().setValue(plot.getPlotWidth());
		initScrollpaneListeners(scrollPane);
		// GridBagLayout
		setGridBagOnScroolPain(scrollPane);
		
		this.getContentPane().add(scrollPane);
	}

	private void setGridBagOnScroolPain(JScrollPane scrollPane) {
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		this.setLayout(gridbag);		
		c.anchor = GridBagConstraints.NORTHWEST;
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		c.weighty = 1.0;	
		c.gridx = 0;
		c.gridy = 1;	
		gridbag.setConstraints(scrollPane, c);
	}
	
//	public SIFrame() throws HeadlessException {
//		super();
//		//initFrame(loopBackData);
//
//	}

//	public SIFrame(GraphicsConfiguration gc) {
//		super(gc);
//		initFrame(loopBackData);
//	}
//
//	public SIFrame(String title, GraphicsConfiguration gc) {
//		super(title, gc);
//		initFrame(loopBackData);
//	}
//
//	public SIFrame(String title) throws HeadlessException {
//		super(title);
//		initFrame(loopBackData);
//	}
	
	public void initScrollpaneListeners(JScrollPane scrollPane)
	{
		// Listeners for the scrollbar
//		class PaneListener extends MouseMotionAdapter
//		{
//		    public void mouseDragged(MouseEvent e)
//		    {
//				for(JPanel panel : plotHolder)
//				{
//			    	panel.repaint();
//					//drawingArea.revalidate();
//				}
//		    }	    
//		};	
//		scrollPane.getHorizontalScrollBar().addMouseMotionListener(new PaneListener());
//		class ScrollAdjusmentListener implements AdjustmentListener
//		{
//			public void adjustmentValueChanged(AdjustmentEvent e) 
//			{
//				for(JPanel panel : plotHolder)
//				{
//			    	panel.repaint();
//					//drawingArea.revalidate();
//				}
//			}
//		}
//		scrollPane.getHorizontalScrollBar().addAdjustmentListener(new ScrollAdjusmentListener());
		scrollPane.getViewport().setScrollMode(JViewport.SIMPLE_SCROLL_MODE);
	}	

}
