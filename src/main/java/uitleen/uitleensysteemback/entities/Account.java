package uitleen.uitleensysteemback.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(
        name = "account"
)
@Getter
@Setter
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "insertion")
    private String insertion;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "displayname")
    private String displayName;

    @Column(name = "email")
    private String email;

    @Column(name = "cardnumber")
    private long cardNumber;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToMany
    @JoinTable(
            name = "account_roles",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;

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