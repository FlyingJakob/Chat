package StripedPandaStudios.Chat.Chat.repositories;

import StripedPandaStudios.Chat.Chat.Models.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends MongoRepository<Message, String> {


}
