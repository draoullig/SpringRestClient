package fr.gillouard.spring.restclient;

import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import fr.gillouard.spring.restclient.pojo.Client;
import org.springframework.http.HttpEntity;

public class RestClient {

	public static void main(String[] args) {
		final String url = "http://localhost:8080/SpringRestWS/client";

		final List<Client> clients = new RestTemplate().exchange(url,
				HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Client>>() {
				}).getBody();
		System.out.println(new StringBuilder("Taille de la liste : ").append(
				clients.size()).toString());
		for (final Client client : clients) {
			System.out.println(new StringBuilder(client.getNom()).append(" ")
					.append(client.getPrenom()).toString());
		}

		final Client add = new Client("4", "Lefebvre", "Gaetan");
		if (new RestTemplate().postForObject(url, add, boolean.class)) {
			System.out.println(new StringBuilder("Nouveau client : ")
					.append(add.getNom()).append(" ").append(add.getPrenom())
					.append(" ajouté").toString());
		}

		final Client update = new Client("4", "Lefebvre", "Amelie");
		final String prenom = new RestTemplate()
				.exchange(url, HttpMethod.PUT, new HttpEntity<Client>(update),
						Client.class).getBody().getPrenom();
		System.out.println(new StringBuilder(
				"L'ancien prenom avant la mise a jour etait : ").append(prenom)
				.toString());

		final Client cli4 = new RestTemplate().getForObject(new StringBuilder(
				url).append("/{id}").toString(), Client.class, update
				.getIdentifiant());
		System.out.println(new StringBuilder(
				"Le client 4 s'appelle désormais : ").append(cli4.getNom())
				.append(" ").append(cli4.getPrenom()).toString());

		System.out.println("Suppression du client 4 !");
		new RestTemplate().delete(new StringBuilder(url).append("/{id}")
				.toString(), cli4.getIdentifiant());
	}

}
