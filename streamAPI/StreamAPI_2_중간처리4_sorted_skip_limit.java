package exam03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;




public class StreamAPI_2_중간처리4_sorted_skip_limit {
	public static void main(String[] args) {
		List<Student> list2 = Arrays.asList(new Student("홍길동",90), 
				new Student("이순신",91),
				new Student("유관순",92)	
				);
		
		List<String> list = Arrays.asList("hello world","happy virus");
		
		//공백 기준으로 문자 처리
		list.stream().flatMap(new Function<String, Stream<? extends String>>() {
			@Override
			public Stream<? extends String> apply(String t) {
				String [] names = t.split(" ");
				return Arrays.stream(names);
			}
			
		}).forEach(System.out::println);
		
		//람다 표현식
		
		Function<String, Stream<? extends String>> mapper3 = new Function<String, Stream<? extends String>>() {
			@Override
			public Stream<? extends String> apply(String t) {
				String [] names = t.split(" ");
				return Arrays.stream(names);
			}
		};
		
		list.stream().flatMap(t->Arrays.stream( t.split(" ") ) ).forEach(System.out::println);
		
		//실습 2: 쉼표 기준으로 분리, 정수값으로 출력.
		List<String> list3 = Arrays.asList("10,20,30","40,50,60");
		list3.stream().flatMap(t->Stream.of( t.split(",") ) ).forEach(System.out::println);
		//list3.stream().flatMapToInt(t->IntStream.of( (t.split(",")) ) ).forEach(System.out::println);
		
		Function<String, IntStream> mapper2 = new Function<String, IntStream>() {
			
			@Override
			public IntStream apply(String t) {
				String [] arr = t.split(",");
				int [] nums = Arrays.stream(arr).mapToInt(Integer::parseInt).toArray();
				return Arrays.stream(nums);
			}
		};
		
		list3.stream().flatMapToInt(mapper2).forEach(System.out::println);
		System.out.println("____________________________");
		list3.stream().flatMapToInt(t -> Arrays.stream(t.split(",")).mapToInt(Integer::parseInt) ).forEach(System.out::println);
		System.out.println("---------------------solution----------------------");
		list3.stream().flatMapToInt(t -> Arrays.stream(Arrays.stream(t.split(",")).mapToInt(Integer::parseInt).toArray())).forEach(System.out::println);
		
		
		
	}//end main
}
