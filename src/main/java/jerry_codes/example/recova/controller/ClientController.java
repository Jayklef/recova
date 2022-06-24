package jerry_codes.example.recova.controller;

import jerry_codes.example.recova.entity.Account;
import jerry_codes.example.recova.entity.Client;
import jerry_codes.example.recova.model.ClientDto;
import jerry_codes.example.recova.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Client>> getAllClient(){
        List<Client> clients = clientService.findAllClient();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Client> saveClient(@RequestBody ClientDto clientDto){
        Client newClient = clientService.saveClient(clientDto);
        return new ResponseEntity<>(newClient, HttpStatus.CREATED);
    }

    @GetMapping("/bvn")
    public ResponseEntity<Client> findClientByBVN(@RequestParam String BVN){
        Client client = clientService.findClientByBvn(BVN);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }


    @GetMapping("/all-accounts")
    public ResponseEntity<Set<Account>> getAllAccountsOwnedByClient(@PathVariable("id") Long id,
                                                                    String BVN){
        Set<Account> accounts = clientService.findAllAccountsByIdAndBVN(id, BVN);
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }
}
