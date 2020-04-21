package cn.beatree.paillier.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "cros")
@Component
@Data
public class CrosParams {
    String[] allowedOrigins;
}
