import java.util.Arrays;
import java.util.List;

public class UserName {
	public String newMember(String[] existingNames, String newName) {
		//Arrays.sort(existingNames);
		List l = Arrays.asList(existingNames);
		if(!l.contains(newName)) {
			return newName;
		}
		String finalName = newName;
		Integer inc = 0;		
		while(l.contains(finalName)) {
			finalName = newName + (++inc).toString();
		}
		return finalName;
	}
}