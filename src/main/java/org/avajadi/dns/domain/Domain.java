package org.avajadi.dns.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Domain {

	public static void main(String[] args) {
		Domain otherDomain = new Domain("lars.son");
		Host otherHost = new Host("sara", otherDomain);
		Service otherService = new Service("Apache", otherHost);
		otherService.setDescription("Web server");
		otherService.addPort(80, ProtocolSelector.BOTH);
		otherDomain.addService(otherService, otherHost);
		Domain domain = new Domain("johan.son");
		Host host = new Host("erik", domain);
		host.addIPAddress(new IPV4Address("192.168.9.12"));
		host.addIPAddress(new IPV6Address("2a05:345f::10"));
		Service service = new Service("TomCat", host);
		service.setDescription("Simple servlet container");
		service.addPort(80, ProtocolSelector.BOTH);
		service.addPort(75, ProtocolSelector.IPV4);
		service.addPort(8080, ProtocolSelector.IPV6);
		domain.addService(service, host);
		domain.addAlias("maria", otherService);
		System.out.println(domain.toString());
	}

	private final List<ServiceAlias> aliases = new ArrayList<ServiceAlias>();
	private final List<Host> hosts = new ArrayList<Host>();

	private String name;

	public Domain(String name) {
		this.name = name;
	}

	public void addAlias(final String name, final Service service) {
		aliases.add(new ServiceAlias(name, this, service));
	}

	public void addHost(final Host host) {
		if (host.belongsTo(this)) {
			hosts.add(host);
		} else {
			throw new IllegalArgumentException(String.format(
					"Host %s belongs to %s, not %s", host.getName(), host
							.getDomain().getName(), getName()));
		}
	}

	public void addService(final Service service, final Host host) {
		int where = hosts.indexOf(host);
		if (where != -1) {
			hosts.get(where).addService(service);
		} else if (host.belongsTo(this)) {
			host.addService(service);
			hosts.add(host);
		} else {
			throw new IllegalArgumentException(String.format(
					"Host %s belongs to %s, not %s", host.getName(), host
							.getDomain().getName(), getName()));
		}
	}

	public List<ServiceAlias> getAliases() {
		return Collections.unmodifiableList(aliases);
	}

	public List<Host> getHosts() {
		return Collections.unmodifiableList(hosts);
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("Domain: %s\n", getName()));
		sb.append("\nHosts\n");
		for (Host host : getHosts()) {
			sb.append(String.format("%s\n", host.toString()));
		}
		sb.append("\nAliases\n");
		for (ServiceAlias alias : getAliases()) {
			sb.append(alias.toString());
		}
		return sb.toString();
	}

}
