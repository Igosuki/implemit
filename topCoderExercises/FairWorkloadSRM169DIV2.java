public class FairWorkload {
	public int getMostWork(int[] folders, int workers) {
		for(int limit = 1; ; limit++) {
			int people = 1;
			int curr = 0;
			boolean ok = true;
			for(int i  = 0; i < folders.length; i++) {	
				if(curr+folders[i] > limit) {
					people++;
					curr = 0;
				}
				curr += folders[i];
				if(curr > limit) ok = false;
			}
			if(ok && people <= workers) return limit;
		}
	}
}