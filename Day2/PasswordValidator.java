import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class PasswordValidator {
	
	
	static void ingestPasswords(ArrayList<String> array)
	{
		String pattern = "([0-9]+).([0-9]+).([a-z])..([a-z]*)";
		Pattern r = Pattern.compile(pattern);
		int validCount =0;

		for(int i=0; i < array.size(); i++)
		{
		      Matcher m = r.matcher(array.get(i));
		      if (m.find() && validatePassword(Integer.parseInt(m.group(1)),
		    		  Integer.parseInt(m.group(2)),m.group(3), m.group(4)))
		    	  validCount++;
		}
		System.out.println("ValidCount: " + validCount);
		
	}
	
	static boolean validatePassword(int low, int high, String letter, String password)
	{
		int charCount = password.length() - password.replaceAll(letter,"").length();
		if (charCount>=low&&charCount<=high)
			return true;
		return false;
	}


	public static void main(String[] args) throws IOException 
	{
		ArrayList<String> lines = new ArrayList<>(Files.readAllLines(Paths.get("input.txt")));
		ingestPasswords(lines);
	}
}
