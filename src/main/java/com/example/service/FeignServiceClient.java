package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pojo.TokenResponse;

@Service
public class FeignServiceClient {

	@Autowired
	private FeignInterface feignInterface;
	
	@Autowired
	private  TokenClient tokenClient;
	
	//private String authorization="bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1MTA5NDUyMzEsInVzZXJfbmFtZSI6InNlcnZpY2UtYWNjb3VudC0xIiwiYXV0aG9yaXRpZXMiOlsiUk9MRV93cml0ZSIsIlJPTEVfcmVhZCJdLCJqdGkiOiIwYzU0ZTkyMC02YTAxLTQxMDUtODExZi01ZjQ4OWMzZGRjMDciLCJjbGllbnRfaWQiOiJzZXJ2aWNlLWFjY291bnQtMSIsInNjb3BlIjpbXX0.KzjcUN9TU8SHqOztE8VL8cTBgyNgyl7JeghlEsBPiVa9DaJHq-EmrLEaD8e169qfdGRspb6DJ9t4oe6Q4asKwAtvQtarZaboStgbOXuC8PCM20gLvHAjdyP7sGgVzSFKKoM7haGtqoAUhzeOqoWlsIfkZg9qJeowFWH9LJ0F9w6gS69bPj1lOhxBOEGWz_DM8S_ylxJU9QUY3Cbb8nNM4QaLmrAXvV1AUtrjWvGqXCyaeTb6yd6cQP7Wqvu4jwtezOu3orpp28AwlDvgzfexHcEtPI2cRLff_WAESdv1MExll-ylSilLpVx8lwxFbtk3es0ThKrBGDHIXXSCN97Jhg";
	
	public String getMyName(){
		TokenResponse token = tokenClient.getkUserToken("Basic c2VydmljZS1hY2NvdW50LTI6c2VydmljZS1hY2NvdW50LTItc2VjcmV0", "service-account-2", "client_credentials");
		System.out.println("token=" + token.getAccess_token());
		return feignInterface.getMyName(token.getToken_type()+" "+token.getAccess_token());
	}
}
