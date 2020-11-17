package com.aplus.ldata.api.database;

import com.aplus.ldata.api.database.meta.Metadata;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
public class GeneralModuleStats extends Metadata {

    private Long id;
    private String userTag;
    private String dataPoints;
}
