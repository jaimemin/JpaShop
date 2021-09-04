package com.tistory.jaimemin.jpabook.jpashop;

import com.tistory.jaimemin.jpabook.jpashop.domain.Book;
import com.tistory.jaimemin.jpabook.jpashop.domain.Order;
import com.tistory.jaimemin.jpabook.jpashop.domain.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory
                = Persistence.createEntityManagerFactory("hello");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        try {
            Book book = new Book();
            book.setName("JPA");
            book.setAuthor("gudetama");
            entityManager.persist(book);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            entityManager.close();
        }

        entityManagerFactory.close();
    }

}
