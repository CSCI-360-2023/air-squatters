package local.airsquatters.TicketSystem;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends MongoRepository<Event, ObjectId>{
    Event findEventByEventName(String eventName);
}
