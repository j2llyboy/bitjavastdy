package Pack;

public class Calculator {
	private int memory;
	
	public int getMemory() {
		return memory;
	}
	
	//�ΰ� �̻��� �����尡 ���ÿ� ���������� ������ ���� �� �ִ� ������ "Critical Section"�� �Ѵ�.
//	public synchronized void setMemory(int memory) {
//		// �Ʒ��� Critical Section
//		this.memory = memory;
//		try {
//			Thread.sleep(2000); //���� ���� �Ѵ�... ��� ����
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		System.out.println(Thread.currentThread().getName() + ":" + this.memory);
//	}
	
	// ũ��Ƽ�� ������ ���Ե� ��ü�� �ۺ긯(����������) ����Ÿ��(���̵�) ���̿� synchronized�� �־��ش�. 
	// �̷��� �Ǹ� Ư�� �����尡 ġ�� �������� �̹� ���� �����尡 ���� �����߸� ���� �� �ְ� �����ش�.
	
	
	public void setMemory(int memory) {
		// �Ʒ��� Critical Section
		synchronized (this) {
			this.memory = memory;
			try {
				Thread.sleep(2000); //���� ���� �Ѵ�... ��� ����
			} catch (Exception e) {
				// TODO: handle exception
			}
			System.out.println(Thread.currentThread().getName() + ":" + this.memory);
		}
	}
	
	//��ü�� ������ �ӵ��� ������ �ִ� ���ظ� �ּ�ȭ �ϰ� �ʿ� �κи� ��ũ�γ������ ������
	// synchronized (this) {}
	
	
}

// ArrayList ��ü�� �ټ��� �����尡 ����ϴµ� ������ ���� �� �ֱ� ������ 
//=> Vector ��ü�� �ϳ��� �ᵵ ���� �߻����ϰ� ���� ����ε� �̸� thread safe�ϴ� ��� �Ѵ�
// Vector�� ArrayList�� thread safe�ϰ� ������ ��!

//HashMap => HashTable(thread safe) 
//�̷� ��Ƽ�����带 ���� �ڹٿ��� ������ ���� �͵�..


