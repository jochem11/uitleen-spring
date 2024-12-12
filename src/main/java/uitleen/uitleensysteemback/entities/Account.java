package uitleen.uitleensysteemback.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(
        name = "account"
)
@Getter
@Setter
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "firstname", nullable = false)
    private String firstname;

    @Column(name = "insertion")
    private String insertion;

    @Column(name = "lastname", nullable = false)
    private String lastname;

    @Column(name = "displayname", nullable = false)
    private String displayName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "cardnumber")
    private Long cardNumber;

    @Column(name = "class_group_id")
    private Long groupId;

    @ManyToOne
    @JoinColumn(name = "class_group_id", insertable = false, updatable = false)
    private ClassGroup classGroup;

    @Column(name = "course_id")
    private Long courseId;

    @ManyToOne
    @JoinColumn(name = "course_id", insertable = false, updatable = false)
    private Course course;

    @ManyToMany
    @JoinTable(
            name = "account_roles",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;

    @PrePersist
    @PreUpdate
    private void setDisplayName() {
        if (insertion != null && !insertion.isEmpty()) {
            this.displayName = String.format("%s %s %s", firstname, insertion, lastname).trim();
        } else {
            this.displayName = String.format("%s %s", firstname, lastname).trim();
        }
    }
}