package com.koussay.test;

import com.koussay.dao.JoueurDao;
import com.koussay.entities.Joueur;

public class JoueurTest {
	public static void main(String[] args) {
		// créer un objet client
		Joueur j = new Joueur();
		j.setNomJoueur("Lionel messi");
		j.setPrix(400);
		//ajouter l'objet client à la BD
		JoueurDao jDao = new JoueurDao();
		jDao.ajouter(j);
		
		System.out.println("Appel de la méthode listerTous");
		for (Joueur j1 : jDao.listerTous())
			System.out.println(j1);
		System.out.println("Appel de la méthode listerParNom");
		for (Joueur j1 : jDao.listerParNom("mess"))
			System.out.println(j1);
		// tester les autres méthodes de la classe ClientDao
	}
}

