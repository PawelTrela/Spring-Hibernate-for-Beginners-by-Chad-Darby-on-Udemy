package my.project.hibernate.demo.entity;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="review")
public class Review {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="comment")
	private String comment;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

//	@ManyToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name="course_id")
//	private Course course;
//
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Review() {
		
	}
	
	public Review(String comment) {
		this.comment = comment;
	}
	
	@Override
	public String toString() {
	    return "Review [id=" + id + ", comment=" + comment + "]";
	}
}
