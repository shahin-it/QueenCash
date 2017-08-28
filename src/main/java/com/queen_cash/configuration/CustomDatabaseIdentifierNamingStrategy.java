package com.queen_cash.configuration;

import com.queen_cash.util.StringUtil;
import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy;

import java.io.Serializable;

public class CustomDatabaseIdentifierNamingStrategy extends SpringPhysicalNamingStrategy implements Serializable {
    @Override
    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
        return name.toIdentifier(StringUtil.toUnderScoreCase(name.getText()).toLowerCase(), name.isQuoted());
    }

    @Override
    public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment context) {
        return name.toIdentifier(StringUtil.toUnderScoreCase(name.getText()).toLowerCase(), name.isQuoted());
    }
}
