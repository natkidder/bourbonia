package app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.LabelValueBean;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;

import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import java.math.*;

public class FindForm extends Login {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String email;
	public String passwd1;
	public String step;
	public ArrayList<LabelValueBean> listStates = Utilities.setStatesList();
	public ArrayList<LabelValueBean> listMth = Utilities.setMonthList();
	public ArrayList<LabelValueBean> listDay = Utilities.setDayList();
	public ArrayList<LabelValueBean> listYr = Utilities.setYearList();
	public ArrayList<LabelValueBean> listCurrEmpl = Utilities.setCurrEmplList();
	public ArrayList<LabelValueBean> listGender = Utilities.setGenderList();

	public void setStep(String step)  {
		this.step = step;
	}
	public String getStep() {
		return this.step;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswd1() {
		return passwd1;
	}
	public void setPasswd1(String passwd1) {
		this.passwd1 = passwd1;
	}

	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();

		if (this.getStep().equals("Login"))  {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			if (this.passwd1.length() > 0) {
				try {
					Login tmpLogin = new Login();
					tmpLogin.setEmail(this.getEmail());
					tmpLogin.setPasswd(Turnpike.genHash(this.getPasswd1()));
					Example example = Example.create(tmpLogin);
					System.out.println("FindForm.ActionErrors, email = " + this.getEmail() + "  passwd = '" + this.getPasswd1() + "'"); ////
					//		System.out.println(example.toString());   ////
					Criteria criteria = session.createCriteria(Login.class);
					criteria.add(example);
					List loginList = criteria.list();
					System.out.println("FindForm.ActionErrors, loginList.size = " + loginList.size()); ////
					if (loginList.size() < 1)  {
						errors.add("passwd", new ActionMessage("error.authenticated.refused"));
					} else {
						ListIterator listIterator = loginList.listIterator();
						HttpSession userSession = request.getSession(false);
						//					userSession.setAttribute(tmpLogin.getEmail() + "resumeFromFindForm", listIterator.next()); 
					}
				} catch (Exception e) {
					e.printStackTrace();
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
			} else {
				errors.add("passwd", new ActionMessage("error.authenticated.refused"));
			}
		}
		return errors;
	}
}
