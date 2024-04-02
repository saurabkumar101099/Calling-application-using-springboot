package com.phonecall.springbootcallapp;

import java.net.URI;


import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.type.PhoneNumber;

@SpringBootApplication
public class SpringBootCallAppApplication implements ApplicationRunner {
private final static String SID_ACCOUNT="AC30135fe2ae99e9c38a257466bb16160a";
private final static String AUTH_ID="c59301123ac8c0a651d6f2ceb8accf53";
private final static String FROM_NUMBER="+12512209376";
private final static String TO_NUMBER="+917396139192";

static {
	Twilio.init(SID_ACCOUNT, AUTH_ID);
}

public static void main(String[] args) {
		SpringApplication.run(SpringBootCallAppApplication.class, args);
	}

@Override
public void run(ApplicationArguments args) throws Exception {
	Call.creator(new PhoneNumber(TO_NUMBER), new PhoneNumber(FROM_NUMBER), new URI("http://demo.twilio.com/docs/voice.xml")).create();
}

}
