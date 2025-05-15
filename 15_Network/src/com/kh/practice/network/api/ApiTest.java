package com.kh.practice.network.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class ApiTest {
	public static void main(String[] args) {
		try {
			String requestUrl = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMsrstnAcctoRltmMesureDnsty";
			String serviceKey = "o%2FmfuKVSlG%2Fs3V9BUqGWcBSjDPWCOL7XAuWO132ZOxEy9zVOHZQhX7db4rk3dNQaOSYeEnQBf9cIsWsijCYwvA%3D%3D";
			String stationName = URLEncoder.encode("종로구","UTF-8");
			String dataTerm = "DAILY"; 
			
			requestUrl += "?serviceKey="+serviceKey;
			requestUrl += "&stationName="+stationName;
			requestUrl += "&dataTerm="+dataTerm;
			
			URL url = new URL(requestUrl);
			
			URLConnection conn = url.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			String line;
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}





