package org.tiaa.jersey.rest.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

import javax.ws.rs.core.MediaType;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.Logger;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataBodyPart;
import com.sun.jersey.multipart.FormDataMultiPart;
import com.sun.jersey.multipart.file.FileDataBodyPart;
import com.sun.jersey.api.client.WebResource.Builder;


public class PostClient {

	Logger log = Logger.getLogger(PostClient.class.getName());

	public static void main(String[] args) {
		if (args.length < 2)  {
			System.out.println("arg1: which method # to call,   arg2: comma-delimited arguments");
			System.exit(2);
		}
		int methodNumber = Integer.parseInt(args[0]);
		String methodArgs = args[1];
		PostClient postClient = new PostClient();
		if (methodNumber == 0) {
			postXML(methodArgs);
		} else if (methodNumber == 1) {
			postClient.postFileMultipart(methodArgs);
		} else if (methodNumber == 2) {
			postClient.postFileOctet(methodArgs);
		} else if (methodNumber == 3) {
			postClient.postFileOctet2(methodArgs);
		} else if (methodNumber == 4) {
			postClient.postFileOctet3(methodArgs);
		} else if (methodNumber == 5) {
			postClient.postFileXml(methodArgs);
		}

	}

	private void postFileMultipart(String methodArgs) {
		try {
			HttpClient httpclient = new DefaultHttpClient();
			URI url = URI.create("http://localhost:8080/RestfulJersey2/rest/fileMultipart/uploadMultipart");
			HttpPost httpPost = new HttpPost(url);

			File uploadFile = new File("c:/tmp/ZambeziRiver.jpg");
			FileBody uploadFilePart = new FileBody(uploadFile);
			MultipartEntity reqEntity = new MultipartEntity();
			reqEntity.addPart("file", uploadFilePart); // "file" must match the UploadFileService FormDataParam
			httpPost.setEntity(reqEntity);

			HttpResponse response = httpclient.execute(httpPost);
			log.info(response.getStatusLine());

		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// http://stackoverflow.com/questions/10326460/upload-a-large-file-using-jersey-client
	private void postFileOctet(String methodArgs) {
		try {
			//ClientConfig cc = new DefaultClientConfig();
	        //Client client = Client.create(cc);
			Client client = Client.create();
		    WebResource webResource = client.resource("http://localhost:8080/RestfulJersey2/rest/fileOctet/uploadOctet/");
		    File file = new File("c:/tmp/ZambeziRiver.jpg");
		    InputStream fileInStream = new FileInputStream(file);
		    String contentDisposition = "attachment; filename=\"" + file.getName() + "\"";
		    ClientResponse response = webResource.type(MediaType.APPLICATION_OCTET_STREAM).header("Content-Disposition", contentDisposition)
		            .post(ClientResponse.class, fileInStream);
		    log.info(response.getStatus());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void postFileOctet2(String methodArgs) {
		try {
			//ClientConfig cc = new DefaultClientConfig();
	        //Client client = Client.create(cc);
			Client client = Client.create();
		    WebResource webResource = client.resource("http://localhost:8080/RestfulJersey2/rest/fileOctet/uploadOctet2");
		    File file = new File("c:/tmp/ZambeziRiver.jpg");
		    InputStream fileInStream = new FileInputStream(file);
		    String contentDisposition = "attachment; filename=\"" + file.getName() + "\"";
		    ClientResponse response = webResource.path("golf3.jpg")
		            .type(MediaType.APPLICATION_OCTET_STREAM).header("Content-Disposition", contentDisposition)
		            .post(ClientResponse.class, fileInStream);
		    log.info(response.getStatus());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void postFileOctet3(String methodArgs) {
		try {
			//ClientConfig cc = new DefaultClientConfig();
	        //Client client = Client.create(cc);
			Client client = Client.create();
		    WebResource webResource = client.resource("http://localhost:8080/RestfulJersey2/rest/fileOctet/uploadOctet3/");
		    File file = new File("c:/tmp/ZambeziRiver.jpg");
		    InputStream fileInStream = new FileInputStream(file);
		    String contentDisposition = "attachment; filename=\"" + file.getName() + "\"";
		    ClientResponse response = webResource.path("proposal.pdf")
		            .type(MediaType.APPLICATION_OCTET_STREAM).header("Content-Disposition", contentDisposition)
		            .post(ClientResponse.class, fileInStream);
		    log.info(response.getStatus());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void postFileXml(String methodArgs)  {

		ClientConfig clientConfig = new DefaultClientConfig();
		//        clientConfig.getClasses().add(ContextProvider.class);

		Client client = Client.create(clientConfig);

		WebResource webResource = client.resource("http://localhost:8080/RestfulJersey2/rest/fileMultipart/uploadFileAndXml");

		FormDataMultiPart mp = new FormDataMultiPart();

		try {
			mp.bodyPart(new FormDataBodyPart("MultiPartXml",
					new FileInputStream("c:/tmp/employee.xml"),
					MediaType.APPLICATION_XML_TYPE));

			mp.bodyPart(new FormDataBodyPart(FormDataContentDisposition.name("files").fileName("VictoriaFallsCopy.jpg").build(),
					new FileInputStream("c:/tmp/VictoriaFalls.jpg"),
					MediaType.APPLICATION_OCTET_STREAM_TYPE));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Builder response = webResource
				.accept("application/octet-stream")
				.type(MediaType.MULTIPART_FORM_DATA)
				.post(Builder.class, mp);

		// same as above but with accepting the octet-stream
/*        Builder response = webResource.accept("application/vnd.tiaa.federated-document-rs-v1.0+xml;profile=federated-document-rs-v1.0.xsd")
                .type(MediaType.MULTIPART_FORM_DATA)
                .post(Builder.class, mp);*/

		System.out.println("Completed Successfully");

	}

	private static void postXML(String methodArgs) {
		try {

			Client client = Client.create();

			WebResource webResource = client
					.resource("http://localhost:8080/RestfulJersey2/rest/user/employee");

			//String input = "{\"singer\":\"Metallica\",\"title\":\"Fade To Black\"}";
			String input = "<Employee><employeeName>Jason</employeeName></Employee>";

			ClientResponse response = webResource.type("application/xml")
					.post(ClientResponse.class, input);

			if (response.getStatus() != 200) {   // or 201
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}

			System.out.println("Output from Server .... \n");
			String output = response.getEntity(String.class);
			System.out.println(output);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

/*ClientConfig clientConfig = new DefaultClientConfig();
//        clientConfig.getClasses().add(ContextProvider.class);

Client client = Client.create(clientConfig);

WebResource webResource = client.resource("http://localhost:7001/federated-document-rs-v1/documents?business-unit-code=PENSION&doc-code=ALT_CARRIER_LTR&version=1");

FormDataMultiPart mp = new FormDataMultiPart();

mp.bodyPart(new FormDataBodyPart("StoreDocumentRequestXML",
		new FileInputStream("src/test/StoreDocumentRequest.xml"),
		MediaType.APPLICATION_XML_TYPE));

mp.bodyPart(new FormDataBodyPart(FormDataContentDisposition.name("files").fileName("SampleFile.pdf").build(),
		new FileInputStream("src/test/SampleFile.pdf"),
		MediaType.APPLICATION_OCTET_STREAM_TYPE));

Builder response = webResource.accept("application/vnd.tiaa.federated-document-rs-v1.0+xml;profile=federated-document-rs-v1.0.xsd")
		.accept("application/octet-stream")
		.type(MediaType.MULTIPART_FORM_DATA)
		.post(Builder.class, mp);

// same as above but with accepting the octet-stream
        Builder response = webResource.accept("application/vnd.tiaa.federated-document-rs-v1.0+xml;profile=federated-document-rs-v1.0.xsd")
        .type(MediaType.MULTIPART_FORM_DATA)
        .post(Builder.class, mp);

System.out.println("Completed Successfully");
*/