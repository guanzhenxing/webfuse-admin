package cn.webfuse.security.util;

import cn.webfuse.framework.core.tool.CryptoTools;
import cn.webfuse.framework.core.tool.JsonTools;
import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Authorization Token的工具类
 */
public class AuthTokenUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthTokenUtil.class);

    /**
     * 校验mac token是否正确
     *
     * @param secret
     * @param macRequestParam
     * @return
     */
    public static boolean checkMacToken(String secret, Map<String, Object> macRequestParam) {
        String newMac = createMacToken(secret, macRequestParam);
        if (!MapUtils.getString(macRequestParam, "mac").equalsIgnoreCase(newMac)) {
            LOGGER.warn("request authRequest:" + JsonTools.toJsonString(macRequestParam));
            LOGGER.warn("Mac key:" + secret);
            LOGGER.warn("right Mac:" + newMac);
            return false;
        }
        return true;
    }

    /**
     * 创建一个Mac Token
     *
     * @param secret
     * @param macRequestParam
     * @return
     */
    public static String createMacToken(String secret, Map<String, Object> macRequestParam) {
        StringBuilder sbRawMac = new StringBuilder();
        sbRawMac.append(MapUtils.getString(macRequestParam, "nonce"));
        sbRawMac.append("\n");
        sbRawMac.append(MapUtils.getString(macRequestParam, "httpMethod").toUpperCase());
        sbRawMac.append("\n");
        sbRawMac.append(MapUtils.getString(macRequestParam, "requestUri"));
        sbRawMac.append("\n");
        sbRawMac.append(MapUtils.getString(macRequestParam, "host"));
        sbRawMac.append("\n");
        String newMac = CryptoTools.encryptHMac256(sbRawMac.toString(), secret);
        return newMac;
    }

}