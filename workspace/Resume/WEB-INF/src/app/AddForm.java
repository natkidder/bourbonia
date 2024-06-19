package app;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.LabelValueBean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.math.*;

public class AddForm extends ActionForm {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ArrayList<LabelValueBean> listStates = Utilities.setStatesList();
	public ArrayList<LabelValueBean> listMth = Utilities.setMonthList();
	public ArrayList<LabelValueBean> listDay = Utilities.setDayList();
	public ArrayList<LabelValueBean> listYr = Utilities.setYearList();
	public ArrayList<LabelValueBean> listCurrEmpl = Utilities.setCurrEmplList();
	public ArrayList<LabelValueBean> listGender = Utilities.setGenderList();
		
}
