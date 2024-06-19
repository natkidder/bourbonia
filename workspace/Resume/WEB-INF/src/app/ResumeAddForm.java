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
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;

import java.security.NoSuchAlgorithmException;
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

public class ResumeAddForm extends Resume {

	private static final long serialVersionUID = 552564352353004869L;

	private String step;  // if the calling form is multi-buttoned

	private String passwd1;
	private String passwd2;
	public ArrayList<LabelValueBean> listStates = Utilities.setStatesList();
	public ArrayList<LabelValueBean> listMth = Utilities.setMonthList();
	public ArrayList<LabelValueBean> listDay = Utilities.setDayList();
	public ArrayList<LabelValueBean> listYr = Utilities.setYearList();
	public ArrayList<LabelValueBean> listCurrEmpl = Utilities.setCurrEmplList();
	public ArrayList<LabelValueBean> listGender = Utilities.setGenderList();

	public void setStep(String step)  {
		this.step = step;
	}
	public String getStep()  {
		return this.step;
	}

	public String getPasswd1() {
		return passwd1;
	}
	public void setPasswd1(String passwd1) {
		this.passwd1 = passwd1;
	}
	public String getPasswd2() {
		return passwd2;
	}
	public void setPasswd2(String passwd2) {
		this.passwd2 = passwd2;
	}

	public void setMi(String mi) {
		if (mi != null && mi.length() > 0)  {
			this.mi = mi.substring(0,1);
		}
	}

	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {

		if (this.getStep().equals("Home"))  {
			return null;
		}
		ActionErrors errors = new ActionErrors();
		request.setAttribute("listStates", this.listStates);

		if (email.length() == 0)  {
			errors.add("email", new ActionMessage("error.acct.exists"));
		} 
/*		else if (! email.matches(".+\\@.+")) {
			errors.add("email", new ActionMessage("error.acct.format"));
		}
*/
		if (passwd1 == null || passwd2 == null || passwd1.length() == 0 || passwd2.length() == 0)  {
			errors.add("passwd", new ActionMessage("error.passwd.existence"));
		}
		if (passwd1.length() > 0 && passwd2.length() > 0)  {
			if (passwd1.length() < Utilities.MIN_PASSWD_LEN || passwd2.length() < Utilities.MIN_PASSWD_LEN)  {
				errors.add("passwd", new ActionMessage("error.passwd.length"));
			} else if (! passwd1.equals(passwd2))  {
				errors.add("passwd", new ActionMessage("error.passwd.duplicate"));
			} 
		}

    	try  {
    		if (this.birthMth != null && this.birthDay != null && this.birthYr != null)  {
        		String birthDtStr = this.birthMth + "/" + this.birthDay + "/" + this.birthYr;
    			DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
    			this.birthDt = df.parse(birthDtStr.trim());	
    		}
    	} catch (ParseException e)  {
    		errors.add("birthDt", new ActionMessage("error.birthDt.castDt"));
    	}		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			Resume tmpResume = new Resume();
			tmpResume.setEmail(this.getEmail());
			Example example = Example.create(tmpResume);
			example.excludeProperty("currEmployed");
			example.excludeProperty("state");
			example.excludeProperty("gender");
			example.excludeProperty("workState");
			example.excludeProperty("employed");
			//		System.out.println(example.toString());   ////
			Criteria criteria = session.createCriteria(Resume.class);
			criteria.add(example);
			criteria.addOrder(Order.asc("lastName"));
			List resumeList = criteria.list();
			if (resumeList.size() > 0)  {
				errors.add("passwd", new ActionMessage("account.already.added"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			try {
				if (session != null)  {
					session.close();
					sessionFactory.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
		HttpSession userSession = request.getSession();
		userSession.setAttribute("resumeAddForm", this);
		if (errors.size() > 0)  {
			userSession.setAttribute("startRegistration", true);
		} else {
			userSession.setAttribute("startRegistration", false);
		}
		return errors;  	
	}
}