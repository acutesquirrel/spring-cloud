/**
* @Title: ReportMail.java
* @Package com.ewp.data.model.response
* @Description: TODO(用一句话描述该文件做什么)
* @author Administrator
* @date 2018年3月9日
* @version V1.0
*/
package com.ewp.data.model.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @ClassName: ReportMail
 * @Description: 汇报信息接收类
 * @author zxj
 * @date 2018年3月9日
 *
 */
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "fieldHandler"}, ignoreUnknown = true)
public class ReportMail {
	
	/**
	 * 保费
	 */
	private String totalPrem;
	
	/**
	 * 保单数
	 */
	private String contNum;
}
