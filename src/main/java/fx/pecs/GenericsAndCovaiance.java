package fx.pecs;

import java.util.ArrayList;
import java.util.List;

import fx.tpf.Apple;
import fx.tpf.Fruit;
import fx.tpf.Orange;

/**
 * 范型的PECS原则  
 * 1.类似<? extends T>的用法，利用他我们可以从list中里面get元素,不能往里面添加元素;
 * 结论：将他视为Producer的提供（get）元素,而不能作为Consumer来对外获取元素
 * @author 
 *
 */

public class GenericsAndCovaiance {

	public static void main(String[] args) {
		List<? extends Fruit> flist = new ArrayList<Apple>();
//		Compile Error:can't add any type of object
//		flist.add(new Apple());	
//		flist.add(new Orange());
		flist.add(null);
		
		
		
		List<? extends Fruit> f1 = new ArrayList<Fruit>();
		List<? extends Fruit> f2 = new ArrayList<Apple>();
		List<? extends Fruit> f3 = new ArrayList<Orange>();
		Fruit f = flist.get(0);
	}
}
