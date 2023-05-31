package com.linkedinlearningcourse.dataAccess.web;

import com.linkedinlearningcourse.dataAccess.business.ReservationService;
import com.linkedinlearningcourse.dataAccess.business.RoomReservation;
import com.linkedinlearningcourse.dataAccess.util.DateUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/reservations")
public class RoomReservationController {
    private final DateUtils dateUtils;
    private final ReservationService reservationService;

    @RequestMapping(method = RequestMethod.GET)
    public String getReservation(@RequestParam(value = "date", required = false) String dateString, Model model) {
        Date date = this.dateUtils.createDateFromDateString(dateString);

        List<RoomReservation> roomReservations = this.reservationService.getRoomReservationsForDate(date);
        model.addAttribute("roomReservations", roomReservations);

        return "roomres";
    }
}
