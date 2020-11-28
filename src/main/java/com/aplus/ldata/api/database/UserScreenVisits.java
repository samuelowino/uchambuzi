package com.aplus.ldata.api.database;

import com.aplus.ldata.api.database.meta.Metadata;
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
public class UserScreenVisits extends Metadata {

    @Id
    @GeneratedValue
    private Long id;
    private String userTag;
    private String activityFragmentName;
    private String durationMilliseconds;
}
