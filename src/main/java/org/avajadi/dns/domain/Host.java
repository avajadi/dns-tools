package org.avajadi.dns.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Host {
	private Domain domain;
	private String name;
	private final List<IPAddress> ipAddresses = new ArrayList<IPAddress>();

	private final List<Service> services = new ArrayList<Service>();

	public Host( final String name, final Domain domain ){
		this.domain=domain;
		this.name=name;
	}
	
	public void addService(Service service) {
		services.add(service);
	}

	public boolean belongsTo(Domain domain) {
		return this.domain.equals(domain);
	}

	public String getName() {
		return name;
	}
	
	public String getFullyQualifiedDomainName() {
		return String.format("%s.%s", getName(), getDomain().getName());
	}

	public Domain getDomain() {
		return domain;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("Host: %s\n",getFullyQualifiedDomainName()));
		for( Service service : getServices()) {
			sb.append(service.toString());
		}
		sb.append("IP Adresses\n");
		for( IPAddress ipAddress: getIpAddresses(ProtocolSelector.BOTH)) {
			sb.append(String.format("%s\n", ipAddress.toString()));
		}
		return sb.toString();
	}

	public List<Service> getServices() {
		// TODO Auto-generated method stub
		return Collections.unmodifiableList(services);
	}

	public List<IPAddress> getIpAddresses( ProtocolSelector protocol) {
		if( protocol == ProtocolSelector.BOTH) {
			return Collections.unmodifiableList(ipAddresses);
		}
		List<IPAddress> addresses = new ArrayList<IPAddress>();
		for (IPAddress ipAddress : ipAddresses) {
			if( ipAddress.isA(protocol)) {
				addresses.add(ipAddress);
			}
		}
		return addresses;
	}

	public void addIPAddress(IPAddress ipAddress) {
		ipAddresses.add(ipAddress);
	}
	
}
