package com.nw.service.webservice;

import javax.jws.WebService;

@WebService
public interface PetWebService {

	/**
	 * 电子免疫证接口
	 * @param phone
	 * @param userName
	 * @return 
	 */
	String getPetImmuneInfo(String phone, String userName) throws Exception;
}
