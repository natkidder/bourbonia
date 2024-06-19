package app;

import java.io.File; 
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.sql.Blob;
import java.sql.SQLException;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.util.LabelValueBean;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

public class Utilities {
	private Utilities() {
		throw new AssertionError();
	}

	public static final String FILE_ROOT_PATH = "C:/FOO/RESUMES";
	
	public static HttpSession setSession(HttpSession userSession, Resume resume) {
		userSession.setAttribute("firstName", resume.getFirstName() ) ;
		userSession.setAttribute("mi", resume.getMi() ) ;
		userSession.setAttribute("lastName", resume.getLastName() ) ;
		userSession.setAttribute("currEmployed", resume.getCurrEmployed() ) ;
		userSession.setAttribute("street", resume.getStreet() ) ;
		userSession.setAttribute("apt", resume.getApt() ) ;
		userSession.setAttribute("city", resume.getCity() ) ;
		userSession.setAttribute("state", resume.getState() ) ;
		userSession.setAttribute("zip", resume.getZip() ) ;
		userSession.setAttribute("hphone", resume.getHphone() ) ;
		userSession.setAttribute("ophone", resume.getOphone() ) ;
		userSession.setAttribute("cphone", resume.getCphone() ) ;
		userSession.setAttribute("workCity", resume.getWorkCity() ) ;
		userSession.setAttribute("workState", resume.getWorkState() ) ;
		userSession.setAttribute("email", resume.getEmail() ) ;
		userSession.setAttribute("birthMth", resume.getBirthMth() );
		userSession.setAttribute("birthDay", resume.getBirthDay() );
		userSession.setAttribute("birthYr", resume.getBirthYr() );
		userSession.setAttribute("birthDt", resume.getBirthDt() ) ;
		userSession.setAttribute("gender", resume.getGender() ) ;
		userSession.setAttribute("lowSalary", resume.getLowSalary() ) ;
		userSession.setAttribute("highSalary", resume.getHighSalary() ) ;
		userSession.setAttribute("relocation", resume.getRelocation() ) ;
		userSession.setAttribute("comments", resume.getComments() ) ;
		userSession.setAttribute("skill", resume.getSkill() ) ;
		userSession.setAttribute("yearsExp", resume.getYearsExp() ) ;
		return userSession;
	}
	
	public static Resume setResume(ActionForm form, Resume resume)  {
		resume.setId( ( ((ResumeForm) form).getId() ) );
		resume.setFirstName( ((ResumeForm) form).getFirstName() ) ;
		if (resume.getFirstName() != null && resume.getFirstName().equals("")) { resume.setFirstName(null); }
		resume.setMi( ((ResumeForm) form).getMi() ) ;
		if (resume.getMi() != null && resume.getMi().equals("")) { resume.setMi(null); }
		resume.setLastName( ((ResumeForm) form).getLastName() ) ;
		if (resume.getLastName() != null && resume.getLastName().equals("")) { resume.setLastName(null); }
		resume.setCurrEmployed( ((ResumeForm) form).getCurrEmployed() ) ;
		resume.setStreet( ((ResumeForm) form).getStreet() ) ;
		resume.setApt( ((ResumeForm) form).getApt() ) ;
		resume.setCity( ((ResumeForm) form).getCity() ) ;
		resume.setState( ((ResumeForm) form).getState() ) ;
		resume.setZip( ((ResumeForm) form).getZip() ) ;
		resume.setHphone( ((ResumeForm) form).getHphone() ) ;
		resume.setOphone( ((ResumeForm) form).getOphone() ) ;
		resume.setCphone( ((ResumeForm) form).getCphone() ) ;
		resume.setWorkCity( ((ResumeForm) form).getWorkCity() ) ;
		resume.setWorkState( ((ResumeForm) form).getWorkState() ) ;
		resume.setEmail( ((ResumeForm) form).getEmail() ) ;
		if (resume.getEmail() != null && resume.getEmail().equals("")) { resume.setEmail(null); }
		resume.setBirthMth( ((ResumeForm) form).getBirthMth() ) ;
		resume.setBirthDay( ((ResumeForm) form).getBirthDay() ) ;
		resume.setBirthYr( ((ResumeForm) form).getBirthYr() ) ;
		resume.setBirthDt( ((ResumeForm) form).getBirthDt() ) ;
		resume.setGender( ((ResumeForm) form).getGender() ) ;
		resume.setLowSalary( ((ResumeForm) form).getLowSalary() ) ;
		resume.setHighSalary( ((ResumeForm) form).getHighSalary() ) ;
		resume.setRelocation( ((ResumeForm) form).getRelocation() ) ;
		resume.setComments( ((ResumeForm) form).getComments() ) ;
		resume.setSkill( ((ResumeForm) form).getSkill() ) ;
		resume.setYearsExp( ((ResumeForm) form).getYearsExp() ) ;
		return resume;
	}

