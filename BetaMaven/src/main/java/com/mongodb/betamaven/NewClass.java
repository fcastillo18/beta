/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mongodb.betamaven;

import freemarker.template.Configuration;
import freemarker.template.Template;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author Franklin
 */
public class NewClass {
    
    public static void main(String[] args){
//        Spark.get("/", new Route() {  //   <========  modification
//            public Object handle(Request request, Response response) throws Exception {
//                return "Hello world from Spark";
//            }
//        });
        
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);

        configuration.setClassForTemplateLoading(
                NewClass.class, "/");

        try {
            Template helloTemplate = configuration.getTemplate("hello.ftl");
            StringWriter writer = new StringWriter();
            Map<String, Object> helloMap = new HashMap<String, Object>();
            helloMap.put("name", "Freemarker");

            helloTemplate.process(helloMap, writer);

            System.out.println(writer);

        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


    }
}


