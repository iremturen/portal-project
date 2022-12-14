package com.izibiz.training.bean.base;

import java.io.Serializable;
import java.sql.Date;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.izibiz.training.service.base.AccountService;
import com.izibiz.training.service.base.ArchiveService;
import com.izibiz.training.service.base.DespatchService;
import com.izibiz.training.service.base.InvoiceService;
import com.izibiz.training.service.base.ReconciliationService;
import com.izibiz.training.service.base.StockService;
import com.izibiz.training.service.base.UserService;
import com.izibiz.training.service.base.UsersService;

public class GenericBean<T> implements Serializable{
	private static final long serialVersionUID = 1L;
	private static final String bundleName = "com.izibiz.training.locale.messages";


	@ManagedProperty(value = "#{userService}")
	private UserService userService;

	@ManagedProperty(value="#{despatchService}")
	private DespatchService despatchService;
	
	@ManagedProperty( value="#{accountService}")
	private AccountService accountService;
	
	@ManagedProperty( value="#{invoiceService}")
	private InvoiceService invoiceService;
	
	@ManagedProperty( value="#{reconciliationService}")
	private ReconciliationService reconciliationService;
	

	@ManagedProperty( value="#{archiveService}")
	private ArchiveService archiveService;

	@ManagedProperty( value="#{stockService}")
	private StockService stockService;
		
	@ManagedProperty(value ="#{restTemplate}")
	private RestTemplate restTemplate;	 
	
	@ManagedProperty(value="#{usersService}")
    private UsersService usersService;
	
	
	private Date minDate = new Date(System.currentTimeMillis() - (7L * 24 * 3600 * 1000));
	private Date today = new Date(System.currentTimeMillis());
	
	
	
	public String getResourceBundleMessage(String key) {
		if (StringUtils.isEmpty(key)) {
			return "";
		}
		return getResourceBundle().getString(key);
	}

	private ResourceBundle getResourceBundle() {
		return ResourceBundle.getBundle(bundleName, FacesContext.getCurrentInstance().getApplication().getDefaultLocale());
	}

	public void addInfoMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void addWarnMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void addErrorMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	
	public StockService getStockService() {
		return stockService;
	}

	public void setStockService(StockService stockService) {
		this.stockService = stockService;
	}
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public DespatchService getDespatchService() {
		return despatchService;
	}

	public void setDespatchService(DespatchService despatchService) {
		this.despatchService = despatchService;
	}

	public AccountService getAccountService() {
		return accountService;
	}

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	public InvoiceService getInvoiceService() {
		return invoiceService;
	}

	public void setInvoiceService(InvoiceService invoiceService) {
		this.invoiceService = invoiceService;
	}
	public ReconciliationService getReconciliationService() {
		return reconciliationService;
	}

	public void setReconciliationService(ReconciliationService reconciliationService) {
		this.reconciliationService = reconciliationService;
	}

	public ArchiveService getArchiveService() {
		return archiveService;
	}

	public void setArchiveService(ArchiveService archiveService) {
		this.archiveService = archiveService;
	}

	public Date getMinDate() {
		return minDate;
	}

	public void setMinDate(Date minDate) {
		this.minDate = minDate;
	}

	public Date getToday() {
		return today;
	}

	public void setToday(Date today) {
		this.today = today;
	}

	public RestTemplate getRestTemplate() {
		return restTemplate;
	}

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public UsersService getUsersService() {
		return usersService;
	}

	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}
	 

}
