
public class TroytownKeeper {
	private int[][] visit;
	private int height;
	private int width;
	
	public int limeLiters(String[] maze){
		//Problem is : depth first search in a graph represented by a matrix
		int liters = 0;
		this.height = maze.length;
		this.width = maze[0].length();
		this.visit = new int[height][width];
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				if(maze[y].charAt(x) == '#') {
					visit[y][x] = -1;
				}
			}
		}
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				if(this.visit[y][x] == -1) {		
					if(y == 0 || y == this.height - 1) {
						liters++;
					}
					if(x == 0 || x == this.width - 1) {
						liters++;
					}
				}
				if (this.visit[y][x] == 0 && ((y == 0 || y == this.height - 1) || (x == 0 || x == this.width - 1)))
					liters += paint(x, y);			
			}
		}		
		return liters;
	}
	
	private int paint(int x, int y) {
		int wallsPainted = 0;
		if(this.visit[y][x] == 0) {
			this.visit[y][x] = 1;
			//Visit below
			if(y < height - 1) {
				wallsPainted += decide(x, y + 1);
			}
			//Visit above
			if(y > 0) {
				wallsPainted +=	decide(x, y - 1);
			}
			//Visit right
			if(x < width - 1) {
				wallsPainted +=	decide(x + 1, y);
			}
			//Visit left
			if(x > 0) {
				wallsPainted += decide(x - 1, y);
			}
		}
		return wallsPainted;
	} 
	private int decide(int x , int y) {
		if(this.visit[y][x] == 0) {
			return paint(x, y);
		} else if(this.visit[y][x] == -1) {
			return 1;
		} else {
			return 0;
		}
	}
}