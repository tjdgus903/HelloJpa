package jpabook.jpashop;

import org.hibernate.Hibernate;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Team team = new Team();
            team.setName("teamA");
            em.persist(team);

            Team teamB = new Team();
            teamB.setName("teamB");
            em.persist(teamB);

            Member member1 = new Member();
            member1.setUserName("hello");
            member1.setTeam(team);
            em.persist(member1);

            Member member2 = new Member();
            member2.setUserName("hello");
            member2.setTeam(teamB);
            em.persist(member2);

            em.flush();
            em.clear();

            List<Member> members = em.createQuery("select m from Member m join fetch m.team", Member.class)
                    .getResultList();


/*
            Member m = em.find(Member.class, member1.getId());
            System.out.println("m = "+m.getTeam().getClass());

            System.out.println("==================");
            System.out.println(m.getTeam().getName());
            System.out.println("==================");
*/

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
