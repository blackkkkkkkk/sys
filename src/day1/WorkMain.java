package day1;

public class WorkMain {

	public static void main(String[] args) {
		System.out.println("*******************************************************");
		System.out.println("                      ");
		System.out.println("\t欢迎使用网博作业管理系统1.0版");
		System.out.println("\t此版本的开发人员为:WBJ20071_17:钟林志");
		System.out.println("\t欢迎查阅7月22日作业");
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
