package com.xhc.javabased.java_jc.code_02;

/*
�ڸ��������и�ֵ��ʱ������Ҳ�ı���ʽ����ȫ���ǳ�����û���κα�����
��ô������javac����ֱ�ӽ����ɸ���������ʽ����õ������
short result = 5 + 8; // �Ⱥ��ұ�ȫ���ǳ�����û���κα�����������
����֮�󣬵õ���.class�ֽ����ļ������൱�ڡ�ֱ�Ӿ��ǡ���
short result = 13;
�Ҳ�ĳ��������ֵ��û�г�����෶Χ��������ȷ��

���Ϊ���������ĳ����Ż�����

����ע�⣺һ������ʽ�����б������룬��ô�Ͳ��ܽ��������Ż��ˡ�
*/
public class Demo13Notice {

	public static void main(String[] args) {
		short num1 = 10; // ��ȷд�����Ҳ�û�г������ķ�Χ��
		
		short a = 5;
		short b = 8;
		// short + short --> int + int --> int
		// short result = a + b; // ����д���������Ҫ��int����
		
		// �Ҳ಻�ñ��������ǲ��ó���������ֻ������������û�б���
		short result = 5 + 8;
		System.out.println(result);
		
		//short result2 =  (5 + a + 8); // 18
	}
}