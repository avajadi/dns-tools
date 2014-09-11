package org.avajadi.dns.record;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class DomainRecord {
	private final Set<MXRecord> mxRecords = new HashSet<MXRecord>();

	private String name;

	private final Set<NSRecord> nsRecords = new HashSet<NSRecord>();
	private SOARecord soaRecord;

	public DomainRecord(String name) {
		this.name = name;
	}

	public void addMxRecord(MXRecord mxRecord) {
		mxRecords.add(mxRecord);
	}

	public void addNsRecord(NSRecord nsRecord) {
		nsRecords.add(nsRecord);
	}

	public Set<MXRecord> getMxRecords() {
		return Collections.unmodifiableSet(mxRecords);
	}

	public String getName() {
		return name;
	}

	public Set<NSRecord> getNsRecords() {
		return Collections.unmodifiableSet(nsRecords);
	}

	public SOARecord getSoaRecord() {
		return soaRecord;
	}

	public void removeMxRecord(MXRecord mxRecord) {
		mxRecords.remove(mxRecord);
	}

	public void removeNsRecord(NSRecord nsRecord) {
		nsRecords.remove(nsRecord);
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSoaRecord(SOARecord soaRecord) {
		this.soaRecord = soaRecord;
	}
}
