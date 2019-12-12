# mbg-generator
mybatis插件自动生成entity、dao及对应的xml，支持自定义注释  

# 项目介绍
1. mbg-comment:自定义注释应用   
2. mbg-service:代码生成应用

# 使用
将mbg-comment应用install到本地仓库，mbg-service依赖   

1. java代码使用     
    1.1 将mbg-service应用中pom.xml，mbg-comment依赖放开  
    1.2 将mbg-service应用中generatorConfig.xml，targetProject属性加上项目名，使用targetProject="mbg-service/src/main/java"   
    1.3 执行GeneratorClient中的main方法  
2. mvn插件使用  
    2.1 在mbg-service应用中<bulid/>标签加入相关依赖，如：mbg-comment  
    2.2 idea工具maven窗口，Plugins目录下，双击mybatis-generator:generator即可  


