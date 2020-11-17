package com.aplus.ldata.api.database;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.util.Date;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class Metadata {

    @Id
    @GeneratedValue
    private Long id;
    @Version
    private Integer version;
    private String uuid;
    private Date createdAt;
    private Date voidedAt;

}
