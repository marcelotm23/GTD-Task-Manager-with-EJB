package com.sdi.business.integration;

import javax.jms.JMSException;

public interface Auditor {

	public void audit(String operation, String message) throws JMSException;

}
