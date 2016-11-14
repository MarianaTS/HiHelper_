package ua.com.hihelper.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Following {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	
	@ManyToOne()
	@JoinColumn(name = "user_id")
	private User sourceFollower;
	@ManyToOne
	@JoinColumn(name = "follower_id")
	private User targetFollower;
	public Following() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getSourceFollower() {
		return sourceFollower;
	}
	public void setSourceFollower(User sourceFollower) {
		this.sourceFollower = sourceFollower;
	}
	public User getTargetFollower() {
		return targetFollower;
	}
	public void setTargetFollower(User targetFollower) {
		this.targetFollower = targetFollower;
	}
	
	
}
