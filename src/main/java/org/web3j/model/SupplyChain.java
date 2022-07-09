package org.web3j.model;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.DynamicStruct;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.8.7.
 */
@SuppressWarnings("rawtypes")
public class SupplyChain extends Contract {
    public static final String BINARY = "6080604052600160055534801561001557600080fd5b50600080546001600160a01b03191633179055610dd5806100376000396000f3fe608060405234801561001057600080fd5b50600436106100415760003560e01c8063404aa8f9146100465780637daefab614610064578063f2d5b13214610079575b600080fd5b61004e61008c565b60405161005b9190610c62565b60405180910390f35b6100776100723660046109a5565b610534565b005b610077610087366004610962565b6107d0565b6100946107d4565b600660006005548152602001908152602001600020604051806101600160405290816000820154815260200160018201548152602001600282018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156101625780601f1061013757610100808354040283529160200191610162565b820191906000526020600020905b81548152906001019060200180831161014557829003601f168201915b505050918352505060038201805460408051602060026001851615610100026000190190941693909304601f81018490048402820184019092528181529382019392918301828280156101f65780601f106101cb576101008083540402835291602001916101f6565b820191906000526020600020905b8154815290600101906020018083116101d957829003601f168201915b5050509183525050600482015460209091019060ff16600181111561021757fe5b600181111561022257fe5b815260058201805460408051602060026001851615610100026000190190941693909304601f81018490048402820184019092528181529382019392918301828280156102b05780601f10610285576101008083540402835291602001916102b0565b820191906000526020600020905b81548152906001019060200180831161029357829003601f168201915b5050509183525050600682015460209091019060ff1660048111156102d157fe5b60048111156102dc57fe5b815260078201805460408051602060026001851615610100026000190190941693909304601f810184900484028201840190925281815293820193929183018282801561036a5780601f1061033f5761010080835404028352916020019161036a565b820191906000526020600020905b81548152906001019060200180831161034d57829003601f168201915b505050918352505060088201805460408051602060026001851615610100026000190190941693909304601f81018490048402820184019092528181529382019392918301828280156103fe5780601f106103d3576101008083540402835291602001916103fe565b820191906000526020600020905b8154815290600101906020018083116103e157829003601f168201915b505050918352505060098201805460408051602060026001851615610100026000190190941693909304601f81018490048402820184019092528181529382019392918301828280156104925780601f1061046757610100808354040283529160200191610492565b820191906000526020600020905b81548152906001019060200180831161047557829003601f168201915b5050509183525050600a8201805460408051602060026001851615610100026000190190941693909304601f81018490048402820184019092528181529382019392918301828280156105265780601f106104fb57610100808354040283529160200191610526565b820191906000526020600020905b81548152906001019060200180831161050957829003601f168201915b505050505081525050905090565b60045460ff16156105785760008160c00151600481111561055157fe5b14156105785760405162461bcd60e51b815260040161056f90610b87565b60405180910390fd5b60045462010000900460ff16156105b95760048160c00151600481111561059b57fe5b14156105b95760405162461bcd60e51b815260040161056f90610be4565b600454610100900460ff16156105f85760038160c0015160048111156105db57fe5b146105f85760405162461bcd60e51b815260040161056f90610c3a565b60055480825260009081526006602090815260409182902083518155818401516001820155918301518051849392610637926002850192910190610839565b5060608201518051610653916003840191602090910190610839565b50608082015160048201805460ff19166001838181111561067057fe5b021790555060a08201518051610690916005840191602090910190610839565b5060c082015160068201805460ff191660018360048111156106ae57fe5b021790555060e082015180516106ce916007840191602090910190610839565b5061010082015180516106eb916008840191602090910190610839565b506101208201518051610708916009840191602090910190610839565b50610140820151805161072591600a840191602090910190610839565b50506005805460010190555060008160c00151600481111561074357fe5b1415610757576004805460ff191660011790555b60048160c00151600481111561076957fe5b1415610781576004805462ff00001916620100001790555b60018160c00151600481111561079357fe5b14156107a9576004805461ff0019166101001790555b60038160c0015160048111156107bb57fe5b14156107cd576004805461ff00191690555b50565b5050565b604051806101600160405280600081526020016000815260200160608152602001606081526020016000600181111561080957fe5b81526060602082015260400160008152602001606081526020016060815260200160608152602001606081525090565b828054600181600116156101000203166002900490600052602060002090601f01602090048101928261086f57600085556108b5565b82601f1061088857805160ff19168380011785556108b5565b828001600101855582156108b5579182015b828111156108b557825182559160200191906001019061089a565b506108c19291506108c5565b5090565b5b808211156108c157600081556001016108c6565b8035600581106108e957600080fd5b919050565b8035600281106108e957600080fd5b600082601f83011261090d578081fd5b813567ffffffffffffffff81111561092157fe5b610934601f8201601f1916602001610d7b565b818152846020838601011115610948578283fd5b816020850160208301379081016020019190915292915050565b60008060408385031215610974578182fd5b823567ffffffffffffffff81111561098a578283fd5b610996858286016108fd565b95602094909401359450505050565b6000602082840312156109b6578081fd5b813567ffffffffffffffff808211156109cd578283fd5b81840191506101608083870312156109e3578384fd5b6109ec81610d7b565b90508235815260208301356020820152604083013582811115610a0d578485fd5b610a19878286016108fd565b604083015250606083013582811115610a30578485fd5b610a3c878286016108fd565b606083015250610a4e608084016108ee565b608082015260a083013582811115610a64578485fd5b610a70878286016108fd565b60a083015250610a8260c084016108da565b60c082015260e083013582811115610a98578485fd5b610aa4878286016108fd565b60e0830152506101008084013583811115610abd578586fd5b610ac9888287016108fd565b8284015250506101208084013583811115610ae2578586fd5b610aee888287016108fd565b8284015250506101408084013583811115610b07578586fd5b610b13888287016108fd565b918301919091525095945050505050565b60058110610b2e57fe5b9052565b60028110610b2e57fe5b60008151808452815b81811015610b6157602081850181015186830182015201610b45565b81811115610b725782602083870101525b50601f01601f19169290920160200192915050565b60208082526038908201527f43756c7469766174696f6e206973206f6e652074696d652070726f636573732060408201527f666f72207468697320736d61727420636f6e74726163742e0000000000000000606082015260800190565b60208082526036908201527f5061636b6167696e67206973206f6e652074696d652070726f6365737320666f60408201527539103a3434b99039b6b0b93a1031b7b73a3930b1ba1760511b606082015260800190565b6020808252600e908201526d02332b93a34b634bd30ba34b7b7160951b604082015260600190565b60006020825282516020830152602083015160408301526040830151610160806060850152610c95610180850183610b3c565b91506060850151601f1980868503016080870152610cb38483610b3c565b935060808701519150610cc960a0870183610b32565b60a08701519150808685030160c0870152610ce48483610b3c565b935060c08701519150610cfa60e0870183610b24565b60e08701519150610100818786030181880152610d178584610b3c565b945080880151925050610120818786030181880152610d368584610b3c565b945080880151925050610140818786030181880152610d558584610b3c565b908801518782039092018488015293509050610d718382610b3c565b9695505050505050565b60405181810167ffffffffffffffff81118282101715610d9757fe5b60405291905056fea2646970667358221220d7db537da252e919d86e6a00cc2233855f2a4c06534df062d4a75af10ebdb3e764736f6c63430007060033";

