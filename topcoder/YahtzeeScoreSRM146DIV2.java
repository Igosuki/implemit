public class YahtzeeScore {
	public int maxPoints(int[] toss) {
		int[] maxs = new int[6];
		for(int i = 0; i < toss.length; i++) {
			maxs[toss[i] - 1] += toss[i];
		}
		return max(maxs);
	}
	
	public int max(int[] array) {
		int max = -1;
		for(int i = 0; i < array.length; i++) {
			if(max < array[i]) {
				max = array[i];
			}
		}
		return max;
	}
}