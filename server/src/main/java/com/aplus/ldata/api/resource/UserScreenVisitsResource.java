package com.aplus.ldata.api.resource;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserScreenVisitsResource {

    private Long id;
    private String uuid;
    private String createdAt;
    private String userTag;
    private String activityFragmentName;
}
