package com.mum.edu.common;

import org.apache.commons.lang3.StringUtils;

import com.mum.edu.model.OrderHistory;

public class OrderHistoryRuleSet implements RuleSet {

	@Override
	public void applyRule(Object object) throws Exception {
		
		OrderHistory orderHistory = (OrderHistory)object;
		
		if (StringUtils.isBlank(orderHistory.getStreet()) || StringUtils.isBlank(orderHistory.getCity())
				|| StringUtils.isBlank(orderHistory.getZipCode()) || StringUtils.isBlank(orderHistory.getState())
				|| StringUtils.isBlank(orderHistory.getPhone()) || StringUtils.isBlank(orderHistory.getEmail())
				|| StringUtils.isBlank(orderHistory.getCardNumber())) {
			throw new Exception("You missing information");
		}
		
		if (!orderHistory.getEmail().matches("/^[a-zA-Z0-9]+\\@\\w+\\.\\w+$/")) {
			throw new Exception("Email is wrong format");
		}
		
	}

}
