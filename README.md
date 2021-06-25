## Operation Uchambuzi

> The Uchambuzi Project is a user centered usage analytics platform 
![Test Image 1](logo_transparent.png)

### Goals

* Visualize Important funnels
* Visualize feature usage and utilization
* Visualize Locale i.e language used by users
* Visualize user behaviour in terms of Sessions duration and churning 
* Support custom tags

### Subscriptions Data

* **Static Models**
    - ExitScreen
        - id
        - user_tag
        - time_stamp
        - screen_name
    
    - UserScreenVisits
        - id
        - user_tag
        - screen_name
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
- Establish realtime channel for rendering data to graphs such as **Chart.js** and desktop client application

![Image of Yaktocat](https://pimg-guru.com/0%2F979%2F979372%2Flivestreaming_7c0fca0a-5d21-4294-86e1-c3f9df97132c.png)

![Image of Yaktocat](https://circuits4you.com/wp-content/uploads/2019/01/line_chart_ESP8266.png)


