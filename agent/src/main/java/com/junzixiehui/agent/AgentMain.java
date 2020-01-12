package com.junzixiehui.agent;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.instrument.Instrumentation;

/**
 * <p>Description: </p>
 * @author: by qulibin
 * @date: 2019/2/28  5:33 PM
 * @version: 1.0
 */
public class AgentMain {

	public static void premain(String agentOps, Instrumentation instrumentation) {
		new AgentBuilder.Default()
				.type(ElementMatchers.named("org.springframework.web.servlet.DispatcherServlet"))
				.transform((builder, type, classLoader, module) ->
						builder.method(ElementMatchers.named("doDispatch"))
								.intercept(MethodDelegation.to(DoDispatchInterceptor.class)))
				.installOn(instrumentation);
	}

}
