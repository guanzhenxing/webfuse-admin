package cn.webfuse.security.authentication.bearer;

import cn.webfuse.security.authentication.AbstractCustomAuthenticationToken;

/**
 * Bearer认证token
 */
public class BearerAuthenticationToken extends AbstractCustomAuthenticationToken {

    private String token;

    public BearerAuthenticationToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
