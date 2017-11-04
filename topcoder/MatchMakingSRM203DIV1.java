import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.Map;
import java.util.HashMap;
//Overall complexity is O(n²logn)
public class MatchMaking {
	public String makeMatch(String[] namesWomen, String[] answersWomen, String[] namesMen, String[] answersMen, String queryWoman) {
		//Probably better just to sort o(nlogn) 
		TreeMap<String, String> womenPoll = new TreeMap<String, String>();
		TreeMap<String, String> menPoll = new TreeMap<String, String>();
		Map<String, String> matches = new HashMap<String, String>();
		int max = answersWomen[0].length();
		for(int i = 0; i < namesWomen.length; i++) {
			womenPoll.put(namesWomen[i], answersWomen[i]);
			menPoll.put(namesMen[i], answersMen[i]);
		}
		for(Entry<String, String> woman : womenPoll.entrySet()) {
			int bestScore = 0;
			String bestMatch = null;
			for(Entry<String, String> man : menPoll.entrySet()) {			
				int score = matches(woman.getValue(), man.getValue());
				if(score > bestScore) {
					bestMatch = man.getKey();
					if(score == max) {
						//Found best possible score and the list is in order, doesn't alter complexity but gives better average run time
						break;
					}
					bestScore = score;
				}
			}
			menPoll.remove(bestMatch);
			matches.put(woman.getKey(), bestMatch);
		}
		return matches.get(queryWoman);
	}
	
	public int matches(String a, String b) {
		int res = 0;
		for(int i = 0; i < a.length(); i++) {
			if(a.charAt(i) == b.charAt(i)) {
				res++;
			}
		}
		return res;
	}
}