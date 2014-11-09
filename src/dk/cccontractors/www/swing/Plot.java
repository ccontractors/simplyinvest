package dk.cccontractors.www.swing;



import javax.swing.JPanel;



@SuppressWarnings("serial")
public abstract class Plot extends JPanel
{
 
	int plotWidth;

	public int getPlotWidth() {
		return plotWidth;
	}

	public void setPlotWidth(int plotWidth) {
		this.plotWidth = plotWidth;
	}

}
