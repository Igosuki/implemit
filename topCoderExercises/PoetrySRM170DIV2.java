public class Poetry {
	//Note : y is a vowel if not at 0 or n of word
	public String rhymeScheme(String[] poem) {
		StringBuilder rhymes = new StringBuilder();
		String lastRhyme = null;
		char rhymeIndex = 'a' - 1;
		for(String s : poem) {
			if(!(s == null || s.matches("\\s*"))) { 
				String[] words = s.split("\\s+");
				s = words[words.length - 1].toLowerCase();
				int lastVowel = -1;
				int pos = s.length() - 1;
				boolean foundVowel = false;
				boolean isVowel = false;
				while(pos >= 0 && ((isVowel = isVowel(s.charAt(pos), pos <= 0 || pos == s.length() - 1)) || !foundVowel)) {
					if(isVowel && !foundVowel) {
						foundVowel = true;
					}
					pos--;
				};
				if(pos < s.length() - 1) {
					String rhyme = s.substring(pos + 1);
					if(!rhyme.equals(lastRhyme)) {
						lastRhyme = rhyme;
						rhymes.append(++rhymeIndex);
					} else {
						rhymes.append(rhymeIndex);
					}
					System.out.println("LastRhyme : " + lastRhyme + ", Rhyme : " + rhyme + ", rhymeIndex : " + rhymeIndex);
				} 
			} else {
				rhymes.append(" ");
			}
		}
		return rhymes.toString();
	}
	
	public boolean isVowel(char c, boolean firstOrLast) {
		return firstOrLast ? c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' :  c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'y';
	}
}