package exam03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class StreamAPI_2_중간처리_distinct_filter {
	public static void main(String[] args) {
		//1. 컬렉션에서
		List<String> list =Arrays.asList("홍길동", "이순신","유관순");
		Stream<String> s = list.stream();
		System.out.println("스트림 요소 갯수 : "+s.count());
		//익명 클래스로
		Consumer<String> c = new Consumer<String>() {
			
			@Override
			public void accept(String t) {
				System.out.println(t);
			}
		};
		list.stream().forEach(c);
		System.out.println("-----------------");
		//람다 표현
		list.stream().forEach(t->System.out.println(t)  );
		
		//method reference
		
		list.stream().forEach(System.out::println);
		System.out.println("-----------------");
		//2. 배열에서
		String [] names = {"홍길동2", "이순신2","유관순2"};
		Stream<String> x = Stream.of(names);//스트림도 가능하고
		
		x.forEach(System.out::println);
		
		System.out.println("--------x2---------");
		Stream<String> x2 = Arrays.stream(names);//배열의 메서드로도 가능
		x2.forEach(System.out::println);
		
		
		//3. 리터럴에서
		System.out.println("--------literal---------");
		Stream<String> y = Stream.of("홍길동2", "이순신2","유관순2");
		y.forEach(System.out::println);
		
		System.out.println("--------Integer---------");
		Stream<Integer> y2 = Stream.of(10,20,30);
		y2.forEach(System.out::println);
		
	}
}
