

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MyClassLoader extends ClassLoader {
	
	private String name; //类加载器的名字
	
	private String path = "d:\\"; //加载来的路径
	
	private final String fileType = ".class" ;//class文件的扩展名
	
	public MyClassLoader(String name) {
		super();
		this.name = name;
	}

	
	public MyClassLoader(ClassLoader parent,String name) {
		super(parent); //指定当前类加载器的父加载器
		this.name = name;
	}

	
	
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		byte[] data = loadClassData(name);
		return super.defineClass(name, data, 0, data.length);
	}


	// load the class data from the connection
	 private byte[] loadClassData(String name) {
		 InputStream is = null;
		 byte[] data = null;
		 ByteArrayOutputStream   baos = null;
		 try {
			 this.name = this.name.replace(".", "\\");
			 String filePath = path + name + fileType;
			 System.out.println("file path :" + filePath);
			 if (!new File(filePath).exists()) {
				 return null;
			 }
			 is = new FileInputStream(new File(filePath));
			 baos = new ByteArrayOutputStream();
			 int ch = 0;
			 while(-1 != (ch = is.read())) {
				 baos.write(ch);
			 }
			 data = baos.toByteArray();
		 } catch(Exception ex ) {
			
			 
		 } finally {
			 try {
				is.close();
				baos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 return data;
     }

	
	
	@Override
	public String toString() {
		return this.name;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}


	public String getFileType() {
		return fileType;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		MyClassLoader loader1 = new MyClassLoader("loader1");
		loader1.setPath("D:\\BF\\class\\serverlib\\");
		
		MyClassLoader loader2 = new MyClassLoader(loader1,"loader2");
		loader2.setPath("D:\\BF\\class\\clientlib\\");
		
		MyClassLoader loader3 = new MyClassLoader(null,"loader3");
		loader3.setPath("D:\\BF\\class\\otherlib\\");
		
		test(loader2);
		test(loader3);
	}
	
	public static void test(ClassLoader loader) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class clazz = loader.loadClass("Sample");
		Object obj = clazz.newInstance();
	}
}
