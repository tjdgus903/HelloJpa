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

            Member member = new Member();
            member.setId(3L);
            member.setUsername("C");
            member.setRoleType(RoleType.GUEST);

            em.persist(member);

            System.out.println("================");
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
