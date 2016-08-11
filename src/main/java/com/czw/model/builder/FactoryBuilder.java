package com.czw.model.builder;

/**
 * @author ZeviChen
 * @Date 2016-08-11 14:36:49
 */
public class FactoryBuilder {
	private String name;
	private int age;
	private String msg;
	private String address;

	public static class Builder {
		private String name;
		private int age;
		private String msg;
		private String address;

		public Builder() {
		}

		public Builder(String name) {
			this.name = name;
		}

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder age(int age) {
			this.age = age;
			return this;
		}

		public Builder msg(String msg) {
			this.msg = msg;
			return this;
		}

		public FactoryBuilder create() {
			return new FactoryBuilder(this);
		}
	}

	private FactoryBuilder(Builder builder) {
		this.name = builder.name;
		this.age = builder.age;
		this.msg = builder.msg;
		this.address = builder.address;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static Builder builder(String name) {
		return new Builder(name);
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getMsg() {
		return msg;
	}

	public String getAddress() {
		return address;
	}

}
