package me.mingxing5212.chaihens.voucher.configure;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Redis 配置参数
 *
 * @author Mingxing Li
 * @date 24/4/16
 */
@ConfigurationProperties(prefix = "chaihens.voucher.redis")
public class RedisConfigurationProperties {

    private String host;

    private int port;

    private int maxTotal;

    private int maxIdle;

    private int maxWaitMillis;

    private boolean testOnBorrow;

    private boolean testOnReturn;


    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getMaxTotal() {
        return maxTotal;
    }

    public void setMaxTotal(int maxTotal) {
        this.maxTotal = maxTotal;
    }

    public int getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(int maxIdle) {
        this.maxIdle = maxIdle;
    }

    public int getMaxWaitMillis() {
        return maxWaitMillis;
    }

    public void setMaxWaitMillis(int maxWaitMillis) {
        this.maxWaitMillis = maxWaitMillis;
    }

    public boolean isTestOnBorrow() {
        return testOnBorrow;
    }

    public void setTestOnBorrow(boolean testOnBorrow) {
        this.testOnBorrow = testOnBorrow;
    }

    public boolean isTestOnReturn() {
        return testOnReturn;
    }

    public void setTestOnReturn(boolean testOnReturn) {
        this.testOnReturn = testOnReturn;
    }

    @Override
    public String toString() {
        return "RedisProperties [host=" + host + ", port=" + port + ", maxTotal=" + maxTotal + ", maxIdle=" + maxIdle
                + ", maxWaitMillis=" + maxWaitMillis + ", testOnBorrow=" + testOnBorrow + ", testOnReturn="
                + testOnReturn + "]";
    }

}