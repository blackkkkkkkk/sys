package day1;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Work_7_22 {
	Work_7_22() {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		LoginInterface();
		int option = in.nextInt();
		while (option != 6) {
			switch (option) {
			case 1:
				System.out.println("查看题目1(利润)");
				profit();
				System.out.print("请重新选择题目(或输入7退出):");
				option = in.nextInt();
				break;
			case 2:
				System.out.println("查看题目2(闰年)");
				leapYear();
				System.out.print("请重新选择题目(或输入7退出):");
				option = in.nextInt();
				break;
			case 3:
				System.out.println("查看题目3(第几天)");
				judgmentDay();
				System.out.print("请重新选择题目(或输入7退出):");
				option = in.nextInt();
				break;
			case 4:
				System.out.println("查看题目4(交换x,y)");
				swopInt();
				System.out.print("请重新选择题目(或输入7退出):");
				option = in.nextInt();
				break;
			case 5:
				System.out.println("查看题目5(排序)");
				sort();
				System.out.print("请重新选择题目(或输入7退出):");
				option = in.nextInt();
				break;
			case 6:
				System.out.println("查看题目6(\"水仙花数\")");
				daffodilNumber();
				System.out.print("请重新选择题目(或输入7退出):");
				option = in.nextInt();
				break;
			case 7:
				System.out.println("退出");
			}

			if (option < 1 || option > 7) {
				System.out.print("输入有误,请重新输入(输入选项前面的序号):");
				LoginInterface();
				option = in.nextInt();
			}

		}
		System.out.println("\t再见！");
	}

	public void LoginInterface() {
		System.out.println("*******************************************************");
		System.out.println("\t请选择题目(输入选项前面的序号):" + "\n\t1.查看题目1" + "\n\t2.查看题目2" + "\n\t3.查看题目3" + "\n\t4.查看题目4"
				+ "\n\t5.查看题目5" + "\n\t6.退出");
		System.out.println("*******************************************************");
	}

	// 题目1：企业发放的奖金根据利润提成。
	public void profit() {
		System.out.println("*******************************************************");
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.println("请输入你的业绩(按回车键结束)：");

		double profitValue = in.nextDouble();
		double bonus = 0;

		if (profitValue > 0 && profitValue < 100000) { // 低于或等于 10 万元
			bonus = profitValue * 0.1;
		} else if (profitValue < 200000) { // 高于 10 万元，低于 20 万元
			bonus = 100000 * 0.1 + (profitValue - 100000) * 0.075;
		} else if (profitValue < 400000) { // 20 万到 40 万之间
			bonus = 100000 * 0.1 + 100000 * 0.075 + (profitValue - 200000) * 0.05;
		} else if (profitValue < 600000) { // 40 万到 60 万之间
			bonus = 100000 * 0.1 + 100000 * 0.075 + 200000 * 0.05 + (profitValue - 400000) * 0.03;
		} else if (profitValue < 1000000) { // 60 万到 100 万之间
			bonus = 100000 * 0.1 + 100000 * 0.075 + 200000 * 0.05 + 200000 * 0.03 + (profitValue - 600000) * 0.015;
		} else {
			bonus = 100000 * 0.1 + 100000 * 0.075 + 200000 * 0.05 + 200000 * 0.03 + 200000 * 0.015
					+ (profitValue - 600000) * 0.01;
		}

		System.out.println("您可获得的提成为：" + new DecimalFormat(".00").format(bonus));
		System.out.println("*******************************************************");
	}

	// 题目2：输入一个年份，判断该年份是否闰年
	public void leapYear() {
		System.out.println("*******************************************************");
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int year = in.nextInt();

		if ((year % 400 == 0) || (year % 100 != 0 && year % 4 == 0)) {
			System.out.println(year + "是闰年");
		} else {
			System.out.println(year + "不是闰年");
		}
		System.out.println("*******************************************************");
	}

	// 题目3：输入某年某月某日，判断这一天是这一年的第几天？
	public void judgmentDay() {

		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.println("请输入年份：");
		int year = in.nextInt();

		System.out.println("请输入月份：");
		int month = in.nextInt();

		System.out.println("请输入几号：");
		int day = in.nextInt();

		int result = 0;

		if (dateDorrectness(year, month, day)) {
			int febDay = 0;
			if ((year % 400 == 0) || (year % 100 != 0 && year % 4 == 0)) {
				febDay = 30 - 29;
			} else {
				febDay = 30 - 28;
			}

			for (int i = 1; i < month; i++) {
				if (i <= 7) {
					if (i % 2 == 1) {
						result += 31;
					} else {
						result += 30;
					}
				} else {
					if (i % 2 == 1) {
						result += 30;
					} else {
						result += 31;
					}
				}
			}

			result += day;

			if (month > 2) {
				result -= febDay;
			}
		}
		System.out.println("这是" + year + "年的第：" + result + "日");
		System.out.println("*******************************************************");
	}

	public boolean dateDorrectness(int year, int month, int day) {
		boolean result = false;
		int febDay = 0;
		if (year > 0) {

			if ((year % 400 == 0) || (year % 100 != 0 && year % 4 == 0)) {
				febDay = 29;
			} else {
				febDay = 28;
			}

			switch (month) {
			case 1:
				if (day >= 1 && day <= 31)
					result = true;
				break;
			case 2:
				if (day >= 1 && day <= febDay)
					result = true;
				break;
			case 3:
				if (day >= 1 && day <= 31)
					result = true;
				break;
			case 4:
				if (day >= 1 && day <= 30)
					result = true;
				break;
			case 5:
				if (day >= 1 && day <= 31)
					result = true;
				break;
			case 6:
				if (day >= 1 && day <= 30)
					result = true;
				break;
			case 7:
				if (day >= 1 && day <= 31)
					result = true;
				break;
			case 8:
				if (day >= 1 && day <= 31)
					result = true;
				break;
			case 9:
				if (day >= 1 && day <= 30)
					result = true;
				break;
			case 10:
				if (day >= 1 && day <= 31)
					result = true;
				break;
			case 11:
				if (day >= 1 && day <= 30)
					result = true;
				break;
			case 12:
				if (day >= 1 && day <= 31)
					result = true;
				break;
			}
		}
		return result;
	}

	// 题目4：输入两个整数 x,y,交换两个数的值。
	public void swopInt() {
		System.out.println("*******************************************************");
		int x, y;
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.println("请输入x：");
		x = in.nextInt();
		System.out.println("请输入y：");
		y = in.nextInt();

		// int temp = x;
		// x=y;
		// y=temp;

		// x +=y;
		// y -=x;
		// x -=y;

		x ^= y;
		y ^= x;
		x ^= y;
		System.out.println("转换后x：" + x);
		System.out.println("转换后y：" + y);
		System.out.println("*******************************************************");
	}

	// 题目5：输入三个整数 x,y,z ，请把这三个数由小到大输出。
	public void sort() {
		System.out.println("*******************************************************");
		List<Integer> list = new ArrayList<Integer>();
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.println("请输入x：");
		list.add(in.nextInt());
		System.out.println("请输入y：");
		list.add(in.nextInt());
		System.out.println("请输入z：");
		list.add(in.nextInt());

		Collections.sort(list);

		System.out.println("增序排列：");
		System.out.println(list.toString());
		System.out.println("*******************************************************");

	}

	// 题目6：水仙花数
	public void daffodilNumber() {
		System.out.println("*******************************************************");
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.println("请输入三位数整数：");
		int number = in.nextInt();
		int daffodil = (int)(Math.pow(number / 100, 3)+Math.pow((number % 100) / 10, 3)+Math.pow(number % 10, 3));
		if(daffodil==number){
			System.out.println(daffodil+"是\"水仙花数\"");
		}else{
			System.out.println(daffodil+"不是\"水仙花数\"");
		}
		System.out.println("*******************************************************");

	}
}
