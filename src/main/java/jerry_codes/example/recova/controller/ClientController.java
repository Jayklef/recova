package jerry_codes.example.recova.controller;

import jerry_codes.example.recova.entity.Client;
import jerry_codes.example.recova.model.ClientDto;
import jerry_codes.example.recova.repository.ClientRepository;
import jerry_codes.example.recova.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("api/v2/clients")
public class ClientController {


    private ClientService clientService;
    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }
    @PostMapping("/save")
    public ResponseEntity<Client> saveClient(@RequestBody ClientDto clientDto){
        Client newclient = clientService.saveClient(clientDto);
        return new ResponseEntity<>(newclient, HttpStatus.CREATED);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Client>> getAllClient(){
        List<Client> clients = clientService.findAllClient();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable("id") Long id){
        Client client = clientService.findById(id);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @PutMapping("/update/{id}/")
    public ResponseEntity<Client> updateClient(@PathVariable("id") Long id,
                                               @RequestBody Client client){
        Client updateClient = clientService.updateClient(id, client);
        return new ResponseEntity<>(updateClient, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteClient(@PathVariable("id") Long id){
         clientService.deleteById(id);
    }
}
