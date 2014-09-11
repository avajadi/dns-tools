package org.avajadi.dns.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Service {

	private String description;
	private Host host;
	private final List<Integer> ipv4Ports = new ArrayList<Integer>();
	private final List<Integer> ipv6Ports = new ArrayList<Integer>();
	private String name;

	public Service(String name, Host host) {
		this.name = name;
		this.host = host;
	}

	public void addPort(int port, ProtocolSelector protocol) {
		if (protocol.ipv4) {
			ipv4Ports.add(port);
		}
		if (protocol.ipv6) {
			ipv6Ports.add(port);
		}
	}

	public String getDescription() {
		return description;
	}

	public Host getHost() {
		return host;
	}

	public String getName() {
		return name;
	}

	public Set<Integer> getPorts( ProtocolSelector protocol ) {
		Set<Integer> ports = new HashSet<Integer>();
		if( protocol.ipv4 ) {
			ports.addAll(Collections.unmodifiableList(ipv4Ports));
		}
		if( protocol.ipv6 ) {
			ports.addAll(Collections.unmodifiableList(ipv6Ports));
		}
		return ports;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setHost(Host host) {
		this.host = host;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("Service %s on %s\n", getName(), getHost().getFullyQualifiedDomainName()));
		sb.append(getDescription());
		sb.append("\nListening on ports\n");
		sb.append(String.format("IPv4:%s\n",ipv4Ports.toString()));
		sb.append(String.format("IPv6:%s\n", ipv6Ports.toString()));
		return sb.toString();
	}
	
}
