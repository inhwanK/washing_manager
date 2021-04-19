package washing_manager.dto;

public class GradeDc {
	private String grade;
	private float discount;
	
	public GradeDc() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public GradeDc(String grade) {
		super();
		this.grade = grade;
	}
	
	public GradeDc(String grade, float discount) {
		super();
		this.grade = grade;
		this.discount = discount;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return String.format("%s", grade);
	}
	
	public String toStringAll() {
		return String.format("GradeDcDto [grade=%s, discount=%s]", grade, discount);
	}
}
