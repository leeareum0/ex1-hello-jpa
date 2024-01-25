package hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;

@Entity
public class Member extends BaseEntity{

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private long id;

    @Column(name = "USERNAME")
    private String username;

//    @Column(name = "TEAM_ID")
//    private Long teamId;

    //@ManyToOne(fetch = FetchType.LAZY) //지연로딩 사용 - 프록시 객체로 조회
    @ManyToOne(fetch = FetchType.EAGER) //즉시로딩
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    @ManyToMany
    @JoinTable(name = "MEMBER_PRODUCT")
    private List<Product> products = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
//    public void changeTeam(Team team) {
//        this.team = team;
//        team.getMembers().add(this);
//    }
}
   /*
    private Integer age;

    @Enumerated(EnumType.STRING) //enum 타입 매핑
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP) //날짜타입 매핑
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    private LocalDate testLocalDate;
    private LocalDateTime testLocalDateTime;

    @Lob //BLOB, CLOB 매핑
    private String description;

    @Transient //매핑 X
    private int temp;
    */


