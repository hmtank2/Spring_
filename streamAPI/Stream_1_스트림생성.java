package exam03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Stream_1_스트림생성 {
	public static void main(String[] args) {
		List<String> list =Arrays.asList("홍길동", "이순신","이순신","이순신","유관순","이철수");
		//1.중간처리 중복제거
		list.stream()
		.distinct()
		.forEach(System.out::println);
		
		System.out.println("###############################");
		//2.중간처리 필터링
		Predicate<String> predicate = new Predicate<String>() {
			
			@Override
			public boolean test(String t) {
				return t.startsWith("이");
			}
		};
		
		list.stream().filter(predicate).forEach(System.out::println);
		
		//람다 표현식
		System.out.println("###############################");
		list.stream().filter(t -> t.startsWith("이")).forEach( t -> System.out.println(t));
		
		
		//중간처리 혼합 
		System.out.println("###############혼합################");
		list.stream()
		.distinct().filter(predicate)
		.forEach(System.out::println);
		
		
	}
}
