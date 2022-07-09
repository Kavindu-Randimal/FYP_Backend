package com.agro.Final.Year.Project.Models.Dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import java.math.BigInteger;

@MappedSuperclass
public class TransactionBase {
    @Transient
    private BigInteger gasLimit;
    @Transient
    private BigInteger gasPrice;
    @Transient
    @JsonInclude()
    private String privateKey;
    private String contractId;

    public BigInteger getGasLimit() {
        return gasLimit;
    }

    public void setGasLimit(BigInteger gasLimit) {
        this.gasLimit = gasLimit;
    }

    public BigInteger getGasPrice() {
        return gasPrice;
    }

    public void setGasPrice(BigInteger gasPrice) {
        this.gasPrice = gasPrice;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }
}
