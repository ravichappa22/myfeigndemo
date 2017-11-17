package com.example.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.pojo.TokenResponse;


@FeignClient(name="tokenclient",url="http://localhost:8080")
public interface TokenClient{
	
	
	@RequestMapping(value="/auth/oauth/token", method=RequestMethod.POST, consumes="application/x-www-form-urlencoded")
    public TokenResponse getkUserToken(@RequestHeader("authorization") String basicAuth, @RequestParam("client_id") String client_id, 
    																			@RequestParam("grant_type") String grant_type);
	
}
