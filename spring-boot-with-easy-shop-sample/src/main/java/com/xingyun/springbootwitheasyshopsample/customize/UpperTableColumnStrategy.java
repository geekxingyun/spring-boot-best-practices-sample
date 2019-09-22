package com.xingyun.springbootwitheasyshopsample.customize;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

/**
 * @author 星云
 * @功能 将数据库表和字段全部大写
 * @date 9/22/2019 10:25 AM
 */
public class UpperTableColumnStrategy extends PhysicalNamingStrategyStandardImpl {
    @Override
    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
        String tableName=name.getText().toUpperCase().trim();
        return Identifier.toIdentifier(tableName);
    }

    @Override
    public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment context) {
        String columnName=name.getText().toUpperCase().trim();
        return Identifier.toIdentifier(columnName);
    }
}
