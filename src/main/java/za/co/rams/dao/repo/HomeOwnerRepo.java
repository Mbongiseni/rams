package za.co.rams.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.rams.dao.entity.HomeOwner;

@Repository
public interface HomeOwnerRepo extends JpaRepository<HomeOwner,Long> {
    HomeOwner findHomeOwnerById(Long homeOwnerId);
}
