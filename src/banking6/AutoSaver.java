package banking6;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

class AutoSaver extends Thread{

	private static boolean autosave = false;

	AccountManager handler = new AccountManager();
	public AutoSaver() {
	}

	void test() throws InterruptedException {
		while(true) {
			try {
				sleep(5000);
				ObjectOutputStream out = new ObjectOutputStream(
						new FileOutputStream("src/banking6/AutoSaveAccount.txt"));
				out.writeObject(handler.AccountSet);
				System.out.println("자동저장 진행중");
		} catch (Exception e) {
			
		}
		}
	}
	@Override
	public void run() {
		try {
			test();
		} catch (InterruptedException e) {
		}
	}
//	@Override
//	public void run() {
//		while (true) {
//			try {
//				Thread.sleep(5000);
//				ObjectOutputStream out = new ObjectOutputStream(
//						new FileOutputStream("src/banking6/AutoSaveAccount.txt"));
//				for (Account ar : AccountSet) {
//					out.writeObject(ar);
//				}
//				out.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			System.out.println("자동저장완료됨");
//		}
//	}

	public static void main(String[] args) {
		AutoSaver a = new AutoSaver();
		a.setDaemon(true);
		a.start();
	}

}
