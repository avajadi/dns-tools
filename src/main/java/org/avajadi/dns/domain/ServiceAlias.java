package org.avajadi.dns.domain;

public class ServiceAlias {
	private Domain domain;
	private Service service;
	private String name;

	public ServiceAlias(String name, Domain domain, Service service) {
		this.name=name;
		this.domain = domain;
		this.service = service;
	}

	public Domain getDomain() {
		return domain;
	}

	public Host getHost() {
		return service.getHost();
	}

	public String getFullyQualifiedName() {
		return String.format("%s.%s", getName(), getDomain().getName());
	}
	public String getName() {
		return name;
	}

	public void setDomain(Domain domain) {
		this.domain = domain;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString(){
		return String.format("%s => %s on %s", getFullyQualifiedName(), getService().getName(), getHost().getFullyQualifiedDomainName());
	}

	public Service getService() {
		return service;
	}
}
