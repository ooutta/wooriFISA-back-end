package dev.spring.step01dependency;

// ���� ������(Tape)�� �о��ִ� ���
public class TapeReader {
	// �������� �׽�Ʈ �ϱ� ���� Tape Ÿ���� �ʵ�� ������ ����
	Tape tape;
	
	// �������� �׽�Ʈ�ϴ� �޼���
	public void test() {
		// �������� �׽�Ʈ�ϱ� ���� ������ ����
		tape = new Tape("���Ϸ���", false);
		
		if(tape.isWorked()) {
			System.out.println(tape.getName() + " ���� �����մϴ�.");
		} else {
			System.out.println(tape.getName() + " ��� ���߽��ϴ�..");
		}
	}
	
}
