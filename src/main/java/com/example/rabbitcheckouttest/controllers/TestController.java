package com.example.rabbitcheckouttest.controllers;

//import com.xventure.xapi.libs.email.model.GenericNotification;
import com.xventure.xapi.libs.notification.Rabbitmq.QueueConfiguration;
import com.xventure.xapi.libs.notification.model.ChannelSelector;
import com.xventure.xapi.libs.notification.model.GenericNotification;
import com.xventure.xapi.libs.notification.model.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    private RabbitTemplate template;

    @PostMapping(value = "/")
    public String sendMessage(@RequestBody List<GenericNotification> notification){
//        List<User>  usersList = new LinkedList<>();
//        usersList.add(new User("userId","orgId"));

//        List<GenericNotification> collect = notification.stream().map(noti ->
//                        new GenericNotification(
//                                noti.getChannelSelector(),
//                                noti.getTemplateName(),
//                                noti.getDataMap(),
//                                noti.getMetaData(),
//                                usersList,
//                                null,
//                                null)).
//                collect(Collectors.toList());
//
//        GenericNotification genericNotification = new GenericNotification();
//        genericNotification.setChannelSelector(ChannelSelector.EMAIL.getMessage());
//        genericNotification.setTemplateName("template:email-forget-password"); // replace with suitable name
//
//        User user1 = new User();
//        user1.setEmail("reshmikaediriweera1997@gmail.com");
//        List<User> users = new LinkedList<>();
//        users.add(user1);
//        genericNotification.setUsers(users);
//
//        Map<String, String> metaData = new HashMap<>();
//        metaData.put("subject","your subject"); // this is mandatory.
//
//        Map<String, String> dataMap = new HashMap<>();
//        dataMap.put("changePassLink","https://www.vectorstock.com/royalty-free-vector/facebook-logo-icon-vector-27990381"); // replace the link with your reset link
//        dataMap.put("images3","https://www.vectorstock.com/royalty-free-vector/facebook-logo-icon-vector-27990381"); // may be change or remove
//        dataMap.put("firstName","Sahan"); // may be change or remove
//        dataMap.put("images2","https://www.google.com/"); // may be change or remove
//        dataMap.put("images1","https://www.google.com/"); // may be change or remove
//        genericNotification.setDataMap(dataMap);
//
//        List<GenericNotification> genericNotifications=new LinkedList<>();
//        genericNotifications.add(genericNotification);

//        template.convertAndSend("notification-exchange", "send-notification", genericNotifications);



        template.convertAndSend(QueueConfiguration.EXCHANGE_PRODUCT,QueueConfiguration.ROUTING_KEY_PRODUCT,notification);
        return "message sent";
    }

}
