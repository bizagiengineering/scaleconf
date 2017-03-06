package controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dev-camiloh on 3/6/17.
 */
@RestController
public class TicketHolderController {


    @RequestMapping("/")
    public String home() {
        return "Hello World";
    }
}