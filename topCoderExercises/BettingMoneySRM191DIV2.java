public class BettingMoney {
	public int moneyMade(int[] amounts, int[] centsPerDollar, int finalResult) {
		int gain = 0;
		int loss = 0;
		for(int i = 0; i < amounts.length; i++) {
			if(i != finalResult) {
				gain+=amounts[i];
			} else {
				loss+=amounts[i]*centsPerDollar[i];
			}
		}
		return gain * 100 - loss;
	}
}