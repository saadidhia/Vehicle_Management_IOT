package com.deutschland.springconceptreplay.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DemandRequest {

    private String dropUpLoc;
    private String dropOffLoc;
    private String dropUpTime;
    private String dropOffTime;



}
