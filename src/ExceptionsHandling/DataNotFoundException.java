package ExceptionsHandling;

public class DataNotFoundException extends Exception{
	
	public DataNotFoundException(String str){
		System.out.println(str+ " property form config.properties file is null");
	}
	
}
