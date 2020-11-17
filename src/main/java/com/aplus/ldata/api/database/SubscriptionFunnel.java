package com.aplus.ldata.api.database;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
public class SubscriptionFunnel extends Metadata {

    @Id
    @GeneratedValue
    private Long id;
    private String userTag;
    private boolean completedOnBoarding;
    private boolean clickedSubscribeImmediatelyAtOnBoarding;
    private boolean clickedSubscribeImmediatelyMonthlySubscription;
    private boolean clickedSubscribeImmediatelyYearlySubscription;
    private boolean clickedSubscribeImmediatelyYearlySubPaySuccess;
    private boolean clickedSubscribeImmediatelyYearlySubPayFailed;
    private boolean clickedSubscribeImmediatelyMonthlySubPaySuccess;
    private boolean clickedSubscribeImmediatelyMonthlySubPayFailed;
    private boolean clickedSkipButtonImmediately;
    private boolean clickedSkipButtonLater;
    private boolean subscriptionCancelledAutomatically;
    private boolean subscriptionCurrencyLabel;
    private boolean subscriptionCurrencyAmountLabel;


}
