package com.util;

public class Credentials {

//    private String pubkey = System.getenv("pubkey");
//    private String secret = System.getenv("secret");
    private String pubkey;
    private String secret;

    public void setPubkey(String pubkey) {
        this.pubkey = pubkey;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public Credentials() {
    }

    public Credentials(String pubkey, String secret) {
        this.pubkey = pubkey;
        this.secret = secret;
    }

    public String getSecret() {
        return secret;
    }

    public String getPubkey() {
        return pubkey;
    }


}
