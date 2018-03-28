/**
* @Title: MyJobFactory.java
* @Package com.ewp.data.controller.quartz
* @Description: 解决不能spring注入bean的问题
* @author zxj
* @date 2018年2月26日
* @version V1.0
*/
package com.ewp.data.config;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

/**
 * @ClassName: MyJobFactory
 * @Description: 解决不能spring注入bean的问题
 * @author zxj
 * @date 2018年2月26日
 *
 */
@Component 
public class MyJobFactory extends AdaptableJobFactory {
	@Autowired  
    private AutowireCapableBeanFactory capableBeanFactory;  
     
    @Override  
    protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {  
      Object jobInstance = super.createJobInstance(bundle);  
      capableBeanFactory.autowireBean(jobInstance); 
      return jobInstance;  
    }  
}
