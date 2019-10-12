package test;

public class Goods {
	private String goodsName;
	private float price;
	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Goods(String goodsName, float price) {
		super();
		this.goodsName = goodsName;
		this.price = price;
	}
	@Override
	public String toString() {
		return  goodsName + "\t" + price ;
	}
	
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	
}
