package scaleconf.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import scaleconf.dao.Holder;
import scaleconf.dao.HolderDDBDao;
import scaleconf.dao.HolderDao;

/**
 * Created by dev-camiloh on 3/6/17.
 */
@RestController
public class TicketHolderController {

    @RequestMapping("/api/holder")
    public String saveHolder() {
        HolderDao holderDao=new HolderDDBDao();
        Holder holder=new Holder("Camilo","http://url","http://document");
        holderDao.createHolder(holder);
        return "Hello World";
    }
}