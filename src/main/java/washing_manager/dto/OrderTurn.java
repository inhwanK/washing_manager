package washing_manager.dto;

import java.util.Date;

public class OrderTurn {
	private int turn;
	private Date orderdate;
	
	public OrderTurn() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderTurn(int turn) {
		super();
		this.turn = turn;
	}
	public OrderTurn(int turn, Date orderdate) {
		super();
		this.turn = turn;
		this.orderdate = orderdate;
	}

	public int getTurn() {
		return turn;
	}
	public void setTurn(int turn) {
		this.turn = turn;
	}
	public Date getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}
	@Override
	public String toString() {
		return String.format("OrderTurn [turn=%s, orderdate=%s]", turn, orderdate);
	}
	
	
}
