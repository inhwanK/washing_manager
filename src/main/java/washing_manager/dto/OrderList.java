package washing_manager.dto;

public class OrderList {
	// 생성자
	private int ordNo;
	private int lndEa;
	private Laundry lndCode;
	private Consumer conPhone;
	private OrderTurn turn;
	
	//impl 
	private int detailNo;
	private int totalPrice;

	public OrderList() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public OrderList(int ordNo) {
		super();
		this.ordNo = ordNo;
	}
	
	public OrderList(int lndEa, Laundry lndCode, Consumer conPhone) {
		super();
		this.lndEa = lndEa;
		this.lndCode = lndCode;
		this.conPhone = conPhone;
	}
	
	public OrderList(int ordNo, int lndEa, Laundry lndCode, Consumer conPhone) {
		super();
		this.ordNo = ordNo;
		this.lndEa = lndEa;
		this.lndCode = lndCode;
		this.conPhone = conPhone;
	}

	public OrderList(int ordNo, int lndEa, Laundry lndCode, Consumer conPhone, OrderTurn turn) {
		super();
		this.ordNo = ordNo;
		this.lndEa = lndEa;
		this.lndCode = lndCode;
		this.conPhone = conPhone;
		this.turn = turn;
	}
	
	public int getOrdNo() {
		return ordNo;
	}

	public void setOrdNo(int ordNo) {
		this.ordNo = ordNo;
	}

	public int getLndEa() {
		return lndEa;
	}

	public void setLndEa(int lndEa) {
		this.lndEa = lndEa;
	}

	public Laundry getLndCode() {
		return lndCode;
	}

	public void setLndCode(Laundry lndCode) {
		this.lndCode = lndCode;
	}

	public Consumer getConPhone() {
		return conPhone;
	}

	public void setConPhone(Consumer conPhone) {
		this.conPhone = conPhone;
	}

	public OrderTurn getTurn() {
		return turn;
	}

	public void setTurn(OrderTurn turn) {
		this.turn = turn;
	}

	
	// impl
	
	public int getDetailNo() {
		return detailNo;
	}

	public void setDetailNo(int detailNo) {
		this.detailNo = detailNo;
	}


	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return String.format("OrderList [ordNo=%s, lndEa=%s, lndCode=%s, conPhone=%s, turn=%s]", ordNo, lndEa, lndCode,
				conPhone, turn);
	}

}
