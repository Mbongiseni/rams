package za.co.rams.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.rams.dao.entity.House;

@Repository
public interface HouseRepo extends JpaRepository<House, Long> {
    House findHouseById(Long houseId);
}
