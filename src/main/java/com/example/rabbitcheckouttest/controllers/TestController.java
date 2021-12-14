package com.example.rabbitcheckouttest.controllers;

//import com.xventure.xapi.libs.email.model.GenericNotification;
import com.xventure.xapi.libs.email.model.GenericNotification;
import com.xventure.xapi.libs.email.model.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    private RabbitTemplate template;

    @PostMapping(value = "/")
    public String sendMessage(@RequestBody List<GenericNotification> notification){
        List<User>  usersList = new LinkedList<>();
        usersList.add(new User("userId","orgId"));

        List<GenericNotification> collect = notification.stream().map(noti ->
                        new GenericNotification(
                                noti.getChannelSelector(),
                                noti.getTemplateName(),
                                noti.getDataMap(),
                                noti.getMetaData(),
                                usersList,
                                null,
                                null)).
                collect(Collectors.toList());

        template.convertAndSend("notification-exchange","send-notification",notification);
        return "message sent";
    }

}
