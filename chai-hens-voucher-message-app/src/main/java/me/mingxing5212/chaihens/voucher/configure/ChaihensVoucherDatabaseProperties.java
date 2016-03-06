package me.mingxing5212.chaihens.voucher.configure;

import com.zaxxer.hikari.HikariConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "chaihens.voucher.dataSource")
public class ChaihensVoucherDatabaseProperties extends HikariConfig {
}
