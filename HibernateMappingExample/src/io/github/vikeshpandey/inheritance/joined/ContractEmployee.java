package io.github.vikeshpandey.inheritance.joined;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "contract_employee_103")
@PrimaryKeyJoinColumn(name="Id") 
class ContractEmployee extends Employee {

	@Column(name = "pay_per_hour")
	private float payPerHour;

	@Column(name = "contract_duration")
	private String contractDuration;

	public float getPayPerHour() {
		return payPerHour;
	}

	public void setPayPerHour(float payPerHour) {
		this.payPerHour = payPerHour;
	}

	public String getContractDuration() {
		return contractDuration;
	}

	public void setContractDuration(String contractDuration) {
		this.contractDuration = contractDuration;
	}

}
