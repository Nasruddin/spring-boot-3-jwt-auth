package com.javatab.springboot3authjwt.utils;

import org.springframework.stereotype.Component;

import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@Component
public class RSAKeyProperties {

    private RSAPublicKey rsaPublicKey;
    private RSAPrivateKey rsaPrivateKey;

    public RSAKeyProperties() {
        KeyPair pair = KeyGeneratorUtility.generateRSAKey();
        this.rsaPublicKey = (RSAPublicKey) pair.getPublic();
        this.rsaPrivateKey = (RSAPrivateKey) pair.getPrivate();
    }

    public RSAPublicKey getRsaPublicKey() {
        return rsaPublicKey;
    }

    public void setRsaPublicKey(RSAPublicKey rsaPublicKey) {
        this.rsaPublicKey = rsaPublicKey;
    }

    public RSAPrivateKey getRsaPrivateKey() {
        return rsaPrivateKey;
    }

    public void setRsaPrivateKey(RSAPrivateKey rsaPrivateKey) {
        this.rsaPrivateKey = rsaPrivateKey;
    }
}
