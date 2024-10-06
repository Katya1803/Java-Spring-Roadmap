package com.company.singleresp_ex.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WorldTimeResponseDTO {

    private String datetime;

    private Long unixtime;

    public WorldTimeResponseDTO() {

    }

    /**
     * @return the datetime
     */
    public String getDatetime() {
        return datetime;
    }

    /**
     * @param datetime the datetime to set
     */
    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    /**
     * @return the unixtime
     */
    public Long getUnixtime() {
        return unixtime;
    }

    /**
     * @param unixtime the unixtime to set
     */
    public void setUnixtime(Long unixtime) {
        this.unixtime = unixtime;
    }

    
}