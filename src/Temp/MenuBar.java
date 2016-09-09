package Temp;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import Records.CachedCalendar;
import constants.MonthsOfYear;


public class MenuBar extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 341341509482431909L;
	private JComboBox monthList 	= null;
	private JComboBox dayList		= null;
	private JComboBox yearList		= null;
	private CalendarApp calendarApp	= null;
	
	

	public MenuBar(CalendarApp calendarApp){
		this.calendarApp = calendarApp;
		
		setMinimumSize(new Dimension(CalendarApp.FRAME_WIDTH,CalendarApp.DAY_OF_MONTH_HEIGHT/2));
		setMaximumSize(new Dimension(CalendarApp.FRAME_WIDTH,CalendarApp.DAY_OF_MONTH_HEIGHT/2));
		setPreferredSize(new Dimension(CalendarApp.FRAME_WIDTH,CalendarApp.DAY_OF_MONTH_HEIGHT/2));
		//this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
	
		initFormatButtons();
		initMonthBox();
		initDayBox();
		initYearBox();
		initUpdate();
		
		
		setBackground(Color.ORANGE);
		
		
	}
	private void initUpdate(){
		JButton applyDate = new JButton("Apply Date");
		
		applyDate.addActionListener(new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	calendarApp.updateCurrentView();
		    	System.out.println("Update");
		    	
		    }
		});
		add(applyDate);
	}
	private void initFormatButtons(){
		JButton month = new JButton("Month");
		month.setMinimumSize(new Dimension(500, 50));
		month.setMaximumSize(new Dimension(500, 50));
		JButton week = new JButton("Week");
		week.setMinimumSize(new Dimension(150, 50));
		week.setMaximumSize(new Dimension(150, 50));
		JButton day = new JButton("Day");
		day.setMinimumSize(new Dimension(150, 50));
		day.setMaximumSize(new Dimension(150, 50));
		add(month);
		add(week);
		add(day);
		add(Box.createRigidArea(new Dimension(100, 0)));
	}
	
	private void initMonthBox(){
		
		MonthsOfYear[] months = MonthsOfYear.values();
		String[] names = new String[months.length];
		for(int i = 0; i<months.length; i++){
			names[i] = months[i].toString();
		}
		
		monthList = new JComboBox(names);
		monthList.setSelectedIndex(CachedCalendar.getInstance().Month);
		monthList.addActionListener(new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	storeMonth();
		        resetDayBox();
		    }
		});
		    
		add(monthList);
	}
	
	private void initDayBox(){
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, CachedCalendar.getInstance().Month);
		int count = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		String[] names = new String[count];
		for(int i = 1; i<=count; i++){
			names[i-1] = i+"";
		}
		
		dayList = new JComboBox(names);
		dayList.setSelectedIndex(CachedCalendar.getInstance().DayOfMonth-1);
		dayList.addActionListener(new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	storeDay();
		    }
		});
		
		add(dayList);
	}
	private void initYearBox(){
		String[] years = {"2015","2016"};
		
		yearList = new JComboBox(years);
		yearList.setSelectedIndex(CachedCalendar.getInstance().Year-2015);
	
		yearList.addActionListener(new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	storeYear();
		    	
		    	//Stupid February and its day count
		    	if(CachedCalendar.getInstance().Month==2)
		    	{
		    		resetDayBox();
		    	}
		    	
		    	
		    }
		});
		add(yearList);
	}
	
	private void storeMonth(){
		CachedCalendar.getInstance().Month = monthList.getSelectedIndex();
		System.out.println("Month "+CachedCalendar.getInstance().Month);
	}
	private void storeDay(){
		CachedCalendar.getInstance().DayOfMonth = dayList.getSelectedIndex()+1;
		System.out.println("Day "+CachedCalendar.getInstance().DayOfMonth);
	}
	private void storeYear(){
		CachedCalendar.getInstance().Year = yearList.getSelectedIndex()+2015;
		System.out.println("Year "+CachedCalendar.getInstance().Year);
	}
	
	private void resetDayBox(){
		
		dayList.removeAllItems();
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, CachedCalendar.getInstance().Month-1);
		cal.set(Calendar.YEAR, CachedCalendar.getInstance().Year);
		
		int count = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		for(int i = 1; i<=count; i++){

			dayList.addItem(i);
		}
	}
}
