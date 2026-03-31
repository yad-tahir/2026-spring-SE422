java.util.concurrent.locks.ReentrantReadWriteLock


private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

private final Lock readLock = rwLock.readLock(); //Create a lock for reading operations
private final Lock writeLock = rwLock.writeLock(); //Create a lock for writing operation

public void put(String key, String value) {
	try{
		//Only one thread can hold it at a time, and it blocks all other readers and writers.
		writeLock.lock(); // Block all other readers and writers
		cache.put(key, value);
	}finally{
		writeLock.unlock();
	}
}

public String get(String key){
	try{
		//Can be held simultaneously by multiple reader threads, as long as there are no writers.
		readLock.lock();
		return cache.get(key);
	}finally{
		readLock().unlock();
	}
}
