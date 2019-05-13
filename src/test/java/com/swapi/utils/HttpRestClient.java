package com.swapi.utils;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import sun.net.www.http.HttpClient;

import java.io.IOException;

public class HttpRestClient {

  public CloseableHttpClient client = HttpClientBuilder.create().build();
  public static HttpPost postrequest;
  public static HttpPut putrequest;
  public static HttpGet getrequest;
  public static HttpDelete deleterequest;
  public static HttpResponse response;
  public static int responsecode;
  public static StringEntity params;
  public static Object responsestring;


  public void exegetRequest(HttpGet getrequest) throws ClientProtocolException, IOException {
    response = client.execute(getrequest);
    responsecode = getResponse().getStatusLine().getStatusCode();
    responsestring = EntityUtils.toString(response.getEntity());
  }

  public HttpResponse getResponse() {
    return response;
  }

  public  void setResponse(HttpResponse response) {
    this.response = response;
  }
}
