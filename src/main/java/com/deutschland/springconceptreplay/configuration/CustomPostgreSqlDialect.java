package com.deutschland.springconceptreplay.configuration;

import org.hibernate.dialect.PostgreSQL94Dialect;
import org.hibernate.type.descriptor.sql.SqlTypeDescriptor;
import org.hibernate.type.descriptor.sql.VarcharTypeDescriptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Types;

public class CustomPostgreSqlDialect extends PostgreSQL94Dialect {

    @Override
    public SqlTypeDescriptor remapSqlTypeDescriptor(SqlTypeDescriptor sqlTypeDescriptor)
    {
        switch (sqlTypeDescriptor.getSqlType())
        {
            case Types.CLOB:
                return VarcharTypeDescriptor.INSTANCE;
            case Types.BLOB:
                return VarcharTypeDescriptor.INSTANCE;
        }
        return super.remapSqlTypeDescriptor(sqlTypeDescriptor);
    }
    public CustomPostgreSqlDialect() {
        super();
        registerHibernateType(1111, "string");
    }}