    public static ResumeForm setResumeForm(ResumeForm resumeForm, Resume resume)  {
    	resumeForm.setId(resume.getId());
        resumeForm.setFirstName(resume.getFirstName() ) ;
        resumeForm.setMi(resume.getMi() ) ;
        resumeForm.setLastName(resume.getLastName() ) ;
        resumeForm.setCurrEmployed(resume.getCurrEmployed() ) ;
        resumeForm.setStreet(resume.getStreet() ) ;
        resumeForm.setApt(resume.getApt() ) ;
        resumeForm.setCity(resume.getCity() ) ;
        resumeForm.setState(resume.getState() ) ;
        resumeForm.setZip(resume.getZip() ) ;
        resumeForm.setHphone(resume.getHphone() ) ;
        resumeForm.setOphone(resume.getOphone() ) ;
        resumeForm.setCphone(resume.getCphone() ) ;
        resumeForm.setWorkCity(resume.getWorkCity() ) ;
        resumeForm.setWorkState(resume.getWorkState() ) ;
        resumeForm.setEmail(resume.getEmail() ) ;
        resumeForm.setBirthMth(resume.getBirthMth() ) ;
        resumeForm.setBirthDay(resume.getBirthDay() ) ;
        resumeForm.setBirthYr(resume.getBirthYr() ) ;
        resumeForm.setBirthDt(resume.getBirthDt() ) ;
        resumeForm.setGender(resume.getGender() ) ;
        resumeForm.setLowSalary(resume.getLowSalary() ) ;
        resumeForm.setHighSalary(resume.getHighSalary() ) ;
        resumeForm.setRelocation(resume.getRelocation() ) ;
        resumeForm.setComments(resume.getComments() ) ;
        resumeForm.setSkill(resume.getSkill() ) ;
        resumeForm.setYearsExp(resume.getYearsExp() ) ;
        return resumeForm;
    }
    
