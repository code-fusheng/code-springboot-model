package xyz.fusheng.code.springboot.model.learn.类型.Json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @FileName: String2JsonTest
 * @Author: code-fusheng
 * @Date: 2022/11/22 00:43
 * @Version: 1.0
 * @Description:
 */

public class String2JsonTest {

    private static String str = "{\"userDetails\":[{\"sort\":1,\"label\":\"姓名: \",\"value\":\"张浩\",\"style\":\"fontSize: 24px\"},{\"sort\":2,\"label\":\"生日: \",\"value\":\"1998-12-18\"},{\"sort\":3,\"label\":\"籍贯: \",\"value\":\"湖南 长沙\"},{\"sort\":4,\"label\":\"电话: \",\"value\":\"15115726712\"},{\"sort\":5,\"label\":\"邮箱: \",\"value\":\"2561035977@qq.com\"}],\"personalHoners\":[{\"sort\":1,\"time\":\"2017年\",\"honer\":\"新生军训“优秀学员”称号\"},{\"sort\":2,\"time\":\"2017年\",\"honer\":\"湖南百公里“百里毅行”证书\"},{\"sort\":3,\"time\":\"2018年\",\"honer\":\"长沙望城国际铁人三项赛志愿者证书\"},{\"sort\":4,\"time\":\"2018年\",\"honer\":\"桃源招生团队“优秀个人”称号\"},{\"sort\":5,\"time\":\"2019年\",\"honer\":\"全国计算机水平等级考试二级合格证\"},{\"sort\":6,\"time\":\"2020年\",\"honer\":\"软考中级“软件设计师“资格证\"},{\"sort\":7,\"time\":\"2020年\",\"honer\":\"软件卓越人才班“优秀学员”称号\"},{\"sort\":8,\"time\":\"2021年\",\"honer\":\"湖南信息学院“优秀毕业生”称号\"}],\"skillStacks\":[{\"sort\":1,\"level\":\"擅长\",\"skill\":\" Java \",\"desc\":\"、5年 Java 编程开发经验，熟练使用线程、并发、集合、反射以及各类工具；\"},{\"sort\":2,\"level\":\"擅长\",\"skill\":\" Mysql \",\"desc\":\"、丰富的中小型项目需求分析、库表设计、SQL 优化实践经验；\"},{\"sort\":3,\"level\":\"擅长\",\"skill\":\" Spring Cloud \",\"desc\":\"、丰富的项目开发实践经验，熟悉各类组件；\"},{\"sort\":4,\"level\":\"擅长\",\"skill\":\" Elaticsearch \",\"desc\":\"、丰富的 ES 业务实践经验，熟悉原理与场景应用；\"},{\"sort\":5,\"level\":\"熟悉\",\"skill\":\" MQ \",\"desc\":\"、具备 RocketMQ、RabbitMQ 消息中间件实践经验，做过技术调研，理解底层实现；\"},{\"sort\":6,\"level\":\"熟悉\",\"skill\":\" Netty、WebSocket \",\"desc\":\"、具备开发案件协同编辑页的经验与能力；\"},{\"sort\":7,\"level\":\"熟悉\",\"skill\":\" Redis、Redisson \",\"desc\":\"、丰富的缓存与分布式锁使用经验，尤其在支付场景使用颇多；\"},{\"sort\":8,\"level\":\"熟悉\",\"skill\":\" Vue、React、Js、Nuxt、Node.js \",\"desc\":\"、扎实的前端基础、具备前端开发能力与一定的开发经验；\"},{\"sort\":9,\"level\":\"熟悉\",\"skill\":\" Element、AntD、Echarts \",\"desc\":\"、对于前端 UI 框架有一定的使用经验；\"},{\"sort\":10,\"level\":\"熟悉\",\"skill\":\" Linux \",\"desc\":\"、具备一定的 CentOS 系统开发、环境搭建、安全运维经验，熟悉常用脚本的编写使用；\"},{\"sort\":11,\"level\":\"熟悉\",\"skill\":\" Docker、K8S \",\"desc\":\"、对云原生技术栈有一定的理解和实践经验；\"},{\"sort\":12,\"level\":\"熟悉\",\"skill\":\" Jenkins、Gitlab、Nginx \",\"desc\":\"、有一定的搭建 CI/DC 自动化运维持续集成技术能力与经验；\"},{\"sort\":13,\"level\":\"了解\",\"skill\":\" MongoDB、FreeMarker、Poi、Promethenus、NFS、Harbor、RPC、Drools ...； \"},{\"sort\":14,\"level\":\"了解\",\"desc\":\" 企服行业知识，包括但不限于：工商注册、知识产权、财务会计、资质政策，并熟悉相应业务系统开发；\"},{\"sort\":15,\"level\":\"具备\",\"desc\":\" 市场调研、技术选型、需求分析、原型设计、团队项目、项目管理、产品培训等能力有一定实践经验； \"},{\"sort\":16,\"level\":\"具备\",\"desc\":\" 计算机、经济、会计、社会心理、管理等诸多领域知识； \"}],\"eduExperiences\":[{\"sort\":1,\"date\":\"2017.09 ~ 2021.07\",\"school\":\"湖南信息学院\",\"class\":\"计算机科学与工程学院\",\"software\":\"软件工程\"}],\"workExperiences\":[{\"sort\":1,\"date\":\"2020.10.18 ~ 至今\",\"company\":\"湖南汉岳数字科技有限公司\",\"department\":\"用户产品研发部\",\"job\":\"Java开发工程师\",\"responsibility\":\"伙伴平台项目负责人、BOSS支付与清算系统项目交接负责人、政府营商云平台核心开发。\",\"details\":[\"负责公司伙伴平台项目的协调产品需求分析确认、库表设计以及项目核心功能的架构设计实现与生产维护；\",\"负责公司支付系统迭代开发与日常维护；\"]}],\"projectExperiences\":[{\"sort\":1,\"date\":\"2022.03.10 ~ 至今\",\"name\":\"个人论坛\",\"duty\":\"Owner\",\"desc\":\"项目描述\",\"details\":[\"主要内容开发为 2020年 ~ 2021年;\",\"后期主要用于技术探索实践与知识备忘。\"],\"refLinks\":[{\"label\":\"个人工程技术笔记主页:\",\"link\":\"http://fusheng.xyz\"}]}]}";

    public static void main(String[] args) {
        JSON.parseObject(str, JSONObject.class);
    }

}
