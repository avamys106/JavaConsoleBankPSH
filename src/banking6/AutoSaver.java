package banking6;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

class AutoSaver extends AccountManager implements Runnable {

	public AutoSaver() {
	}

	void test() throws InterruptedException {
		
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(5000);
				BufferedWriter out = new BufferedWriter(new FileWriter("src/banking6/AutoSaveAccount.txt"));
				for (Account ar : AccountSet) {
					out.write(ar.acnumber);
					out.write(ar.name);
					out.write(ar.mymoney);
					System.out.println("저장완료");
					
				}
				out.close();
				System.out.println("자동저장 진행중");
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		AutoSaver a = new AutoSaver();
		Thread thread = new Thread(a);
		thread.start();
	}

}
