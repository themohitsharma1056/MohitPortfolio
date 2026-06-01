
package com.mohit.portfolio.repository;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.mohit.portfolio.model.ContactMessage;

public interface ContactMessageRepository
        extends MongoRepository<ContactMessage, String> {
	
	List<ContactMessage> findAllByOrderByCreatedAtDesc();
	
	List<ContactMessage>

	findByNameContainingIgnoreCaseOrEmailContainingIgnoreCaseOrMessageContainingIgnoreCaseOrderByCreatedAtDesc(

	        String name,

	        String email,

	        String message

	);

}

