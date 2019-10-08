package com.xingyun.springbootwithspringdatajpasample.customize;
import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy;

import java.util.Locale;

/**
 * @author 星云
 * @功能 将数据库表和字段全部大写
 * @date 9/22/2019 10:25 AM
 */
public class UpperTableColumnStrategy extends SpringPhysicalNamingStrategy {

    /**
     * 父类中映射规则是nikeName映射为nick_name
     * 自雷重写父类方法将nikeName映射为NIKE_NAME
     * @param name
     * @param quoted
     * @param jdbcEnvironment
     * @return
     */
    @Override
    protected Identifier getIdentifier(String name, boolean quoted, JdbcEnvironment jdbcEnvironment) {
        if (this.isCaseInsensitive(jdbcEnvironment)) {
            name = name.toUpperCase(Locale.ROOT);
        }
        return new Identifier(name, quoted);
    }

    /**
     * 大小写是否敏感
     * @param jdbcEnvironment
     * @return 默认是true
     */
    @Override
    protected boolean isCaseInsensitive(JdbcEnvironment jdbcEnvironment) {
        return super.isCaseInsensitive(jdbcEnvironment);
    }
}