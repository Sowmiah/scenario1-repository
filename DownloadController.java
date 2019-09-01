package com.test.practise.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.test.practise.model.EmpModel;
import com.test.practise.service.DownloadService;

@RestController
public class DownloadController {

	@Autowired
	DownloadService service;
	
	public DownloadService getService() {
		return service;
	}

	public void setService(DownloadService service) {
		this.service = service;
	}

	@GetMapping("/")
	public ModelAndView index() {
		
		EmpModel empModel = new EmpModel();
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("empModel", empModel);
		return mv;
	}
	
	@RequestMapping(value="/hello", method= {RequestMethod.GET})
	public @ResponseBody String sayHello(HttpServletRequest request, HttpServletResponse response) {
		
		List<EmpModel> empList = new ArrayList<EmpModel>();
		
		empList = service.getEmpDetails();
		
		JsonObject responseDetails = new JsonObject();
		Gson gson = new Gson();
		
		String jsonString = responseDetails.toString();
		
		System.out.println("JSON String : " + jsonString);
		
		responseDetails.add("aaData", gson.toJsonTree(empList));
		response.setContentType("application/json");
		
		/*response.setHeader("aaData", responseDetails.toString());
		response.setContentType("application/json");*/
		
		/*JSONGenerator gen = JSON.createGenerator(true);

        // Write data to the JSON string.
        gen.writeStartObject();
		
		gen.writeFieldName("aaData");       
        gen.writeStartArray();
        for (EmpModel emp : empList)
        {       
            gen.writeStartArray();
            gen.writeString(emp.getName());
            gen.writeString(emp.getAge());
            gen.writeString(emp.getGender());
            gen.writeEndArray();

        }

        gen.writeEndArray();
        gen.writeEndObject();

        JSONString = gen.getAsString();  */
		
		return responseDetails.toString();
	}
	
		/*EmpModel eModel = new EmpModel();
        
        List<String> value = clothing;
        
        PdfDocument document = new PdfDocument();
        Document doc = new Document();
        PdfReader reader =  null;
        PdfWriter writer = null;
	      try
	      {
	    	  
	    	  PdfReader reader1 = new PdfReader("D:\\test\\test.pdf");
	    	    Document document1 = new Document(reader.getPageSizeWithRotation(1));
	    	    PdfCopy copy = new PdfCopy(document, new FileOutputStream(
	    	        "D:\\test\\Pdfletswritetest.pdf"));
	    	    document.open();
	    	    for(int i=0; i<8; i++) {
	    	    	copy.addPage(copy.getImportedPage(reader, 1));
	    	    }
	    	    reader = new PdfReader("Pdf.pdf");
	    	    copy.addPage(copy.getImportedPage(reader, 1));
	    	    reader = new PdfReader("Hello3.pdf");
	    	    copy.addPage(copy.getImportedPage(reader, 1));
	    	    document.close();
 	    	  File file = new File("D://test//pdf.pdf");
	    	  InputStream inputStream = new FileInputStream(file); 
	    	  byte[] bytes = new byte[(int) file.length()];
	    	  inputStream.read(bytes);
	    	  inputStream.close();
	    	  
	    	  reader = new PdfReader("D:\\test\\test.pdf");
	    	 
	    	  PdfStamper stamper = new PdfStamper(reader, new FileOutputStream("D:\\test\\testingggggggggg.pdf"));
	    	  int n = reader.getNumberOfPages();
	    	  System.out.println("No. of Pages :" +n);
	    	  for (int i = 1; i <= n; i++) {
	    	          if (i == 1) {            
	    	                 // removed code for clarity
	    	                 PdfImportedPage page = writer.getImportedPage(reader, i);

	    	                 ((PdfCopy) writer).addPage(page);
	    	              }
	    	  }
	    	  
	        PdfWriter writer2 = PdfWriter.getInstance(document, new FileOutputStream("D:\\pdf-test.pdf"));
	        
	         reader.selectPages("1");
	         PdfStamper stamper2 = new PdfStamper(reader, new FileOutputStream("D:\\pdf-test.pdf"));
	         reader = new PdfReader("D://test//Effective Java (2017, Addison-Wesley).pdf");
	         byte[] write = reader.getPageContent(1);
	         document.open();
	         document.add(new Paragraph("A Hello World PDF document."));
	         document.close();
	         writer.close();
	    	//  reader.close();
	      } catch (FileNotFoundException e)
	      {
	         e.printStackTrace();
	      } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
        
		return new ModelAndView("hello");
	}	*/
}
