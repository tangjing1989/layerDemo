package com.tangjing.drools;


import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;


/**
 * Describe:
 * User:tangjing
 * Date:2017/3/31
 * Time:下午4:17
 */
@Service
public class Test {
    public  void test(){
        //从工厂中获得KieServices实例
        KieServices kieServices = KieServices.Factory.get();
        //从KieServices中获得KieContainer实例，其会加载kmodule.xml文件并load规则文件
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        //建立KieSession到规则文件的通信管道
        KieSession kSession = kieContainer.newKieSession("ksession-rules");

        Message    message  = new Message();
        message.setMessage("Hello World");
        message.setStatus(Message.HELLO);
        //将实体类插入执行规则
        kSession.insert(message);
        kSession.fireAllRules();
        System.out.println("执行过了");
    }



//        public  void test() {
//
//            String rule = "package com.tangjing\r\n";
//            rule += "import com.tangjing.drools.Message;\r\n";
//            rule += "rule \"rule1\"\r\n";
//            rule += "\twhen\r\n";
//            rule += " eval(true)";
//            rule += "\tthen\r\n";
//            rule += "\t\tSystem.out.println( \":---------------------\");\r\n";
//            rule += "end\r\n";
//
//
//            String rule2 = "package com.tangjing\r\n";
//            rule += "import com.tangjing.drools.Message;\r\n";
//
//            rule += "rule \"rule2\"\r\n";
//            rule += "\twhen\r\n";
//            rule += "Message( status == 2, myMessage : msg )";
//            rule += "\tthen\r\n";
//            rule += "\t\tSystem.out.println( 2+\":\"+myMessage );\r\n";
//            rule += "end\r\n";
//
//
//            StatefulKnowledgeSession kSession = null;
//            try {
//
//
//                KnowledgeBuilder kb = KnowledgeBuilderFactory.newKnowledgeBuilder();
//                //装入规则，可以装入多个
//                kb.add(ResourceFactory.newByteArrayResource(rule.getBytes("utf-8")), ResourceType.DRL);
//               // kb.add(ResourceFactory.newByteArrayResource(rule2.getBytes("utf-8")), ResourceType.DRL);
//
//                KnowledgeBuilderErrors errors = kb.getErrors();
//                for (KnowledgeBuilderError error : errors) {
//                    System.out.println(error);
//                }
//                KnowledgeBase kBase = KnowledgeBaseFactory.newKnowledgeBase();
//                kBase.addKnowledgePackages(kb.getKnowledgePackages());
//
//                kSession = kBase.newStatefulKnowledgeSession();
//
//
//                Message message1 = new Message();
//                message1.setStatus(1);
//                message1.setMsg("hello world!");
//
//                Message message2 = new Message();
//                message2.setStatus(2);
//                message2.setMsg("hi world!");
//
//                kSession.insert(message1);
//                kSession.insert(message2);
//                System.out.println("==============开始================");
//                kSession.fireAllRules();
//                System.out.println("==============结束================");
//
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            } finally {
//                if (kSession != null)
//                    kSession.dispose();
//            }
//
//    }
}
