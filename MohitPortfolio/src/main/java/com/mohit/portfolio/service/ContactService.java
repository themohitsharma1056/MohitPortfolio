
package com.mohit.portfolio.service;

import java.util.List;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohit.portfolio.model.ContactMessage;
import com.mohit.portfolio.repository.ContactMessageRepository;

@Service
public class ContactService {

    @Autowired
    private ContactMessageRepository contactMessageRepository;

   
    public void processMessage(
            ContactMessage contactMessage
    ) {
    	 contactMessage.setCreatedAt(
                 LocalDateTime.now()
         );

        contactMessageRepository.save(contactMessage);



        System.out.println(
                "Message saved successfully."
        );
       
     
    } 
    public List<ContactMessage> getAllMessages() {

    	return contactMessageRepository
    		       .findAllByOrderByCreatedAtDesc();

    }
    public List<ContactMessage>
    searchMessages(
            String keyword
    ) {

        return contactMessageRepository
                .findByNameContainingIgnoreCaseOrEmailContainingIgnoreCaseOrMessageContainingIgnoreCaseOrderByCreatedAtDesc(

                        keyword,

                        keyword,

                        keyword

                );

    }
    public void deleteMessage(
            String id
    ) {

        contactMessageRepository.deleteById(id);

    }
    public void markAsRead(
            String id
    ) {

        ContactMessage message =
                contactMessageRepository
                .findById(id)
                .orElse(null);

        if(message != null) {

            message.setRead(true);

            contactMessageRepository.save(message);

        }
        

    }
    
}

