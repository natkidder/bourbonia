import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.apache.commons.io.FilenameUtils;



public class upLoadFileCode extends HttpServlet
{ 


/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void doPost(HttpServletRequest request, HttpServletResponse resp) throws IOException
{
	try {
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		System.out.println(isMultipart);
			
		FileItemFactory factory = new DiskFileItemFactory();	
		ServletFileUpload upload = new ServletFileUpload(factory);
			// Parse the request
					
			FileItemIterator iter = upload.getItemIterator(request);
			while (iter.hasNext()) {
			      FileItemStream item = iter.next();
			     String name = item.getFieldName();
			     InputStream stream = item.openStream();
			    
			     if (item.isFormField()) {
			               System.out.println("Form field " + name + " with value " + Streams.asString(stream) + " detected.");
			     } else {
			              System.out.println("File field " + name + " with file name " + item.getName() + " detected.");
			              // Process the input stream

			    }
			     
			           name = FilenameUtils.getName(name);
			         
			         String dirName = "/file_uploads/";

			         File saveTo = new File(dirName + name);
			       

			    
			}
	} catch (FileUploadException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


	
}
