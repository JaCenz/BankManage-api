# BankManage-api
Springboot+Mybatis+Oracle+Mybatis-generator搭建的银行管理HelloWorld项目


## 项目使用步骤
### 注意ORACLE数据库表名，字段名使用大写。我虽然在generatorConfig2.xml中配置了关键字加引号但是并不能起作用，所以数据库全部使用大写。
* 下载项目到本地
* 将/src/main/rescources/config/ojdbc6.jar 拷贝到本地任何一个文件夹中
* 打开cmd运行命令 mvn install:install-file -DgroupId=com.oracle -DartifactId=ojdbc6 -Dversion=11.2.0.1.0 -Dpackaging=jar -Dfile=拷贝路径\ojdbc6.jar
* 如果mvn install命令未安装可以将/src/main/rescources/config/maven 中的三个文件拷贝到C:\Users\JaCen\.m2\repository\com\oracle\ojdbc6\11.2.0.1.0文件夹下面即可运行
* （如果直接运行我的项目可以省略）修改generatorConfig2.xml 中数据库的配置信息和odbc6.jar包的位置
* 修改application.properties文件连接数据库配置
* 在navicat中执行/src/main/rescources/config/TEST3.sql 文件建表
* 运行
