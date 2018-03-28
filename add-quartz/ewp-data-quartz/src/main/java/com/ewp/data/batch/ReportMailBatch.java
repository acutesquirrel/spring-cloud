/**
* @Title: ReportMailBatch.java
* @Package com.ewp.data.batch
* @Description: 邮件汇报批
* @author zxj
* @date 2018年3月8日
* @version V1.0
*/
package com.ewp.data.batch;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ewp.data.service.ReportMailService;

/**
 * @ClassName: ReportMailBatch
 * @Description: 邮件汇报批
 * @author zxj
 * @date 2018年3月8日
 *
 */
@Component
public class ReportMailBatch implements Job{

	private static final Logger log = LoggerFactory.getLogger(ReportMailBatch.class);
	
	@Autowired
	private ReportMailService service;
	
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		log.info("ReportMailBatch--data-c->execute()");
		log.info("ReportMailBatch: {}", arg0.getJobDetail().getKey().getName());
		service.sendReportMail();
	}
}
