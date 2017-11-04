import java.math.BigDecimal;

public class SymbolFrequency {
	
	public double language(String[] frequencies, String[] text) {
		//Rebuilding frequency table
		Double deviation = null;
		float[] actualFreqs = new float[255];
		int lettercount = 0;
		int lowbound = (int)'a';
		int upperbound = (int)'z';
		for(int j = 0; j < text.length; j++) {
			for(int i = 0; i < text[j].length(); i++) {
				int charVal = (int)text[j].charAt(i);
				if(charVal >= lowbound && charVal <= upperbound) {
					lettercount++;
					actualFreqs[text[j].charAt(i)]++;
				}
			}
		}
		System.out.println("Letter count" + lettercount);
		for(int j = 0; j < frequencies.length; j++) {
			float[] expectedFreqs = new float[255];
			double newDeviation = 0.0;
			String orig = frequencies[j];
			if(orig.length() % 3 != 0) {
				throwUsage();
			}
			for(int i = 0; i < orig.length(); i+=3) {
				try {
					float freq = (Float.valueOf(orig.substring(i+1, i+3))/100)*lettercount;
					expectedFreqs[orig.charAt(i)] = freq;
				} catch(NumberFormatException e) {
					throwUsage();
				}
			}
			for(int i = lowbound; i <= upperbound; i++) {
				System.out.println(((char)i) + " : Actual Freq : " + actualFreqs[i] + " Expected Freq : " + expectedFreqs[i] + " New Deviation : " + newDeviation);
				newDeviation += Math.pow(actualFreqs[i] - expectedFreqs[i], 2);
			}
			if(deviation == null || deviation > newDeviation) {
				deviation = newDeviation;
			} 
		}
		System.out.println("Deviation : " + deviation);
		//Stupid hack to round to second decimal in prec cba to go with big decimals all the way
		int precision = 10000;
		return new Double(Math.round(deviation*precision))/precision;
	}
	
	private void throwUsage() {
		throw new IllegalArgumentException("SymbolFrequency::language frequency strings are expected to be of the format \"ANN\"");
	}
}