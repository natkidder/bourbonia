import java.util.*;

public class CalcTimeDiff {

	private static String MON_OF_YEAR = "JanFebMarAprMayJunJulAugSepOctNovDec";

    public static void main(String args[]) {
		String firstAccess = "171.182.78.209 - - [18/Nov/2011:00:00:54 -0600] \"GET /monitor/bigip.jsp HTTP/1.0\" 200 15";
		String startAccess = getAccessString(firstAccess); //"18/Nov/2011:00:00:54";
		String lastAccess = "171.182.78.209 - - [18/Nov/2011:00:01:29 -0600] \"GET /monitor/bigip.jsp HTTP/1.0\" 200 15";
		String endAccess =  getAccessString(lastAccess);
		System.out.println(startAccess+"    "+endAccess); ////
		long AccessMilliseconds = (getEpochAccessTime(endAccess) - getEpochAccessTime(startAccess));
		System.out.println("Access sample period took " + AccessMilliseconds + " milliseconds");
		String firstSession = "<Oct 29, 2011 5:25:29 AM CDT> <Notice> <Stdout> <000000> <2011-10-29 05:25:29,864 | INFO  com.bofa.security.sso.CompleteCreateSessionController - ================================BEGIN COMPLETE_CREATE_SESSION REQUEST======================>";
		String startSession = getSessionString(firstSession); //"2011-10-29 05:25:29,864";
		String lastSession= "<Oct 29, 2011 5:25:30 AM CDT> <Notice> <Stdout> <000000> <2011-10-29 05:25:30,245 | INFO  com.bofa.security.sso.CompleteCreateSessionController - ================================BEGIN COMPLETE_CREATE_SESSION REQUEST======================>";
		String endSession = getSessionString(lastSession);
		System.out.println(startSession+"     "+endSession); ////
		long SessionMilliseconds = (getEpochSessionTime(endSession) - getEpochSessionTime(startSession));
		System.out.println("Session sample period took " + SessionMilliseconds + " milliseconds");
	}

	private static String getAccessString(String logLine) {
		return logLine.split("\\[")[1].split(" ")[0];
	}

	private static String getSessionString(String logLine) {
		return logLine.split("<")[5].split("\\|")[0];
	}

	private static long getEpochAccessTime(String strTime)  {
        Calendar time = Calendar.getInstance();
	    List<String> stDay = Arrays.asList(strTime.split("/"));
	    List<String> stTime = Arrays.asList(stDay.get(2).split(":"));
	    stDay.set(2,stTime.get(0).toString());
	    //stTime.remove(0);
	    int year = Integer.parseInt(stDay.get(2));
	    int month = MON_OF_YEAR.indexOf(stDay.get(1))/3 - 1;
	    int day = Integer.parseInt(stDay.get(0));
	    int hour = Integer.parseInt(stTime.get(1));
	    int min = Integer.parseInt(stTime.get(2));
	    int sec = Integer.parseInt(stTime.get(3));
	    time.set(year, month, day, hour, min, sec);
	    return time.getTimeInMillis();
	}

	private static long getEpochSessionTime(String strTime)  {
        Calendar time = Calendar.getInstance();
        String[] components = strTime.split(" ");
	    List<String> stDay = Arrays.asList(components[0].split("-"));
	    List<String> stTime = Arrays.asList(components[1].split(":"));
	    int year = Integer.parseInt(stDay.get(0));
	    int month = Integer.parseInt(stDay.get(1));
	    int day = Integer.parseInt(stDay.get(2));
	    int hour = Integer.parseInt(stTime.get(0));
	    int min = Integer.parseInt(stTime.get(1));
	    int sec = Integer.parseInt(stTime.get(2).split(",")[0]);
	    long millisec = Long.parseLong(stTime.get(2).split(",")[1]);
	    time.set(year, month, day, hour, min, sec);
	    return time.getTimeInMillis()+millisec;
	}
}

/*
171.182.78.209 - - [18/Nov/2011:00:00:54 -0600] "GET /monitor/bigip.jsp HTTP/1.0" 200 15
171.182.78.209 - - [18/Nov/2011:00:01:00 -0600] "GET /monitor/bigip.jsp HTTP/1.0" 200 15
171.182.78.209 - - [18/Nov/2011:00:01:00 -0600] "GET /monitor/bigip.jsp HTTP/1.0" 200 15
171.182.78.209 - - [18/Nov/2011:00:01:24 -0600] "GET /monitor/bigip.jsp HTTP/1.0" 200 15
171.182.78.209 - - [18/Nov/2011:00:01:29 -0600] "GET /monitor/bigip.jsp HTTP/1.0" 200 15

<Oct 29, 2011 5:25:29 AM CDT> <Notice> <Stdout> <000000> <2011-10-29 05:25:29,864 | INFO  com.bofa.security.sso.CompleteCreateSessionController - ================================BEGIN COMPLETE_CREATE_SESSION REQUEST======================>
<Oct 29, 2011 5:25:29 AM CDT> <Notice> <Stdout> <000000> <2011-10-29 05:25:29,951 | INFO  com.bofa.security.sso.CompleteCreateSessionController -  uid: sprofile>
<Oct 29, 2011 5:25:29 AM CDT> <Notice> <Stdout> <000000> <2011-10-29 05:25:29,967 | INFO  com.bofa.security.sso.CompleteCreateSessionController -  signature verification for userid: sprofile successful>
<Oct 29, 2011 5:25:29 AM CDT> <Notice> <Stdout> <000000> <2011-10-29 05:25:29,971 | INFO  com.bofa.security.sso.CompleteCreateSessionController -  subject: [UidPrincipal:sprofile]>
<Oct 29, 2011 5:25:29 AM CDT> <Notice> <Stdout> <000000> <2011-10-29 05:25:29,973 | INFO  com.bofa.security.sso.SiteXferController -  Creating the signature for principal sprofile>
<Oct 29, 2011 5:25:29 AM CDT> <Notice> <Stdout> <000000> <2011-10-29 05:25:29,974 | INFO  com.bofa.security.sso.SiteXferController -  Authenticating the user sprofile>
<Oct 29, 2011 5:25:30 AM CDT> <Notice> <Stdout> <000000> <2011-10-29 05:25:30,195 | INFO  com.bofa.security.authentication.SiteMinderAgentAPIAuthenticator - User [sprofile] has been successfully authenticated: 1>
<Oct 29, 2011 5:25:30 AM CDT> <Notice> <Stdout> <000000> <2011-10-29 05:25:30,245 | INFO  com.bofa.security.sso.CompleteCreateSessionController - ================================BEGIN COMPLETE_CREATE_SESSION REQUEST======================>

*/
