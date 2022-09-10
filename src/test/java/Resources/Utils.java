package Resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

public class Utils {
    RequestSpecification req;
    public RequestSpecification RequestSpecification() throws IOException {
        PrintStream log=new PrintStream(new FileOutputStream("Logging.txt"));
        req=new RequestSpecBuilder().setBaseUri(GetGlobalValues("baseURL"))
                .addFilter(RequestLoggingFilter.logRequestTo(log))
                .addFilter(ResponseLoggingFilter.logResponseTo(log))
                .setContentType(ContentType.JSON).build();
        return req;
    }
    public static String GetGlobalValues(String Prop_Key) throws IOException {
        Properties prop=new Properties();
        FileInputStream fis=new FileInputStream("src/test/java/Resources/Global.properties");
        prop.load(fis);
       return prop.getProperty(Prop_Key);
    }
    public String getJsonPath(Response response, String Key)
    {
        String resp=response.asString();
        JsonPath js = new JsonPath(resp);
        //return js.get(Key).toString();
        return js.getString(Key);
    }
}
