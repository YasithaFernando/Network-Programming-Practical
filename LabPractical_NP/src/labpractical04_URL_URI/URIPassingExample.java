package labpractical04_URL_URI;

import java.net.URI;
import java.net.URISyntaxException;


public class URIPassingExample {
    
    public static void main(String[] args) {
        
        try{
            String urlString = "https://en.wikipedia.org/wiki/Computer_Science";
            URI uri = new URI(urlString);
            System.out.println("Scheme : " + uri.getScheme());
            System.out.println("Host : " + uri.getHost());
            System.out.println("path :" + uri.getPath());
            System.out.println("Query :" + uri.getQuery());
            System.out.println("Fragment :" + uri.getFragment());
            
        }catch(URISyntaxException e){
            e.printStackTrace();
        }
    }
}
