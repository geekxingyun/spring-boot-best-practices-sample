package com.xingyun.util;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.core.rolling.RollingFileAppender;
import ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy;
import ch.qos.logback.core.util.FileSize;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.nio.charset.Charset;

/**
 * 线程日志工具类
 */
public class LogbackThreadLogger extends RollingFileAppender{

    /**
     * 只有静态方法应该禁用构造方法
     * */
    private LogbackThreadLogger(){}

    /**
     * App Name
     */
    public final static String APP_NAME="myApp";

    /**
     * 通用配置
     * 日志存放路径
     */
    public final static String LOG_FILE_BASE_PATH="/opt/applog/"+APP_NAME+"/log/";
    /**
     * 配置日志输出格式
     */
    public static final String fileLogLayout="%d{yyyy-MM-dd HH:mm:ss.SSS} %-5level --- %logger{36} --- %c:%L:%n%m%n";
    /**
     * 配置日志编码
     */
    public static final String charSetName="UTF-8";
    /**
     * 是否自动追加
     */
    public static final Boolean append=true;
    /**
     * 是否立即刷新
     */
    public static final Boolean immediateFlush=true;
    /**
     * 单个文件最大值
     */
    public static final String maxFileSize="100MB";
    /**
     * 单个文件最大值
     */
    public static final  FileSize maxFileSizeValue=FileSize.valueOf(maxFileSize);
    /**
     * 保存30天
     */
    public static final Integer maxHistory=30;
    /**
     * 日志保存最大容量
     */
    public static final String totalSizeCap="20GB";
    /**
     * 日志保存最大容量
     */
    public static final  FileSize totalSizeCapValue=FileSize.valueOf(totalSizeCap);
    /**
     * 启动清理
     */
    public static final Boolean cleanHistoryOnStart=false;

    /**
     * 打印线程日志
     * @param folderName
     * @param className
     * @return
     */
    @SuppressWarnings("unused")
    public static Logger getLogger(String folderName,String className){

        //创建日志实例对象
        Logger logger = (Logger) LoggerFactory.getLogger(className);
        //获取日志上下文
        LoggerContext loggerContext = logger.getLoggerContext();

        //创建文件追加器
        RollingFileAppender rollingFileAppender = new RollingFileAppender();
        //配置上下文
        rollingFileAppender.setContext(loggerContext);
        //配置文本追加 如果设置为false则覆盖
        rollingFileAppender.setAppend(append);
        //配置立即追加
        rollingFileAppender.setImmediateFlush(immediateFlush);
        //配置日志路径和名称 opt/applog/log/spring/log/test/myThread.log
        rollingFileAppender.setFile(LOG_FILE_BASE_PATH+folderName+ File.separator+className+".log");
        //配置输出格式和输出字符集
        rollingFileAppender.setEncoder(configPatternLayoutEncoder(loggerContext));
        //配置滚动策略 opt/applog/log/spring/log/2019-08-20/test/myThread.log
        rollingFileAppender.setRollingPolicy(configSizeAndTimeBasedRollingPolicy(loggerContext,rollingFileAppender,folderName,className));
        //启动文件追加器
        rollingFileAppender.start();
        //如果为false,线程日志不会重复追加到主日志文件中,如果为 true,则会输出到主日志和线程文件夹中
        logger.setAdditive(false);
        //添加日志追加器
        logger.addAppender(rollingFileAppender);
        return logger;
    }


    /**
     * 日志输出格式和字符集
     * @param loggerContext
     * @return
     */
    private static PatternLayoutEncoder configPatternLayoutEncoder(LoggerContext loggerContext){

        PatternLayoutEncoder patternLayoutEncoder = new PatternLayoutEncoder();
        //配置日志上下文
        patternLayoutEncoder.setContext(loggerContext);
        //配置日志输出格式 layout
        patternLayoutEncoder.setPattern(fileLogLayout);
        //配置日志输出字符集
        patternLayoutEncoder.setCharset(Charset.forName(charSetName));
        //启动encoder
        patternLayoutEncoder.start();

        return patternLayoutEncoder;
    }

    /**
     * 日志滚动策略
     * @param loggerContext
     * @param rollingFileAppender
     * @param folderName
     * @param className
     * @return
     */
    private static SizeAndTimeBasedRollingPolicy configSizeAndTimeBasedRollingPolicy(LoggerContext loggerContext,RollingFileAppender rollingFileAppender,String folderName,String className){
        //配置大小和日期时间分割策略
        SizeAndTimeBasedRollingPolicy sizeAndTimeBasedRollingPolicy = new SizeAndTimeBasedRollingPolicy<>();
        //配置上下文
        sizeAndTimeBasedRollingPolicy.setContext(loggerContext);
        //配置日志追加器
        sizeAndTimeBasedRollingPolicy.setParent(rollingFileAppender);
        //配置日志滚动策略规则 /opt/applog/myApp/log/2019-08-20/test/myThread.log
        sizeAndTimeBasedRollingPolicy.setFileNamePattern(LOG_FILE_BASE_PATH+"%d{yyyy-MM-dd,aux}"+File.separator+folderName+File.separator+className+"-%d{yyyy-MM-dd,UTC}.%i.log");
        //设置单个文件大小
        sizeAndTimeBasedRollingPolicy.setMaxFileSize(maxFileSizeValue);
        //保存多少天
        sizeAndTimeBasedRollingPolicy.setMaxHistory(maxHistory);
        //磁盘最大日志大小
        sizeAndTimeBasedRollingPolicy.setTotalSizeCap(totalSizeCapValue);
        //启动时候清理日志
        sizeAndTimeBasedRollingPolicy.setCleanHistoryOnStart(cleanHistoryOnStart);
        //开启滚动策略
        sizeAndTimeBasedRollingPolicy.start();
        return sizeAndTimeBasedRollingPolicy;
    }
}
