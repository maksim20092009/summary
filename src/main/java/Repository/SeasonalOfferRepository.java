package Repository;

import Model.SeasonaOffers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeasonalOfferRepository extends JpaRepository<SeasonaOffers, Integer> {
}
