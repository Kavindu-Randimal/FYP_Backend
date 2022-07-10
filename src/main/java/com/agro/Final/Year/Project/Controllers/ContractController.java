package com.agro.Final.Year.Project.Controllers;


import com.agro.Final.Year.Project.Contract.SupplyChain;
import com.agro.Final.Year.Project.Models.Dto.ContractRecord;
import com.agro.Final.Year.Project.Models.Dto.ProcessEvent;
import com.agro.Final.Year.Project.Models.Dto.TransactionBase;
import com.agro.Final.Year.Project.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api")
public class ContractController {

    @Autowired
    private UserService userService;

    @GetMapping("/accounts")
    public List<String> getAccounts() throws IOException, ExecutionException, InterruptedException {
        return userService.getAccounts();
    }

    @PostMapping("/start")
    public TransactionReceipt startContract(@RequestBody ContractRecord contractRecord) throws Exception {
        return userService.startContract(contractRecord);
    }

    @PostMapping("/addEvent")
    public TransactionReceipt addEvent (@RequestBody ProcessEvent processEvent ) throws Exception {
        return userService.addEvent(
                processEvent,
                processEvent.getContractId(),
                processEvent.getPrivateKey(),
                processEvent.getGasPrice(),
                processEvent.getGasLimit());
    }

    @GetMapping("/contracts")
    public List<ContractRecord> getAllContracts(@Param("farmerName") String farmerName) {
        return userService.getContracts(farmerName);
    }

    @GetMapping("/contracts/officer")
    public List<ContractRecord> getAllContractsForOfficer() {
        return userService.getAllContracts();
    }

    @PostMapping("/contracts/load")
    public List<SupplyChain.ProcessEvent> getContract(@RequestBody TransactionBase transactionBase) throws Exception{
        return userService.loadContract(transactionBase);
    }
}
