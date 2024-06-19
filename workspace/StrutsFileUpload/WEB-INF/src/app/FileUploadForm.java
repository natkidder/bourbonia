/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;
import org.apache.struts.action.ActionForm;

/**
 *
 * @author eswar@vaannila.com
 */
public class FileUploadForm extends ActionForm {

    /**
	 * 
	 */
	private static final long serialVersionUID = -7441876988603358852L;

    private enum Extension { DOC, DOCX, HTM, HTML, PDF, TXT };
    
	private FormFile fileSelected;

    private String message;

    public FileUploadForm() {
        super();
    // TODO Auto-generated constructor stub
    }

    /**
     * @return the file
     */
    public FormFile getFileSelected() {
        return fileSelected;
    }

    /**
     * @param file the file to set
     */
    public void setFileSelected(FormFile fileSelected) {
        this.fileSelected = fileSelected;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        if (fileSelected.getFileSize() == 0) {
            errors.add("fileSelected", new ActionMessage("error.file.required"));
        /**
         * If the file size is greater than a given amount.
         */
        } else if (fileSelected.getFileSize() > Math.pow(2, 20)) {
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
/*
        if (!fileSelected.getContentType().equals("application/vnd.ms-excel")) {
    		errors.add("fileSelected", new ActionMessage("error.file.type"));
        }
*/
        return errors;
    }
}
