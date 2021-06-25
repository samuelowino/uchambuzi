## Life Planner Data Visualization

### Goals

* Visualize subscription funnel
* Visualize feature usage and utilization
* Visualize Locale i.e language spoken by users
* Visualize user behaviour interms of Timer, Duration, Life Line...

### Subscriptions Data

* **Models**
    
    - SubscriptionFunnel
        - id
        - user_tag
        - completed_onboarding
        - clicked_subscribe_immediately_at_oboarding
        - clicked_subscribe_immediately_monthly_subscription
        - clicked_subscribe_immediately_yearly_subscription
        - clicked_subscribe_immediately_yearly_sub_pay_success
        - clicked_subscribe_immediately_yearly_sub_pay_failed
        - clicked_subscribe_immediately_monthly_sub_pay_success
        - clicked_subscribe_immediately_monthly_sub_pay_failed
        - clicked_skip_button_immediately
        - clicked_skip_button_later
        - subscription_cancelled_automaticaly
        - subscription_currency_label
        - subscription_currency_amount_label

    - ExitScreen
        - id
        - user_tag
        - time_stamp
        - activity_name
    
    - UserScreenVisits
        - id
        - user_tag
        - activity_fragment_name
        - duration
    
    - UserFeatureActions
        - id
        - user_tag
        - action_name
        - module_name
        - timestamp
    
    - GeneralModuleStats
        - id
        - user_tag
        - data_points_created
    
* **Visualization Mechanism**
- Establish realtime channel for rendering data to graphs such as **Chart.js**

![Image of Yaktocat](https://pimg-guru.com/0%2F979%2F979372%2Flivestreaming_7c0fca0a-5d21-4294-86e1-c3f9df97132c.png)

![Image of Yaktocat](https://circuits4you.com/wp-content/uploads/2019/01/line_chart_ESP8266.png)


