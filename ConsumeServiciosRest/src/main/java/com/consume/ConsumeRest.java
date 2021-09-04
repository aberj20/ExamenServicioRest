
package com.consume;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class ConsumeRest {

    public static void main(String args[]) {
        ConsumeRest consume = new ConsumeRest();
        try {
            //consume.peticionPost();
            consume.peticionPut();
        } catch (Exception ex) {
            Logger.getLogger(ConsumeRest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void peticionPost() throws Exception {
        JSONObject json = new JSONObject();
        HttpPost post = new HttpPost("http://localhost:8080/POST/NutriNET/Cliente");

      
       json.put("nombre", "armando");
        json.put("apellidos", "lopez");
        json.put("nombreUsuario", "alopez");
        json.put("correoElectronico", "alopez@gmail.com");
        json.put("contrasenia", "cambiocontra");

        StringEntity parametros = new StringEntity(json.toString());
        post.setHeader("Content-Type", "application/json");
        post.setEntity(parametros);

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
                CloseableHttpResponse response = httpClient.execute(post)) {

            System.out.println(EntityUtils.toString(response.getEntity()));
        }

    }
    
    
     private void peticionPut() throws Exception {
        JSONObject json = new JSONObject();
        HttpPut post = new HttpPut("http://localhost:8080/PUT/NutriNET/Cliente/5");

      
      json.put("edad", 39);
        json.put("estatura", 1.80);
        json.put("peso", "80");
        json.put("GEB", "1500");
       

        StringEntity parametros = new StringEntity(json.toString());
        post.setHeader("Content-Type", "application/json");
        post.setEntity(parametros);

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
                CloseableHttpResponse response = httpClient.execute(post)) {

            System.out.println(EntityUtils.toString(response.getEntity()));
        }

    }
}
