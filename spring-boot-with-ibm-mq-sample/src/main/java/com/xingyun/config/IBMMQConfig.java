package com.xingyun.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.connection.UserCredentialsConnectionFactoryAdapter;
import org.springframework.jms.core.JmsOperations;
import org.springframework.jms.core.JmsTemplate;

import com.ibm.mq.jms.MQQueueConnectionFactory;
import com.ibm.msg.client.wmq.WMQConstants;
import com.xingyun.properties.IBMMQProperties;

@Configuration
public class IBMMQConfig {
	
	private Logger logger=LoggerFactory.getLogger(IBMMQConfig.class);
	
	@Autowired
    IBMMQProperties iBMMQProperties;
	
	/**
	 * 配置连接工厂
	 * **/
	@Bean
	public MQQueueConnectionFactory mqQueueConnectionFactory() {
	    MQQueueConnectionFactory mqQueueConnectionFactory = new MQQueueConnectionFactory();
	    try {
	    	mqQueueConnectionFactory.setHostName(iBMMQProperties.getHostName());
	    	//设置传输类型
	        mqQueueConnectionFactory.setTransportType(WMQConstants.WMQ_CM_CLIENT);
	        //CCSID要与连接到的队列管理器一致，Windows下默认为1381，Linux下默认为1208,1208表示UTF-8字符集，建议把队列管理器的CCSID改为1208
	        mqQueueConnectionFactory.setCCSID(1208);
	        //设置管道名称
	        mqQueueConnectionFactory.setChannel(iBMMQProperties.getChannelName());
	        //设置端口
	        mqQueueConnectionFactory.setPort(iBMMQProperties.getPort());
	        //设置队列管理器名称
	        mqQueueConnectionFactory.setQueueManager(iBMMQProperties.getQueueManagerName());
	    } catch (Exception e) {
	    	logger.debug(e.toString());
	    }
	    return mqQueueConnectionFactory;
	}
	
	/**
	 * 用户认证连接工厂适配器
	 * */
	@Bean
	public UserCredentialsConnectionFactoryAdapter userCredentialsConnectionFactoryAdapter(MQQueueConnectionFactory mqQueueConnectionFactory) {
	    UserCredentialsConnectionFactoryAdapter userCredentialsConnectionFactoryAdapter = new UserCredentialsConnectionFactoryAdapter();
	    if(iBMMQProperties.getUserName()!=null&&iBMMQProperties.getPassWord()!=null) {
	    	userCredentialsConnectionFactoryAdapter.setUsername(iBMMQProperties.getUserName());
		    userCredentialsConnectionFactoryAdapter.setPassword(iBMMQProperties.getPassWord());
	    }
	    userCredentialsConnectionFactoryAdapter.setTargetConnectionFactory(mqQueueConnectionFactory);
	    return userCredentialsConnectionFactoryAdapter;
	}
	
	
	/**
	 * 配置缓存连接工厂
	 * 不配置该类则每次与MQ交互都需要重新创建连接，大幅降低速度。
	 * */
	@Bean
	@Primary
	public CachingConnectionFactory cachingConnectionFactory(UserCredentialsConnectionFactoryAdapter userCredentialsConnectionFactoryAdapter) {
	    CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory();
	    cachingConnectionFactory.setTargetConnectionFactory(userCredentialsConnectionFactoryAdapter);
	    //设置缓存大小
	    cachingConnectionFactory.setSessionCacheSize(500);
	    //设置是否异常重连尝试
	    cachingConnectionFactory.setReconnectOnException(true);
	    return cachingConnectionFactory;
	}
	
	/**
	 * 不使用事务可以跳过该步骤。如需使用事务
	 * 可添加注解@EnableTransactionManagement到程序入口类中，事务的具体用法可参考Spring Trasaction。
	 * */
//	@Bean
//	public PlatformTransactionManager jmsTransactionManager(CachingConnectionFactory cachingConnectionFactory) {
//	    JmsTransactionManager jmsTransactionManager = new JmsTransactionManager();
//	    jmsTransactionManager.setConnectionFactory(cachingConnectionFactory);
//	    return jmsTransactionManager;
//	}
	
	/**
	 *  配置JMS模板 
	 *  JmsOperations为JmsTemplate的实现接口。
	 *  重要：不设置setReceiveTimeout时，当队列为空，从队列中取出消息的方法将会一直挂起直到队列内有消息
	 *  */
	@Bean
	public JmsOperations jmsOperations(CachingConnectionFactory cachingConnectionFactory) {
	    JmsTemplate jmsTemplate = new JmsTemplate(cachingConnectionFactory);
	    jmsTemplate.setReceiveTimeout(20000);
	    return jmsTemplate;
	}
}
