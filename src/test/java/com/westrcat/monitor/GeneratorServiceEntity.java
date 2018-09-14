package com.westrcat.monitor;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

public class GeneratorServiceEntity {

    @Test
    public void generateCode() {
        String packageName = "";
        boolean serviceNameStartWithI = false;//user -> UserService, 设置成true: user -> IUserService
        generateByTables(serviceNameStartWithI, packageName, "monitor");
    }

    private void generateByTables(boolean serviceNameStartWithI, String packageName, String... tableNames) {
        GlobalConfig config = new GlobalConfig();

        String dbUrl = "jdbc:mysql://localhost:3306/hasika";
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL);
        dataSourceConfig.setUrl(dbUrl);
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("q936611560q");
        dataSourceConfig.setDriverName("com.mysql.jdbc.Driver");
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setCapitalMode(true);
        strategyConfig.setDbColumnUnderline(true);
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setInclude(tableNames);//修改替换成你需要的表名，多个表名传数组
        config.setActiveRecord(false);
        config.setAuthor("ql");
        config.setOutputDir("/Users/ql/Documents/Java/monitor/src/main/java/com/westcatr/monitor");
        config.setFileOverride(true);
        if (!serviceNameStartWithI) {
            config.setServiceName("%sService");
        }
        AutoGenerator autoGenerator = new AutoGenerator();
        PackageConfig packageConfig = new PackageConfig();
        autoGenerator .setGlobalConfig(config);
        autoGenerator  .setDataSource(dataSourceConfig);
        autoGenerator    .setStrategy(strategyConfig);
        packageConfig .setParent(packageName);
        packageConfig .setController("controller");
        packageConfig .setEntity("entity");
        autoGenerator.setPackageInfo(packageConfig);
        autoGenerator.execute();
    }

    private void generateByTables(String packageName, String... tableNames) {
        generateByTables(true, packageName, tableNames);
    }
}
