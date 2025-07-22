package hellojpa;

import jakarta.persistence.*;

import java.sql.SQLOutput;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        // persistence에 설정된 정보를 가져와 실행
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        // db 작업이 필요할 때 트랜잭션을 수행
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

            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(1)
                    .setMaxResults(10)
                    .getResultList();

            for(Member member : result){
                System.out.println("member.name = " + member.getName());
            }

            // 트랜잭션 커밋(변경사항 적용)
            tx.commit();
        } catch(Exception e){
            tx.rollback();
        } finally {
            // 트랜잭션 닫기
            em.close();
        }
        
        // 리소스 정리
        emf.close();
    }
}
