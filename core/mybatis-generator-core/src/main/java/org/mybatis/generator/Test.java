package org.mybatis.generator;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.*;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) throws InvalidConfigurationException, InterruptedException, SQLException, IOException {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        Configuration config = new Configuration();

        //   ... fill out the config object as appropriate...
        Context context = new Context(ModelType.CONDITIONAL);
        context.setTargetRuntime("MyBatis3");
        JDBCConnectionConfiguration jdbcConnectionConfiguration = new JDBCConnectionConfiguration();
        jdbcConnectionConfiguration.setConnectionURL("jdbc:mysql://b.yedaoholding.com:3306/test?characterEncoding=utf-8");
        jdbcConnectionConfiguration.setDriverClass("com.mysql.jdbc.Driver");
        jdbcConnectionConfiguration.setUserId("root");
        jdbcConnectionConfiguration.setPassword("mode2019");
        context.setJdbcConnectionConfiguration(jdbcConnectionConfiguration);
        JavaTypeResolverConfiguration javaTypeResolverConfiguration = new JavaTypeResolverConfiguration();
        javaTypeResolverConfiguration.addProperty("forceBigDecimals","false");
        context.setJavaTypeResolverConfiguration(javaTypeResolverConfiguration);
        JavaModelGeneratorConfiguration javaModelGeneratorConfiguration = new JavaModelGeneratorConfiguration();
        javaModelGeneratorConfiguration.setTargetPackage("com.kamajia.test");
        javaModelGeneratorConfiguration.setTargetProject("src\\gene\\model\\");
        javaModelGeneratorConfiguration.addProperty("enableSubPackages","true'");
        context.setJavaModelGeneratorConfiguration(javaModelGeneratorConfiguration);

        SqlMapGeneratorConfiguration sqlMapGeneratorConfiguration = new SqlMapGeneratorConfiguration();
        sqlMapGeneratorConfiguration.setTargetPackage("com.kamajia.test");
        sqlMapGeneratorConfiguration.setTargetProject("src\\gene\\mapper\\");
        sqlMapGeneratorConfiguration.addProperty("enableSubPackages","true'");
        context.setSqlMapGeneratorConfiguration(sqlMapGeneratorConfiguration);
        JavaClientGeneratorConfiguration javaClientGeneratorConfiguration = new JavaClientGeneratorConfiguration();
        javaClientGeneratorConfiguration.setTargetPackage("com.kamajia.test");
        javaClientGeneratorConfiguration.setConfigurationType("XMLMAPPER");
        javaClientGeneratorConfiguration.setTargetProject("src\\gene\\dao\\");
        javaClientGeneratorConfiguration.addProperty("enableSubPackages","true'");
        context.setJavaClientGeneratorConfiguration(javaClientGeneratorConfiguration);
        context.setId("mysql");
        TableConfiguration tableConfiguration =new TableConfiguration(context);
        tableConfiguration.setCatalog("test");
        tableConfiguration.setTableName("t_shopify_order");
        tableConfiguration.setDomainObjectName("ShopifyOrder");
        context.addTableConfiguration(tableConfiguration);
        config.addContext(context);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }
}
