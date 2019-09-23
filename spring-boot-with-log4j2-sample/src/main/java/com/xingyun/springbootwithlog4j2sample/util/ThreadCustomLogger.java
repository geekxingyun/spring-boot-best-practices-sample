package com.xingyun.springbootwithlog4j2sample.util;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.appender.RollingFileAppender;
import org.apache.logging.log4j.core.appender.rolling.CompositeTriggeringPolicy;
import org.apache.logging.log4j.core.appender.rolling.DefaultRolloverStrategy;
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
public class ThreadCustomLogger{

    /**
     * 配置方法
     *日志输出文件夹
     */
    private static String logBasePath="/opt/applog/myApp/log/customThread";
    /**
     * 日志文件后缀
     */
    private static String logFileSuffix=".log";
    /**
     * 单个文件最大大小
     */
    private static String maxFileSize="1GB";
    /**
     * 是否使用缓冲区
     */
    private static Boolean bufferedIo=true;
    /**
     * 缓冲区大小
     */
    private static Integer bufferSize=8192;
    /**
     * 是否继承Root节点配置
     */
    private static Boolean additive=false;
    ////////////////////////////////////不经常修改/////////////////////////////////////////////////////
    /**
     *  滚动追加器名称
     */
    private static final String name="customRollingFileAppenderBuilder";
    /**
     * 字符集
     */
    private static final String charSet="UTF-8";
    /**
     * 日志文件中日志输出格式
     */
    private static String logOutFileFormat="%d{yyyy/MM/dd HH:mm:ss,SSS} %X{path} %X{ip} %-5level %l %n%msg%n";
    /**
     * 滚动压缩后日志文件路径和名称
     */
    private static String filePatternValue=logBasePath+File.separator+"customThread-archive-%d{yyyy-MM-dd}-%i.log.gz";

    /**
     * 是否使用日志追加模式
     */
    private static final Boolean appendEnable=true;

    /**
     * 是否忽略异常继续写入
     */
    private static final Boolean ignoreExceptions=true;

    /**
     * 是否立即写入
     */
    private static final Boolean immediateFlush=true;

    /**
     * 默认为false，该appender按需创建文件，当日志事件通过所有的filters并且通过路由指向了该appender,该appender仅仅创建该文件
     */
    private static final Boolean createOnDemand=false;

    /**
     * 获取日志上下文
     */
    private static LoggerContext loggerContext= (LoggerContext) LogManager.getContext(false);
    /**
     * 获取日志配置文件实例
     */
    private static Configuration loggerConfiguration=loggerContext.getConfiguration();

