//обеспечивает доступ к данным
package Repository;

import Model.Guests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends JpaRepository<Guests, Integer> {
}
