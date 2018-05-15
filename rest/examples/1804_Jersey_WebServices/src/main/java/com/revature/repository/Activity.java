package com.revature.repository;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Activity implements Serializable {

	private static final long serialVersionUID = -640682485508519590L;
	private int activityId;
	private String activityName;
	private String duration;
	private User user;
	
	public Activity(int activityId, String activityName, String duration) {
		super();
		this.activityId = activityId;
		this.activityName = activityName;
		this.duration = duration;
	}
	public Activity() {
		super();
	}
	public int getActivityId() {
		return activityId;
	}
	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + activityId;
		result = prime * result + ((activityName == null) ? 0 : activityName.hashCode());
		result = prime * result + ((duration == null) ? 0 : duration.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Activity other = (Activity) obj;
		if (activityId != other.activityId)
			return false;
		if (activityName == null) {
			if (other.activityName != null)
				return false;
		} else if (!activityName.equals(other.activityName))
			return false;
		if (duration == null) {
			if (other.duration != null)
				return false;
		} else if (!duration.equals(other.duration))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Activity [activityId=" + activityId + ", activityName=" + activityName + ", duration=" + duration + "]";
	}
	
	
}
