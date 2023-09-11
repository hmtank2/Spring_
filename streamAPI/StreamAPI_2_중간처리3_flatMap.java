package exam03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;




public class StreamAPI_2_중간처리3_flatMap {
	public static void main(String[] args) {
		List<Student> list2 = Arrays.asList(new Student("홍길동",90), 
				new Student("이순신",91),
				new Student("유관순",92)	
				);
		
		List<String> list = Arrays.asList("hello world","happy virus");
		
		//1. 정렬
		
		
		//2. skip
		
		//이 파일에서는 시간이 없는 관계로 중요한 부분만 작성함
		//
		list2.stream().sorted(Comparator.comparing(Person::getScore)).skip(2).forEach(System.out::println);
		
		
		//3. limit(M) m개 얻기
		list2.stream().sorted(Comparator.comparing(Person::getScore)).limit(3).forEach(System.out::println);
		// 
		
	}//end main
}
