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
				System.out.println("�鿴��Ŀ1(����)");
				profit();
				System.out.print("������ѡ����Ŀ(������7�˳�):");
				option = in.nextInt();
				break;
			case 2:
				System.out.println("�鿴��Ŀ2(����)");
				leapYear();
				System.out.print("������ѡ����Ŀ(������7�˳�):");
				option = in.nextInt();
				break;
			case 3:
				System.out.println("�鿴��Ŀ3(�ڼ���)");
				judgmentDay();
				System.out.print("������ѡ����Ŀ(������7�˳�):");
				option = in.nextInt();
				break;
			case 4:
				System.out.println("�鿴��Ŀ4(����x,y)");
				swopInt();
				System.out.print("������ѡ����Ŀ(������7�˳�):");
				option = in.nextInt();
				break;
			case 5:
				System.out.println("�鿴��Ŀ5(����)");
				sort();
				System.out.print("������ѡ����Ŀ(������7�˳�):");
				option = in.nextInt();
				break;
			case 6:
				System.out.println("�鿴��Ŀ6(\"ˮ�ɻ���\")");
				daffodilNumber();
				System.out.print("������ѡ����Ŀ(������7�˳�):");
				option = in.nextInt();
				break;
			case 7:
				System.out.println("�˳�");
			}

			if (option < 1 || option > 7) {
				System.out.print("��������,����������(����ѡ��ǰ������):");
				LoginInterface();
				option = in.nextInt();
			}

		}
		System.out.println("\t�ټ���");
	}

	public void LoginInterface() {
		System.out.println("*******************************************************");
		System.out.println("\t��ѡ����Ŀ(����ѡ��ǰ������):" + "\n\t1.�鿴��Ŀ1" + "\n\t2.�鿴��Ŀ2" + "\n\t3.�鿴��Ŀ3" + "\n\t4.�鿴��Ŀ4"
				+ "\n\t5.�鿴��Ŀ5" + "\n\t6.�˳�");
		System.out.println("*******************************************************");
	}

	// ��Ŀ1����ҵ���ŵĽ������������ɡ�
	public void profit() {
		System.out.println("*******************************************************");
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.println("���������ҵ��(���س�������)��");

		double profitValue = in.nextDouble();
		double bonus = 0;

		if (profitValue > 0 && profitValue < 100000) { // ���ڻ���� 10 ��Ԫ
			bonus = profitValue * 0.1;
		} else if (profitValue < 200000) { // ���� 10 ��Ԫ������ 20 ��Ԫ
			bonus = 100000 * 0.1 + (profitValue - 100000) * 0.075;
		} else if (profitValue < 400000) { // 20 �� 40 ��֮��
			bonus = 100000 * 0.1 + 100000 * 0.075 + (profitValue - 200000) * 0.05;
		} else if (profitValue < 600000) { // 40 �� 60 ��֮��
			bonus = 100000 * 0.1 + 100000 * 0.075 + 200000 * 0.05 + (profitValue - 400000) * 0.03;
		} else if (profitValue < 1000000) { // 60 �� 100 ��֮��
			bonus = 100000 * 0.1 + 100000 * 0.075 + 200000 * 0.05 + 200000 * 0.03 + (profitValue - 600000) * 0.015;
		} else {
			bonus = 100000 * 0.1 + 100000 * 0.075 + 200000 * 0.05 + 200000 * 0.03 + 200000 * 0.015
					+ (profitValue - 600000) * 0.01;
		}

		System.out.println("���ɻ�õ����Ϊ��" + new DecimalFormat(".00").format(bonus));
		System.out.println("*******************************************************");
	}

	// ��Ŀ2������һ����ݣ��жϸ�����Ƿ�����
	public void leapYear() {
		System.out.println("*******************************************************");
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int year = in.nextInt();

		if ((year % 400 == 0) || (year % 100 != 0 && year % 4 == 0)) {
			System.out.println(year + "������");
		} else {
			System.out.println(year + "��������");
		}
		System.out.println("*******************************************************");
	}

	// ��Ŀ3������ĳ��ĳ��ĳ�գ��ж���һ������һ��ĵڼ��죿
	public void judgmentDay() {

		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.println("��������ݣ�");
		int year = in.nextInt();

		System.out.println("�������·ݣ�");
		int month = in.nextInt();

		System.out.println("�����뼸�ţ�");
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
		System.out.println("����" + year + "��ĵڣ�" + result + "��");
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

	// ��Ŀ4�������������� x,y,������������ֵ��
	public void swopInt() {
		System.out.println("*******************************************************");
		int x, y;
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.println("������x��");
		x = in.nextInt();
		System.out.println("������y��");
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
		System.out.println("ת����x��" + x);
		System.out.println("ת����y��" + y);
		System.out.println("*******************************************************");
	}

	// ��Ŀ5�������������� x,y,z ���������������С���������
	public void sort() {
		System.out.println("*******************************************************");
		List<Integer> list = new ArrayList<Integer>();
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.println("������x��");
		list.add(in.nextInt());
		System.out.println("������y��");
		list.add(in.nextInt());
		System.out.println("������z��");
		list.add(in.nextInt());

		Collections.sort(list);

		System.out.println("�������У�");
		System.out.println(list.toString());
		System.out.println("*******************************************************");

	}

	// ��Ŀ6��ˮ�ɻ���
	public void daffodilNumber() {
		System.out.println("*******************************************************");
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.println("��������λ��������");
		int number = in.nextInt();
		int daffodil = (int)(Math.pow(number / 100, 3)+Math.pow((number % 100) / 10, 3)+Math.pow(number % 10, 3));
		if(daffodil==number){
			System.out.println(daffodil+"��\"ˮ�ɻ���\"");
		}else{
			System.out.println(daffodil+"����\"ˮ�ɻ���\"");
		}
		System.out.println("*******************************************************");

	}
}
