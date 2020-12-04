package br.com.alura.jpa.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TestaSomaDasMovimentacoes {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();

		soma(em);
		media(em);
	}
	
	public static void soma (EntityManager em) {
		String jpql = "select sum(m.valor) from Movimentacao m";
		
		TypedQuery<BigDecimal> query = em.createQuery(jpql, BigDecimal.class);
		BigDecimal somaDasMovimentacoes = query.getSingleResult();
		
		System.out.println("A soma das movimentação é: "+ somaDasMovimentacoes);
	}
	
	public static void media (EntityManager em) {
		String jpql = "select avg(m.valor) from Movimentacao m";
		
		TypedQuery<Double> query = em.createQuery(jpql, Double.class);
		Double mediaDasMovimentacoes = query.getSingleResult();
		
		System.out.println("A média das movimentação é: "+ mediaDasMovimentacoes);
	}

}