    public static final String FUNC_ADDEVENT = "addEvent";

    public static final String FUNC_GETEVENTS = "getEvents";

    public static final String FUNC_INITIALIZECONTRACT = "initializeContract";

    public static final Event ADDENTITY_EVENT = new Event("AddEntity", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected SupplyChain(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected SupplyChain(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected SupplyChain(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected SupplyChain(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<AddEntityEventResponse> getAddEntityEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(ADDENTITY_EVENT, transactionReceipt);
        ArrayList<AddEntityEventResponse> responses = new ArrayList<AddEntityEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            AddEntityEventResponse typedResponse = new AddEntityEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.id = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.batchId = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<AddEntityEventResponse> addEntityEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, AddEntityEventResponse>() {
            @Override
            public AddEntityEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(ADDENTITY_EVENT, log);
                AddEntityEventResponse typedResponse = new AddEntityEventResponse();
                typedResponse.log = log;
                typedResponse.id = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.batchId = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<AddEntityEventResponse> addEntityEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ADDENTITY_EVENT));
        return addEntityEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> addEvent(ProcessEvent _event) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_ADDEVENT, 
                Arrays.<Type>asList(_event), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<ProcessEvent> getEvents() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETEVENTS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<ProcessEvent>() {}));
        return executeRemoteCallSingleValueReturn(function, ProcessEvent.class);
    }

    public RemoteFunctionCall<TransactionReceipt> initializeContract(String _cultivationFieldAddress, BigInteger _batchId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_INITIALIZECONTRACT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_cultivationFieldAddress), 
                new org.web3j.abi.datatypes.generated.Uint256(_batchId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static SupplyChain load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new SupplyChain(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static SupplyChain load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new SupplyChain(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static SupplyChain load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new SupplyChain(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static SupplyChain load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new SupplyChain(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<SupplyChain> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(SupplyChain.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<SupplyChain> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(SupplyChain.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<SupplyChain> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(SupplyChain.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<SupplyChain> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(SupplyChain.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class ProcessEvent extends DynamicStruct {
        public BigInteger eventId;

        public BigInteger userId;

        public String firstName;

        public String lastName;

        public BigInteger userType;

        public String foodName;

        public BigInteger stage;

        public String date;

        public String spec;

        public String details;

        public String certificateStatus;

        public ProcessEvent(BigInteger eventId, BigInteger userId, String firstName, String lastName, BigInteger userType, String foodName, BigInteger stage, String date, String spec, String details, String certificateStatus) {
            super(new org.web3j.abi.datatypes.generated.Uint256(eventId),new org.web3j.abi.datatypes.generated.Uint256(userId),new org.web3j.abi.datatypes.Utf8String(firstName),new org.web3j.abi.datatypes.Utf8String(lastName),new org.web3j.abi.datatypes.generated.Uint8(userType),new org.web3j.abi.datatypes.Utf8String(foodName),new org.web3j.abi.datatypes.generated.Uint8(stage),new org.web3j.abi.datatypes.Utf8String(date),new org.web3j.abi.datatypes.Utf8String(spec),new org.web3j.abi.datatypes.Utf8String(details),new org.web3j.abi.datatypes.Utf8String(certificateStatus));
            this.eventId = eventId;
            this.userId = userId;
            this.firstName = firstName;
            this.lastName = lastName;
            this.userType = userType;
            this.foodName = foodName;
            this.stage = stage;
            this.date = date;
            this.spec = spec;
            this.details = details;
            this.certificateStatus = certificateStatus;
        }

        public ProcessEvent(Uint256 eventId, Uint256 userId, Utf8String firstName, Utf8String lastName, Uint8 userType, Utf8String foodName, Uint8 stage, Utf8String date, Utf8String spec, Utf8String details, Utf8String certificateStatus) {
            super(eventId,userId,firstName,lastName,userType,foodName,stage,date,spec,details,certificateStatus);
            this.eventId = eventId.getValue();
            this.userId = userId.getValue();
            this.firstName = firstName.getValue();
            this.lastName = lastName.getValue();
            this.userType = userType.getValue();
            this.foodName = foodName.getValue();
            this.stage = stage.getValue();
            this.date = date.getValue();
            this.spec = spec.getValue();
            this.details = details.getValue();
            this.certificateStatus = certificateStatus.getValue();
        }
    }

    public static class AddEntityEventResponse extends BaseEventResponse {
        public String id;

        public BigInteger batchId;
    }
}
