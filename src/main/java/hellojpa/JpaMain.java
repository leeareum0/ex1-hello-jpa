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

            //저장
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");
            //연관관계의 주인에 값 설정 1
            //member.changeTeam(team);
            em.persist(member);

            //team.getMembers().add(member);

            team.addMember(member); //2

            em.flush();
            em.clear();

            Member findMember = em.find(Member.class, member.getId());
            List<Member> members = findMember.getTeam().getMembers();

            for (Member m : members) {
                System.out.println("m = " + m.getUsername());
            }

            tx.commit(); //DB에 쿼리 전송
        } catch (Exception e) {
            tx.rollback(); //문제가 생겼을 때
        } finally {
            em.close();
        }
        emf.close();
    }
}
