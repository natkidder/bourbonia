package com.springinaction.springidol2;

import java.lang.reflect.Method;
import org.springframework.beans.factory.support.MethodReplacer;

public class TigerReplacer implements MethodReplacer  {
	public Object reimplement(Object target, Method method, Object[] args) throws Throwable {
		return "A ferocious tiger";
	}
}
