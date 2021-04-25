package washing_manager.dto;

import java.util.Date;

public class ViewAll {
	private int turnNo;
	private int rank;
	private String conName;
	private String lndNameEa; // 값이 여러개임.
	private String priceEa; // 값이 여러개임.
	private String conGrade;
	private int discount;
	private int priceAll;
	private String lndCode;
	private String conPhone;
	private String ordNo;
	private Date orderTime;
	private String lndName; // 값이 여러개임.
	private String lndEa; // 값이 여러개임.
	
	public int getTurnNo() {
		return turnNo;
	}
	
	public void setTurnNo(int turnNo) {
		this.turnNo = turnNo;
	}
	
	public int getRank() {
		return rank;
	}
	
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	public String getConName() {
		return conName;
	}
	
	public void setConName(String conName) {
		this.conName = conName;
	}
	
	public String getLndNameEa() {
		return lndNameEa;
	}
	public void setLndNameEa(String lndNameEa) {
		this.lndNameEa = lndNameEa;
	}
	
	public String getPriceEa() {
		return priceEa;
	}
	
	public void setPriceEa(String priceEa) {
		this.priceEa = priceEa;
	}
	public String getConGrade() {
		return conGrade;
	}
	
	public void setConGrade(String conGrade) {
		this.conGrade = conGrade;
	}
	
	public float getDiscount() {
		return discount;
	}
	
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getPriceAll() {
		return priceAll;
	}
	
	public void setPriceAll(int priceAll) {
		this.priceAll = priceAll;
	}
	
	public String getLndCode() {
		return lndCode;
	}
	public void setLndCode(String lndCode) {
		this.lndCode = lndCode;
	}
	
	public String getConPhone() {
		return conPhone;
	}
	
	public void setConPhone(String conPhone) {
		this.conPhone = conPhone;
	}
	
	public String getOrdNo() {
		return ordNo;
	}
	
	public void setOrdNo(String ordNo) {
		this.ordNo = ordNo;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public String getLndName() {
		return lndName;
	}

	public void setLndName(String lndName) {
		this.lndName = lndName;
	}

	public String getLndEa() {
		return lndEa;
	}

	public void setLndEa(String lndEa) {
		this.lndEa = lndEa;
	}

	@Override
	public String toString() {
		return String.format(
				"ViewAll [turnNo=%s, rank=%s, conName=%s, lndNameEa=%s, priceEa=%s, conGrade=%s, discount=%s, priceAll=%s, lndCode=%s, conPhone=%s, ordNo=%s, orderTime=%s]",
				turnNo, rank, conName, lndNameEa, priceEa, conGrade, discount, priceAll, lndCode, conPhone, ordNo,
				orderTime);
	}
	

	
}
