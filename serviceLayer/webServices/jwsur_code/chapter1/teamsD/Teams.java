
package teamsD;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.1 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebService(name = "Teams", targetNamespace = "http://team.ch01/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Teams {


    /**
     * 
     * @param arg0
     * @return
     *     returns teamsD.Team
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getTeam", targetNamespace = "http://team.ch01/", className = "teamsD.GetTeam")
    @ResponseWrapper(localName = "getTeamResponse", targetNamespace = "http://team.ch01/", className = "teamsD.GetTeamResponse")
    public Team getTeam(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @return
     *     returns java.util.List<teamsD.Team>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getTeams", targetNamespace = "http://team.ch01/", className = "teamsD.GetTeams")
    @ResponseWrapper(localName = "getTeamsResponse", targetNamespace = "http://team.ch01/", className = "teamsD.GetTeamsResponse")
    public List<Team> getTeams();

}