package cn.webfuse.security.authentication.bearer;

import cn.webfuse.security.authentication.AuthenticationInterceptor;
import cn.webfuse.security.authentication.AuthenticationInterceptorImpl;
import cn.webfuse.security.entity.UserAuthenticationToken;
import cn.webfuse.security.entity.uaa.AuthToken;
import cn.webfuse.security.entity.uaa.User;
import cn.webfuse.security.service.impl.BearerAuthenticationTokenCheckService;
import cn.webfuse.security.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * BearerToken认证
 */
@Component
@Order(10)
public class BearerTokenAuthenticationProvider implements AuthenticationProvider {

    private static final Logger LOGGER = LoggerFactory.getLogger(BearerTokenAuthenticationProvider.class);

    private AuthenticationInterceptor authenticationInterceptor = new AuthenticationInterceptorImpl();

    @Autowired
    private UserService userService;


    /**
     * 引入定制的AuthenticationInterceptor，且名字为bearerAuthenticationInterceptor
     *
     * @param authenticationInterceptor
     */
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired(required = false)
    @Qualifier(value = "bearerAuthenticationInterceptor")
    public void setAuthenticationInterceptor(AuthenticationInterceptor authenticationInterceptor) {
        if (authenticationInterceptor != null) {
            this.authenticationInterceptor = authenticationInterceptor;
        }
    }

    @Autowired
    private BearerAuthenticationTokenCheckService bearerAuthenticationTokenCheckService;



    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        LOGGER.debug("Bearer token authenticate begin.");
        authenticationInterceptor.preHandle(authentication);

        BearerAuthenticationToken bearerPreAuthenticationToken = (BearerAuthenticationToken) authentication;
        AuthToken authToken = bearerAuthenticationTokenCheckService.verifyToken(bearerPreAuthenticationToken);
        User user = userService.loadUserDetailsByAccessToken(authToken);    //获得相关的用户信息
        user.setAuthToken(authToken);
        UserAuthenticationToken userAuthenticationToken = new UserAuthenticationToken(user, "BEARER");

        authenticationInterceptor.postHandle(userAuthenticationToken);
        LOGGER.debug("Bearer token authenticate end.");

        return userAuthenticationToken;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication == BearerAuthenticationToken.class;
    }
}

