import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;



//���ʵ��������������Ի�����ϸ��

/**
 * @author asus
 *��������������capacity������ʱ�Լ�ָ������limit��position
 *������������������䣬������clear()��position��limit�������õ��»������޷������µ�����
 *������flip()�����Ĵ��ڣ����Բ�ͣ�������һ�ξͶ����˵�����
 *
 *
 *���ԡ�������static
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
