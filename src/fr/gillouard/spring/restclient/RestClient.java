package fr.gillouard.spring.restclient;

import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import fr.gillouard.spring.restclient.pojo.Client;

public class RestClient {

	public static void main(String[] args) {
		final List<Client> clients = new RestTemplate().exchange(
				"http://localhost:8080/SpringRestWS/client", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Client>>() {
				}).getBody();
		System.out.println(new StringBuilder("Taille de la liste : ").append(
				clients.size()).toString());
		for (final Client client : clients) {
			System.out.println(new StringBuilder(client.getNom()).append(" ")
					.append(client.getPrenom()).toString());
		}

	}

}
