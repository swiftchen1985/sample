package fx.tpf;

import java.util.Arrays;
import java.util.List;

/**
 * 泛型通配符作用
 * Created by 2017-08-29
 * 
 *在了解通配符之前，我们首先必须要澄清一个概念，还是借用我们上面定义的Box类，假设我们添加一个这样的方法：
 *public void boxTest(Box<Number> n) {}
 *那么现在Box<Number> n允许接受什么类型的参数？
 *我们是否能够传入Box<Integer>或者Box<Double>呢？答案是否定的，
 *虽然Integer和Double是Number的子类，
 *但是在泛型中Box<Integer>或者Box<Double>与Box<Number>之间并没有任何的关系。
 *这一点非常重要，接下来我们通过一个完整的例子来加深一下理解
 */


public class GenericReading {
	static List<Apple> apples = Arrays.asList(new Apple());
	static List<Fruit> fruit =  Arrays.asList(new Fruit());
	
	
	static class Reader<T> {
		T readExact(List<T> list) {
			return list.get(0);
		}
	}
	static void f1() {
		Reader<GenericReading> fruitReader = new Reader<GenericReading>();
		//Errors: List<Fruit> cannot be applied to List<Apple>.
		// Fruit f = fruitReader.readExact(apples);
	}
	
	
	static class CovariantReader<T> {
		T readCovariant(List<? extends T> list) {
			return list.get(0);
		}
	}
	
	static void f2 () {
		CovariantReader<Fruit> fruitReader = new CovariantReader<Fruit>();
		Fruit f = fruitReader.readCovariant(fruit);
		Apple a = (Apple) fruitReader.readCovariant(apples);
		System.out.println(f.toString() + a.toString() );
	}
	public static void main(String[] args) {
		f2();
	}
	
	
	
}
