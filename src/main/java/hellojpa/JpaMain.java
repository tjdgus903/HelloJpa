package hellojpa;

import jakarta.persistence.*;

import java.sql.SQLOutput;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        // persistence에 설정된 정보를 가져와 실행
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        // 엔티티 메니저 - 영속성 컨텍스트를 관리하는 주체(db 작업이 필요할 때 트랜잭션을 수행)
        EntityManager em = emf.createEntityManager();

        // 트랜잭션 시작
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{

            Member member1 = new Member();
            member1.setUsername("A");

            Member member2 = new Member();
            member2.setUsername("B");

            Member member3 = new Member();
            member3.setUsername("C");

            System.out.println("==================");

            em.persist(member1);
            em.persist(member2);
            em.persist(member3);

            System.out.println("member1 = "+member1.getId());
            System.out.println("member2 = "+member2.getId());
            System.out.println("member3 = "+member3.getId());

            System.out.println("==================");

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
