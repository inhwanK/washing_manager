package washing_manager.dto;

public class Laundry {
	private String lndCode;
	private String lndName;
	private int lndPrice;
	
	public Laundry() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Laundry(String lndCode) {
		super();
		this.lndCode = lndCode;
	}
	
	public Laundry(String lndCode, String lndName, int lndPrice) {
		super();
		this.lndCode = lndCode;
		this.lndName = lndName;
		this.lndPrice = lndPrice;
	}
	
	public String getLndCode() {
		return lndCode;
	}
	public void setLndCode(String lndCode) {
		this.lndCode = lndCode;
	}
	public String getLndName() {
		return lndName;
	}
	public void setLndName(String lndName) {
		this.lndName = lndName;
	}
	public int getLndPrice() {
		return lndPrice;
	}
	public void setLndPrice(int lndPrice) {
		this.lndPrice = lndPrice;
	}
	
	@Override
	public String toString() {
		return String.format("LaundryDto [lndCode=%s, lndName=%s, lndPrice=%s]", lndCode, lndName, lndPrice);
	}

	

}
