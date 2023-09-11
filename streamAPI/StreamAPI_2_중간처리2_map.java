package exam03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;


class Student{
	String username;
	int Score;
	
	public Student() {
	}
	public Student(String username, int score) {
		this.username = username;
		Score = score;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getScore() {
		return Score;
	}
	public void setScore(int score) {
		Score = score;
	}
	@Override
	public String toString() {
		return "Student [username=" + username + ", Score=" + Score + "]";
	}
	
}

public class StreamAPI_2_중간처리2_map {
	public static void main(String[] args) {
		List<Student> list = Arrays.asList(new Student("홍길동",90), 
				new Student("이순신",91),
				new Student("유관순",92)	
				);
		
		//가공 1 이름에서 성만 출력
		Function<Student, String> mapper = new Function<Student, String>() {
			
			@Override
			public String apply(Student t) {
				return t.getUsername().substring(0,1);
			}
		};
		
				
		list.stream().map(mapper).forEach(System.out::println);
		
		System.out.println("-------------------Lambda-----------------");
		list.stream().map(t-> mapper.apply(t) ).forEach(System.out::println);
		//가공 2 score 값만
		System.out.println("-------------------가공2-----------------");
		list.stream().map(t-> t.getScore() ).forEach(System.out::println);
		
		Function<Student, Integer> mapper2 = new Function<Student, Integer>() {
			
			@Override
			public Integer apply(Student t) {
				return t.getScore();
			}
		};
		System.out.println("mapper");
		list.stream().map(mapper2).forEach(System.out::println);
		
		//method reference
		System.out.println("//method reference");
		list.stream().map(Student::getScore).forEach(System.out::println);
		
		//가공2 : score 출력 => mapToInt 이용
		System.out.println("가공2 : score 출력 => mapToInt 이용");
		ToIntFunction<Student> mapper3 = new ToIntFunction<Student>() {
			
			@Override
			public int applyAsInt(Student value) {
				return value.getScore();
			}
		};
		list.stream().mapToInt(mapper3).forEach(System.out::println);
		
		
	}//end main
}
