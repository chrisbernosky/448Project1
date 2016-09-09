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
	

	private Integer day;
	public MonthViewDay(Integer s, Dimension d){
		day = s;
		setMinimumSize(d);
		setMaximumSize(d);
		setPreferredSize(d);
		setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel label;
		if(s == null){
			label = new JLabel("");
		}else{
			label = new JLabel(s+"");
		}
		label.setForeground(Color.WHITE);
		add(label);

	}
	public int getDay(){
		return day;
	}


}
