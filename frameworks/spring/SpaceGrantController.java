package gov.nasa.needs.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

import gov.nasa.needs.service.SGAffiliateService;
import gov.nasa.needs.sg.dao.attr.AffiliateAttr;
import gov.nasa.needs.sg.dao.attr.ContactAttr;
import static gov.nasa.needs.constant.SGAffiliateFields.*;

@Controller
@Scope("request")
public class SpaceGrantController extends AbstractController {
	// full-fledge example of a data entry screen that can do it all
	
	private Logger logger = Logger.getLogger(getClass());

	@Autowired
	protected SGAffiliateService sgAffiliateService;
	
    @Autowired
    protected HttpServletRequest request;

	@RequestMapping(SPACE_GRANT_HOME_PATH)
	public ModelAndView home(@RequestParam(OEPM_PROJECT_ID_FIELD) int oepmProjectId) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put(OEPM_PROJECT_ID_FIELD, oepmProjectId);
		return new ModelAndView(SPACE_GRANT_HOME_VIEW, model);
	}

	/* =========================== Affiliates ======================================= */

	@RequestMapping(LIST_SPACE_GRANT_AFFILS_STATE_PATH)
	public ModelAndView listAffilsByState(@RequestParam(OEPM_PROJECT_ID_FIELD) int oepmProjectId,
			@RequestParam(SHORT_STATE_FIELD) String shortState) {
		Map<String, Object> model = new HashMap<String, Object>();
		List<AffiliateAttr> aAttrs = sgAffiliateService.getAffilsByState(oepmProjectId, shortState);
		logger.warn("aAttrs.size="+aAttrs.size()); ////
		model.put(OEPM_PROJECT_ID_FIELD, oepmProjectId);
		model.put(AFFILIATE_BEANS, aAttrs);
		model.put(AFFILIATE_STATES_NAME, AFFILIATE_STATES);
		model.put(AFFILIATE_ORG_TYPES_NAME, AFFILIATE_ORG_TYPES);
		model.put(FILTER_BY_STATE, true);
		return new ModelAndView(LIST_SPACE_GRANT_AFFILIATES_VIEW, model);
	}

	@RequestMapping(LIST_SPACE_GRANT_AFFILIATES_PATH)
	public ModelAndView listAffiliates(@RequestParam(OEPM_PROJECT_ID_FIELD) int oepmProjectId,
			@RequestParam(FILTER_BY_STATE) boolean filterByState) {
		Map<String, Object> model = new HashMap<String, Object>();
		List<AffiliateAttr> aAttrs = sgAffiliateService.getAffiliates(oepmProjectId);
		logger.warn("aAttrs.size="+aAttrs.size()); ////
		model.put(OEPM_PROJECT_ID_FIELD, oepmProjectId);
		model.put(AFFILIATE_BEANS, aAttrs);
		model.put(AFFILIATE_STATES_NAME, AFFILIATE_STATES);
		model.put(AFFILIATE_ORG_TYPES_NAME, AFFILIATE_ORG_TYPES);
		model.put(FILTER_BY_STATE, filterByState);
		return new ModelAndView(LIST_SPACE_GRANT_AFFILIATES_VIEW, model);
	}

	@RequestMapping(NEW_SPACE_GRANT_AFFILIATE_PATH)
	public ModelAndView newAffiliate(
			@RequestParam(OEPM_PROJECT_ID_FIELD) int oepmProjectId) {
		Map<String, Object> model = new HashMap<String, Object>();
		String fy = (String)request.getAttribute("FY");
		AffiliateAttr aAttr = new AffiliateAttr();
		model.put(AFFILIATE_BEAN, aAttr);
		model.put(OEPM_PROJECT_ID_FIELD, oepmProjectId);
		model.put(AFFILIATE_ID_FIELD, aAttr.getId());
		model.put(AFFILIATE_STATES_NAME, AFFILIATE_STATES);
		model.put(AFFILIATE_ORG_TYPES_NAME, AFFILIATE_ORG_TYPES);
		return new ModelAndView(EDIT_SPACE_GRANT_AFFILIATE_VIEW, model);	
	}

	@RequestMapping(EDIT_SPACE_GRANT_AFFILIATE_PATH)
	public ModelAndView editAffiliate(@RequestParam(AFFILIATE_ID_FIELD) int idAffiliate) {
		Map<String, Object> model = new HashMap<String, Object>();
		String fy = (String)request.getAttribute("FY");
		AffiliateAttr aAttr = sgAffiliateService.getAffiliate(idAffiliate);
		if (aAttr == null)  {
			aAttr = new AffiliateAttr();
		}
		model.put(AFFILIATE_BEAN, aAttr);
		model.put(OEPM_PROJECT_ID_FIELD, aAttr.getOepmProjectId());
		model.put(AFFILIATE_ID_FIELD, aAttr.getId());
		model.put(AFFILIATE_STATES_NAME, AFFILIATE_STATES);
		model.put(AFFILIATE_ORG_TYPES_NAME, AFFILIATE_ORG_TYPES);
		return new ModelAndView(EDIT_SPACE_GRANT_AFFILIATE_VIEW, model);
	}

	@RequestMapping(value=UPDATE_SPACE_GRANT_AFFILIATE_PATH, method=RequestMethod.POST)
	public ModelAndView updAffiliate() {
/*		logger.warn("request.getParameter(oepmProjectId)=|"+request.getParameter("oepmProjectId")+"|"); ////
		logger.warn("request.getParameter(idAffiliate)=|"+request.getParameter("idAffiliate")+"|"); ////
		logger.warn("request.getParameter(state)=|"+request.getParameter("state")+"|"); ////
		logger.warn("request.getParameter(tmpQTxt)=|"+request.getParameter("tmpQTxt")+"|"); ////
		logger.warn("request.getParameter(nameOrg)=|"+request.getParameter("nameOrg")+"|"); ////
		logger.warn("request.getParameter(typeOrg)=|"+request.getParameter("typeOrg")+"|"); ////
*/		logger.warn("request.getParameter(lead)=|"+request.getParameter("lead")+"|"); ////
		AffiliateAttr aAttr = fromAffiliatePosting(request);
		logger.warn("aAttr.getoepmProjectId=|"+aAttr.getOepmProjectId()+"|"); ////
		logger.warn("aAttr.getidAffiliate=|"+aAttr.getId()+"|"); ////
		logger.warn("aAttr.getstate=|"+aAttr.getState()+"|"); ////
		logger.warn("aAttr.getNameInst=|"+aAttr.getNameInst()+"|"); ////
		logger.warn("aAttr.getNameOrg=|"+aAttr.getNameOrg()+"|"); ////
		logger.warn("aAttr.getTypeOrg=|"+aAttr.getTypeOrg()+"|"); ////		
		if (request.getParameter("idAffiliate").equals("-1"))  {
			aAttr.setId(sgAffiliateService.createAffiliate(aAttr));
		} else {
			sgAffiliateService.updateAffiliate(aAttr);
		}
		if (request.getParameter("lead").equals("Y"))  {
			sgAffiliateService.replacePrimaryAffiliate(aAttr.getOepmProjectId(), aAttr.getId());
		}
		if (aAttr.getNameOrg().equals(""))  {
			aAttr.setTypeOrg("");
		}
		Map<String, Object> model = new HashMap<String, Object>();
		model.put(AFFILIATE_BEAN, aAttr);
		model.put(AFFILIATE_ID_FIELD, aAttr.getId());
		model.put(OEPM_PROJECT_ID_FIELD, aAttr.getOepmProjectId());
		model.put(AFFILIATE_STATES_NAME, AFFILIATE_STATES);
		model.put(AFFILIATE_ORG_TYPES_NAME, AFFILIATE_ORG_TYPES);
		return new ModelAndView(EDIT_SPACE_GRANT_AFFILIATE_VIEW, model);
	}

	@RequestMapping(DELETE_SPACE_GRANT_AFFILIATE_PATH)
	public ModelAndView delAffiliate(@RequestParam(AFFILIATE_ID_FIELD) int idAffiliate) {
		int oepmProjectId = sgAffiliateService.getAffiliate(idAffiliate).getOepmProjectId();
		// TODO: Have the affiliate contacts get deleted as well
		sgAffiliateService.deleteAffiliate(idAffiliate);
		Map<String, Object> model = new HashMap<String, Object>();
		List<AffiliateAttr> aAttrs = sgAffiliateService.getAffiliates(oepmProjectId);
		logger.warn("aAttrs.size="+aAttrs.size()); ////
		model.put(OEPM_PROJECT_ID_FIELD, oepmProjectId);
		model.put(AFFILIATE_BEANS, aAttrs);
		model.put(AFFILIATE_STATES_NAME, AFFILIATE_STATES);
		model.put(AFFILIATE_ORG_TYPES_NAME, AFFILIATE_ORG_TYPES);
		return new ModelAndView(LIST_SPACE_GRANT_AFFILIATES_VIEW, model);
	}

	/* =========================== Contacts ======================================= */
	
	@RequestMapping(LIST_SPACE_GRANT_CONTACTS_PATH)
	public ModelAndView listContacts(@RequestParam(AFFILIATE_ID_FIELD) int idAffiliate) {
		Map<String, Object> model = new HashMap<String, Object>();
		//model.put(AFFILIATE_ID_FIELD, idAffiliate);
		List<ContactAttr> cAttrs = sgAffiliateService.getAffiliateContacts(idAffiliate);
		logger.warn("cAttrs.size="+cAttrs.size()); ////
		model.put(CONTACT_BEANS, cAttrs);
		AffiliateAttr aAttr = sgAffiliateService.getAffiliate(idAffiliate);
		String affiliateName = "";
		if (aAttr.getNameInst() == null ) { //|| NULL_STR.indexOf(","+aAttr.getNameInst()+",") > -1) {
			affiliateName = aAttr.getNameOrg();
		} else {
			affiliateName = aAttr.getNameInst();
		}
		model.put(OEPM_PROJECT_ID_FIELD, aAttr.getId());
		model.put("affiliateName", affiliateName);
		model.put(AFFILIATE_BEAN, aAttr);
		model.put(CONTACT_TYPES_NAME, CONTACT_TYPES);
		model.put(CONTACT_STATES_NAME, CONTACT_STATES);
		logger.warn("10");
		return new ModelAndView(LIST_SPACE_GRANT_CONTACTS_VIEW, model);
	}
	
	@RequestMapping(NEW_SPACE_GRANT_CONTACT_PATH)
	public ModelAndView newContact(
			@RequestParam(AFFILIATE_ID_FIELD) int idAffiliate) {
		Map<String, Object> model = new HashMap<String, Object>();
		String fy = (String)request.getAttribute("FY");
		ContactAttr cAttr = new ContactAttr();
		model.put(CONTACT_BEAN, cAttr);
		model.put(AFFILIATE_ID_FIELD, idAffiliate);
		model.put(CONTACT_ID_FIELD, cAttr.getId());
		model.put(CONTACT_TYPES_NAME, CONTACT_TYPES);
		model.put(CONTACT_STATES_NAME, CONTACT_STATES);
		return new ModelAndView(EDIT_SPACE_GRANT_CONTACT_VIEW, model);	
	}
	
	@RequestMapping(EDIT_SPACE_GRANT_CONTACT_PATH)
	public ModelAndView editContact(
			@RequestParam(AFFILIATE_ID_FIELD) int idAffiliate,
			@RequestParam(CONTACT_ID_FIELD) int contactId) {
		Map<String, Object> model = new HashMap<String, Object>();
		String fy = (String)request.getAttribute("FY");
		ContactAttr cAttr = sgAffiliateService.getContact(contactId);
		if (cAttr == null)  {
			cAttr = new ContactAttr();
		}
		model.put(CONTACT_BEAN, cAttr);
		model.put(CONTACT_ID_FIELD, contactId);
		model.put(AFFILIATE_ID_FIELD, idAffiliate);
		model.put(CONTACT_TYPES_NAME, CONTACT_TYPES);
		model.put(CONTACT_STATES_NAME, CONTACT_STATES);
		return new ModelAndView(EDIT_SPACE_GRANT_CONTACT_VIEW, model);
	}

	@RequestMapping(value=UPDATE_SPACE_GRANT_CONTACT_PATH, method=RequestMethod.POST)
	public ModelAndView updContact() {
		logger.warn("request.getParameter(isPrimary)=|"+request.getParameter("isPrimary")+"|"); ////
		logger.warn("request.getParameter(contactId)=|"+request.getParameter("contactId")+"|"); ////
		logger.warn("request.getParameter(idAffiliate)=|"+request.getParameter("idAffiliate")+"|"); ////

		ContactAttr cAttr = fromContactPosting(request);
		if (request.getParameter("contactId").equals("-1"))  {
			cAttr.setId(sgAffiliateService.createContact(cAttr));
		} else {
			sgAffiliateService.updateContact(cAttr);
		}
		if (request.getParameter("isPrimary").equals("Y"))  {
			sgAffiliateService.replacePrimaryContact(cAttr.getIdAffiliate(), cAttr.getId());
		}
		Map<String, Object> model = new HashMap<String, Object>();
		model.put(CONTACT_BEAN, cAttr);
		model.put(CONTACT_ID_FIELD, cAttr.getId());
		model.put(AFFILIATE_ID_FIELD, cAttr.getIdAffiliate());
		model.put(CONTACT_TYPES_NAME, CONTACT_TYPES);
		model.put(CONTACT_STATES_NAME, CONTACT_STATES);
		return new ModelAndView(EDIT_SPACE_GRANT_CONTACT_VIEW, model);
	}

	@RequestMapping(DELETE_SPACE_GRANT_CONTACT_PATH)
	public ModelAndView delContact(@RequestParam(CONTACT_ID_FIELD) int contactId,
			@RequestParam(AFFILIATE_ID_FIELD) int idAffiliate) {
		sgAffiliateService.deleteContact(contactId);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put(AFFILIATE_ID_FIELD, idAffiliate);
		List<ContactAttr> cAttrs = sgAffiliateService.getAffiliateContacts(idAffiliate);
		model.put(CONTACT_BEANS, cAttrs);
		AffiliateAttr aAttr = sgAffiliateService.getAffiliate(idAffiliate);
		String affiliateName = "";
		if (aAttr.getNameInst() == null || NULL_STR.indexOf(","+aAttr.getNameInst()+",") > -1) {
			affiliateName = aAttr.getNameOrg();
		} else {
			affiliateName = aAttr.getNameInst();
		}
		model.put("affiliateName", affiliateName);
		model.put(AFFILIATE_BEAN, aAttr);
		model.put(CONTACT_TYPES_NAME, CONTACT_TYPES);
		model.put(CONTACT_STATES_NAME, CONTACT_STATES);
		return new ModelAndView(LIST_SPACE_GRANT_CONTACTS_VIEW, model);
	}

	@RequestMapping(SEARCH_SPACE_GRANT_PATH)
	public ModelAndView search() {
		return new ModelAndView(SEARCH_SPACE_GRANT_VIEW);
	}
	
	private ContactAttr fromContactPosting(HttpServletRequest request)  {
		ContactAttr cAttr = new ContactAttr();
		if (request.getParameter("fy") != null) {
		    cAttr.setFy(request.getParameter("fy"));
		}
		if (request.getParameter("address1") != null) {
		    cAttr.setAddress1(request.getParameter("address1"));
		}
		if (request.getParameter("address2") != null) {
		    cAttr.setAddress2(request.getParameter("address2"));
		}
		if (request.getParameter("city1") != null) {
		    cAttr.setCity1(request.getParameter("city1"));
		}
		if (request.getParameter("city2") != null) {
		    cAttr.setCity2(request.getParameter("city2"));
		}
		if (request.getParameter("contactType") != null) {
		    cAttr.setContactType(request.getParameter("contactType"));
		}
		if (request.getParameter("email1") != null) {
		    cAttr.setEmail1(request.getParameter("email1")); 
		}
		if (request.getParameter("email2") != null) {
		    cAttr.setEmail2(request.getParameter("email2"));
		}
		if (request.getParameter("firstName") != null) {
		    cAttr.setFirstName(request.getParameter("firstName"));
		}
		if (request.getParameter("contactId") != null) {
		    cAttr.setId(Integer.parseInt(request.getParameter("contactId")));
		}
		if (request.getParameter("idAffiliate") != null) {
		    cAttr.setIdAffiliate(Integer.parseInt(request.getParameter("idAffiliate")));
		}
		if (request.getParameter("isPrimary") != null) {
		    cAttr.setIsPrimary(request.getParameter("isPrimary"));
		}
		if (request.getParameter("lastName") != null)  {
		    cAttr.setLastName(request.getParameter("lastName"));
		}
		if (request.getParameter("phone1") != null) {
		    cAttr.setPhone1(request.getParameter("phone1"));
		}
		if (request.getParameter("phone2") != null)  {
		    cAttr.setPhone2(request.getParameter("phone2"));
		}
		if (request.getParameter("state1") != null) {
		    cAttr.setState1(request.getParameter("state1"));
		}
		if (request.getParameter("state2") != null) {
		    cAttr.setState2(request.getParameter("state2"));
		}
		if (request.getParameter("title") != null) {
		    cAttr.setTitle(request.getParameter("title"));
		}
		if (request.getParameter("zip1") != null) {
		    cAttr.setZip1(request.getParameter("zip1"));
		}
		if (request.getParameter("zip2") != null) {
		    cAttr.setZip2(request.getParameter("zip2"));
		}

		return cAttr;
	}

	private AffiliateAttr fromAffiliatePosting(HttpServletRequest request)  {
		AffiliateAttr aAttr = new AffiliateAttr();
		if (request.getParameter("fy") != null) {
		    aAttr.setFy(request.getParameter("fy"));
		}
		if (request.getParameter("oepmProjectId") != null) {
		    aAttr.setOepmProjectId(Integer.parseInt(request.getParameter("oepmProjectId")));
		}
		if (request.getParameter("idAffiliate") != null) {
		    aAttr.setId(Integer.parseInt(request.getParameter("idAffiliate")));
		}
		if (request.getParameter("state") != null) {
		    aAttr.setState(request.getParameter("state"));
		}
		// the function that applies the institution select to the associated text box ASSUMES it has a name attribute of tmpQtxt
		if (request.getParameter("tmpQTxt") != null) {
		    aAttr.setNameInst(request.getParameter("tmpQTxt"));
		}
		if (request.getParameter("nameOrg") != null) {
		    aAttr.setNameOrg(request.getParameter("nameOrg"));
		}
		if (request.getParameter("typeOrg") != null) {
		    aAttr.setTypeOrg(request.getParameter("typeOrg"));
		}
		if (request.getParameter("lead") != null) {
		    aAttr.setLead(request.getParameter("lead"));
		}
		return aAttr;
	}
}
