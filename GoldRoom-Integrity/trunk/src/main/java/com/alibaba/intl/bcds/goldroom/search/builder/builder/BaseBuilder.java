package com.alibaba.intl.bcds.goldroom.search.builder.builder;

import java.io.IOException;

public abstract class BaseBuilder {
	String destination;
	boolean incrementBuild = false;

	public String getDestination() {
		return destination;
	}

	public BaseBuilder setDestination(String destination) {
		this.destination = destination;
		return this;
	}

	public boolean isIncrementBuild() {
		return incrementBuild;
	}

	public BaseBuilder setIncrementBuild(boolean incrementBuild) {
		this.incrementBuild = incrementBuild;
		return this;
	}

	protected abstract void beforeBuild();

	public void process() {
		beforeBuild();
		try {
			if (!incrementBuild) {
				fullBuild();
			} else {
				incrementBuild();
			}
		} catch (IOException e) {
			onError(e);
		}
		afterBuild();
	}

	protected abstract void fullBuild() throws IOException;

	protected abstract void onError(Object errorObj);

	protected abstract void afterBuild();

	protected abstract void incrementBuild() throws IOException;
}
