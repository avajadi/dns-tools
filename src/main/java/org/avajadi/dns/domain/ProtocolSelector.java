package org.avajadi.dns.domain;

public enum ProtocolSelector {
	BOTH(true, true), IPV4(true, false), IPV6(false, true);
	public boolean ipv4;
	public boolean ipv6;

	ProtocolSelector(boolean ipv4, boolean ipv6) {
		this.ipv4 = ipv4;
		this.ipv6 = ipv6;
	}

}