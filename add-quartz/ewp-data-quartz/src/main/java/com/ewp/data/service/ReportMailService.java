/**
* @Title: ReportMailService.java
* @Package com.ewp.data.service
* @Description: 汇报邮件
* @author zxj
* @date 2018年3月8日
* @version V1.0
*/
package com.ewp.data.service;

import java.text.MessageFormat;
import java.util.List;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.ewp.data.domain.Code;
import com.ewp.data.domain.MsgTemplate;
import com.ewp.data.model.response.ReportMail;
import com.ewp.data.persistence.CodeMapper;
import com.ewp.data.persistence.MsgTemplateMapper;
import com.ewp.data.persistence.TransContMapper;
import com.ewp.data.persistence.UserStaffInfoMapper;
import com.ewp.data.util.DateUtil;
import com.ewp.data.util.StringUtil;

/**
 * @ClassName: ReportMailService
 * @Description: 汇报邮件
 * @author zxj
 * @date 2018年3月8日
 *
 */
@Service
public class ReportMailService {
	private static final Logger log = LoggerFactory.getLogger(ReportMailService.class);
	
	@Autowired
	CodeMapper cMapper;
	
	@Autowired
	JavaMailSender mailSender;
	
	@Autowired
	MsgTemplateMapper mMapper;
	
	@Autowired
	TransContMapper tMapper;
	
	@Autowired
	UserStaffInfoMapper uMapper;
	
	@Value("${spring.mail.username}")
	private String sender;// 发件人
	
	
	private final String TYPE="Emp";// 身份标识
	
	/**
	 * 
	* @Title: sendReportMail
	* @Description: 汇报短信发送
	* @param     参数
	* @return void    返回类型
	* @throws
	 */
	@SuppressWarnings("all")
	public void sendReportMail(){
		log.info("+++++汇报邮件发送+++++开始++++");
		List<Code> p = cMapper.selectCompanyCodeType(TYPE);
		if (p.size()<=0) {
			log.info("无待发送人员信息");
			return;
		}
		for (Code code : p) {
			try{
				String[] mId = code.getCodePosition().split("-");
				MsgTemplate t = mMapper.selectByPrimaryKey(Long.parseLong(mId[1]));
				if (null == t || StringUtil.isEmpty(t.getTemplateContent())) {
					log.info("无模板信息:------->"+mId[1]);
					continue;
				}
				String personNum = uMapper.selectPersonNum(0,0);
				ReportMail reportMail = tMapper.selectContMsg(0,0);//查询当前信息
				String contNum = (reportMail.getContNum()==null)?"0":reportMail.getContNum();// 保单
				String totalPrem =( reportMail.getTotalPrem()==null)?"0.00":reportMail.getTotalPrem();// 保费
				String personNumT = uMapper.selectPersonNum(-365000,0);
				reportMail = tMapper.selectContMsg(-365000,0);//查询所有信息
				String contNumT = (reportMail.getContNum()==null)?"0":reportMail.getContNum();// 总保单
				String totalPremT = (reportMail.getTotalPrem()==null)?"0.00":reportMail.getTotalPrem();// 总保费
				String[] args = {code.getCodeName(),DateUtil.getCurrentStrNew(),personNum,contNum,totalPrem,personNumT,contNumT,totalPremT};// 模板参数组
				String content = MessageFormat.format(t.getTemplateContent(), args);
				log.info("发送邮件信息：----->"+content);
				MimeMessage message = null;// 邮件发送
				message = mailSender.createMimeMessage();
				MimeMessageHelper helper = new MimeMessageHelper(message,true);
				helper.setFrom(sender);// 发件人
				helper.setTo(code.getCodeValue());// 邮件地址
				helper.setSubject(mId[0]);// 主题
				helper.setText(content, true);// 内容
				mailSender.send(message);	
			}catch(Exception e){
				e.printStackTrace();
				log.info("邮件发送异常！！！");
				continue;
			}
		}
		log.info("+++++汇报邮件发送+++++结束++++");
	}
	
}
