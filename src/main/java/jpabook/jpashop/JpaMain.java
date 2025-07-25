package jpabook.jpashop;


import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            // 저장
            Team team = new Team();
            team.setName("A");
            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");
            member.setTeam(team);
            em.persist(member);

            // 영속성 컨텍스트의 쿼리 sql 로 푸쉬
            em.flush();
            // 영속성 컨텍스트 클리어
            em.clear();

            Member findMember = em.find(Member.class, member.getId());
            // 4. 양방향 연관관계 환경 셋팅
            List<Member> members = findMember.getTeam().getMembers();

            for (Member m : members) {
                System.out.println("m : "+m.getUsername());
            }

            tx.commit();
        }catch(Exception e){
            tx.rollback();
        } finally{
            em.close();
        }

        tx.commit();
        emf.close();
    }
}
