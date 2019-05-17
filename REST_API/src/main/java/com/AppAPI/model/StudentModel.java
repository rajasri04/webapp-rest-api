package com.AppAPI.model;
	import java.util.Date;
	import javax.persistence.Entity;
	import javax.persistence.EntityListeners;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;
	import javax.persistence.Temporal;
	import javax.persistence.TemporalType;
	import org.springframework.data.annotation.LastModifiedDate;
	import org.springframework.data.jpa.domain.support.AuditingEntityListener;

	@Entity
	@Table(name="Student")
	@EntityListeners(AuditingEntityListener.class)

	public class StudentModel {
		
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Long id;
		
		
		private String name;
		
	
		private String department;


		
		private String technology;
		
		
		@Temporal(TemporalType.TIMESTAMP)
		@LastModifiedDate
		private Date createdAt;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		
		public String getDepartment() {
			return department;
		}

		public void setDepartment(String department) {
			this.department = department;
		}
		
		public String getTechnology() {
			return technology;
		}

		public void setTechnology(String technology) {
			this.technology = technology;
		}


		public Date getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}


	}


