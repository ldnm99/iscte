package special;

import java.util.LinkedList;

class BlockingQueue<T> {

	private LinkedList<Task> queue = new LinkedList<Task>();
	private int maxSize;

	public BlockingQueue() {
		maxSize = Integer.MAX_VALUE;
	}

	public BlockingQueue(int maxSize) {
		this.maxSize = maxSize;
	}


	// Offer
	public synchronized void offer(Task element) throws InterruptedException {
		while(queue.size() == maxSize) {
			wait();
		}
		queue.add(element);
		notifyAll();
	}


	// Poll
	public synchronized Task poll() throws InterruptedException {
		while(queue.size() == 0) {
			wait();
		}
		Task object = queue.pollFirst();
		notifyAll();
		return object;
	}


	// Size
	public int size() {
		return queue.size();
	}

	// Clear
	public synchronized void clear() {
		queue.clear();
	}

/*
	public synchronized void clearSpecific(int idClient) {
		if(queue.size() != 0) {
			for(int i = 0; i < queue.size(); i++)
				if(queue.get(i).getIdClient() == idClient)
					queue.remove(i);
			System.out.println("Tasks from the client cleared from the queue");
		}else {
			System.out.println("No tasks of this client in the queue");
		}

	}*/
}

