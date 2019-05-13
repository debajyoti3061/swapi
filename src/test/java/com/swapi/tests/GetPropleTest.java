package com.swapi.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.swapi.utils.HttpRestClient;
import com.swapi.view.GetPeople;
import org.apache.http.client.methods.HttpGet;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static com.swapi.utils.HttpRestClient.responsestring;

public class GetPropleTest {
  HttpRestClient client = new HttpRestClient();

  @Test
  public void getAccountTest() throws IOException {
    String url = "https://swapi.co/api/people/";
    callget(url);
  }

  private void callget(String url) throws IOException {
    client.getrequest = new HttpGet( url);
    client.getrequest.addHeader("Content_Type", "application/json");
    client.exegetRequest(client.getrequest);
    Assert.assertEquals(200,client.responsecode);
    //System.out.println(responsestring);
    ObjectMapper mapper = new ObjectMapper();
    GetPeople people = mapper.readValue(String.valueOf(responsestring),GetPeople.class);
    int n = people.getResults().size();
    for(int i = 0;i<n ; i++){
      System.out.println(people.getResults().get(i).getName() +" "+people.getResults().get(i).getUrl());
    }
    if (people.getNext() == null) {
      System.out.println("end");
      return;}
    else  callget(people.getNext());

  }
}
