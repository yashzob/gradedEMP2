package com.EmpMgmt2.EmpMgmt.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String FirstName;
	private String LastName;
	private String Email;
	
	//Getters
	public long getId() {
		return id;
	}
	public String getFirstName() {
		return FirstName;
	}
	public String getLastName() {
		return LastName;
	}
	public String getEmail() {
		return Email;
	}
	//Setters
	public void setId(long id) {
		this.id = id;
	}
	public void setFirstName(String firstName) {
		System.out.println(firstName);
		System.out.println(firstName);
		System.out.println(firstName);
		FirstName = firstName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public void setEmail(String email) {
		Email = email;
	}
	//ToString
	@Override
	public String toString() {
		return "Employee [id=" + id + ", FirstName=" + FirstName + ", LastName=" + LastName + ", Email=" + Email + "]";
	}
	//EqualsAndHashCode
	@Override
	public int hashCode() {
		return Objects.hash(Email, FirstName, LastName, id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(Email, other.Email) && Objects.equals(FirstName, other.FirstName)
				&& Objects.equals(LastName, other.LastName) && id == other.id;
	}
	//Constructors
	public Employee(long id, String firstName, String lastName, String email) {
		
		this.id = id;
		FirstName = firstName;
		LastName = lastName;
		Email = email;
	}
	public Employee() {
	
	}
	

}
