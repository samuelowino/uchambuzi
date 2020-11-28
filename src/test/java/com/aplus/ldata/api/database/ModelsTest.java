package com.aplus.ldata.api.database;

import com.aplus.ldata.constants.ModuleEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Date;

public class ModelsTest {

    public static void main(String[]args){
        ExitScreen exitScreen = new ExitScreen();
        exitScreen.setId(null);
        exitScreen.setActivityName("Home Screen");
        exitScreen.setTimestamp(new Date());
        exitScreen.setUserTag("user-john");

        try {
            System.out.println(new ObjectMapper().writeValueAsString(exitScreen));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        GeneralModuleStats moduleStats = new GeneralModuleStats();
        moduleStats.setUserTag("user-johny");
        moduleStats.setModuleName("Habits");
        moduleStats.setId(null);
        moduleStats.setEvent(ModuleEvent.OPEN_MODULE);

        try {
            System.out.println(new ObjectMapper().writeValueAsString(moduleStats));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        SubscriptionFunnel subscriptionFunnel = new SubscriptionFunnel();
        subscriptionFunnel.setId(null);
        subscriptionFunnel.setClickedSkipButtonImmediately(true);
        subscriptionFunnel.setClickedSkipButtonLater(false);
        subscriptionFunnel.setCompletedOnBoarding(true);
        subscriptionFunnel.setClickedSubscribeImmediatelyMonthlySubscription(true);
        subscriptionFunnel.setClickedSubscribeImmediatelyMonthlySubPaySuccess(true);

        try {
            System.out.println( new ObjectMapper().writeValueAsString(subscriptionFunnel));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        UserScreenVisits userScreenVisits = new UserScreenVisits();
        userScreenVisits.setId(null);
        userScreenVisits.setUserTag("johna-user");
        userScreenVisits.setActivityFragmentName("MainFragmentActivity");
        userScreenVisits.setDurationMilliseconds("2000");

        try {
            System.out.println( new ObjectMapper().writeValueAsString(userScreenVisits));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}