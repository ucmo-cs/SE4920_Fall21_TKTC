package com.FedReserve.FederalReserveProject.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity //  mapping an object state to database column
@Table(name = "guidance")
public class GuidanceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int guid;
    private String PosterName;
    private String GuidanceDesc;


}
