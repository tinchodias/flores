package transaction.spring;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import transaction.Block;
import transaction.spring.support.Dummy;

public class SpringTransactionManagerTest extends TestCase {

	private SpringTransactionManager transactionManager;

	protected void setUp() throws Exception {
		super.setUp();
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/spring/context-test.xml", this.getClass());

		transactionManager = (SpringTransactionManager) ctx.getBean("fooService");
	}

	public void testSimpleCommit() {
		final Dummy dummy = new Dummy("1");
		
		Block block = new Block() {
			public Object executeBlock() {
				dummy.setContent("2");
				return null;
			}
		};
		
		transactionManager.execute(block);
		
		assertEquals("2", dummy.getContent());
	}
	
	public void testSimpleRollback() {
		final Dummy dummy = new Dummy("1");
		
		Block block = new Block() {
			public Object executeBlock() {
				dummy.setContent("2");
				throw new RuntimeException();
			}
		};
		
		transactionManager.execute(block);
		
		assertEquals("1", dummy.getContent());
	}
	
}
