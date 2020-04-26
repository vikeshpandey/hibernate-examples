package io.github.vikeshpandey.mapping.collection;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "college")
class College {
	
	College(){}

	@Id
	@Column(name = "college_id")
	private int collegeId;

	@Column(name = "name")
	private String collegeName;

	@ElementCollection
	@CollectionTable(name = "student", joinColumns = @JoinColumn(name = "college_id"))
	@Column(name = "student_name")
	private Set<String> students;

	public College(int collegeId, String collegeName) {
		this.collegeId = collegeId;
		this.collegeName = collegeName;
	}

	public Set<String> getStudents() {
		return students;
	}

	public void setStudents(Set<String> students) {
		this.students = students;
	}

	public int getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
}
