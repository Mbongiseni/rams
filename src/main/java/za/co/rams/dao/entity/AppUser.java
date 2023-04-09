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
@Table(name = "app_user")
public class AppUser implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "app_user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "pass_word")
    private String passWord;

    @Column(name = "captured")
    private LocalDateTime captured;

    @Column(name = "last_updated")
    private LocalDateTime lastUpdated;

    public AppUser(String userName, String passWord, LocalDateTime captured, LocalDateTime lastUpdated){
        this.userName = userName;
        this.passWord = passWord;
        this.captured = captured;
        this.lastUpdated = lastUpdated;
    }
}
