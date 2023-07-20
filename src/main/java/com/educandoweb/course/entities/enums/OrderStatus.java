package com.educandoweb.course.entities.enums;

public enum OrderStatus {

		WAITING_PAYMENT(1), // é necessário colocar o numero de cada tipo para ter maior controle
		PAID(2),
		SHIPPED(3),
		DELIVERED(4),
		CANCELED(5);
	
	private int code;
	
	// o java exige que exista um construtor para os tipos enumerados
	// private pq não pode ser acessível a qualquer um
	private OrderStatus(int code) {
		this.code = code;
	}
	
	// é usado esse método para o programador poder implementar onde e quem pode acessar os tipos enum
	public int getCode() {
		return code;
	}
	
	//metodo statico para retornar o OrderStatus correto a partir do código q eu quiser
	public static OrderStatus valueOf(int code) {
		for (OrderStatus value : OrderStatus.values()) { // esse for percorre todos valores possiveis do OrderStatus
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
	
}
