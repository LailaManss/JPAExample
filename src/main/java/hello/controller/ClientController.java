package hello.controller;

import hello.model.Client;
import hello.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;


    @GetMapping("/clients")
    public List<Client> retrieveAllClients() {
        return clientRepository.findAll();
    }

}
