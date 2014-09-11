package org.avajadi.dns.domain;

public interface IPAddress {

	public String getAddress();

	public boolean isA(ProtocolSelector protocol);

	public void setAddress(String address);

}
