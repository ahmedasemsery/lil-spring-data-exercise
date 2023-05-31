package com.linkedinlearningcourse.dataAccess.web;

import com.linkedinlearningcourse.dataAccess.business.GuestDTO;
import com.linkedinlearningcourse.dataAccess.business.GuestService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/guests")
public class GuestController {

    private final GuestService guestService;

    @RequestMapping(method = RequestMethod.GET)
    public String getGuests(Model model) {
        List<GuestDTO> allGuests = this.guestService.getAllGuests();
        model.addAttribute("guests", allGuests);
        return "guests";
    }
}
