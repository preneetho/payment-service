package com.upgrad.sweethome.payment.restclients;

import com.upgrad.sweethome.payment.dto.BookingDTO;
import com.upgrad.sweethome.payment.utility.PaymentsConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class BookingClient {

    @Autowired
    RestTemplate restTemplate;

    @Value("${booking-service-name}")
    String bookingService;

    public BookingDTO findBooking(int bookingId){

        System.out.println("findBooking bookingId " + bookingId);
        Map<String, String> map = new HashMap<>();
        map.put("bookingId", String.valueOf(bookingId));
        String uri = "http://"+bookingService+"/booking/"+bookingId;
        BookingDTO bookingDTO = restTemplate.getForObject(uri, BookingDTO.class,map );
        System.out.println("findBooking " + bookingDTO);
        return bookingDTO;

    }


}
