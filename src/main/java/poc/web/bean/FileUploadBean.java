package poc.web.bean;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.commons.io.FilenameUtils;
import org.apache.myfaces.custom.fileupload.UploadedFile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("request")
public class FileUploadBean {
    private UploadedFile uploadedFile;

    public void submit() throws IOException {
        long begin= System.currentTimeMillis();
    	String fileName = FilenameUtils.getName(uploadedFile.getName());
        String contentType = uploadedFile.getContentType();
//        byte[] bytes = uploadedFile.getBytes();
//        
//        System.out.println(new String(bytes));
        // Now you can save bytes in DB (and also content type?)

        InputStream in = uploadedFile.getInputStream();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String strLine = null;
        int i=0;
        while( (strLine = br.readLine()) != null)
        {
        	i++;
           System.out.println(i+" Line entered : "  + strLine);
        }
       
        br.close();                             
        
        long end= System.currentTimeMillis();
        System.out.println("Time: " + (end-begin)/1000);
        FacesContext.getCurrentInstance().addMessage(null, 
            new FacesMessage(String.format("File '%s' of type '%s' successfully uploaded!", fileName, contentType)));
    }

    public UploadedFile getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(UploadedFile uploadedFile) {
        this.uploadedFile = uploadedFile;
    }

}
