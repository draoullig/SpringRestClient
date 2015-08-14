package fr.gillouard.spring.restclient;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import fr.gillouard.spring.restclient.pojo.Client;

public class RestClientError {

	public static void main(String[] args) {
		final String url = "http://localhost:8080/SpringRestWS/client";

		try {
			new RestTemplate().exchange(url, HttpMethod.GET, null,
					new ParameterizedTypeReference<List<Client>>() {
					});
		} catch (final HttpStatusCodeException hsce) {
			System.out.println(hsce.getResponseBodyAsString());
		}

		try {
			new RestTemplate().getForObject(
					new StringBuilder(url).append("/{id}").toString(),
					Client.class, "-1");
		} catch (final HttpStatusCodeException hsce) {
			System.out.println(hsce.getResponseBodyAsString());
		}
	}

}
