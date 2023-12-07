package local.airsquatters.TicketSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Logger;

import java.util.*;
  
@RestController
@RequestMapping("/api/v1/events")
@CrossOrigin(origins = "*")
public class EventController {
    @Autowired
    private EventService eventService;
    
    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents() {
        return new ResponseEntity<List<Event>>(eventService.allEvents(), HttpStatus.OK);
    }

    @GetMapping("/{eventName}")
    public ResponseEntity<Event> getSingleEvent(@PathVariable String eventName) {
        System.out.print("This is " + eventService.singleEvent(eventName).toString());
        return new ResponseEntity<Event>(eventService.singleEvent(eventName), HttpStatus.OK);
    }
}
