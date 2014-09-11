package org.avajadi.dns.record;

public abstract class HostNameResourceRecord extends BaseResourceRecord
		implements HostNameRecord {

	private String hostName;

	public HostNameResourceRecord(RecordType type) {
		super(type);
		// TODO Auto-generated constructor stub
	}

	public String getData() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getCanonicalHostName() {
		return String.format("%s.%s.", getHostName(),getDomainName());
	}

}
