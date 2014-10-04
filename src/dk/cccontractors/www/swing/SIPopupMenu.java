package dk.cccontractors.www.swing;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 * @author Bjoern
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public class SIPopupMenu extends JPopupMenu{

	public SIPopupMenu()
	{
		JMenuItem modelPropertiesItem = new JMenuItem("Modelinstillinger", 'N');   //New
		JMenuItem fontItem = new JMenuItem("Font", 'N');
		JMenuItem signigicantDigitItem = new JMenuItem("Decimaler", 'N');
		JMenuItem showItem = new JMenuItem("Vis", 'N');
		JMenuItem sortItem = new JMenuItem("Sortere kolonner", 'N');
		JMenuItem selectItem = new JMenuItem("Markere alt", 'N');
		JMenuItem invertItem = new JMenuItem("Inverter række", 'N');
		
		add(modelPropertiesItem);
		addSeparator();
		add(fontItem);
		add(signigicantDigitItem);
		add(sortItem);
		add(showItem);
		addSeparator();
		add(selectItem);
		add(invertItem);
	}
}
