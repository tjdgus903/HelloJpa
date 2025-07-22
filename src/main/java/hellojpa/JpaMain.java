package hellojpa;

import jakarta.persistence.*;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        // 트랜잭션 시작
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            /* 조회 */
            Member findMember = em.find(Member.class, 2L);
            System.out.println("findMember.id = " + findMember.getId());
            System.out.println("findMember.name = " + findMember.getName());

            /* 등록
            Member member = new Member();
            member.setId(2L);
            member.setName("HelloB");
            em.persist(member);
            */
            /* 삭제
            Member findMember = em.find(Member.class, 2L);
            em.remove(findMember);
            */
            /* 수정
            Member findMember = em.find(Member.class, 2L);
            findMember.setName("HelloJPA");
            */

            // 트랜잭션 커밋
            tx.commit();
        } catch(Exception e){
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
