package com.xingyun.springbootwithlog4j2sample.util;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.appender.RollingFileAppender;
import org.apache.logging.log4j.core.appender.rolling.DefaultRolloverStrategy;
import org.apache.logging.log4j.core.appender.rolling.OnStartupTriggeringPolicy;
import org.apache.logging.log4j.core.appender.rolling.SizeBasedTriggeringPolicy;
import org.apache.logging.log4j.core.appender.rolling.TimeBasedTriggeringPolicy;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.layout.PatternLayout;

import java.io.File;
import java.nio.charset.Charset;
/**
 * @author 星云
 * @功能 线程日志工具类 使用Log4j2自定义线程日志类
 * @date 9/17/2019 7:09 AM
 */
public class ThreadCustomLogger {
    /**
     * 获取日志上下文
     */
    private static LoggerContext loggerContext= (LoggerContext) LogManager.getContext(false);
    /**
     * 获取日志配置文件实例
     */
    private static Configuration loggerConfiguration=loggerContext.getConfiguration();

    /**
     * 滚动文件日志记录器
     */
    private static RollingFileAppender.Builder rollingFileAppenderBuilder;

    /**
     * 日志输出文件夹
     */
    private static volatile String lOG_BASE_PATH="/opt/appLogs/myApp/log/customThread";
    /**
     * 日志输出格式
     */
    private static volatile String OUT_PUT_FORMAT_VALUE="%d %p %c{1.} [%t] %m%n";
    /**
     * 滚动策略
     */
    private static volatile String FILE_PATTERN_VALUE=lOG_BASE_PATH+"/$${date:yyyy-MM-dd}/customThread/customThread-archive-%d{yyyy-MM-dd}-%i.log.gz";

    /**
     * @param threadFolderName
     * @param loggerName
     * @return
     */
    public static  Logger getLogger(String threadFolderName, String loggerName) {

        //是接口
        Appender appender;

        //日志分割文件夹路径
        String threadLoggerFolder=lOG_BASE_PATH+ File.separator+threadFolderName;

        //判断是否需要重复初始化共同配置
        if(null==rollingFileAppenderBuilder){
            //初始化相同的公共配置
            rollingFileAppenderBuilder=initCustomRollingFileAppender();
        }
        //带文件大小和日期时间滚动策略的日志记录器
        appender=rollingFileAppenderBuilder.withFileName(threadLoggerFolder+File.separator+loggerName+".log").build();
        appender.start();
        //返回实例
        Logger logger =(Logger)LogManager.getLogger(loggerName);
        //是否继承自log4j2.xml中Root节点的配置
        logger.setAdditive(false);
        //设置拦截的日志级别
        logger.setLevel(Level.DEBUG);
        //设置追加器
        logger.addAppender(appender);
        return logger;
    }

    /**
     * 初始化
     * @return
     */
    private static RollingFileAppender.Builder initCustomRollingFileAppender(){
        //日志打印输出布局
        Layout layout= PatternLayout.newBuilder()
                //设置字符集
                .withCharset(Charset.forName("UTF-8"))
                //加载配置
                .withConfiguration(loggerConfiguration)
                //输出布局
                .withPattern(OUT_PUT_FORMAT_VALUE).build();

        //系统启动出发滚动策略 当系统重新加载启动的时候触发该策略
        /*OnStartupTriggeringPolicy onStartupTriggeringPolicy=OnStartupTriggeringPolicy.createPolicy(1);*/
        //根据大小触发滚动策略 当文件大小增加到1GB时候触发该策略
        SizeBasedTriggeringPolicy sizeBasedTriggeringPolicy= SizeBasedTriggeringPolicy.createPolicy("1GB");
        //根据日期和时间触发滚动策略
        TimeBasedTriggeringPolicy timeBasedTriggeringPolicy= TimeBasedTriggeringPolicy.newBuilder()
                //如果是yyyy-MM-dd 那么1表示一天 如果是yyyy-MM 那么1表示一个月
                .withInterval(1)
                .withModulate(true)
                .withMaxRandomDelay(0)
                .build();

        //设置默认值
        DefaultRolloverStrategy defaultRolloverStrategy= DefaultRolloverStrategy.newBuilder()
                .withMin("1")
                .withMax("20")
                .build();

        //日志滚动追加器
        RollingFileAppender.Builder rollingFileAppenderBuilder = RollingFileAppender.newBuilder()
                .setName("customRollingFileAppenderBuilder")
                //日志是否追加模式
                .withAppend(true)
                //是否使用缓冲区
                .withBufferedIo(true)
                //缓冲区大小
                .withBufferSize(8192)
                .withCreateOnDemand(false)
                //是否立即刷新
                .withImmediateFlush(true)
                //是否忽略异常继续写入
                .setIgnoreExceptions(true)
                //默认的滚动策略
                .withStrategy(defaultRolloverStrategy)
                //启动时候出发的策略
                /*.withPolicy(onStartupTriggeringPolicy)*/
                //文件大小达到条件触发策略
                .withPolicy(sizeBasedTriggeringPolicy)
                //日期和时间达到条件触发策略
                .withPolicy(timeBasedTriggeringPolicy)
                //日志输出格式
                .setLayout(layout)
                //滚动输出归档压缩包文件命名格式
                .withFilePattern(FILE_PATTERN_VALUE);
        return rollingFileAppenderBuilder;
    }
}