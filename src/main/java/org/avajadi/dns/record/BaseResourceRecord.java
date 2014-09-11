package org.avajadi.dns.record;

public abstract class BaseResourceRecord implements ResourceRecord {

	private DomainRecord domain;
	private String key;
	private RecordType type;

	public BaseResourceRecord(RecordType type) {
		this.type = type;
	}

	public String getCanonicalKey() {
		return String.format("%s.%s.", getKey(), getDomainRecord().getName());
	}

	public DomainRecord getDomainRecord() {
		return domain;
	}

	public String getDomainName() {
		return getDomainRecord().getName();
	}

	public String getKey() {
		return key;
	}

	public RecordType getType() {
		return type;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
