package org.avajadi.dns.record;

public interface ResourceRecord {

	public enum RecordType {
		A, AAAA, CNAME, MX, NS, PTR, SOA, TXT
	}

	public String getData();

	public DomainRecord getDomainRecord();

	public String getKey();

	public RecordType getType();

	public void setKey(String key);
}
