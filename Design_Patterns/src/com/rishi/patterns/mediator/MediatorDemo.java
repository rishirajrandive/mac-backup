package com.rishi.patterns.mediator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Create an "intermediary" that decouples "senders" from "receivers"
 * Producers are coupled only to the Mediator
 * Consumers are coupled only to the Mediator
 * The Mediator arbitrates the storing and retrieving of messages
 * @author rishi
 *
 */
public class MediatorDemo {
	public static void main(String[] args) {
		List<Thread> producerList = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Press ENTER for exit");
		Mediator mb = new Mediator();
		producerList.add(new Thread(new Producer(mb)));
		producerList.add(new Thread(new Producer(mb)));
		producerList.add(new Thread(new Consumer(mb)));
		producerList.add(new Thread(new Consumer(mb)));
		producerList.add(new Thread(new Consumer(mb)));
		producerList.add(new Thread(new Consumer(mb)));
		for (Thread p : producerList) {
			p.start();
		}
		boolean stop = false;
		String exit = scanner.nextLine();
		while (!stop) {
			if (exit.equals("")) {
				stop = true;
				for (Thread p : producerList) {
					// noinspection deprecation
					p.stop();
				}
			}
		}
	}
}
