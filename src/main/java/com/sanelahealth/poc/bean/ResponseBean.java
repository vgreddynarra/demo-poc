package com.sanelahealth.poc.bean;

import lombok.Data;

@Data
public class ResponseBean {

	String id;
	String message;
	Object data;
	int status;
}
