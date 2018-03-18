package com.bharath.restws;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.ContentDisposition;

public class FileClient {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		// este client podemos imaginarlo como un web-browser, de hecho haremos aqui todo lo que se hace en el
		// fileUpload.html, de la carpeta static del proyecto "provider"
		WebClient client = WebClient.create("http://localhost:8080/restattachments/services/fileService/upload");
		client.type("multipart/form-data");
		ContentDisposition cd = new ContentDisposition("attachment;filename=Benito_Paris.JPG");
		
		Attachment attachment = new Attachment("root", new FileInputStream(new File("/home/benito/Downloads/uploads/Benito_Paris.JPG")), cd);
		
		// uploading...
		client.post(attachment);
		
	}
	
}
