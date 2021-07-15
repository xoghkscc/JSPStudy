package chap03.bean;

public class Student implements Comparable<Student>{
	
	//필드의 접근제어가를 private으로 설정
	private int id;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private double avg;
	private int rank;
	
	//기본 생성자가 반드시 존재해야함
	
	
	//필드에 접근할 때는 getter/setter를 이용해야 함
	
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
		return "번호 : "+this.id+" 이름 : "+this.name + " 평균 점수 : "+Math.round(this.avg)+ " 순위 :" + this.rank;
	}
}
