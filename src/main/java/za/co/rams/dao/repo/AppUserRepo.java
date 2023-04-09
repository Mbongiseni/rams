package za.co.rams.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.rams.dao.entity.AppUser;

import java.util.List;

@Repository
public interface AppUserRepo extends JpaRepository<AppUser, Long> {

    // That's it... No need to write any code LOL!!!

    /**
     * Method to sort by last name
     *
     * For More Details:
     * www.luv2code.com/query-methods
     */
    List<AppUser> findAllByOrderByUserNameAsc();
    AppUser findAppUsersById(Long appUserId);
}
