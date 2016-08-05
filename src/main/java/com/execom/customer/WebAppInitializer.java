package com.execom.customer;

import org.springframework.web.servlet.support.*;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class< ? >[] getRootConfigClasses() {
		return new Class< ? >[]{WebConfig.class};
	}

	@Override
	protected Class< ? >[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}



}
