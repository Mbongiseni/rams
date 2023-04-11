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
@Table(name = "house")
public class House implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "house_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "street_name")
    private String streetName;

    @Column(name = "number")
    private String houseNumber;

    @Column(name = "location")
    private String location;

    @Column(name = "town")
    private String town;

    @Column(name = "captured")
    private LocalDateTime captured;

    @Column(name = "last_updated")
    private LocalDateTime lastUpdated;

    public House(String streetName, String houseNumber, String location, String town, LocalDateTime captured, LocalDateTime lastUpdated) {
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.location = location;
        this.town = town;
        this.captured = captured;
        this.lastUpdated = lastUpdated;
    }
}
