/**
* @Title: QuartzController.java
* @Package com.ewp.data.controller.quartz
* @Description: 批处理入口
* @author zxj
* @date 2018年2月26日
* @version V1.0
*/
package com.ewp.data.controller;

import io.swagger.annotations.ApiOperation;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ewp.data.model.response.ObjectDataResponse;
import com.ewp.data.quartz.TaskInfo;
import com.ewp.data.quartz.exception.ServiceException;
import com.ewp.data.service.TaskService;

/**
 * @ClassName: QuartzController
 * @Description: zxj
 * @author 批处理入口
 * @date 2018年2月26日
 *
 */
@RestController
@RequestMapping(value = "/api/v1", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
public class QuartzController {
	private static final Logger log = LoggerFactory.getLogger(QuartzController.class);
	
	@Autowired
	private TaskService service;
	
	/**
	 * 
	* @Title: queryJobList
	* @Description: 查询任务列表
	* @param @return    参数
	* @return ObjectDataResponse<String>    返回类型
	* @throws
	 */
	@ApiOperation(value = "查询任务列表")
	@RequestMapping(value="/queryJobList/{notUse}", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE)
	public ObjectDataResponse<List<TaskInfo>> queryJobList(@PathVariable("notUse")String notUse){
		log.info("QuartzController-->queryJobList()");
		return new ObjectDataResponse<List<TaskInfo>>(service.queryJobList());
	}
	
	/**
	 * 
	* @Title: addJob
	* @Description: 添加/修改任务
	* @param @param info
	* @param @return    参数
	* @return ObjectDataResponse<String>    返回类型
	* @throws
	 */
	@ApiOperation(value = "添加/修改任务")
	@RequestMapping(value="/addOrModifyJob", method=RequestMethod.POST)
	public ObjectDataResponse<String> addOrModifyJob(@RequestBody TaskInfo info){
		log.info("QuartzController-->addJob()"+info.toString());
		try {
			if(info.getId() == 0) {
				service.addJob(info);
			}else{
				service.editJob(info);
			}
		} catch (ServiceException e) {
			log.info("添加/修改任务-------->c："+e.getMessage());
			return new ObjectDataResponse<String>("failed");
		}
		return new ObjectDataResponse<String>("success");
	}
	
	/**
	 * 
	* @Title: setSimpleTriggerJob
	* @Description: 简单调度
	* @param @param info
	* @param @return    参数
	* @return ObjectDataResponse<String>    返回类型
	* @throws
	 */
	@ApiOperation(value = "简单调度")
	@RequestMapping(value="/setSimpleTriggerJob", method=RequestMethod.POST)
	public ObjectDataResponse<String> setSimpleTriggerJob(@RequestBody TaskInfo info){
		log.info("QuartzController-->setSimpleTriggerJob()"+info.toString());
		try {
			service.setSimpleTriggerJob(info);
		} catch (ServiceException e) {
			log.info("简单调度-------->c:"+e.getMessage());
			return new ObjectDataResponse<String>("failed");
		}
		return new ObjectDataResponse<String>("success");
	}
	
	/**
	 * 
	* @Title: deleteJob
	* @Description: 删除任务
	* @param @param jobName
	* @param @param jobGroup
	* @param @return    参数
	* @return ObjectDataResponse<String>    返回类型
	* @throws
	 */
	@ApiOperation(value = "删除任务")
	@RequestMapping(value="/deleteJob/{jobName}/{jobGroup}", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE)
	public ObjectDataResponse<String> deleteJob(@PathVariable("jobName")String jobName, @PathVariable("jobGroup")String jobGroup){
		log.info("QuartzController--data-c-->deleteJob()--jobName:"+jobName+"jobGroup:"+jobGroup);
		try {
			service.deleteJob(jobName, jobGroup);
		} catch (ServiceException e) {
			log.info("删除任务-------->c:"+e.getMessage());
			return new ObjectDataResponse<String>("failed");
		}
		return new ObjectDataResponse<String>("success");
	}
	
	/**
	* @Title: pauseJob
	* @Description: 暂停任务
	* @param @param jobName
	* @param @param jobGroup
	* @param @return    参数
	* @return ObjectDataResponse<String>    返回类型
	* @throws
	 */
	@ApiOperation(value = "暂停任务")
	@RequestMapping(value="/pauseJob/{jobName}/{jobGroup}", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE)
	public ObjectDataResponse<String> pauseJob(@PathVariable("jobName")String jobName, @PathVariable("jobGroup")String jobGroup){
		log.info("QuartzController--data-c-->pauseJob()--jobName:"+jobName+"jobGroup:"+jobGroup);
		try {
			service.pauseJob(jobName, jobGroup);
		} catch (ServiceException e) {
			log.info("暂停任务-------->c:"+e.getMessage());
			return new ObjectDataResponse<String>("failed");
		}
		return new ObjectDataResponse<String>("success");
	}
	
	/**
	 * 
	* @Title: resumeJob
	* @Description: 恢复暂停任务
	* @param @param jobName
	* @param @param jobGroup
	* @param @return    参数
	* @return ObjectDataResponse<String>    返回类型
	* @throws
	 */
	@ApiOperation(value = "恢复暂停任务")
	@RequestMapping(value="/resumeJob/{jobName}/{jobGroup}", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE)
	public ObjectDataResponse<String> resumeJob(@PathVariable("jobName")String jobName, @PathVariable("jobGroup")String jobGroup){
		log.info("QuartzController--data-c-->resumeJob()--jobName:"+jobName+"jobGroup:"+jobGroup);
		try {
			service.resumeJob(jobName, jobGroup);
		} catch (ServiceException e) {
			log.info("恢复暂停任务-------->c:"+e.getMessage());
			return new ObjectDataResponse<String>("failed");
		}
		return new ObjectDataResponse<String>("success");
	}
	
	
}
