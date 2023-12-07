package local.airsquatters.TicketSystem;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends MongoRepository<Account, Integer>{
    Account findAccountByCofcId(Integer cofcId);
}
