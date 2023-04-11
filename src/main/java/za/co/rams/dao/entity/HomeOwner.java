package za.co.rams.dao.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "home_owner")
public class HomeOwner implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "home_owner_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "primary_phone_number")
    private String primaryPhoneNumber;

    @Column(name = "secondary_phone_number")
    private String secondaryPhoneNumber;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "captured")
    private LocalDateTime captured;

    @Column(name = "last_updated")
    private LocalDateTime lastUpdated;

    public HomeOwner(String firstName, String lastName, String primaryPhoneNumber, String secondaryPhoneNumber, String emailAddress, LocalDateTime captured, LocalDateTime lastUpdated) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.primaryPhoneNumber = primaryPhoneNumber;
        this.secondaryPhoneNumber = secondaryPhoneNumber;
        this.emailAddress = emailAddress;
    }
}