package com.nw.client.ws.support;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.wss4j.common.ext.WSPasswordCallback;
import org.springframework.stereotype.Component;

@Component
public class ClientPasswordCallback implements CallbackHandler {

	@Override
	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
		for (int i = 0; i < callbacks.length; i++) {  
            WSPasswordCallback pc = (WSPasswordCallback)callbacks[i];
            pc.setIdentifier("nw");
            pc.setPassword("nw");  
        }  

	}

}
