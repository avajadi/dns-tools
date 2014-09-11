package org.avajadi.dns.domain;

public class IPV4Address implements IPAddress {

	private String address;

	public IPV4Address(final String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public boolean isA(ProtocolSelector protocol) {
		return protocol.ipv4;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return String.format("IPv4: %s", getAddress());
	}
}
