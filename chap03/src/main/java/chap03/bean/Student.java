package chap03.bean;

public class Student implements Comparable<Student>{
	
	//�ʵ��� ��������� private���� ����
	private int id;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private double avg;
	private int rank;
	
	//�⺻ �����ڰ� �ݵ�� �����ؾ���
	
	
	//�ʵ忡 ������ ���� getter/setter�� �̿��ؾ� ��
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public int compareTo(Student o) {
		if((this.getAvg() - o.getAvg())>0) {
			return -1;
		}else if((this.getAvg() - o.getAvg())<0) {
			return 1;
		}else if((this.getAvg() - o.getAvg())==0){
			return 0;
		}
		return 0;
	}
	
	@Override
	public String toString() {
		return "��ȣ : "+this.id+" �̸� : "+this.name + " ��� ���� : "+Math.round(this.avg)+ " ���� :" + this.rank;
	}
}
