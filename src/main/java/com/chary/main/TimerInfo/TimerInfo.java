package com.chary.main.TimerInfo;

import java.io.Serializable;

public class TimerInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int totalFireCount;
	private boolean runForever;
	private long repeatInterval;
	private long InitialOffSet;
	private String callBackData;
	public int getTotalFireCount() {
		return totalFireCount;
	}
	public void setTotalFireCount(int totalFireCount) {
		this.totalFireCount = totalFireCount;
	}
	public boolean isRunForever() {
		return runForever;
	}
	public void setRunForever(boolean runForever) {
		this.runForever = runForever;
	}
	public long getRepeatInterval() {
		return repeatInterval;
	}
	public void setRepeatInterval(long repeatInterval) {
		this.repeatInterval = repeatInterval;
	}
	public long getInitialOffSet() {
		return InitialOffSet;
	}
	public void setInitialOffSet(long initialOffSet) {
		InitialOffSet = initialOffSet;
	}
	public String getCallBackData() {
		return callBackData;
	}
	public void setCallBackData(String callBackData) {
		this.callBackData = callBackData;
	}
	
	
}
