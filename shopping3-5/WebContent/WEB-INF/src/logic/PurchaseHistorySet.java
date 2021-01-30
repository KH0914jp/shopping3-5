package logic;

import java.io.Serializable;
import java.sql.Timestamp;

//w“ü—š—ğ‚ÌModelƒNƒ‰ƒX
public class PurchaseHistorySet implements Serializable {

	private static final long serialVersionUID = 1L;

	private Timestamp updateTime;

	private String itemName;

	private Integer itemId;

	private Integer quantity;

	private Integer price;

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Integer getItemId() {
		return this.itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
}
