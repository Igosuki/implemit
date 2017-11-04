public class EvenRoute {
	public String isItPossible(int[] x, int[] y, int wantedParity) {
		int N = x.length;
		//We want to calculate the norm of a vector from point a to b and make the addition see if that is even or uneven
		//The space is complete (we can use any point in the space to join two) so if there is an even path to join two points, all paths are even
		int currentX = 0;
		int currentY = 0;
		int distance = 0;
		for(int i = 0; i < x.length; i++) {	
			distance += Math.sqrt(Math.pow(x[i]-currentX,2))+ Math.sqrt(Math.pow(y[i]-currentY, 2));
			currentX = x[i];
			currentY = y[i];
		}
		return distance % 2 == wantedParity ? "CAN" : "CANNOT";
	}
}