    public static ArrayList<LabelValueBean> setStatesList() {
    	ArrayList<LabelValueBean> listStates = new ArrayList<LabelValueBean>();
        listStates.add( new LabelValueBean( "ALABAMA", "ALABAMA" ) );
        listStates.add( new LabelValueBean( "ALASKA", "ALASKA" ) );
        listStates.add( new LabelValueBean( "AMERICAN SAMOA", "AMERICAN SAMOA" ) );
        listStates.add( new LabelValueBean( "ARIZONA", "ARIZONA" ) );
        listStates.add( new LabelValueBean( "ARKANSAS", "ARKANSAS" ) );
        listStates.add( new LabelValueBean( "CALIFORNIA", "CALIFORNIA" ) );
        listStates.add( new LabelValueBean( "COLORADO", "COLORADO" ) );
        listStates.add( new LabelValueBean( "CONNECTICUT", "CONNECTICUT" ) );
        listStates.add( new LabelValueBean( "DELAWARE", "DELAWARE" ) );
        listStates.add( new LabelValueBean( "DISTRICT OF COLUMBIA", "DISTRICT OF COLUMBIA" ) );
        listStates.add( new LabelValueBean( "FEDERATED STATES OF MICRONESIA", "FEDERATED STATES OF MICRONESIA" ) );
        listStates.add( new LabelValueBean( "FLORIDA", "FLORIDA" ) );
        listStates.add( new LabelValueBean( "GEORGIA", "GEORGIA" ) );
        listStates.add( new LabelValueBean( "GUAM", "GUAM" ) );
        listStates.add( new LabelValueBean( "HAWAII", "HAWAII" ) );
        listStates.add( new LabelValueBean( "IDAHO", "IDAHO" ) );
        listStates.add( new LabelValueBean( "ILLINOIS", "ILLINOIS" ) );
        listStates.add( new LabelValueBean( "INDIANA", "INDIANA" ) );
        listStates.add( new LabelValueBean( "IOWA", "IOWA" ) );
        listStates.add( new LabelValueBean( "KANSAS", "KANSAS" ) );
        listStates.add( new LabelValueBean( "KENTUCKY", "KENTUCKY" ) );
        listStates.add( new LabelValueBean( "LOUISIANA", "LOUISIANA" ) );
        listStates.add( new LabelValueBean( "MAINE", "MAINE" ) );
        listStates.add( new LabelValueBean( "MARSHALL ISLANDS", "MARSHALL ISLANDS" ) );
        listStates.add( new LabelValueBean( "MARYLAND", "MARYLAND" ) );
        listStates.add( new LabelValueBean( "MASSACHUSETTS", "MASSACHUSETTS" ) );
        listStates.add( new LabelValueBean( "MICHIGAN", "MICHIGAN" ) );
        listStates.add( new LabelValueBean( "MINNESOTA", "MINNESOTA" ) );
        listStates.add( new LabelValueBean( "MISSISSIPPI", "MISSISSIPPI" ) );
        listStates.add( new LabelValueBean( "MISSOURI", "MISSOURI" ) );
        listStates.add( new LabelValueBean( "MONTANA", "MONTANA" ) );
        listStates.add( new LabelValueBean( "NEBRASKA", "NEBRASKA" ) );
        listStates.add( new LabelValueBean( "NEVADA", "NEVADA" ) );
        listStates.add( new LabelValueBean( "NEW HAMPSHIRE", "NEW HAMPSHIRE" ) );
        listStates.add( new LabelValueBean( "NEW JERSEY", "NEW JERSEY" ) );
        listStates.add( new LabelValueBean( "NEW MEXICO", "NEW MEXICO" ) );
        listStates.add( new LabelValueBean( "NEW YORK", "NEW YORK" ) );
        listStates.add( new LabelValueBean( "NORTH CAROLINA", "NORTH CAROLINA" ) );
        listStates.add( new LabelValueBean( "NORTH DAKOTA", "NORTH DAKOTA" ) );
        listStates.add( new LabelValueBean( "NORTHERN MARIANA ISLANDS", "NORTHERN MARIANA ISLANDS" ) );
        listStates.add( new LabelValueBean( "OHIO", "OHIO" ) );
        listStates.add( new LabelValueBean( "OKLAHOMA", "OKLAHOMA" ) );
        listStates.add( new LabelValueBean( "OREGON", "OREGON" ) );
        listStates.add( new LabelValueBean( "PALAU", "PALAU" ) );
        listStates.add( new LabelValueBean( "PENNSYLVANIA", "PENNSYLVANIA" ) );
        listStates.add( new LabelValueBean( "PUERTO RICO", "PUERTO RICO" ) );
        listStates.add( new LabelValueBean( "RHODE ISLAND", "RHODE ISLAND" ) );
        listStates.add( new LabelValueBean( "SOUTH CAROLINA", "SOUTH CAROLINA" ) );
        listStates.add( new LabelValueBean( "SOUTH DAKOTA", "SOUTH DAKOTA" ) );
        listStates.add( new LabelValueBean( "TENNESSEE", "TENNESSEE" ) );
        listStates.add( new LabelValueBean( "TEXAS", "TEXAS" ) );
        listStates.add( new LabelValueBean( "UTAH", "UTAH" ) );
        listStates.add( new LabelValueBean( "VERMONT", "VERMONT" ) );
        listStates.add( new LabelValueBean( "VIRGIN ISLANDS", "VIRGIN ISLANDS" ) );
        listStates.add( new LabelValueBean( "VIRGINIA", "VIRGINIA" ) );
        listStates.add( new LabelValueBean( "WASHINGTON", "WASHINGTON" ) );
        listStates.add( new LabelValueBean( "WEST VIRGINIA", "WEST VIRGINIA" ) );
        listStates.add( new LabelValueBean( "WISCONSIN", "WISCONSIN" ) );
        listStates.add( new LabelValueBean( "WYOMING", "WYOMING" ) );
    	return listStates;
    }

