package com.aplus.ldata.api.database;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
public class ExitScreen extends Metadata {

    @Id
    @GeneratedValue
    private Long id;
    private String userTag;
    private Date timestamp;
    private String activityName;
}
