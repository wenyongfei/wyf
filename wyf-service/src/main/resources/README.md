## 目录结构解释
1、整体目录就按照demo模式开发。不同业务只需要修改顶级
目录即可。例如会员系统。com.xfs.cart修改为com.xfs.member即可

## dao.mybatis
1、mybatis数据库访问操作。分主备访问模式。所有写操作都在master目录下面编写，
所有读库存操作，都在slave下面开发；
2、类名要和mybatis.mapper里面的映射文件一一对应；
3、目前支持注解和xml两种方式访问。因为，我们目前都是单
系统开发，名义上不允许跨系统连表操作。因此，建议用注解
方式开发，更为简洁、清晰；
## datasource
主备数据源切换类，无需修改
## httpControl
兼容目前系统的http请求，不建议使用。若确实
需要Http调用，则走xfs-cart-web服务

## service.impl
服务开发接口。主要开发在这里面进行

## spring目录
applicatiointext-*.xml
dubbo的配置文件。消费接口和服务接口都需要在这里面声明。
为了保障后期的扩展，目前建议用xml的配置方式管理。

## dubbo监控地址
http://192.168.0.53:8000
用户名：root
密码：root

