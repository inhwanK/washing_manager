package washing_manager.dto;

public class Consumer {
	private String conPhone;
	private String conName;
	private String conGrade;
	
	public Consumer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Consumer(String conPhone) {
		super();
		this.conPhone = conPhone;
	}
	
	public Consumer(String conName, String conGrade, String conPhone) {
		super();
		this.conName = conName;
		this.conGrade = conGrade;
		this.conPhone = conPhone;
	}

	public String getConPhone() {
		return conPhone;
	}

	public void setConPhone(String conPhone) {
		this.conPhone = conPhone;
	}

	public String getConName() {
		return conName;
	}

	public void setConName(String conName) {
		this.conName = conName;
	}

	public String getConGrade() {
		return conGrade;
	}

	public void setConGrade(String conGrade) {
		this.conGrade = conGrade;
	}



	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((conGrade == null) ? 0 : conGrade.hashCode());
		result = prime * result + ((conName == null) ? 0 : conName.hashCode());
		result = prime * result + ((conPhone == null) ? 0 : conPhone.hashCode());
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
		if (conGrade == null) {
			if (other.conGrade != null)
				return false;
		} else if (!conGrade.equals(other.conGrade))
			return false;
		if (conName == null) {
			if (other.conName != null)
				return false;
		} else if (!conName.equals(other.conName))
			return false;
		if (conPhone == null) {
			if (other.conPhone != null)
				return false;
		} else if (!conPhone.equals(other.conPhone))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("Consumer [conName=%s, conGrade=%s, conPhone=%s]", conName, conGrade, conPhone);
	}
	
}
