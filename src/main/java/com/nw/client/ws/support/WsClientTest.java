package com.nw.client.ws.support;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.xml.namespace.QName;
import javax.xml.ws.soap.SOAPFaultException;

import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.handler.WSHandlerConstants;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nw.service.webservice.PetWebService;

public class WsClientTest {

	public static void main(String[] args) {
		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance(); 
		org.apache.cxf.endpoint.Client client = dcf.createClient("http://www.m7pets.com/nw-service/ws/petWeb?wsdl");  
		QName name=new QName("http://webservice.service.nw.com/","getPetImmuneInfo"); 
		Map<String, Object> props = new HashMap<String, Object>(); 
		props.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN);  
		//密码类型 明文:PasswordText密文：PasswordDigest  
		props.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_DIGEST);
		props.put(WSHandlerConstants.USER, "nw");
		props.put(WSHandlerConstants.PW_CALLBACK_CLASS, ClientPasswordCallback.class.getName());
		WSS4JOutInterceptor wssOut = new WSS4JOutInterceptor(props);
		client.getOutInterceptors().add(wssOut);
		
		Object[] objects = null;
        try {
            //String mailTrackId=UUID.randomUUID().toString().replace("-", "");
            objects = client.invoke(name,"18773808783","画画");
            System.out.println(objects.toString());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }   
//		ApplicationContext context = new ClassPathXmlApplicationContext("spring-client.xml");  
//		try {  
//			PetWebService hi = (PetWebService) context.getBean("petService");  
//            System.out.println(hi.getPetImmuneInfo("18773808783", "画画"));  
//        } catch (Exception ex) {  
//            ex.printStackTrace();  
//        }  
	}
}
