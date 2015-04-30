package fr.gillouard.spring.restclient.pojo;

public class Client {
	
	/**
	  * Identifiant du client.
	  */
	private int identifiant;

	/**
	  * Nom du client.
	  */
	private String nom;

	/**
	  * Prénom du client.
	  */
	private String prenom;
	
	/**
	  * Constructeur par defaut.
	  */
	 public Client() {

	 }

	/**
	  * Constructeur.
	  *
	  * @param identifiant du client
	  * @param nom du client
	  * @param prenom du client
	  */
	public Client(final int identifiant, final String nom, final String prenom) {
	 this.identifiant = identifiant;
	 this.nom = nom;
	 this.prenom = prenom;
	}

	/**
	  * @return the identifiant
	  */
	public int getIdentifiant() {
	 return identifiant;
	}

	/**
	  * @param identifiant the identifiant to set
	  */
	public void setIdentifiant(final int identifiant) {
	 this.identifiant = identifiant;
	}

	/**
	  * @return the nom
	  */
	public String getNom() {
	 return nom;
	}

	/**
	  * @param nom the nom to set
	  */
	public void setNom(final String nom) {
	 this.nom = nom;
	}

	/**
	  * @return the prenom
	  */
	public String getPrenom() {
	 return prenom;
	}

	/**
	  * @param prenom the prenom to set
	  */
	public void setPrenom(final String prenom) {
	 this.prenom = prenom;
	}

}
