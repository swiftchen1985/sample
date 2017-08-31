package fx.pecs;

import java.util.ArrayList;
import java.util.List;

import fx.tpf.Apple;
import fx.tpf.Fruit;

/**
 * PECS 范型
 * 使用<? super T>
 * 使用super的坏处是以后不能get容器里面的元素了，原因很简单，我们继续从编译器的角度考虑这个问题
 * 
 * 结论：
 * “Producer Extends” – 如果你需要一个只读List，用它来produce T，那么使用? extends T。
 * “Consumer Super” – 如果你需要一个只写List，用它来consume T，那么使用? super T。
 * created by 2017-08-31
 *
 */
public class GenericWriting {
	static List<Apple> apples = new ArrayList<Apple>();	
	static List<Fruit> fruit = new ArrayList<Fruit>();
	static <T> void writeExact(List<T> list,T item) {
		list.add(item);
	}
	static void f1() {
		writeExact(apples,new Apple());
		writeExact(fruit,new Apple());
	}
	
	static <T> void writeWithWildcard(List<? super T>list,T item){
		list.add(item);
	}
	
	static void f2 () {
		writeWithWildcard(apples, new Apple());
		writeWithWildcard(fruit, new Apple());
	}
	
	public static void main(String[] args) {
		f1();f2();
	}
}
