package Temp;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import MonthView.MonthView;
import Views.Views;



public class CalendarApp extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6376610934523560443L;
	public static final int FRAME_WIDTH = 700;
	public static final int FRAME_HEIGHT = 700;
	public static final int DAY_OF_MONTH_WIDTH = 100;
	public static final int DAY_OF_MONTH_HEIGHT = 100;

	private JPanel activePanel;
	private Views activeView;
	
	public CalendarApp(){
	
		initFrame();
	
		add(new MenuBar(this));
		activePanel = MonthView.getMonthView();
		activeView = MonthView.getMonthView();
		add(activePanel);
		
		display();
	}
	
	private void display(){
		pack();
		invalidate();
		validate();
		setVisible(true);
	}
	
	private void initFrame(){
		
		setMinimumSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	

		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS) );
		
	}
	
	public void updateCurrentView(){
		activeView.update();
	}

	

}
