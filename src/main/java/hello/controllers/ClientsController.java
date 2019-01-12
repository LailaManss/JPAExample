package hello.controllers;

import hello.model.Client;
import hello.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClientsController {
    @Autowired
    private ClientRepository clientRepository;

    @GetMapping(path = "/addClient") // Map ONLY GET Requests
    public @ResponseBody
    String addNewUser(@RequestParam String firstName
            , @RequestParam String lastName) {

        Client client = new Client();
        client.setFirstName(firstName);
        client.setLastName(lastName);
        clientRepository.save(client);
        return "Saved";
    }

    @GetMapping(path = "/allClients")
    public  ModelAndView getAllClients() {
        ModelAndView model = new ModelAndView("clients.html");
        model.addObject("allClients", clientRepository.findAll());
        return model;
    }
}
