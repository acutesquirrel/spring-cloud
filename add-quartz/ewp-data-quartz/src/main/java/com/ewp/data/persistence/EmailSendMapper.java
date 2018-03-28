package com.ewp.data.persistence;

import com.ewp.data.MyBatisRepository;
import com.ewp.data.domain.EmailSend;

@SuppressWarnings("InterfaceNeverImplemented")
@MyBatisRepository
public interface EmailSendMapper extends CrudMapper<EmailSend> {
    
}