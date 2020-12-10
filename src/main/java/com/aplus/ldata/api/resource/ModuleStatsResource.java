package com.aplus.ldata.api.resource;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ModuleStatsResource {

    private int habitsCount;
    private int productivityCount;
    private int financeCount;
    private int wellnessCount;

    public ModuleStatsResource(int habitsCount, int productivityCount, int financeCount, int wellnessCount) {
        this.habitsCount = habitsCount;
        this.productivityCount = productivityCount;
        this.financeCount = financeCount;
        this.wellnessCount = wellnessCount;
    }
}
