package com.ryonishikawa.bbs.model;

import com.ryonishikawa.bbs.model.schema.*;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

public class Article {

	public Article() {
	}

	public void main() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("hibernate");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tran = em.getTransaction();
		tran.begin();

		try {
			this.printAll(em);
			tran.commit();
		} catch (Exception e) {
			if (tran.isActive()) {
				tran.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
	}

	private void printAll(EntityManager em) {
		Query query = em.createQuery("SELECT a FROM ArticleSchema a");
		List<ArticleSchema> list = query.getResultList();
		System.out.println("全件抽出：" + list.size() + "件");
		for (int i = 0; i < list.size(); i++) {
			ArticleSchema article = list.get(i);
			System.out.println((i + 1) + "件目：");
			System.out.println(article.getTitle());
			System.out.println(article.getBody());
		}
		System.out.println("-----");
	}

}
