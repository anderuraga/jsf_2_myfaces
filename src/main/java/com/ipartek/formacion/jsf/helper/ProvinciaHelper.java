package com.ipartek.formacion.jsf.helper;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@ManagedBean
@RequestScoped
public class ProvinciaHelper {

	private static final Logger LOG = LogManager.getRootLogger();

	private List<SelectItem> selectedItems;

	public ProvinciaHelper() {
		LOG.info("ProvinciaHelper constructor");
		this.selectedItems = new ArrayList<SelectItem>();
		this.selectedItems.add(new SelectItem(0, "--selecciona--"));
		this.selectedItems.add(new SelectItem(48, "Bizkaia"));
		this.selectedItems.add(new SelectItem(38, "Andalucia"));
		this.selectedItems.add(new SelectItem(4, "Asturies"));

	}

	public List<SelectItem> getSelectedItems() {
		return selectedItems;
	}

	public void setSelectedItems(List<SelectItem> selectedItems) {
		this.selectedItems = selectedItems;
	}

}