    /**
     * 日志输出文件名称
     */
    private static StringBuffer loggerFullFileName=null;
    /**
     * 日志
     */
    private static Logger logger=null;
    /**
     * 滚动日志追加Appender Builder 对象
     */
    private static RollingFileAppender.Builder rollingFileAppenderBuilder= null;
    /**
     * 滚动日志追加Appender对象
     */
    private static RollingFileAppender rollingFileAppender= null;
    /**
     * 设计思路
     * 1.log4j2.xml 根节点是configuration
     * 2.Appenders 可以多个追加方法，比如追加到控制台，追加到文件等
     * 3.代码中获取上面的配置,然后动态修改追加到文件的Appender
     * @param threadFolderName
     * @param loggerName
     * @return
     */
    public static  Logger getLogger(String threadFolderName, String loggerName) {
        //返回实例
        logger =(Logger)LogManager.getLogger(loggerName);

        //日志分割文件夹路径
        loggerFullFileName=new StringBuffer();
        loggerFullFileName.append(logBasePath);
        loggerFullFileName.append(File.separator);
        loggerFullFileName.append(threadFolderName);
        //设置文件名称
        loggerFullFileName.append(File.separator);
        //设置日志的名称
        loggerFullFileName.append(loggerName);
        //日志文件后缀类型 默认.log
        loggerFullFileName.append(logFileSuffix);

        //不需要重复创建公共的配置过程
        if(null==rollingFileAppenderBuilder){
            rollingFileAppenderBuilder=initCustomRollingFileAppender();
        }

        //添加Appender
        rollingFileAppender=rollingFileAppenderBuilder.withFileName(loggerFullFileName.toString()).build();
        rollingFileAppender.start();
        //设置追加器
        logger.addAppender(rollingFileAppender);
        //是否继承自log4j2.xml中Root节点的配置
        logger.setAdditive(additive);
        //设置拦截的日志级别
        logger.setLevel(Level.DEBUG);
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
                .withCharset(Charset.forName(charSet))
                //加载配置
                .withConfiguration(loggerConfiguration)
                //输出布局
                .withPattern(logOutFileFormat).build();


        //设置默认值
        DefaultRolloverStrategy defaultRolloverStrategy= DefaultRolloverStrategy.newBuilder()
                //从2.8版本开始，如果fileIndex属性设置为nomax，那么最大和最小值，都将会被忽略掉
                .withFileIndex("noMax")
                //.withMin("1")
                //.withMax("20")
                //设置压缩级别0-9，其中0=无，1=最佳速度，通过9=最佳压缩。只适用于ZIP文件。
                //.withCompressionLevelStr("9")
                .withConfig(loggerConfiguration)
                .build();

        //根据大小触发滚动策略 当文件大小增加到1GB时候触发该策略
        SizeBasedTriggeringPolicy sizeBasedTriggeringPolicy= SizeBasedTriggeringPolicy.createPolicy(maxFileSize==null?null:maxFileSize);

        //根据日期和时间触发滚动策略
        TimeBasedTriggeringPolicy timeBasedTriggeringPolicy= TimeBasedTriggeringPolicy.newBuilder()
                //根据日期格式中最具体的时间单位来决定应该多久发生一次rollover
                //例如，在日期模式中小时为具体的时间单位，那么每4小时会发生4次rollover，默认值为1
                //如果是yyyy-MM-dd 那么1表示一天 如果是yyyy-MM 那么1表示一个月
                .withInterval(1)
                //表示是否调整时间间隔以使在时间间隔边界发生下一个rollover
                //假设小时为具体的时间单元，当前时间为上午3点，时间间隔为4，第一次发送rollover是在上午4点，接下来是上午8点，接着是中午，接着是下午4点等发生
                .withModulate(false)
                //默认值 0 单位：秒，下一次触发时间会在interval基础上，增加一个随机的毫秒数Random.nextLong(0, 1+maxRandomDelay*1000)
                .withMaxRandomDelay(0)
                .build();

        //日志滚动追加器
        RollingFileAppender.Builder defaultConfigRollingFileAppenderBuilder = RollingFileAppender.newBuilder()
                .withName(name)
                //日志是否追加模式
                .withAppend(appendEnable)
                //是否使用缓冲区
                .withBufferedIo(bufferedIo)
                //缓冲区大小
                .withBufferSize(bufferSize)
                .withCreateOnDemand(createOnDemand)
                //是否立即刷新
                .withImmediateFlush(immediateFlush)
                //log4j 2.9.1 以上版本使用.setIgnoreExceptions(true)替换
                .withIgnoreExceptions(ignoreExceptions)
                //日志输出格式 log4j 2.9.1 以上版本使用.setLayout(layout)替换
                .withLayout(layout)
                //滚动输出归档压缩包文件命名格式
                .withFilePattern(filePatternValue)
                //用于决定是否发生rollover的策略 根据大小和日志进行滚动
                .withPolicy(CompositeTriggeringPolicy.createPolicy(sizeBasedTriggeringPolicy,timeBasedTriggeringPolicy))
                //用于决定压缩文件的名称和路径 单个文件最大1G
                .withStrategy(defaultRolloverStrategy);

        return defaultConfigRollingFileAppenderBuilder;
    }
}
