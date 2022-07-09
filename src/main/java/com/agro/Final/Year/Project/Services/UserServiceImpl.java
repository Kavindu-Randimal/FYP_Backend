package com.agro.Final.Year.Project.Services;

import com.agro.Final.Year.Project.Configurations.Web3Client;
import com.agro.Final.Year.Project.Models.Dto.*;
import com.agro.Final.Year.Project.Repositories.ContractRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.model.SupplyChain;
import org.web3j.protocol.core.methods.response.EthBlockNumber;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple11;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.StaticGasProvider;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    Web3Client web3Client;

    @Autowired
    private ContractRecordRepository contractRecordRepository;

    @Override
    public List<String> getAccounts() throws ExecutionException, InterruptedException, IOException {
        EthBlockNumber result = web3Client.getWeb3().ethBlockNumber().sendAsync().get();
        System.out.println(" The Block Number is: " + result.getBlockNumber().toString());
        List<String> accountAddress= web3Client.getWeb3().ethAccounts().send().getAccounts();
        System.out.printf(accountAddress.get(0));
        return accountAddress;
    }

    @Override
    public List<String> getData() {
        return null;
    }

    @Override
    public Tuple11<Integer, Integer, String, String, UserType, String, Stage, String, String, String, String>
    getUser(Integer eventId, Integer userId, String firstName, String lastName, UserType userType, String foodName, Stage stage, String date, String spec, String details, String certificationStatus)
            throws Exception {
        return null;
    }

    @Override
    public TransactionReceipt startContract(ContractRecord contractRecord) {
        Credentials credentials = Credentials.create(contractRecord.getPrivateKey());
        ContractGasProvider gasContractProvider = new StaticGasProvider(contractRecord.getGasPrice(), contractRecord.getGasLimit());
        SupplyChain contract = null;
        try {
            contract = SupplyChain.deploy( web3Client.getWeb3(), credentials , gasContractProvider  ).send();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        TransactionReceipt deployedContract = contract.getTransactionReceipt().get();
        contractRecord.setContractId( contract.getTransactionReceipt().get().getContractAddress() );
        contractRecordRepository.save( contractRecord );
        return deployedContract;
    }

    @Override
    public List<ContractRecord> getContracts(String farmerName) {
        if ( farmerName != null && !farmerName.isEmpty() ) {
            return contractRecordRepository.findByFarmerName(farmerName);
        }
        return new ArrayList<>();
    }

    @Override
    public List<ContractRecord> getAllContracts() {
        return contractRecordRepository.findAll();
    }

    @Override
    public TransactionReceipt loadContract(TransactionBase transactionBase) {
        Credentials credentials = Credentials.create(transactionBase.getPrivateKey());
        SupplyChain supplyChain = SupplyChain.load(transactionBase.getContractId(),
                web3Client.getWeb3(), credentials, new StaticGasProvider(transactionBase.getGasPrice(), transactionBase.getGasLimit()));
        return supplyChain.getTransactionReceipt().get();
    }

    @Override
    public TransactionReceipt addEvent(ProcessEvent processEvent, String contractAddress, String privateKey, BigInteger gasPrice, BigInteger gasLimit) throws Exception {
        if ( privateKey != null && !privateKey.isEmpty() ) {
            Credentials credentials = Credentials.create(privateKey);
            SupplyChain supplyChain = SupplyChain.load(contractAddress, web3Client.getWeb3(), credentials, new StaticGasProvider(gasPrice, gasLimit));
            SupplyChain.ProcessEvent _processEvent = new SupplyChain.ProcessEvent(
                    BigInteger.valueOf(Integer.valueOf(processEvent.getEventId())),
                    BigInteger.valueOf(Integer.valueOf(processEvent.getUserId())),
                    processEvent.getFirstName(),
                    processEvent.getLastName(),
                    BigInteger.valueOf(Integer.valueOf(processEvent.getUserType().ordinal())),
                    processEvent.getFoodName(),
                    BigInteger.valueOf(Integer.valueOf(processEvent.getStage().ordinal())),
                    processEvent.getDate(),
                    processEvent.getSpec(),
                    processEvent.getDetails(),
                    processEvent.getCertificationStatus()
            );
            return supplyChain.addEvent(_processEvent).send();
        }
        return  null;
    }
}
