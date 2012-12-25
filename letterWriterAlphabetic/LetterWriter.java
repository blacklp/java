package letterWriterAlphabetic;

public class LetterWriter {
	private char[] array;
	private int max = 400;
	private int lastEmpty;
	private char lastLetter;
	
	public LetterWriter() {
		this.array = new char[max];
		this.lastEmpty = 0;
		lastLetter = 'a' - 1;
		new Thread(new WriteProcess(this, 'a')).start();
		new Thread(new WriteProcess(this, 'b')).start();
		new Thread(new WriteProcess(this, 'c')).start();
		new Thread(new WriteProcess(this, 'd')).start();
	}
	
	public synchronized void write(char element) throws InterruptedException {
		while( !this.correctOrder(element) ) {
			wait();
		}
		
		this.lastLetter = element;
		array[lastEmpty] = element;
		++lastEmpty;
		System.out.println("Letter " + element + " was written.\n");
		
		notifyAll();
	}
	
	public boolean correctOrder(char element) {
		if(lastLetter < 'd') {
			return element == (lastLetter + 1);
		}else {
			return element == 'a';
		}
	}
	
	public static void main(String[] args) {
		new LetterWriter();
	}
}
