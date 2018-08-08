package cn.webfuse.security.authentication.debug;

import cn.webfuse.security.authentication.AbstractCustomAuthenticationToken;

public class DebugAuthenticationToken extends AbstractCustomAuthenticationToken {

    private String account;
    private String realm;

    public DebugAuthenticationToken(String account, String realm) {
        this.account = account;
        this.realm = realm;
    }

    public DebugAuthenticationToken() {
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getRealm() {
        return realm;
    }

    public void setRealm(String realm) {
        this.realm = realm;
    }
}