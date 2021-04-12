package com.bfxy.spring.convert;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.MessageConversionException;
import org.springframework.amqp.support.converter.MessageConverter;

public class TextMessageConverter implements MessageConverter {

	/**
	　　* @description: 将java对象转换成Message
	　　* @param ${tags}
	　　* @return ${return_type}
	　　* @throws
	　　* @author ${USER}
	　　* @date 2021/3/18 19:41
	　　*/
	@Override
	public Message toMessage(Object object, MessageProperties messageProperties) throws MessageConversionException {
		System.out.println("===========toMessage================");
		return new Message(object.toString().getBytes(), messageProperties);
	}

	/**
	　　* @description: 将Message转换成java对象
	　　* @param ${tags}
	　　* @return ${return_type}
	　　* @throws
	　　* @author ${USER}
	　　* @date 2021/3/18 19:41
	　　*/
	@Override
	public Object fromMessage(Message message) throws MessageConversionException {
		System.out.println("===========fromMessage================");
		String contentType = message.getMessageProperties().getContentType();
		if(null != contentType && contentType.contains("text")) {
			//return new String(message.getBody());
			return message.getBody();
		}
//		return message.getBody();
		return new String(message.getBody());
	}

}
