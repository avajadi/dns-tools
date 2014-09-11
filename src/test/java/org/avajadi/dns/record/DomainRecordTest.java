package org.avajadi.dns.record;

import static org.testng.Assert.*;

import org.avajadi.dns.record.DomainRecord;
import org.avajadi.dns.record.SOARecord;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DomainRecordTest {
//	@Mock
	private SOARecord soaRecord;
	private String domainName = "example.com";
//	@InjectMocks
	private DomainRecord sut;

	@BeforeMethod
	public void createDomainRecord() throws Exception {
//		MockitoAnnotations.initMocks(this);
		sut = new DomainRecord(domainName);
		soaRecord = new SOARecord();
		sut.setSoaRecord(soaRecord);
	}

	@Test
	public void testGetName() throws Exception {
		assertEquals(sut.getName(),domainName);
	}

	@Test
	public void testGetSoaRecord() throws Exception {
		assertEquals(sut.getSoaRecord(), soaRecord);
	}

	@Test
	public void testSetName() throws Exception {
		String monkeyName = "monkey.apa";
		sut.setName(monkeyName);
		assertEquals(sut.getName(), monkeyName);
	}

}
