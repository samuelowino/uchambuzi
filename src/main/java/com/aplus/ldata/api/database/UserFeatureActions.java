package com.aplus.ldata.api.database;

import com.aplus.ldata.api.database.meta.Metadata;
import com.aplus.ldata.api.enums.ModuleName;
import com.aplus.ldata.api.enums.UserAction;
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
public class UserFeatureActions extends Metadata {

    @Id
    @GeneratedValue
    private Long id;
    private String userTag;
    private UserAction actionName;
    private ModuleName moduleName;
    private Date timestamp;
}
