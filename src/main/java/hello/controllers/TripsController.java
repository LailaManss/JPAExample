package hello.controllers;

import hello.repositories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TripsController {

    @Autowired
    private TripRepository tripRepository;

    @GetMapping(path="/allTrips")
    public ModelAndView getAllTrips(){
        ModelAndView model = new ModelAndView("trips.html");
                model.addObject("allTrips", tripRepository.findAll());
    return model;
    }

}
