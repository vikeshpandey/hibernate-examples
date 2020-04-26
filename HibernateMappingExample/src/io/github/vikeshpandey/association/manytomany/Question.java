package io.github.vikeshpandey.association.manytomany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ques1123")
class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String qname;

	@ManyToMany(targetEntity = Answer.class, cascade = { CascadeType.ALL })
	@JoinTable(name = "ques1123_ans1123", joinColumns = { @JoinColumn(name = "question_id") }, inverseJoinColumns = {
			@JoinColumn(name = "answers_id") })
	private List<Answer> answers;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQname() {
		return qname;
	}

	public void setQname(String qname) {
		this.qname = qname;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
}
