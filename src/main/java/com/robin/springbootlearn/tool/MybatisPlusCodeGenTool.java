package com.robin.springbootlearn.tool;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.robin.springbootlearn.common.entity.SuperEntity;

/**
 * MyBatis-Plus 代码生成器；
 * 可以快速生成 Entity、Mapper、Mapper XML、Service、Controller 等各个模块的代码，极大的提升了开发效率
 *
 * @author robin
 * @version v0.0.1
 * @since 2020-04-06 15:18
 */
public class MybatisPlusCodeGenTool {

    // 数据源配置
    private static final String dbUrl = "jdbc:mysql://127.0.0.1:3306/sso?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai";
    private static final String driverName = "com.mysql.cj.jdbc.Driver";
    private static final String schemaName = "sso";
    private static final String userName = "root";
    private static final String passWord = "robin1216";

    // 作者
    private static final String authorName = "robin";

    // 父包名
    private static final String parentPackage = "com.robin.springbootlearn.app";

    // 子模块路径 如 /test-module
//    private static final String subModule = "/test-module";
    private static final String subModule = "";

    // 策略配置
    private static final String tablePrefix = "t_";
    private static final String fieldPrefix = "f_";
    private static final String[] includeTableNames = {"t_user"};

    public static void main(String[] args) {
        System.out.println("代码生成器 启动...");

        // 生成实体 覆盖
        genCode(true, true, false, false,false, false);
        // 生成其他层 不覆盖
        genCode(false, false, true, true,true, true);

        System.out.println("代码生成器 结束！！！");
    }

    public static void genCode(boolean isOverWrite, boolean needGenEntity, boolean needGenMapper, boolean needGenMapXml,
                               boolean needGenService, boolean needGenServiceImpl) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = getGlobalConfig(authorName, subModule, isOverWrite);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = getDataSourceConfig(dbUrl, driverName, schemaName, userName, passWord);
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = getPackageConfig(parentPackage);
        mpg.setPackageInfo(pc);

        // 自定义配置
//        InjectionConfig cfg = getInjectionConfig();
//        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = getTemplateConfig(needGenEntity, needGenMapper, needGenMapXml, needGenService, needGenServiceImpl);
        mpg.setTemplate(templateConfig);

        // 策略配置
        final String superEntityClass = "com.robin.springbootlearn.common.entity.SuperEntity";
        final String superMapperClass = "com.robin.springbootlearn.common.mapper.SuperMapper";
        final String superServiceClass = "com.robin.springbootlearn.common.service.SuperService";
        final String superServiceImplClass = "com.robin.springbootlearn.common.service.SuperServiceImpl";
        final String superControllerClass = "com.robin.springbootlearn.common.controller.SuperController";
        final String versionFieldName = SuperEntity.VERSION;
        final String logicDeleteFieldName = SuperEntity.DELETED;
        final String[] superEntityColumns = {SuperEntity.ID, SuperEntity.VERSION, SuperEntity.CREATED_AT, SuperEntity.CREATED_BY_ID, SuperEntity.CREATED_BY_NAME,
                SuperEntity.LAST_UPDATED_AT, SuperEntity.LAST_UPDATED_BY_ID, SuperEntity.LAST_UPDATED_BY_ID, SuperEntity.LAST_UPDATED_BY_NAME, SuperEntity.DELETED};

        StrategyConfig strategy = getStrategyConfig(tablePrefix, fieldPrefix, superEntityClass, superMapperClass, superServiceClass,
                superServiceImplClass, superEntityColumns, includeTableNames, versionFieldName, logicDeleteFieldName);

        mpg.setStrategy(strategy);

