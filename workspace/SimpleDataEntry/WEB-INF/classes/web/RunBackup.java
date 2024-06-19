package web;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RunBackup extends HttpServlet {

	static final String BACKUP_FILE = "c:/Users/nat/Documents/home/Acq_Hibernate_Backup.txt";
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)  {
		runTask(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)  {
		runTask(request, response);
	}
	
	public void runTask(HttpServletRequest request, HttpServletResponse response)  {
		response.setContentType("text/html");
		String fname;
		String lname;
		String mi;
		String street;
		String street2;
		String city;
		String state;
		String zip;
		String hphone;
		String dphone;
		String email;
		String spouse;
		String comments;
		PrintWriter pw = null;
		PrintWriter pw2 = null;
		try  {
			pw = new PrintWriter(new FileWriter(BACKUP_FILE, false));
			pw.print("List<Acquantance> acqs = new ArrayList<Acquantance>();\n\n");
			pw.print("Acquantance acq = null;\n\n");
			pw2 = response.getWriter();
			List acqs = RunQuery.getAddresses();
			if (acqs != null)  {
				Iterator iter = acqs.iterator();
				Acquantance acq;
				while(iter.hasNext()) {
					acq = (Acquantance)iter.next();
					fname = acq.getFname();
					lname = acq.getLname();
					mi = acq.getMi();
					street = acq.getStreet();
					street2 = acq.getStreet2();
					city = acq.getCity();
					state = acq.getState();
					zip = acq.getZip();
					hphone = acq.getHomePhone();
					dphone = acq.getDayPhone();
					email = acq.getEmail();
					spouse = acq.getSpouse();
					comments = acq.getComments();

					if (fname == null) { fname = ""; }
					if (lname == null) { lname  = "";}
					if (mi == null) { mi  = "";}
					if (street == null) { street  = "";}
					if (street2 == null) { street2  = "";}
					if (city == null) { city  = "";}
					if (state == null) { state  = "";}
					if (zip == null) { zip  = "";}
					if (hphone == null) { hphone  = "";}
					if (dphone == null) { dphone  = "";}
					if (email == null) { email  = "";}
					if (spouse == null) { spouse  = "";}
					if (comments == null) { comments  = "";}
					
					StringBuilder addScript = new StringBuilder();
					addScript.append("acq = new Acquantance();\n");
					addScript.append("acq.setFname(\""+fname+"\");\n");
					addScript.append("acq.setLname(\""+lname+"\");\n");
					addScript.append("acq.setMi(\""+mi+"\");\n");
					addScript.append("acq.setStreet(\""+street+"\");\n");
					addScript.append("acq.setStreet2(\""+street2+"\");\n");
					addScript.append("acq.setCity(\""+city+"\");\n");
					addScript.append("acq.setState(\""+state+"\");\n");
					addScript.append("acq.setZip(\""+zip+"\");\n");
					addScript.append("acq.setHomePhone(\""+hphone+"\");\n");
					addScript.append("acq.setDayPhone(\""+dphone+"\");\n");
					addScript.append("acq.setEmail(\""+email+"\");\n");
					addScript.append("acq.setSpouse(\""+spouse+"\");\n");
					addScript.append("acq.setComments(\""+comments+"\");\n");
					addScript.append("acqs.add(acq)\n\n");
					pw.print(addScript.toString());
				}
			}
			pw.print("hibernateTemplate.saveOrUpdateAll(acqs);\n");
			pw2.println("<h3>Save file is '"+BACKUP_FILE+"'</h3>"); 
		} catch(IOException e) {
			e.printStackTrace();
		} catch(Exception e)  {
			e.printStackTrace();
		} finally  {
			if (pw != null) { pw.close(); }
			if (pw2 != null) { pw2.close(); }
		}
	}
}
