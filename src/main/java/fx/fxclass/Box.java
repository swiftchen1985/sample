package fx.fxclass;
/**
 * 泛型类学习
 * @author 
 * Created by 2017-08-29
 *
 *这样我们的Box类便可以得到复用，我们可以将T替换成任何我们想要的类型：
 * @param <T>
 */
public class Box<T> {

	private T t;
	public void set(T t) {
		this.t = t;
	}
	
	public T get() {
		return t;
	}
	public static void main(String[] args) {
		Box<Integer> b1 = new Box<Integer>();
		Box<Double> d1 = new Box<Double>();
		Box<String> s1 = new Box<String>();
	}
}
