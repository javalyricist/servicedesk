package com.service.desk.servicedesk.util;

import java.io.IOException;

import org.apache.tomcat.util.codec.binary.Base64;

public class ServiceDeskUtil {

	public static String decodeBase64(String authString) throws IOException {
		String decodedAuth = "";
		String[] authParts = authString.split("\\s+");
		String authInfo = authParts[1];
		byte[] bytes = null;
		bytes = Base64.decodeBase64(authInfo);
		decodedAuth = new String(bytes);
		return decodedAuth;
	}
}
