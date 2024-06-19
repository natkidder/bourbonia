package app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.LabelValueBean;
import org.apache.struts.upload.FormFile;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.*;
import java.util.*;

public class ResumeUpdForm extends Resume {
    
	public void setMi(String mi) {
		if (mi != null && mi.length() > 0)  {
			this.mi = mi.substring(0,1);
		}
	}

	private String birthDtStr;
	private String lowSalaryStr;
	private String highSalaryStr;
	private String commentsStr;
	private String yearsExpStr;
	public String passwd1;
	private String step;  // if the calling form is multi-buttoned
	private FormFile fileSelected;
	public ArrayList<LabelValueBean> listStates = Utilities.setStatesList();
	public ArrayList<LabelValueBean> listMth = Utilities.setMonthList();
	public ArrayList<LabelValueBean> listDay = Utilities.setDayList();
	public ArrayList<LabelValueBean> listYr = Utilities.setYearList();
	public ArrayList<LabelValueBean> listCurrEmpl = Utilities.setCurrEmplList();
	public ArrayList<LabelValueBean> listGender = Utilities.setGenderList();
    private enum Extension { DOC, DOCX, HTM, HTML, PDF, TXT };
    private String extensionStr = "Files must be in the following formats: " + extensionToStr();  // may be superfluous--cannot use bean:value on it
 
    /* superfluous if cannot use extensionStr in associated jsp */
    private String extensionToStr()  {
    	StringBuilder sb = new StringBuilder();
		for (Extension e : Extension.values()) {
			sb.append(e.toString() + ",");
		}
		String s = sb.substring(0, sb.length()-2);
		return s ;
    }
	
	public void setStep(String step)  {
		this.step = step;
	}
	public String getStep()  {
		return this.step;
	}

	public void setPasswd1(String passwd1) {
		this.passwd1 = passwd1;
	}
	public String getPasswd1() {
		return passwd1;
	}

	public void setLowSalaryStr(String lowSalaryStr) {
		this.lowSalaryStr = lowSalaryStr.replace(",", "");
	}
	public void setHighSalaryStr(String highSalaryStr) {
		this.highSalaryStr = highSalaryStr.replace(",", "");
	}

	public void setCommentsStr(String commentsStr) {
		this.commentsStr = commentsStr;
		if (commentsStr != null) { this.comments = commentsStr; }
	}

	public void setYearsExpStr(String yearsExpStr) {
		this.yearsExpStr = yearsExpStr;
	}

	public FormFile getFileSelected() {
		return fileSelected;
	}
	public void setFileSelected(FormFile fileSelected) {
		this.fileSelected = fileSelected;   // sometimes a String gets passed to it
	}

	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {

    	ActionErrors errors = new ActionErrors();
		Utilities.pl("ResumeUpdForm.validate 1: errors.size=" + errors.size()); /////
		request.setAttribute("listStates", this.listStates);

    	try  {
    		if (lowSalaryStr != null && lowSalaryStr.trim().length() > 0)  {
    			lowSalary = new BigDecimal(lowSalaryStr.trim());
    		}
    	} catch (NumberFormatException e)  {
    		errors.add("lowSalary", new ActionMessage("error.lowSalary.castFloat"));
    	}
    	try  {
    		if (highSalaryStr != null && highSalaryStr.trim().length() > 0)  {
    			highSalary = new BigDecimal(highSalaryStr.trim());
    		}
    	} catch (NumberFormatException e)  {
    		errors.add("highSalary", new ActionMessage("error.highSalary.castFloat"));
    	}
    	try {
    		if (yearsExpStr != null && yearsExpStr.trim().length() > 0)  {
    			yearsExp = Integer.parseInt(yearsExpStr.trim());
    		}
    	}  catch (NumberFormatException e)  {
    		errors.add("yearsExp", new ActionMessage("error.yearsExp.castInt"));
    	}
    	
    	try  {

    		if (this.birthMth != null && this.birthDay != null && this.birthYr != null)  {
        		String birthDtStr = this.birthMth + "/" + this.birthDay + "/" + this.birthYr;
    			DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
    			this.setBirthDt(df.parse(birthDtStr.trim()));	
    		}
    	} catch (ParseException e)  {
    		errors.add("birthDt", new ActionMessage("error.birthDt.castDt"));
    	}
    	/*
         * If the file size is greater than a given amount.
         */
    	if (fileSelected != null && !fileSelected.getFileName().equals(""))   {
    		System.out.println("ResumeUpdForm.validate: " + fileSelected.getFileName()); /////
    		if (fileSelected.getFileSize() > Math.pow(2, 20)) {
    			errors.add("fileSelected", new ActionMessage("error.file.size"));
    		}

    		boolean inAcceptedExt = false;
    		for (Extension e : Extension.values()) {
    			if (Utilities.rtnExtension(fileSelected.getFileName()).equalsIgnoreCase(e.toString()))  {
    				inAcceptedExt = true;
    			}
    		}
    		if (!inAcceptedExt)  {
    			errors.add("fileSelected", new ActionMessage("error.file.type"));
    		} 
    	}
    	Utilities.pl("ResumeUpdForm.validate 2: errors.size="+errors.size()); ////
		HttpSession userSession = request.getSession();
		userSession.setAttribute("resumeUpdForm", this);
		if (errors.size() > 0)  {
			userSession.setAttribute("continueUpdate", true);
		} else {
			userSession.setAttribute("continueUpdate", false);
		}
     	return errors;
     	
    }
}
