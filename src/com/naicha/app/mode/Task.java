package com.naicha.app.mode;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.naicha.app.utils.JsonDateSerializer;

@Entity
@Table(name = "task")
public class Task implements Serializable {
	/**
	 * @author yangxujia
	 * @date 2015年9月17日上午10:32:29
	 */
	private static final long serialVersionUID = 7284346646889457057L;
	private Integer id;
	private Integer userId;
	private Integer taskType;
	private Integer reward;
	private Date servicesTime;
	private Integer timeLength;
	private Date publicTime;
	private String notes;
	private String location;
	private String relativeToCurrentTime;
	private String relativeToClosingTime;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "userId", nullable = false)
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "taskType", nullable = false)
	public Integer getTaskType() {
		return taskType;
	}

	public void setTaskType(Integer taskType) {
		this.taskType = taskType;
	}

	@Column(name = "reward", nullable = false)
	public Integer getReward() {
		return reward;
	}

	public void setReward(Integer reward) {
		this.reward = reward;
	}

	@JsonSerialize(using=JsonDateSerializer.class) 
	@Column(name = "servicesTime", nullable = false)
	public Date getServicesTime() {
		return servicesTime;
	}

	public void setServicesTime(Date servicesTime) {
		this.servicesTime = servicesTime;
	}

	@Column(name = "timeLength", nullable = false)
	public Integer getTimeLength() {
		return timeLength;
	}

	public void setTimeLength(Integer timeLength) {
		this.timeLength = timeLength;
	}

	@JsonSerialize(using=JsonDateSerializer.class) 
	@Column(name = "publicTime", nullable = false)
	public Date getPublicTime() {
		return publicTime;
	}

	public void setPublicTime(Date publicTime) {
		this.publicTime = publicTime;
	}

	@Column(name = "notes")
	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Column(name = "location")
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Transient
	public String getRelativeToCurrentTime() {
		return relativeToCurrentTime;
	}

	public void setRelativeToCurrentTime(String relativeToCurrentTime) {
		this.relativeToCurrentTime = relativeToCurrentTime;
	}

	@Transient
	public String getRelativeToClosingTime() {
		return relativeToClosingTime;
	}

	public void setRelativeToClosingTime(String relativeToClosingTime) {
		this.relativeToClosingTime = relativeToClosingTime;
	}
}
