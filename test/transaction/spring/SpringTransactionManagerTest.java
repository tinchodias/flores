package transaction.spring;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.db4o.ObjectContainer;

import transaction.Block;
import transaction.spring.support.Dummy;

public class SpringTransactionManagerTest extends TestCase {

	private SpringTransactionManager transactionManager;
	private ObjectContainer objectContainer;

	public SpringTransactionManagerTest() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/spring/context-test.xml", this.getClass());

		transactionManager = (SpringTransactionManager) ctx.getBean("fooService");
		objectContainer = (ObjectContainer) ctx.getBean("objectContainer"); 	
	}
	
	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		
		objectContainer.ext().purge(); //??
	}
//	
//	public void testSimpleCommit() {
//		final Dummy dummy = new Dummy("1");
//		objectContainer.set(dummy);
//		
//		Block block = new Block() {
//			public Object executeBlock() {
//				dummy.setContent("2");
//				objectContainer.set(dummy);	//TRY REMOVING THIS LINE
//				return null;
//			}
//		};
//
//		transactionManager.execute(block);
//		
//		objectContainer.rollback();
//		objectContainer.ext().refresh(dummy, 2);
//		
//		assertEquals("2", dummy.getContent());
//	}
	
	public void testSimpleRollback() {
		final Dummy dummy = new Dummy("1");
		objectContainer.set(dummy);
		
		Block block = new Block() {
			public Object executeBlock() {
				dummy.setContent("2");
				objectContainer.set(dummy); //TRY REMOVING THIS LINE
				throw new RuntimeException();
			}
		};
		
		try {
			transactionManager.execute(block);
		} catch (Exception e) {
		}
		
		assertEquals("1", dummy.getContent());
	}
	
}
