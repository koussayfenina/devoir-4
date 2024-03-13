package com.koussay.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.koussay.entities.Joueur;
import com.koussay.entities.util.JPAutil;

//classe contenant les méthodes génériques ajouter, supprimer,
//consulter par clé primaire (Id)
public class JoueurDao {
	private EntityManager entityManager=JPAutil.getEntityManager("MonProjetJPA");
//méthode ajouter d'une entité à la bd
public void ajouter(Joueur j)
{
	EntityTransaction tx = entityManager.getTransaction();
	tx.begin();
	entityManager.persist(j);
	tx.commit();

	}
	//méthode modifier d'une entité à partir de la bd
	public void modifier(Joueur j)
	{
	EntityTransaction tx = entityManager.getTransaction();
	tx.begin();
	entityManager.merge(j);
	tx.commit();

	}
	//méthode Supprimer d'une entité à partir de la bd
	public void supprimer(Joueur j)
	{
	EntityTransaction tx = entityManager.getTransaction();
	 tx.begin();
	 j=entityManager.merge(j); // important
	 entityManager.remove(j);
	 tx.commit();
	}
	//méthode Consulter d'une entité à partir de la bd
	public Joueur consulter(Joueur j,Object id)
	{
	return entityManager.find(j.getClass(), id);
	}
	//méthode pour lister tous les objets à partir de la bd
	public List<Joueur> listerTous() {
	List<Joueur> joueurs =entityManager.createQuery("select j from Joueur j").getResultList();
	return joueurs;
	}
	//méthode pour lister tous les client dont le nom contient un
	//texte donné en paramètre (pnom)
	public List<Joueur> listerParNom(String nom) {List<Joueur> joueurs=entityManager.createQuery( "select j from Joueur j where j.nomJoueur like :pnom").setParameter("pnom","%"+nom+"%").getResultList();
	return joueurs; 
	}
	}