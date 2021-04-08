package com.xingyun.springbootwithlogback.customized;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author qing-feng.zhao
 */
@Data
@ConfigurationProperties(prefix="customized.logback-thread-logging-config")
public class LogbackThreadLoggingProperties {
    private String applicationName;
    private String loggingFileBasePath;
    private String singleFileMaxSize;
}
