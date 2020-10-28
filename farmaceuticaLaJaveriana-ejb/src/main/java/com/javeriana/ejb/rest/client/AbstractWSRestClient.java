/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javeriana.ejb.rest.client;

import java.util.logging.Logger;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.client.ClientProperties;

/**
 *
 * @author Karen Calderon R
 */
public class AbstractWSRestClient {

    private static Client client = ClientBuilder.newClient();
    private static final Logger LOG = Logger.getLogger(AbstractWSRestClient.class.getName());

    public static final String AUTHORIZATION = "Authorization";

    public AbstractWSRestClient() {
        super();
    }

    public Response getJSON(String url, String token, Integer timeOut) {
        client.property(ClientProperties.CONNECT_TIMEOUT, timeOut * 1000);
        client.property(ClientProperties.READ_TIMEOUT, timeOut * 1000);

        WebTarget target = client.target(url);

        if (token == null || token.isEmpty()) {
            return target.request(MediaType.APPLICATION_JSON).get();
        } else {
            return target.request(MediaType.APPLICATION_JSON)
                    .header(AUTHORIZATION, token).get();
        }
    }

    public Response postJSON(String url, String token, Entity<?> entity, Integer timeOut) {
        client.property(ClientProperties.CONNECT_TIMEOUT, timeOut * 1000);
        client.property(ClientProperties.READ_TIMEOUT, timeOut * 1000);
        WebTarget target = client.target(url);

        if (token == null || token.isEmpty()) {
            return target.request(MediaType.APPLICATION_JSON).post(entity);
        } else {
            return target.request(MediaType.APPLICATION_JSON)
                    .header(AUTHORIZATION, token).post(entity);
        }
    }

    public Response putJSON(String url, String token, Entity<?> entity, Integer timeOut) {

        client.property(ClientProperties.CONNECT_TIMEOUT, timeOut * 1000);
        client.property(ClientProperties.READ_TIMEOUT, timeOut * 1000);
        WebTarget target = client.target(url);
        if (token == null || token.isEmpty()) {
            return target.request(MediaType.APPLICATION_JSON).put(entity);
        } else {
            return target.request(MediaType.APPLICATION_JSON)
                    .header(AUTHORIZATION, token).post(entity);
        }
    }
}
