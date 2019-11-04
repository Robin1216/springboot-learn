[toc]

# springboot-learn
springboot 单体样板工程搭建

***任务***  
 1. 创建合理的项目目录结构,对各目录进行诠释  
 2. 统一编程格式、样式等，参考《阿里巴巴 Java 开发手册》，制作统一的 idea 模板
 3. 整理通用工具类
 4. 实现常用 组件 框架 的使用示例
 
##  项目目录结构  
采用分层的形式，遵循“高内聚，低耦合”的原则，行使各层次的职责

    ``
    Java 目录结构
    |- gateway 网关服务，主要实现对请求的认证拦截
        |- egress 当前应用返回结果给外部请求
        |- ingress 外部请求进入当前应用
    |- app 应用
        |- controller 控制层；只管接收用户的请求，不会涉及太多的业务处理操作，可以实现对入参大小/非空/特殊字符、访问权限等初步校验，但凡涉及到业务处理，就交给service层来操作。
        |- service 业务服务层；对外暴露的服务接口，要在接口方法上方用 javadoc 注释、除了返回值、参数、异常说明外，还必须指出该方法做什么事情，实现什么功能，如有实现和调用注意事项，请一并说明如有实现和调用注意事项，请一并说明。
            |- serviceImpl 服务接口的主要逻辑实现；主要用来处理一些业务逻辑，不做任何的数据库操作，数据库的操作都交给dao层来做；除了重写的方法为 public，其他方法一般均要设置为 private 
        |- dao 数据库操作层；主要实现与数据的交互
        |- pojo 主要用到的 bean 类，按照分层领域模型规约，一般分为如下几种：
            |- DO（Data Object）：与数据库表结构一一对应，通过 DAO 层向上传输数据源对象。  
            |- DTO（Data Transfer Object）：数据传输对象，Service 和 Manager 向外传输的对象。   
            |- BO（Business Object）：业务对象。可以由 Service 层输出的封装业务逻辑的对象。   
            |- QUERY：数据查询对象，各层接收上层的查询请求。注：超过 2 个参数的查询封装，禁止使用 Map 类来传输。  
            |- VO（View Object）：显示层对象，通常是 Web 向模板渲染引擎层传输的对象。
        |- entity 数据库表接口实体，与 pojo 的 do 数据，这里建议 舍去  pojo 的 do 目录结构
        |- enum 业务枚举值
        |- constant 业务使用的常量
        |- task 定时任务，非即时的服务实现
        |- config 配置相关的类，这里建议 可放到 common 下的中间件服务中去
    |- common 通用功能
    |- utils 常用的工具类
    |- manager 通用业务处理层，它有如下特征：
       1） 对第三方平台封装的层，预处理返回结果及转化异常信息；
       2） 对 Service 层通用能力的下沉，如缓存方案、中间件通用处理；
       3） 与 DAO 层交互，对 DAO 的业务通用能力的封装。
    
    resources 目录结构
    |- db 主要是数据库相关的文件；如 sql 程序不执行，仅作存档用
    |- db mybatis 的 mapper.xml 文件集合，实现实体对数据表的映射
    |- config 配置文件
    |- application.yml 主要配置文件，通用配置
    |- application-dev.yml  开发环境配置
    |- application-test.yml 测试环境配置
    |- application-pro.yml  生产环境配置
    
    ``


## 编码格式  
- 项目全局设置为 utf-8 格式  
  IDEA 中设置方式：File -> Settings -> Editor -> File encodings -> gold encoding 及 project encoding 均设置为 utf-8 
- tab 键改成 4 个空格 
  IDEA 中设置方式：Editor ->Code Style -> java(如果使用的是其他编程语言请选择其他语言) -> 不要勾选Use tab character -> Indent设置为4（表示按一下tab键代表4个空格）
- 文件注释规约  
  - 类、类属性、类方法的注释必须使用 javadoc 规范，使用/**内容*/格式，不得使用 //xxx 方式。
  - 所有的抽象方法（包括接口中的方法）必须要用 javadoc 注释、除了返回值、参数、异常说明外，还必须指出该方法做什么事情，实现什么功能。如有实现和调用注意事项，请一并说明。
  - 所有的类都必须添加创建者信息。
  - 方法内部单行注释，在被注释语句上方另起一行，使用//注释。方法内部多行注释使用/* */注释，注意与代码对齐。
  - 所有的枚举类型字段必须要有注释，说明每个数据项的用途。
  - 代码修改的同时，注释也要进行相应的修改，尤其是参数、返回值、异常、核心逻辑等的修改。
  - 特殊注释标记，请注明标记人与标记时间。待办事宜（TODO）:（ 标记人，标记时间，[预计处理时间]），在必要的时候进行注解，实现后及时清除
```
    idea 中设置通用的 文件头 file -> settings -> Editor -> -> File+and+Code+Templates -> including -> File header 添加如下内容
    /**
    * @author ${USER}
    * @Description
    * @version v0.0.1
    * @create ${YEAR}-${MONTH}-${DAY} ${TIME}
    **/
```   

## 通用工具

  
## 各业务层通用功能补充实现
  
  