package MonthView;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;




public class MonthViewDay extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -917222811593509063L;
	
	public MonthViewDay(String s, Dimension d){
		setMinimumSize(d);
		setMaximumSize(d);
		setPreferredSize(d);
		setBorder(BorderFactory.createLineBorder(Color.black));
		
		JLabel label = new JLabel(s);
		label.setForeground(Color.WHITE);
		add(label);

	}


}
