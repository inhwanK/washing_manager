package washing_manager.dto;

public class Consumer {
	private int conPhone;
	private String conName;
	private char conGrade;
	
	public Consumer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Consumer(int conPhone, String conName, char conGrade) {
		super();
		this.conPhone = conPhone;
		this.conName = conName;
		this.conGrade = conGrade;
	}

	public int getConPhone() {
		return conPhone;
	}

	public void setConPhone(int conPhone) {
		this.conPhone = conPhone;
	}

	public String getConName() {
		return conName;
	}

	public void setConName(String conName) {
		this.conName = conName;
	}

	public char getConGrade() {
		return conGrade;
	}

	public void setConGrade(char conGrade) {
		this.conGrade = conGrade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + conGrade;
		result = prime * result + ((conName == null) ? 0 : conName.hashCode());
		result = prime * result + conPhone;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Consumer other = (Consumer) obj;
		if (conGrade != other.conGrade)
			return false;
		if (conName == null) {
			if (other.conName != null)
				return false;
		} else if (!conName.equals(other.conName))
			return false;
		if (conPhone != other.conPhone)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("Consumer [conPhone=%s, conName=%s, conGrade=%s]", conPhone, conName, conGrade);
	}
	
	
}
