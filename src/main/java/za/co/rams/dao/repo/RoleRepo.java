package za.co.rams.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.rams.dao.entity.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {
}
