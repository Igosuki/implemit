
public class SpeedRadar {
	public double averageSpeed(int minLimit, int maxLimi, int[] readings) {
		if(maxLimit < 1 || maxLimit > 200 || minLimit < 1 || minLimit > maxLimit || readings.length > 50 || readings.length == 0) {
			throw new IllegalArgumentException("SpeedRadar::averageSpeed One of the arguments is invalid");
		}
		int faultySpeeds = 0;
		double addedSpeeds = 0;
		double okSpeeds = 0;
		for(int i = 0; i < readings.length; i++) {
			if(readings[i] < 1 || readings[i] > 200) {
				throw new IllegalArgumentException("SpeedRadar::averageSpeed invalid speed measure, calculus over");
			} else if(readings[i] < maxLimit && readings[i] > minLimit) {
				okSpeeds++;
				addedSpeeds += readings[i];
			} else {
				faultySpeeds++;
			}
		}
		if(readings.length*0.1 < faultySpeeds) {
			return 0.0;
		}
		return okSpeeds > 0 ? addedSpeeds/okSpeeds : 0.0;
	}
}