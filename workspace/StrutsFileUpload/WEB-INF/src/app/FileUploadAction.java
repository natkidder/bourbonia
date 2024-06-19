/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.io.File;
import java.io.FileOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.upload.FormFile;

/**
 *
 * @author eswar@vaannila.com
 */
public class FileUploadAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private final static String SUCCESS = "success";

    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    	
        FileUploadForm uploadForm = (FileUploadForm) form;
        FileOutputStream outputStream = null;
        FormFile formFile = null;
        try {
            formFile = uploadForm.getFileSelected();
            String path = getServlet().getServletContext().getRealPath("")+"/"+ formFile.getFileName();
            System.out.println("Path = " + path); ////
            outputStream = new FileOutputStream(new File(path));
            outputStream.write(formFile.getFileData());
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
        }
        uploadForm.setMessage("The file "+formFile.getFileName()+" is uploaded successfully.");

        return mapping.findForward(SUCCESS);
    }
}
