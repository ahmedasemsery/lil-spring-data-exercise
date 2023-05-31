package com.linkedinlearningcourse.dataAccess.business;

import com.linkedinlearningcourse.dataAccess.data.Guest;
import com.linkedinlearningcourse.dataAccess.data.GuestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class GuestService {
    private final GuestRepository guestRepository;

    public List<GuestDTO> getAllGuests() {
        List<GuestDTO> guestList = new ArrayList<>();
        Iterable<Guest> guests = guestRepository.findAll();

        guests.forEach(guest -> {
            GuestDTO guestDTO = new GuestDTO();
            guestDTO.setFirstName(guest.getFirstName());
            guestDTO.setLastName(guest.getLastName());
            guestDTO.setEmailAddress(guest.getEmailAddress());
            guestDTO.setPhoneNumber(guest.getPhoneNumber());
            guestList.add(guestDTO);
        });

        guestList.sort((o1, o2) -> {
            if (o1.getLastName().equals(o2.getLastName())) {
                return o1.getFirstName().compareTo(o2.getFirstName());
            }
            return o1.getLastName().compareTo(o2.getLastName());
        });

        return guestList;
    }
}
