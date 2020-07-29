/**
 * 
 */
package com.alfazid.siasd.model.entity;

import java.sql.Timestamp;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;

import groovy.transform.builder.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author   mohirwanh@gmail.com
 * @web	     www.alfaz.id
 * @Date     Oct 20, 2019
 * @projects siasd @package com.alfazid.siasd.model
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BaseEntity {
	 @Basic
	 @Column(name = "created_by",length = 36)
	 private String createdBy;
	 @Basic
	 @Column(name = "created_at")
	 private Timestamp createdAt;
	 @Basic
	 @Column(name = "update_by",length = 36)
	 private String updatedBy;
	 @Basic
	 @Column(name = "update_at")
	 private Timestamp updateAt;

}
