package view;

import controller.ThreadPing;

public class Main {

	public static void main(String[] args) {
		for(int i = 0; i < 3; i++) {
			ThreadPing threadPing = new ThreadPing(i);
			threadPing.start();
		}
	}

}
