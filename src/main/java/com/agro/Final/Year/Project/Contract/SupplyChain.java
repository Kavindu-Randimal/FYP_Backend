package com.agro.Final.Year.Project.Contract;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.DynamicArray;
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
 * <p>Generated with web3j version 1.4.1.
 */
@SuppressWarnings("rawtypes")
public class SupplyChain extends Contract {
    public static final String BINARY = "6080604052600160055534801561001557600080fd5b50600080546001600160a01b03191633179055611494806100376000396000f3fe608060405234801561001057600080fd5b50600436106100415760003560e01c8063215c0a2e146100465780637daefab614610064578063c27a500d14610079575b600080fd5b61004e61008e565b60405161005b9190610fcf565b60405180910390f35b6100776100723660046110d9565b610540565b005b6100816108ad565b60405161005b919061125d565b610096610de2565b6006600060016005546100a991906112d5565b81526020019081526020016000206040518061016001604052908160008201548152602001600182015481526020016002820180546100e7906112ec565b80601f0160208091040260200160405190810160405280929190818152602001828054610113906112ec565b80156101605780601f1061013557610100808354040283529160200191610160565b820191906000526020600020905b81548152906001019060200180831161014357829003601f168201915b50505050508152602001600382018054610179906112ec565b80601f01602080910402602001604051908101604052809291908181526020018280546101a5906112ec565b80156101f25780601f106101c7576101008083540402835291602001916101f2565b820191906000526020600020905b8154815290600101906020018083116101d557829003601f168201915b5050509183525050600482015460209091019060ff16600181111561021957610219610e9a565b600181111561022a5761022a610e9a565b815260200160058201805461023e906112ec565b80601f016020809104026020016040519081016040528092919081815260200182805461026a906112ec565b80156102b75780601f1061028c576101008083540402835291602001916102b7565b820191906000526020600020905b81548152906001019060200180831161029a57829003601f168201915b5050509183525050600682015460209091019060ff1660048111156102de576102de610e9a565b60048111156102ef576102ef610e9a565b8152602001600782018054610303906112ec565b80601f016020809104026020016040519081016040528092919081815260200182805461032f906112ec565b801561037c5780601f106103515761010080835404028352916020019161037c565b820191906000526020600020905b81548152906001019060200180831161035f57829003601f168201915b50505050508152602001600882018054610395906112ec565b80601f01602080910402602001604051908101604052809291908181526020018280546103c1906112ec565b801561040e5780601f106103e35761010080835404028352916020019161040e565b820191906000526020600020905b8154815290600101906020018083116103f157829003601f168201915b50505050508152602001600982018054610427906112ec565b80601f0160208091040260200160405190810160405280929190818152602001828054610453906112ec565b80156104a05780601f10610475576101008083540402835291602001916104a0565b820191906000526020600020905b81548152906001019060200180831161048357829003601f168201915b50505050508152602001600a820180546104b9906112ec565b80601f01602080910402602001604051908101604052809291908181526020018280546104e5906112ec565b80156105325780601f1061050757610100808354040283529160200191610532565b820191906000526020600020905b81548152906001019060200180831161051557829003601f168201915b505050505081525050905090565b60045460ff16156105db5760008160c00151600481111561056357610563610e9a565b036105db5760405162461bcd60e51b815260206004820152603860248201527f43756c7469766174696f6e206973206f6e652074696d652070726f636573732060448201527f666f72207468697320736d61727420636f6e74726163742e000000000000000060648201526084015b60405180910390fd5b60045462010000900460ff16156106705760048160c00151600481111561060457610604610e9a565b036106705760405162461bcd60e51b815260206004820152603660248201527f5061636b6167696e67206973206f6e652074696d652070726f6365737320666f60448201527539103a3434b99039b6b0b93a1031b7b73a3930b1ba1760511b60648201526084016105d2565b600454610100900460ff16156106d65760038160c00151600481111561069857610698610e9a565b146106d65760405162461bcd60e51b815260206004820152600e60248201526d02332b93a34b634bd30ba34b7b7160951b60448201526064016105d2565b60055480825260009081526006602090815260409182902083518155908301516001820155908201518291906002820190610711908261136f565b5060608201516003820190610726908261136f565b50608082015160048201805460ff19166001838181111561074957610749610e9a565b021790555060a08201516005820190610762908261136f565b5060c082015160068201805460ff1916600183600481111561078657610786610e9a565b021790555060e0820151600782019061079f908261136f565b5061010082015160088201906107b5908261136f565b5061012082015160098201906107cb908261136f565b50610140820151600a8201906107e1908261136f565b505060058054915060006107f48361142f565b90915550600090508160c00151600481111561081257610812610e9a565b03610825576004805460ff191660011790555b60048160c00151600481111561083d5761083d610e9a565b03610854576004805462ff00001916620100001790555b60018160c00151600481111561086c5761086c610e9a565b03610881576004805461ff0019166101001790555b60038160c00151600481111561089957610899610e9a565b036108aa576004805461ff00191690555b50565b6060600060055467ffffffffffffffff8111156108cc576108cc610fe9565b60405190808252806020026020018201604052801561090557816020015b6108f2610de2565b8152602001906001900390816108ea5790505b50905060015b600554811015610ddc5760066000828152602001908152602001600020604051806101600160405290816000820154815260200160018201548152602001600282018054610958906112ec565b80601f0160208091040260200160405190810160405280929190818152602001828054610984906112ec565b80156109d15780601f106109a6576101008083540402835291602001916109d1565b820191906000526020600020905b8154815290600101906020018083116109b457829003601f168201915b505050505081526020016003820180546109ea906112ec565b80601f0160208091040260200160405190810160405280929190818152602001828054610a16906112ec565b8015610a635780601f10610a3857610100808354040283529160200191610a63565b820191906000526020600020905b815481529060010190602001808311610a4657829003601f168201915b5050509183525050600482015460209091019060ff166001811115610a8a57610a8a610e9a565b6001811115610a9b57610a9b610e9a565b8152602001600582018054610aaf906112ec565b80601f0160208091040260200160405190810160405280929190818152602001828054610adb906112ec565b8015610b285780601f10610afd57610100808354040283529160200191610b28565b820191906000526020600020905b815481529060010190602001808311610b0b57829003601f168201915b5050509183525050600682015460209091019060ff166004811115610b4f57610b4f610e9a565b6004811115610b6057610b60610e9a565b8152602001600782018054610b74906112ec565b80601f0160208091040260200160405190810160405280929190818152602001828054610ba0906112ec565b8015610bed5780601f10610bc257610100808354040283529160200191610bed565b820191906000526020600020905b815481529060010190602001808311610bd057829003601f168201915b50505050508152602001600882018054610c06906112ec565b80601f0160208091040260200160405190810160405280929190818152602001828054610c32906112ec565b8015610c7f5780601f10610c5457610100808354040283529160200191610c7f565b820191906000526020600020905b815481529060010190602001808311610c6257829003601f168201915b50505050508152602001600982018054610c98906112ec565b80601f0160208091040260200160405190810160405280929190818152602001828054610cc4906112ec565b8015610d115780601f10610ce657610100808354040283529160200191610d11565b820191906000526020600020905b815481529060010190602001808311610cf457829003601f168201915b50505050508152602001600a82018054610d2a906112ec565b80601f0160208091040260200160405190810160405280929190818152602001828054610d56906112ec565b8015610da35780601f10610d7857610100808354040283529160200191610da3565b820191906000526020600020905b815481529060010190602001808311610d8657829003601f168201915b505050505081525050828281518110610dbe57610dbe611448565b60200260200101819052508080610dd49061142f565b91505061090b565b50919050565b6040518061016001604052806000815260200160008152602001606081526020016060815260200160006001811115610e1d57610e1d610e9a565b81526060602082015260400160008152602001606081526020016060815260200160608152602001606081525090565b6000815180845260005b81811015610e7357602081850181015186830182015201610e57565b81811115610e85576000602083870101525b50601f01601f19169290920160200192915050565b634e487b7160e01b600052602160045260246000fd5b60028110610ec057610ec0610e9a565b9052565b60058110610ec057610ec0610e9a565b600061016082518452602083015160208501526040830151816040860152610efe82860182610e4d565b91505060608301518482036060860152610f188282610e4d565b9150506080830151610f2d6080860182610eb0565b5060a083015184820360a0860152610f458282610e4d565b91505060c0830151610f5a60c0860182610ec4565b5060e083015184820360e0860152610f728282610e4d565b9150506101008084015185830382870152610f8d8382610e4d565b925050506101208084015185830382870152610fa98382610e4d565b925050506101408084015185830382870152610fc58382610e4d565b9695505050505050565b602081526000610fe26020830184610ed4565b9392505050565b634e487b7160e01b600052604160045260246000fd5b604051610160810167ffffffffffffffff8111828210171561102357611023610fe9565b60405290565b600082601f83011261103a57600080fd5b813567ffffffffffffffff8082111561105557611055610fe9565b604051601f8301601f19908116603f0116810190828211818310171561107d5761107d610fe9565b8160405283815286602085880101111561109657600080fd5b836020870160208301376000602085830101528094505050505092915050565b8035600281106110c557600080fd5b919050565b8035600581106110c557600080fd5b6000602082840312156110eb57600080fd5b813567ffffffffffffffff8082111561110357600080fd5b90830190610160828603121561111857600080fd5b611120610fff565b823581526020830135602082015260408301358281111561114057600080fd5b61114c87828601611029565b60408301525060608301358281111561116457600080fd5b61117087828601611029565b606083015250611182608084016110b6565b608082015260a08301358281111561119957600080fd5b6111a587828601611029565b60a0830152506111b760c084016110ca565b60c082015260e0830135828111156111ce57600080fd5b6111da87828601611029565b60e08301525061010080840135838111156111f457600080fd5b61120088828701611029565b828401525050610120808401358381111561121a57600080fd5b61122688828701611029565b828401525050610140808401358381111561124057600080fd5b61124c88828701611029565b918301919091525095945050505050565b6000602080830181845280855180835260408601915060408160051b870101925083870160005b828110156112b257603f198886030184526112a0858351610ed4565b94509285019290850190600101611284565b5092979650505050505050565b634e487b7160e01b600052601160045260246000fd5b6000828210156112e7576112e76112bf565b500390565b600181811c9082168061130057607f821691505b602082108103610ddc57634e487b7160e01b600052602260045260246000fd5b601f82111561136a57600081815260208120601f850160051c810160208610156113475750805b601f850160051c820191505b8181101561136657828155600101611353565b5050505b505050565b815167ffffffffffffffff81111561138957611389610fe9565b61139d8161139784546112ec565b84611320565b602080601f8311600181146113d257600084156113ba5750858301515b600019600386901b1c1916600185901b178555611366565b600085815260208120601f198616915b82811015611401578886015182559484019460019091019084016113e2565b508582101561141f5787850151600019600388901b60f8161c191681555b5050505050600190811b01905550565b600060018201611441576114416112bf565b5060010190565b634e487b7160e01b600052603260045260246000fdfea2646970667358221220d24d98b8bfca543b078ceb0c1038b1e2b936e836fa6dfe8e1b385165651f5b9664736f6c634300080f0033";

    public static final String FUNC_ADDEVENT = "addEvent";

    public static final String FUNC_GETALLEVENTS = "getAllEvents";

    public static final String FUNC_GETLASTEVENT = "getLastEvent";

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

    public RemoteFunctionCall<List> getAllEvents() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETALLEVENTS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<ProcessEvent>>() {}));
        return new RemoteFunctionCall<List>(function,
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteFunctionCall<ProcessEvent> getLastEvent() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETLASTEVENT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<ProcessEvent>() {}));
        return executeRemoteCallSingleValueReturn(function, ProcessEvent.class);
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