	public static ArrayList<LabelValueBean> setMonthList() {
    	ArrayList<LabelValueBean> listMth = new ArrayList<LabelValueBean>();
        listMth.add( new LabelValueBean( "January", "1") );
        listMth.add( new LabelValueBean( "February", "2") );
        listMth.add( new LabelValueBean( "March", "3") );
        listMth.add( new LabelValueBean( "April", "4") );
        listMth.add( new LabelValueBean( "May", "5") );
        listMth.add( new LabelValueBean( "June", "6") );
        listMth.add( new LabelValueBean( "July", "7") );
        listMth.add( new LabelValueBean( "August", "8") );
        listMth.add( new LabelValueBean( "September", "9") );
        listMth.add( new LabelValueBean( "October", "10") );
        listMth.add( new LabelValueBean( "November", "11") );
        listMth.add( new LabelValueBean( "December", "12") );
		return listMth;
	}

	
	public static ArrayList<LabelValueBean> setDayList() {
    	ArrayList<LabelValueBean> listDay = new ArrayList<LabelValueBean>();
        listDay.add( new LabelValueBean( "1", "1") );
        listDay.add( new LabelValueBean( "2", "2") );
        listDay.add( new LabelValueBean( "3", "3") );
        listDay.add( new LabelValueBean( "4", "4") );
        listDay.add( new LabelValueBean( "5", "5") );
        listDay.add( new LabelValueBean( "6", "6") );
        listDay.add( new LabelValueBean( "7", "7") );
        listDay.add( new LabelValueBean( "8", "8") );
        listDay.add( new LabelValueBean( "9", "9") );
        listDay.add( new LabelValueBean( "10", "10") );
        listDay.add( new LabelValueBean( "11", "11") );
        listDay.add( new LabelValueBean( "12", "12") );
        listDay.add( new LabelValueBean( "13", "13") );
        listDay.add( new LabelValueBean( "14", "14") );
        listDay.add( new LabelValueBean( "15", "15") );
        listDay.add( new LabelValueBean( "16", "16") );
        listDay.add( new LabelValueBean( "17", "17") );
        listDay.add( new LabelValueBean( "18", "18") );
        listDay.add( new LabelValueBean( "19", "19") );
        listDay.add( new LabelValueBean( "20", "20") );
        listDay.add( new LabelValueBean( "21", "21") );
        listDay.add( new LabelValueBean( "22", "22") );
        listDay.add( new LabelValueBean( "23", "23") );
        listDay.add( new LabelValueBean( "24", "24") );
        listDay.add( new LabelValueBean( "25", "25") );
        listDay.add( new LabelValueBean( "26", "26") );
        listDay.add( new LabelValueBean( "27", "27") );
        listDay.add( new LabelValueBean( "28", "28") );
        listDay.add( new LabelValueBean( "29", "29") );
        listDay.add( new LabelValueBean( "30", "30") );
        listDay.add( new LabelValueBean( "31", "31") );
		return listDay;
	}

	public static ArrayList<LabelValueBean> setYearList() {
    	ArrayList<LabelValueBean> listYr = new ArrayList<LabelValueBean>();
        listYr.add( new LabelValueBean( "1930", "1930") );
        listYr.add( new LabelValueBean( "1931", "1931") );
        listYr.add( new LabelValueBean( "1932", "1932") );
        listYr.add( new LabelValueBean( "1933", "1933") );
        listYr.add( new LabelValueBean( "1934", "1934") );
        listYr.add( new LabelValueBean( "1935", "1935") );
        listYr.add( new LabelValueBean( "1936", "1936") );
        listYr.add( new LabelValueBean( "1937", "1937") );
        listYr.add( new LabelValueBean( "1938", "1938") );
        listYr.add( new LabelValueBean( "1939", "1939") );
        listYr.add( new LabelValueBean( "1940", "1940") );
        listYr.add( new LabelValueBean( "1941", "1941") );
        listYr.add( new LabelValueBean( "1942", "1942") );
        listYr.add( new LabelValueBean( "1943", "1943") );
        listYr.add( new LabelValueBean( "1944", "1944") );
        listYr.add( new LabelValueBean( "1945", "1945") );
        listYr.add( new LabelValueBean( "1946", "1946") );
        listYr.add( new LabelValueBean( "1947", "1947") );
        listYr.add( new LabelValueBean( "1948", "1948") );
        listYr.add( new LabelValueBean( "1949", "1949") );
        listYr.add( new LabelValueBean( "1950", "1950") );
        listYr.add( new LabelValueBean( "1951", "1951") );
        listYr.add( new LabelValueBean( "1952", "1952") );
        listYr.add( new LabelValueBean( "1953", "1953") );
        listYr.add( new LabelValueBean( "1954", "1954") );
        listYr.add( new LabelValueBean( "1955", "1955") );
        listYr.add( new LabelValueBean( "1956", "1956") );
        listYr.add( new LabelValueBean( "1957", "1957") );
        listYr.add( new LabelValueBean( "1958", "1958") );
        listYr.add( new LabelValueBean( "1959", "1959") );
        listYr.add( new LabelValueBean( "1960", "1960") );
        listYr.add( new LabelValueBean( "1961", "1961") );
        listYr.add( new LabelValueBean( "1962", "1962") );
        listYr.add( new LabelValueBean( "1963", "1963") );
        listYr.add( new LabelValueBean( "1964", "1964") );
        listYr.add( new LabelValueBean( "1965", "1965") );
        listYr.add( new LabelValueBean( "1966", "1966") );
        listYr.add( new LabelValueBean( "1967", "1967") );
        listYr.add( new LabelValueBean( "1968", "1968") );
        listYr.add( new LabelValueBean( "1969", "1969") );
        listYr.add( new LabelValueBean( "1970", "1970") );
        listYr.add( new LabelValueBean( "1971", "1971") );
        listYr.add( new LabelValueBean( "1972", "1972") );
        listYr.add( new LabelValueBean( "1973", "1973") );
        listYr.add( new LabelValueBean( "1974", "1974") );
        listYr.add( new LabelValueBean( "1975", "1975") );
        listYr.add( new LabelValueBean( "1976", "1976") );
        listYr.add( new LabelValueBean( "1977", "1977") );
        listYr.add( new LabelValueBean( "1978", "1978") );
        listYr.add( new LabelValueBean( "1979", "1979") );
        listYr.add( new LabelValueBean( "1980", "1980") );
        listYr.add( new LabelValueBean( "1981", "1981") );
        listYr.add( new LabelValueBean( "1982", "1982") );
        listYr.add( new LabelValueBean( "1983", "1983") );
        listYr.add( new LabelValueBean( "1984", "1984") );
        listYr.add( new LabelValueBean( "1985", "1985") );
        listYr.add( new LabelValueBean( "1986", "1986") );
        listYr.add( new LabelValueBean( "1987", "1987") );
        listYr.add( new LabelValueBean( "1988", "1988") );
        listYr.add( new LabelValueBean( "1989", "1989") );
        listYr.add( new LabelValueBean( "1990", "1990") );
        listYr.add( new LabelValueBean( "1991", "1991") );
        listYr.add( new LabelValueBean( "1992", "1992") );
        listYr.add( new LabelValueBean( "1993", "1993") );
        listYr.add( new LabelValueBean( "1994", "1994") );
        listYr.add( new LabelValueBean( "1995", "1995") );
		return listYr;
	}
	
