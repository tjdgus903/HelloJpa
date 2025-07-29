package jpabook.jpashop;

import org.hibernate.Hibernate;

import javax.persistence.*;

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
            member.setHomeAddress(new Address("homeCity", "street", "1"));

            member.getFavoriteFoods().add("치킨");
            member.getFavoriteFoods().add("족발");
            member.getFavoriteFoods().add("피자");

            member.getAddressHistory().add(new AddressEntity("old1", "street", "1"));
            member.getAddressHistory().add(new AddressEntity("old2", "street", "1"));

            em.persist(member);

            em.flush();
            em.clear();
/*

            // 조회
            Member findMember = em.find(Member.class, member.getId());

            List<Address> addressHistory = findMember.getAddressHistory();
            for (Address address : addressHistory) {
                System.out.println("address = "+address.getCity());
            }

            Set<String> favoriteFoods = findMember.getFavoriteFoods();
            for (String favoriteFood : favoriteFoods) {
                System.out.println("favoriteFood = "+favoriteFood);
            }

            // 수정
            // 이렇게 하면 절대 안됨!!
            // findMember.getHomeAddress().setCity("newCity");

            // embedded 타입은 객체에 참조하는 역할이기 때문에 부분 수정이 안됨
            // 무조건 통으로 갈아 끼워서 수정해야됨!!
            Address a = findMember.getHomeAddress();
            findMember.setHomeAddress(new Address("newCity",a.getStreet(), a.getZipCode()));

            // String 값타입은 삭제를 하고 갈아끼워야됨!
            findMember.getFavoriteFoods().remove("치킨");
            findMember.getFavoriteFoods().add("국밥");

            // 삭제가 일어나면 데이터를 모두 삭제한 뒤 남아있는 데이터들을 insert 함
            //
            findMember.getAddressHistory().remove(new AddressEntity("old1", "street", "1"));
            findMember.getAddressHistory().add(new AddressEntity("newCity1", "street", "10000"));
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
