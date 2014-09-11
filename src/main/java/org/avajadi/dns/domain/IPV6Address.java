package org.avajadi.dns.domain;

public class IPV6Address implements IPAddress {

	private String address;

	public IPV6Address(final String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public boolean isA(ProtocolSelector protocol) {
		return protocol.ipv6;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String toString(){
		return String.format("IPv6: %s", getAddress());
	}
}
