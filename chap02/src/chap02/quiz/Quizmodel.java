package chap02.quiz;

public class Quizmodel {
	String id;
	String pw;
	String email;

	public Quizmodel(String id, String pw, String email) {
		this.id = id;
		this.pw = pw;
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "���̵� : "+this.id + " �̸��� : " + this.email;
	}
}
