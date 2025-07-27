package jpabook.jpashop;

import org.hibernate.Hibernate;

import javax.persistence.*;

import java.time.LocalDateTime;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Member member1 = new Member();
            member1.setUserName("hello");
            em.persist(member1);

            em.flush();
            em.clear();

            Member m1 = em.getReference(Member.class, member1.getId());
            System.out.println("m1 : "+m1.getClass());
            // m1.getUserName();
            System.out.println("isLoaded = "+ emf.getPersistenceUnitUtil().isLoaded(m1));

            Hibernate.initialize(m1);

            tx.commit();
        }catch(Exception e){
            tx.rollback();
        } finally{
            em.close();
        }

        emf.close();
    }

    private static void printMember(Member member) {
        System.out.println("member = "+member);
    }

    private static void printMemberAndTeam(Member member) {
        String username = member.getUserName();
        System.out.println("username : "+username);

        Team team = member.getTeam();
        System.out.println("team = "+team.getName());

    }
}
