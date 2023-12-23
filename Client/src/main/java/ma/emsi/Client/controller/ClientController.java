package ma.emsi.Client.controller;

import ma.emsi.Client.model.Client;
import ma.emsi.Client.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    ClientRepository clientRepository;

    @GetMapping("/clients")
    public List<Client> findAllClients() {
        return clientRepository.findAll();
    }

    @GetMapping("/clients/{id}")
    public Client findClientById(@PathVariable Long id) throws Exception {
        return this.clientRepository.findById(id).orElseThrow(() -> new Exception("Client inexistant"));
    }


}
