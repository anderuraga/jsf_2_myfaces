package com.ipartek.formacion.jsf.managed.bean;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.ipartek.formacion.jsf.bean.Order;

@ManagedBean(name = "order")
@SessionScoped
public class OrderBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Order[] orderList = new Order[] {

			new Order("A0001", "Intel CPU", new BigDecimal("700.00"), 1),
			new Order("A0002", "Harddisk 10TB", new BigDecimal("500.00"), 2),
			new Order("A0003", "Dell Laptop", new BigDecimal("11600.00"), 8),
			new Order("A0004", "Samsung LCD", new BigDecimal("5200.00"), 3),
			new Order("A0005", "A4Tech Mouse", new BigDecimal("100.00"), 10) };

	public Order[] getOrderList() {

		return orderList;

	}

}
