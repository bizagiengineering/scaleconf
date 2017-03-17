package scaleconf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by dev-camiloh on 3/6/17.
 */
@SpringBootApplication
public class App {

    public static void main(String[] args) {
        args=new String[3];
        String blobKey=args[0]="DefaultEndpointsProtocol=http;AccountName=scaleconf;AccountKey=Zl9MhlM/iiAiyIKdvqJvX3x3tWIEM0P5VfxYqRuQJbgxM7JMFlYnvOqq0YoWHLMSdwC36R/ogbqwcsk36ajDEw==";
        args[1]="https://scaleconf.documents.azure.com:443/";
        args[2]="bNnQ05Sra5g9k7T4KdfXIzs0ZwxlSwAf8o69bBQB5c1u8k0VoKZmM9ne0ie1Ul6yFZ7BUUyA8vaBxigGgMIVug==";
        SpringApplication.run(App.class, args);
    }
}
