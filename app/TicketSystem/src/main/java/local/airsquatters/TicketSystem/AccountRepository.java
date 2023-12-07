package local.airsquatters.TicketSystem;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends MongoRepository<Account, Integer>{
    @Query("{cofcId:'?0'}")
    Account findAccountByCofcId(Integer cofcId);

    public long count();

}
