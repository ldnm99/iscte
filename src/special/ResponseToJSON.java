package special;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;

import special.Models.Response;  

public class ResponseToJSON {

    public void ResToJSON(List<Response> output) {
        ObjectMapper Obj = new ObjectMapper();
        Obj.registerModule(new JodaModule());
        try{
            // Converting the Java object into a JSON string  
            for(Response response: output){
                String jsonStr = Obj.writeValueAsString(response);  
                // Displaying Java object into a JSON string  
                 System.out.println(jsonStr); 
            }
        }
        catch (IOException e) {  
            e.printStackTrace();  
        }  

        
    }
    
}
