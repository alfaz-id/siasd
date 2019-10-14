package com.alfazid.siasd.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by www.alfaz.id mail : mohirwanh@gmail.com on 10/10/19.
 */
@Data
@Builder
@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
public class RandomCity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
}
