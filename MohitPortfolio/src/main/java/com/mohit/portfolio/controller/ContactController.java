
package com.mohit.portfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import com.mohit.portfolio.model.ContactMessage;
import com.mohit.portfolio.service.ContactService;
import com.mohit.portfolio.service.EmailService;

import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
@Controller
public class ContactController {
	@Autowired
	private ContactService contactService;
	 @Autowired
	    private EmailService emailService;

    @PostMapping("/contact/send")
    public String handleContactForm(

    	@ModelAttribute ContactMessage contactMessage,
    	
          RedirectAttributes redirectAttributes
    	) {
    	
    	contactService.processMessage(contactMessage);
    	
    	try {

    	    emailService.sendContactNotification(
    	        contactMessage.getName(),
    	        contactMessage.getEmail(),
    	        contactMessage.getMessage()
    	    );

    	} catch (Exception e) {

    	    System.out.println("Email notification failed.");
    	    e.printStackTrace();

    	}
    
    	redirectAttributes.addFlashAttribute(
    			
    			"successMessage",
    			"message sent successfully."
    			);
    	
    	return "redirect:/contact";
    }
    @GetMapping("/admin/messages")
    public String showMessages(
    	     @RequestParam(
    	                required = false
    	        ) String keyword,

    	        Model model
    	
    ) {

    	List<ContactMessage> messages;

    	if(keyword != null &&
    	   !keyword.trim().isEmpty()) {

    	    messages =
    	            contactService
    	            .searchMessages(
    	                    keyword
    	            );

    	}
    	else {

    	    messages =
    	            contactService
    	            .getAllMessages();

    	}

        model.addAttribute(
                "messages",
                messages
        );
        model.addAttribute(
                "keyword",
                keyword
        );
        model.addAttribute(
                "totalMessages",
                messages.size()
        );
        long unreadMessages =
                messages.stream()
                        .filter(message -> !message.isRead())
                        .count();

        long readMessages =
                messages.stream()
                        .filter(ContactMessage::isRead)
                        .count();

        model.addAttribute(
                "unreadMessages",
                unreadMessages
        );

        model.addAttribute(
                "readMessages",
                readMessages
        );

        return "admin-messages";
    }
    @GetMapping("/admin/delete/{id}")
    public String deleteMessage(
            @PathVariable String id
    ) {

        contactService.deleteMessage(id);
        return "redirect:/admin/messages";
    }
    
    @GetMapping("/admin/read/{id}")
    public String markAsRead(
            @PathVariable String id
    ) {

        contactService.markAsRead(id);

        return "redirect:/admin/messages";
    }
    @GetMapping("/login")
    public String loginPage() {

        return "login";
    }
    
    @GetMapping("/logout")
    public String logoutPage() {

        return "login";
    }
   
    
}

