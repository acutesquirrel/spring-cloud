package com.ewp.data.domain;

import com.ewp.data.model.BasicDomain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "fieldHandler"}, ignoreUnknown = true)
public class EmailSend extends BasicDomain {

	private static final long serialVersionUID = -3431565013700313155L;

	private Long id;

    private String tasktype;

    private Long userId;

    private String userPwd;

    private String theme;

    private String templateId;

    private String sendstatus;

    private String attachment;

    private String failReason;

    private Long sendfailuretimes;

    private Date modifyDate;

    private Date createDate;
}