        // 模版引擎
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());

        // 执行代码生成器
        mpg.execute();
    }


    // 全局配置

    /**
     * 全局策略配置
     *
     * @param author      作者
     * @param subModule   子模块路径
     * @param isOverWrite 是否覆盖已有文件；默认 false 不覆盖
     * @return GlobalConfig
     */
    public static GlobalConfig getGlobalConfig(String author, String subModule, boolean isOverWrite) {
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");  // 获得程序当前路径
        gc.setOutputDir(projectPath + subModule + "/src/main/java"); // 生成文件的输出目录; 默认值：D 盘根目录
        gc.setAuthor(author);  // 开发人员; 默认值：null
        gc.setOpen(false); // 是否打开输出目录; 默认值：true
        gc.setFileOverride(isOverWrite);  // 是否覆盖已有文件; 默认值：false
        gc.setEntityName("%sEntity");  // 实体命名方式; 默认值：null
        gc.setMapperName("%sMapper");  // mapper 命名方式; 默认值：null
        gc.setServiceName("%sService");  // service 命名方式; 默认值：null
        gc.setServiceImplName("%sServiceImpl");  // service impl 命名方式; 默认值：null

//        gc.setXmlName("%sDao");  // Mapper xml 命名方式; 默认值：null
//        gc.setControllerName("%sController");  // controller 命名方式; 默认值：null
//        gc.setIdType(IdType.AUTO);  // 指定生成的主键的ID类型; 默认值：null
//
//        gc.setEnableCache(false);  // 是否在xml中添加二级缓存配置; 默认值：`false
//        gc.setKotlin(false);  // 开启 Kotlin 模式; 默认值：false
//        gc.setSwagger2(true); // 开启 swagger2 模式; 默认值：false
//        gc.setActiveRecord(false);  // 开启 ActiveRecord 模式; 默认值：false
//        gc.setBaseResultMap(false);  // 开启 BaseResultMap; 默认值：false
//        gc.setBaseColumnList(false);  // 开启 baseColumnList; 默认值：false
//        gc.setDateType(DateType.TIME_PACK);  // 时间类型对应策略; 默认值：TIME_PACK, 使用 java.time 包下的

        return gc;
    }

    private static DataSourceConfig getDataSourceConfig(String dbUrl, String driverName, String schemaName, String userName, String passWord) {

        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(dbUrl); // 驱动连接的URL
        dsc.setDriverName(driverName);  // 驱动名称
        dsc.setSchemaName(schemaName); // 数据库 schema name
        dsc.setUsername(userName);  // 数据库连接用户名
        dsc.setPassword(passWord);  // 数据库连接密码

//        dsc.setDbType(DbType.MYSQL);  // 数据库类型
//        dsc.setDbQuery();  // 数据库信息查询类; 默认由 dbType 类型决定选择对应数据库内置，实现实现 IDbQuery 接口自定义数据库查询 SQL 语句 定制化返回自己需要的内容
//        dsc.setTypeConvert();  // 类型转换; 默认由 dbType 类型决定选择对应数据库内置实现，实现 ITypeConvert 接口自定义数据库 字段类型 转换为自己需要的 java 类型，内置转换类型无法满足可实现 IColumnType 接口自定义

        return dsc;
    }

    /**
     * 包名配置，通过该配置，指定生成代码的包路径
     *
     * @param parentPackage 父包名
     * @return PackageConfig
     */
    private static PackageConfig getPackageConfig(String parentPackage) {
        PackageConfig pc = new PackageConfig();

        pc.setParent(parentPackage);  // 父包名。如果为空，将下面子包名必须写全部， 否则就只需写子包名

//        pc.setModuleName();  // 父包模块名
//        pc.setEntity();  // Entity包名
//        pc.setService();  // Service包名
//        pc.setServiceImpl();  // Service Impl包名
//        pc.setMapper();  // Mapper包名
//        pc.setXml();  // Mapper XML包名
//        pc.setController();  // Controller包名
//        pc.setPathInfo();  // 路径配置信息

        return pc;
    }

    // 注入配置，通过该配置，可注入自定义参数等操作以实现个性化操作
    private static InjectionConfig getInjectionConfig() {
        InjectionConfig cfg = new InjectionConfig() {

            // 注入自定义 Map 对象(注意需要setMap放进去)
            @Override
            public void initMap() {
                // to do nothing
            }
        };

/*
        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();

        // 自定义配置会被优先输出
        String templatePath = "/templates/mapper.xml.ftl";  // 如果模板引擎是 freemarker
        // String templatePath = "/templates/mapper.xml.vm";   // 如果模板引擎是 velocity
        String projectPath = System.getProperty("user.dir");  // 获得程序当前路径
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/" + moduleName
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);  // 自定义输出文件; 配置 FileOutConfig 指定模板文件、输出文件达到自定义文件生成目的
*/

        /*
        // 自定义判断是否创建文件; 实现 IFileCreate 接口; 该配置用于判断某个类是否需要覆盖创建，当然你可以自己实现差异算法 merge 文件
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir("调用默认方法创建的目录");
                return false;
            }
        });
        */


        return cfg;
    }

    /**
     * 模板配置，可自定义代码生成的模板，实现个性化操作
     *
     * @param needGenEntity      是否生成 Java 实体类模板
     * @param needGenMapper      是否生成 mapper 模板
     * @param needGenMapXml      是否生成 mapper xml 模板
     * @param needGenService     是否生成 service 模板
     * @param needGenServiceImpl 是否生成 service Impl 模板
     * @return TemplateConfig
     */
    private static TemplateConfig getTemplateConfig(boolean needGenEntity, boolean needGenMapper, boolean needGenMapXml,
                                                    boolean needGenService, boolean needGenServiceImpl) {

        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别

        if (!needGenEntity) {
            templateConfig.setEntity(null);  // Java 实体类模板
        }

        if (!needGenMapper) {
            templateConfig.setMapper(null);  // mapper 模板
        }

        if (!needGenMapXml) {
            templateConfig.setXml(null);  // mapper xml 模板
        }

        if (!needGenService) {
            templateConfig.setService(null);  // Service 类模板
        }

        if (!needGenServiceImpl) {
            templateConfig.setServiceImpl(null);  // Service impl 实现类模板
        }

        //不自动生成controller层代码，防止覆盖已有代码
        templateConfig.setController(null);  // controller 控制器模板

//        templateConfig.setEntityKt();  // Kotin 实体类模板

        return templateConfig;
    }

    /**
     * 数据库表配置，通过该配置，可指定需要生成哪些表或者排除哪些表
     *
     * @param tablePrefix           表前缀
     * @param fieldPrefix           字段前缀
     * @param superEntityClass      自定义继承的Entity类全称，带包名
     * @param superMapperClass      自定义继承的Mapper类全称，带包名
     * @param superServiceClass     自定义继承的Mapper类全称，带包名
     * @param superServiceImplClass 自定义继承的ServiceImpl类全称，带包名
     * @param superEntityColumns    自定义基础的Entity类，公共字段
     * @param includeTableNames     需要包含的表名，允许正则表达式（与exclude二选一配置）; 多个英文逗号分割
     * @param versionFieldName      乐观锁属性名称
     * @param logicDeleteFieldName  逻辑删除属性名称
     * @return StrategyConfig
     */
    private static StrategyConfig getStrategyConfig(String tablePrefix, String fieldPrefix, String superEntityClass, String superMapperClass,
                                                    String superServiceClass, String superServiceImplClass, String[] superEntityColumns,
                                                    String[] includeTableNames, String versionFieldName, String logicDeleteFieldName) {

        StrategyConfig strategy = new StrategyConfig();

//        strategy.setCapitalMode(false);  // 是否大写命名
//        strategy.setSkipView(false);  // 是否跳过视图
        strategy.setTablePrefix(tablePrefix); // 表前缀
        strategy.setFieldPrefix(fieldPrefix);  // 字段前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);  // 数据库表映射到实体的命名策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);  // 数据库表字段映射到实体的命名策略, 未指定按照 naming 执行
        strategy.setInclude(includeTableNames);  // 需要包含的表名，允许正则表达式（与exclude二选一配置）; 多个英文逗号分割
//        strategy.setExclude(excludeTableNames);  // 需要排除的表名，允许正则表达式; 多个英文逗号分割

        // 公共父类
        strategy.setSuperEntityClass(superEntityClass);  // 自定义继承的Entity类全称，带包名
        strategy.setSuperEntityColumns(superEntityColumns);  // 自定义基础的Entity类，公共字段
        strategy.setSuperMapperClass(superMapperClass);  // 自定义继承的Mapper类全称，带包名
        strategy.setSuperServiceClass(superServiceClass);  // 自定义继承的Service类全称，带包名
        strategy.setSuperServiceImplClass(superServiceImplClass);  // 自定义继承的ServiceImpl类全称，带包名
//        strategy.setSuperControllerClass(superControllerClass);  // 自定义继承的Controller类全称，带包名

        strategy.setEntityColumnConstant(true);  // 【实体】是否生成字段常量（默认 false）
        strategy.setEntityBuilderModel(true);  // 【实体】是否为构建者模型（默认 false）
        strategy.setEntityLombokModel(true);  // 【实体】是否为lombok模型（默认 false）
//        strategy.setEntityBooleanColumnRemoveIsPrefix(false);  // Boolean类型字段是否移除is前缀（默认 false）
        strategy.setRestControllerStyle(true);  // 生成 @RestController 控制器
        strategy.setControllerMappingHyphenStyle(true);  // 驼峰转连字符
        strategy.setEntityTableFieldAnnotationEnable(true);  // 是否生成实体时，生成字段注解
        strategy.setVersionFieldName(versionFieldName);  // 乐观锁属性名称
        strategy.setLogicDeleteFieldName(logicDeleteFieldName);  // 逻辑删除属性名称
//        strategy.setTableFillList();  // 表填充字段

        return strategy;
    }

}