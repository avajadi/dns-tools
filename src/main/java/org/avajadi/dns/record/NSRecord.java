package org.avajadi.dns.record;

public class NSRecord extends HostNameResourceRecord implements ResourceRecord, HostNameRecord {

	
	public NSRecord() {
		super(RecordType.NS);
	}

	public String getData() {
		return null;
	}

}
