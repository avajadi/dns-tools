package org.avajadi.dns.record;

public class MXRecord extends BaseResourceRecord implements ResourceRecord {
	private String hostName;
	private int priority;
	
	public MXRecord() {
		super(RecordType.MX);
	}
	

	public String getData() {
		return String.format("%d\t%s", priority, hostName);
	}


	public String getHostName() {
		return hostName;
	}


	public int getPriority() {
		return priority;
	}


	public void setHostName(String hostName) {
		this.hostName = hostName;
	}


	public void setPriority(int priority) {
		this.priority = priority;
	}

}
