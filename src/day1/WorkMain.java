package day1;

public class WorkMain {

	public static void main(String[] args) {
		System.out.println("*******************************************************");
		System.out.println("                      ");
		System.out.println("\t��ӭʹ��������ҵ����ϵͳ1.0��");
		System.out.println("\t�˰汾�Ŀ�����ԱΪ:WBJ20071_17:����־");
		System.out.println("\t��ӭ����7��22����ҵ");
		System.out.println("                      ");
		System.out.println("*******************************************************");
		System.out.println("                      ");
		new Thread(){
			public void run(){
			try {
			Thread.sleep(2000);
			new Work_7_22();
			} catch (InterruptedException e) { }
			}
			}.start(); 
	}

}
