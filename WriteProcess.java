package letterWriterAlphabetic;

public class WriteProcess implements Runnable {
	private LetterWriter lw;
	private int maxTimes = 100;
	char element = ' ';
		
	public WriteProcess(LetterWriter lw, char element) {
		this.lw = lw;
		this.element = element;
	}

	public void run() {
		try {
			for(int i = 0; i < maxTimes - 1; i++) {
				lw.write(element);
			}
		}catch(InterruptedException e) {
			System.out.println("Stopped");
		}
	}
}
