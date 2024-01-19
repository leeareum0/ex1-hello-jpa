package hellojpa;

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

            //비영속
//          Member member = new Member();
//          member.setId(101L);
//          member.setName("HelloJPA");

            //영속
//          Member member1 = new Member(150L, "A");
//          Member member2 = new Member(160L, "B");
//
//          em.persist(member1);
//          em.persist(member2);

            //엔티티 수정 - 변경 감지
//          Member member = em.find(Member.class, 150L);
//          member.setName("ZZZZZ");

            //플러시 사용
//          Member member = new Member(200L, "member200");
//          em.persist(member);
//
//          em.flush();

//          Member member = em.find(Member.class, 150L);
//          member.setName("AAAAA");

            //em.clear(); //영속성 컨텍스트를 완전히 초기화

            //Member member2 = em.find(Member.class, 150L);

            Member member = new Member();
            member.setUsername("C");

            em.persist(member);

            System.out.println("member.id = " + member.getId());

            tx.commit(); //DB에 쿼리 전송
        } catch (Exception e) {
            tx.rollback(); //문제가 생겼을 때
        } finally {
            em.close();
        }
        emf.close();
    }
}
