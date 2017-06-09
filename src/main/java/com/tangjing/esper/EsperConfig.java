package com.tangjing.esper;



/**
 * Describe:
 * User:tangjing
 * Date:2017/4/5
 * Time:下午4:25
 */

public class EsperConfig {
//
//    /**
//     *创建生产者
//     * @return
//     */
//    public static EPServiceProvider getProvider() {
//        Configuration config = new Configuration();
//        config.addEventTypeAutoName("com.tangjing.esper.event");// 添加包路径，这样在查询表达式中就不需要写类的全路径了
//        EPServiceProvider provider = EPServiceProviderManager.getDefaultProvider(config);/* 创建引擎实例 */
//        return provider;
//    }
//
//    public static EPStatement getStatement() {
//        EPServiceProvider provider = EsperConfig.getProvider();
//        EPAdministrator   admin    = provider.getEPAdministrator();
//        /* 创建statement的管理接口实例 */
//        EPStatement statement = admin.createEPL("select id, name from TestEvent"); //创建EPL查询语句实例，功能：查询所有进入的myEvent事件
//        return statement;
//    }
//
//
//    public void getEPRuntime() {
//        EPStatement statement = EsperConfig.getStatement();
//        statement.addListener(new EsperUpdateListener());
//    }
//
//
//    /**
//     * 发送事件
//     * @param event
//     */
//    public void sendEvent(Event event) {
//        EPServiceProvider provider = EsperConfig.getProvider();
//        provider.getEPRuntime().sendEvent(event);
//    }

}
