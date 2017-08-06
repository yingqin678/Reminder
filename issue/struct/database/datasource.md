#数据表

> jdbc.properties 保存数据库连接信息

###item相关

##### 配置文件
>* dairy.spring.service.xml
>* ItemMapper.xml

##### 数据表

###### 1. item表

    /*
    Navicat MySQL Data Transfer
    
    Source Server         : localhost
    Source Server Version : 50718
    Source Host           : localhost:3306
    Source Database       : mysql
    
    Target Server Type    : MYSQL
    Target Server Version : 50718
    File Encoding         : 65001
    
    Date: 2017-08-06 17:45:39
    */
    
    SET FOREIGN_KEY_CHECKS=0;
    
    -- ----------------------------
    -- Table structure for item
    -- ----------------------------
    DROP TABLE IF EXISTS `item`;
    CREATE TABLE `item` (
      `id` int(11) NOT NULL AUTO_INCREMENT,
      `content` varchar(255) NOT NULL,
      `deadTime` bigint(15) NOT NULL,
      `result` int(15) NOT NULL,
      `levelValue` int(11) NOT NULL,
      `type` int(2) NOT NULL,
      `ip` varchar(255) NOT NULL,
      PRIMARY KEY (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

###### 2. ipid表

    /*
    Navicat MySQL Data Transfer
    
    Source Server         : localhost
    Source Server Version : 50718
    Source Host           : localhost:3306
    Source Database       : mysql
    
    Target Server Type    : MYSQL
    Target Server Version : 50718
    File Encoding         : 65001
    
    Date: 2017-08-06 17:46:46
    */
    
    SET FOREIGN_KEY_CHECKS=0;
    
    -- ----------------------------
    -- Table structure for ipid
    -- ----------------------------
    DROP TABLE IF EXISTS `ipid`;
    CREATE TABLE `ipid` (
      `ip` varchar(255) NOT NULL,
      `name` varchar(255) NOT NULL
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