	public static ArrayList<LabelValueBean> setCurrEmplList() {
    	ArrayList<LabelValueBean> listCurrEmpl = new ArrayList<LabelValueBean>();
    		listCurrEmpl.add( new LabelValueBean( "YES", "Y") );
    		listCurrEmpl.add( new LabelValueBean( "NO", "N") );
    		return listCurrEmpl;
	}
	
	public static ArrayList<LabelValueBean> setGenderList() {
    	ArrayList<LabelValueBean> listGender = new ArrayList<LabelValueBean>();
    		listGender.add( new LabelValueBean( "MALE", "M") );
    		listGender.add( new LabelValueBean( "FEMALE", "F") );
    		return listGender;
	}
	
	public static String rtnExtension(String filename)  {
		if (filename == null)  { return ""; }
		String extension = "";
		for (int i = filename.length(); !filename.substring(i-1,i).equals("."); i--)  {
			extension = filename.substring(i-1,i) + extension;
		}
		return extension;
	}

    public static List<String> showEmails(String text) {

        // Get the session factory we can use for persistence
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        // Ask for a session using the JDBC information we've configured
        Session session = sessionFactory.openSession();
        try {
        	Criteria criteria = session.createCriteria(Resume.class);
        	//criteria.add(Restrictions.like("title", "%" + text + "%").ignoreCase());
        	criteria.add(Property.forName("email").like("%" + text + "%").ignoreCase());
        	criteria.setProjection(Projections.projectionList().
        			add(Projections.property("email")));
        	List<String> emails = criteria.list();
         	return emails;
        } finally {
        	session.close();
            sessionFactory.close();
        }

    }
    
    public static void writeToDisk(String email, FormFile formFile) throws IOException   {
    	if (formFile.getFileName().equals(""))   {
    		return;
    	}
		String filePath = Utilities.FILE_ROOT_PATH + "/" + email;
		FileOutputStream outputStream = null;
		File resumeDir = new File(filePath);
		try {
			if (!resumeDir.isDirectory())  {
				if (!resumeDir.mkdir())  {
					System.out.println("failed to make directory: " + filePath);
				}
			}
			File resumeFile = new File(filePath + "/" + formFile.getFileName());

			outputStream = new FileOutputStream(resumeFile);
			outputStream.write(formFile.getFileData());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (outputStream != null)
				outputStream.close();
		}
    }
	
}
