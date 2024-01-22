package hellojpa;

import javax.persistence.*;

@Entity
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private long id;

    @Column(name = "USERNAME")
    private String username;

//    @Column(name = "TEAM_ID")
//    private Long teamId;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

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


