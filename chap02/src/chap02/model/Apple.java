package chap02.model;

public class Apple {
	int price;
	int size;
	public Apple() {
		this.price = (int)(Math.random() * 10) + 10;
		this.size = (int)(Math.random() * 10) + 10;
	}
	
	
	public int getPrice() {
		return price;
	}

	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}


	@Override
	public String toString() {
		return "price : "+ price + " size : "+ size;
	}
}