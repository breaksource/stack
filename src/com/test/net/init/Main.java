package com.test.net.init;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Main {
	
	private static final String HOST = "www.baidu.com";
	private static final String URL = "http://"+HOST+"/";

	public static void main(String[] args) throws ClientProtocolException, IOException {
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		HttpGet getReq = new HttpGet(URL);
		getReq.addHeader("Accept", "application/json, text/javascript, */*; q=0.01");
		getReq.addHeader("Accept-Encoding", "gzip,deflate,sdch");
		getReq.addHeader("Accept-Language", "zh-CN,zh;q=0.8");
		getReq.addHeader("Content-Type", "text/html; charset=UTF-8");
		getReq.addHeader("Host", HOST);
		getReq.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 5.2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/32.0.1700.76 Safari/537.36");
		
		CloseableHttpResponse rep = httpClient.execute(getReq);
		
		HttpEntity repEntity = rep.getEntity();
		
		String content = EntityUtils.toString(repEntity);
		 
		System.out.println(content);
		
		rep.close();
		httpClient.close();

	}

}
