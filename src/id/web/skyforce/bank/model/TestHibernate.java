package id.web.skyforce.bank.model;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.codequ.util.HibernateUtil;

public class TestHibernate {

	public static void main(String[] args) throws Exception {
		Customer customer = new Customer();
		customer.setBirthDate(new Date());
		customer.setFirstName("First Name");
		customer.setLastName("Last Name");
		customer.setGender('M');
		customer.setIdNumber("123");

		Account account = new Account();
		account.setAccountNo("001001");
		account.setBalance(BigDecimal.ZERO);
		account.setCustomer(customer);
		account.setStatus('I');

		Address address = new Address();
		address.setCity("City");
		address.setStreet("Street");
		address.setPostalCode("12345");

		customer.getAccounts().add(account);
		customer.getAddresses().add(address);

		Session session = (Session) HibernateUtil.openSession();
		Transaction transaction = (Transaction) session.beginTransaction();

		session.save(customer);

		transaction.commit();
		session.close();
	}

}
