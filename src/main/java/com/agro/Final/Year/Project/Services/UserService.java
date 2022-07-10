package com.agro.Final.Year.Project.Services;

import com.agro.Final.Year.Project.Contract.SupplyChain;
import com.agro.Final.Year.Project.Models.Dto.*;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple11;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.ExecutionException;


public interface UserService {
     List<String> getAccounts() throws IOException, ExecutionException, InterruptedException;

     List<String> getData();

     Tuple11<Integer, Integer, String,String, UserType, String, Stage, String,String,String,String> getUser
             (Integer eventId, Integer userId, String firstName, String lastName, UserType userType,String foodName,Stage stage
     ,String date,String spec,String details,String certificationStatus) throws Exception;


     TransactionReceipt startContract(ContractRecord contractRecord) throws Exception;

     List<ContractRecord> getAllContracts();

     TransactionReceipt addEvent(ProcessEvent processEvent, String contractAddress, String privateKey, BigInteger gasPrice, BigInteger gasLimit) throws Exception;

     List<ContractRecord> getContracts(String farmerName);

     List<SupplyChain.ProcessEvent> loadContract(TransactionBase contractName) throws Exception;
}
