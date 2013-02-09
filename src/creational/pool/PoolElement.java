package creational.pool;

import java.util.Date;

/**
 * 
 */
public class PoolElement {
	private Date time;
	private Boolean finished = false;
	private Boolean expired = false;
	private Long life;
	
	Object getContent() {
		return "PoolElement";
	}
	
	/**
	 * 
	 */
	public PoolElement(Long life) {
		this.life = life;
		this.time = new Date();
	}
	void doThing(){
		//doStuff
		if((new Date().getTime() - time.getTime()) > life){
			this.expired = true;
		}
		this.finished = true;
	}
	Boolean isExpired() {
		return this.expired;
	}
	Boolean isFinished(){
		return this.finished;
	}
}



