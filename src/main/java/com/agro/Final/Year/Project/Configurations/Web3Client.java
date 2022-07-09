package com.agro.Final.Year.Project.Configurations;

import org.springframework.context.annotation.Configuration;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

@Configuration
public class Web3Client {
    Web3j web3;

    public Web3Client() {
        this.web3 = Web3j.build(new HttpService("http://localhost:7545/"));
    }

    public Web3j getWeb3() {
        return web3;
    }
}
