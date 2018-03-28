/**
* @Title: HttpsPort.java
* @Package com.ewp.data.config
* @Description: 添加https
* @author zxj
* @date 2018年3月14日
* @version V1.0
*/
package com.ewp.data.config;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @ClassName: HttpsPort
 * @Description: 添加https
 * @author zxj
 * @date 2018年3月14日
 *
 */

public class HttpsPort {/*
	
	@Value("${server.port}")
	private  int sPort;
	
	@Value("${http.port}")
	private  int hPort;
	
	private static class Tomcat extends TomcatEmbeddedServletContainerFactory{
		@Override
	    protected void postProcessContext(Context context) {
	        SecurityConstraint constraint = new SecurityConstraint();
	        constraint.setUserConstraint("CONFIDENTIAL");
	        SecurityCollection collection = new SecurityCollection();
	        collection.addPattern("/*");
	        constraint.addCollection(collection);
	        context.addConstraint(constraint);
	    }
	}
	
	@Bean
    public EmbeddedServletContainerFactory servletContainer() {
		Tomcat tomcat = new Tomcat();
        tomcat.addAdditionalTomcatConnectors(httpConnector());
        return tomcat;
	}
	
	@Bean
    public Connector httpConnector() {
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setScheme("http");
        connector.setPort(hPort);       
        connector.setSecure(false);
        connector.setRedirectPort(sPort);
        return connector;
    }
	
*/}
