package com.mum.edu.common;

import java.util.HashMap;
import java.util.Map;

import com.mum.edu.model.OrderHistory;

public class RuleSetFactory {

	private RuleSetFactory() {
	}

	private static Map<Class<? extends Object>, RuleSet> factory = new HashMap<>();

	static {
		 factory.put(OrderHistory.class, new OrderHistoryRuleSet());
	}
	
	public static RuleSet getRuleSet(Object ob) throws Exception{
		Class<? extends Object> c = ob.getClass();
		
		if(!factory.containsKey(c))
			throw new Exception("No Rule for this component");
		
		return factory.get(c);
	}
}
