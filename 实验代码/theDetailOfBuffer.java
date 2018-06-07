import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;



//这个实验代码是用来测试缓冲区细节

/**
 * @author asus
 *缓冲区三个变量capacity（创建时自己指定），limit与position
 *代码中如果缓冲区不变，不进行clear()则position与limit不会重置导致缓冲区无法读入新的数据
 *但由于flip()方法的存在，可以不停的输出第一次就读到了的数据
 *
 *
 *测试。。。。static
 *
 */
public class test1 {
//	private static ByteBuffer buffer = ByteBuffer.allocate(1024);
	public static void main(String[] args) {
		try {
			
			
//			ByteBuffer buffer = new buuyrte().getBuffer();
//			ByteBuffer buffer = ByteBuffer.allocate(1024);
			while (true) {
				FileInputStream fin = new FileInputStream("D:\\new eclipse workspace\\NIOTest\\src\\read.txt");
				FileOutputStream fout = new FileOutputStream("D:\\new eclipse workspace\\NIOTest\\src\\write.txt");
				FileChannel fc = fin.getChannel();
				FileChannel fco = fout.getChannel();
//				buffer.clear();
				int len = fc.read(buuyrte.buffer);
				System.out.println(buuyrte.buffer.get(0));
//				if (len == -1) {
//					break;
//				}
				//######
				buuyrte.buffer.flip();
				//######
				fco.write(buuyrte.buffer);
				
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
