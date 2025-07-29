package jpabook.jpashop;

import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Member member = new Member();
            member.setUsername("member1");
            em.persist("member");

            em.flush();
            em.clear();

            // 네이티브 sql 사용
            /*List<Member> resultList = em.createNativeQuery("select * from member", Member.class).getResultList();

            for (Member member1 : resultList) {
                System.out.println("member1 : "+member1);
            }*/

/*
            디버깅이 어렵고 실용성이 없어서 실무에서 사용을 잘 안함
            // Criteria 사용 준비(자바에서 제공하는 문법)
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Member> query = cb.createQuery(Member.class);

            Root<Member> m = query.from(Member.class);

            CriteriaQuery<Member> cq = query.select(m).where(cb.equal(m.get("username"), "kim"));
            List<Member> resultList =em.createQuery(cq).getResultList();
*/


/*          jpql 조회 예시
            String qlString = "select m From Member m where m.username like '%kim%'";
            List<Member> result = em.createQuery(
                    qlString,
                    Member.class
            ).getResultList();
*/

            tx.commit();
        }catch(Exception e){
            tx.rollback();
        } finally{
            em.close();
        }

        emf.close();
    }
}
